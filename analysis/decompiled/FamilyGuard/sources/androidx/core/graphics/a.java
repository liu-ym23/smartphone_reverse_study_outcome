package androidx.core.graphics;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f9640a = new ThreadLocal<>();

    public static void a(int i5, int i6, int i7, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d6 = i5 / 255.0d;
        double dPow = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        double d7 = i6 / 255.0d;
        double dPow2 = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        double d8 = i7 / 255.0d;
        double dPow3 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    public static int b(double d6, double d7, double d8) {
        double d9 = (((3.2406d * d6) + ((-1.5372d) * d7)) + ((-0.4986d) * d8)) / 100.0d;
        double d10 = ((((-0.9689d) * d6) + (1.8758d * d7)) + (0.0415d * d8)) / 100.0d;
        double d11 = (((0.0557d * d6) + ((-0.204d) * d7)) + (1.057d * d8)) / 100.0d;
        return Color.rgb(i((int) Math.round((d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d11 > 0.0031308d ? (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d : d11 * 12.92d) * 255.0d), 0, 255));
    }

    public static int c(int i5, int i6, float f5) {
        float f6 = 1.0f - f5;
        return Color.argb((int) ((Color.alpha(i5) * f6) + (Color.alpha(i6) * f5)), (int) ((Color.red(i5) * f6) + (Color.red(i6) * f5)), (int) ((Color.green(i5) * f6) + (Color.green(i6) * f5)), (int) ((Color.blue(i5) * f6) + (Color.blue(i6) * f5)));
    }

    public static double d(int i5) {
        double[] dArrJ = j();
        e(i5, dArrJ);
        return dArrJ[1] / 100.0d;
    }

    public static void e(int i5, double[] dArr) {
        a(Color.red(i5), Color.green(i5), Color.blue(i5), dArr);
    }

    private static int f(int i5, int i6) {
        return 255 - (((255 - i6) * (255 - i5)) / 255);
    }

    public static int g(int i5, int i6) {
        int iAlpha = Color.alpha(i6);
        int iAlpha2 = Color.alpha(i5);
        int iF = f(iAlpha2, iAlpha);
        return Color.argb(iF, h(Color.red(i5), iAlpha2, Color.red(i6), iAlpha, iF), h(Color.green(i5), iAlpha2, Color.green(i6), iAlpha, iF), h(Color.blue(i5), iAlpha2, Color.blue(i6), iAlpha, iF));
    }

    private static int h(int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            return 0;
        }
        return (((i5 * 255) * i6) + ((i7 * i8) * (255 - i6))) / (i9 * 255);
    }

    private static int i(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : Math.min(i5, i7);
    }

    private static double[] j() {
        ThreadLocal<double[]> threadLocal = f9640a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int k(int i5, int i6) {
        if (i6 < 0 || i6 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i5 & 16777215) | (i6 << 24);
    }
}
