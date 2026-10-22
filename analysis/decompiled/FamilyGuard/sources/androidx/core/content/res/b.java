package androidx.core.content.res;

import android.graphics.Color;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    static final float[][] f9596a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    static final float[][] f9597b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    static final float[] f9598c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d, reason: collision with root package name */
    static final float[][] f9599d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    static int a(float f5) {
        if (f5 < 1.0f) {
            return -16777216;
        }
        if (f5 > 99.0f) {
            return -1;
        }
        float f6 = (f5 + 16.0f) / 116.0f;
        float f7 = f5 > 8.0f ? f6 * f6 * f6 : f5 / 903.2963f;
        float f8 = f6 * f6 * f6;
        boolean z5 = f8 > 0.008856452f;
        float f9 = z5 ? f8 : ((f6 * 116.0f) - 16.0f) / 903.2963f;
        if (!z5) {
            f8 = ((f6 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f9598c;
        return androidx.core.graphics.a.b(f9 * fArr[0], f7 * fArr[1], f8 * fArr[2]);
    }

    static float b(int i5) {
        return c(g(i5));
    }

    static float c(float f5) {
        float f6 = f5 / 100.0f;
        return f6 <= 0.008856452f ? f6 * 903.2963f : (((float) Math.cbrt(f6)) * 116.0f) - 16.0f;
    }

    static float d(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    static float e(int i5) {
        float f5 = i5 / 255.0f;
        return (f5 <= 0.04045f ? f5 / 12.92f : (float) Math.pow((f5 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    static void f(int i5, float[] fArr) {
        float fE = e(Color.red(i5));
        float fE2 = e(Color.green(i5));
        float fE3 = e(Color.blue(i5));
        float[][] fArr2 = f9599d;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[0] * fE) + (fArr3[1] * fE2) + (fArr3[2] * fE3);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[0] * fE) + (fArr4[1] * fE2) + (fArr4[2] * fE3);
        float[] fArr5 = fArr2[2];
        fArr[2] = (fE * fArr5[0]) + (fE2 * fArr5[1]) + (fE3 * fArr5[2]);
    }

    static float g(int i5) {
        float fE = e(Color.red(i5));
        float fE2 = e(Color.green(i5));
        float fE3 = e(Color.blue(i5));
        float[] fArr = f9599d[1];
        return (fE * fArr[0]) + (fE2 * fArr[1]) + (fE3 * fArr[2]);
    }

    static float h(float f5) {
        return (f5 > 8.0f ? (float) Math.pow((f5 + 16.0d) / 116.0d, 3.0d) : f5 / 903.2963f) * 100.0f;
    }
}
