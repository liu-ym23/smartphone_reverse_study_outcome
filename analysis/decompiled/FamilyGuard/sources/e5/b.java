package e5;

/* loaded from: classes.dex */
class b {
    public static float a(float f5, float f6) {
        if (f5 < 0.0f || f6 <= 0.0f) {
            return 0.0f;
        }
        float fMin = Math.min(f5, f6 - 1.0E-5f);
        return ((f6 * fMin) / (f6 - fMin)) / 1.0f;
    }

    public static float b(float f5, float f6) {
        if ((f5 < 0.0f) || (f6 <= 0.0f)) {
            return 0.0f;
        }
        return (1.0f - (1.0f / (((f5 / f6) * 1.0f) + 1.0f))) * f6;
    }
}
