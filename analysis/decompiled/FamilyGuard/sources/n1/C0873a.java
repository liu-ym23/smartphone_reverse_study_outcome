package n1;

/* renamed from: n1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0873a {
    public static boolean a(float[] fArr) {
        if (fArr.length <= 1) {
            return true;
        }
        float f5 = fArr[0];
        for (int i5 = 1; i5 < fArr.length; i5++) {
            if (fArr[i5] != f5) {
                return false;
            }
        }
        return true;
    }

    public static float b(float f5, float f6, float f7, float f8) {
        return (float) Math.hypot(f7 - f5, f8 - f6);
    }

    public static float c(float f5, float f6, float f7, float f8, float f9, float f10) {
        return e(b(f5, f6, f7, f8), b(f5, f6, f9, f8), b(f5, f6, f9, f10), b(f5, f6, f7, f10));
    }

    public static float d(float f5, float f6, float f7) {
        return ((1.0f - f7) * f5) + (f7 * f6);
    }

    private static float e(float f5, float f6, float f7, float f8) {
        return (f5 <= f6 || f5 <= f7 || f5 <= f8) ? (f6 <= f7 || f6 <= f8) ? f7 > f8 ? f7 : f8 : f6 : f5;
    }
}
