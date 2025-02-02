package com.example.newrecipecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeScreen()
        }
    }
}

@Composable
fun RecipeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        RecipeCard()
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Delicious Pasta",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.pasta),
                contentDescription = "Pasta Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Text(text = "Ingredients", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Column(modifier = Modifier.padding(top = 4.dp)) {
                listOf("200g Pasta", "1 cup Tomato Sauce", "2 cloves Garlic", "1 tbsp Olive Oil", "Salt & Pepper to taste").forEach { ingredient ->
                    Row(modifier = Modifier.padding(vertical = 2.dp)) {
                        Text(text = "•", fontSize = 16.sp, modifier = Modifier.padding(end = 4.dp))
                        Text(text = ingredient, fontSize = 16.sp)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Text(text = "Instructions", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "1. Boil pasta in salted water.\n2. Heat oil in a pan, sauté garlic.\n3. Add tomato sauce and cook.\n4. Mix pasta with sauce.\n5. Serve with cheese.",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}