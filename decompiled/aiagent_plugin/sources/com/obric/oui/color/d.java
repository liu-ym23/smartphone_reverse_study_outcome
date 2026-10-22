package com.obric.oui.color;

import android.graphics.Color;

/* JADX INFO: compiled from: OPalette.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static boolean a(int r2) {
        return a(r2, 0.5d);
    }

    public static boolean a(int r2, double r3) {
        if (b(r2) >= r3) goto L5;
        return true;
    L5:
        return false;
    }

    public static double b(int r8) {
        double r0 = ((double) ((r8 >> 16) & 255)) / 255.0d;
        double r4 = ((double) ((r8 >> 8) & 255)) / 255.0d;
        double r1 = a(r0);
        double r2 = a(r4);
        return ((r1 * 0.2126d) + (r2 * 0.7152d)) + (a(((double) (r8 & 255)) / 255.0d) * 0.0722d);
    }

    private static double a(double r2) {
        if (r2 > 0.04045d) goto L7;
        return r2 / 12.92d;
    L7:
        return Math.pow((r2 + 0.055d) / 1.055d, 2.4d);
    }

    public static boolean c(int r2) {
        int r0 = Color.red(r2);
        int r1 = Color.green(r2);
        int r3 = Color.blue(r2);
        if (r0 != r1) goto L7;
        if (r0 != r3) goto L7;
        return false;
    L7:
        return true;
    }

    public static int a(int r3, float r4) {
        int r0 = Color.alpha(r3);
        float[] r1 = new float[3];
        Color.colorToHSV(r3, r1);
        r1[1] = Math.max(0.0f, r1[1] - r4);
        int r5 = Color.HSVToColor(r1) & 16777215;
        return r5 | (r0 << 24);
    }
}
