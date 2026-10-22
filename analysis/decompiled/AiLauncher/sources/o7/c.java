package o7;

/* loaded from: classes.dex */
public class c {
    public static float a(float f10, float f11) {
        if (f10 < 0.0f || f11 <= 0.0f) {
            return 0.0f;
        }
        float fMin = Math.min(f10, f11 - 1.0E-5f);
        return ((f11 * fMin) / (f11 - fMin)) / 1.0f;
    }

    public static float b(float f10, float f11) {
        if ((f10 < 0.0f) || (f11 <= 0.0f)) {
            return 0.0f;
        }
        return (1.0f - (1.0f / (((f10 / f11) * 1.0f) + 1.0f))) * f11;
    }
}
