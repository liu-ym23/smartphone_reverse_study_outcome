package com.stepos.activeview.graphicsanim.utils;

import java.util.Random;

/* loaded from: classes.dex */
public class MathHelper {
    public static Random rand = new Random();

    public static float getFlexibleValue(float f4, float f5) {
        return (((rand.nextFloat() * f5) * 2.0f) + f4) - f5;
    }

    public static float randomRange(float f4, float f5) {
        int i4 = (int) f4;
        return rand.nextInt((((int) f5) - i4) + 1) + i4;
    }
}
