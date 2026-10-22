package com.obric.oui.color;

import android.graphics.Color;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i0 {
    public static int a(int r10, float r11) {
        int r12 = Color.alpha(r10);
        float[] r13 = new float[3];
        Color.colorToHSV(r10, r13);
        r13[1] = Math.max(0.0f, r13[1] - r11);
        int r14 = Color.HSVToColor(r13) & 16777215;
        return r14 | (r12 << 24);
    }

    public static boolean b(int r10) {
        int r11 = Color.red(r10);
        int r12 = Color.green(r10);
        int r13 = Color.blue(r10);
        if (r11 != r12) goto L7;
        if (r11 != r13) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean c(int r10) {
        return d(r10, 0.5d);
    }

    public static boolean d(int r10, double r11) {
        if (f(r10) >= r11) goto L5;
        return true;
    L5:
        return false;
    }

    public static double e(double r10) {
        if (r10 > 0.04045d) goto L7;
        return r10 / 12.92d;
    L7:
        return Math.pow((r10 + 0.055d) / 1.055d, 2.4d);
    }

    public static double f(int r10) {
        double r11 = ((double) ((r10 >> 16) & PrivateKeyType.INVALID)) / 255.0d;
        double r12 = ((double) ((r10 >> 8) & PrivateKeyType.INVALID)) / 255.0d;
        double r13 = ((double) (r10 & PrivateKeyType.INVALID)) / 255.0d;
        double r14 = e(r11);
        double r15 = e(r12);
        return ((r14 * 0.2126d) + (r15 * 0.7152d)) + (e(r13) * 0.0722d);
    }
}
