package S2;

/* loaded from: classes2.dex */
public final class a {
    public static boolean a(float[] fArr) {
        if (fArr.length <= 1) {
            return true;
        }
        float f10 = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (fArr[i10] != f10) {
                return false;
            }
        }
        return true;
    }

    public static float b(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot(f12 - f10, f13 - f11);
    }

    public static float c(float f10, float f11, float f12, float f13, float f14, float f15) {
        return e(b(f10, f11, f12, f13), b(f10, f11, f14, f13), b(f10, f11, f14, f15), b(f10, f11, f12, f15));
    }

    public static float d(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    public static float e(float f10, float f11, float f12, float f13) {
        return (f10 <= f11 || f10 <= f12 || f10 <= f13) ? (f11 <= f12 || f11 <= f13) ? f12 > f13 ? f12 : f13 : f11 : f10;
    }
}
