package m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f10444a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    public static final float[][] f10445b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f10446c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d, reason: collision with root package name */
    public static final float[][] f10447d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int a(float f8) {
        if (f8 < 1.0f) {
            return -16777216;
        }
        if (f8 > 99.0f) {
            return -1;
        }
        float f9 = (f8 + 16.0f) / 116.0f;
        float f10 = f8 > 8.0f ? f9 * f9 * f9 : f8 / 903.2963f;
        float f11 = f9 * f9 * f9;
        boolean z = f11 > 0.008856452f;
        float f12 = z ? f11 : ((f9 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f11 = ((f9 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f10446c;
        return n0.a.a(f12 * fArr[0], f10 * fArr[1], f11 * fArr[2]);
    }

    public static float b(int i10) {
        float f8 = i10 / 255.0f;
        return (f8 <= 0.04045f ? f8 / 12.92f : (float) Math.pow((f8 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static float c() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}
