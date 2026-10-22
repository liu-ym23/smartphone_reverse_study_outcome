package m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: k, reason: collision with root package name */
    public static final h f10470k;

    /* renamed from: a, reason: collision with root package name */
    public final float f10471a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10472b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10473c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10474d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10475e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10476f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f10477g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final float f10478i;

    /* renamed from: j, reason: collision with root package name */
    public final float f10479j;

    static {
        float fC = (float) ((b.c() * 63.66197723675813d) / 100.0d);
        float[] fArr = b.f10446c;
        float f8 = fArr[0];
        float[][] fArr2 = b.f10444a;
        float[] fArr3 = fArr2[0];
        float f9 = fArr3[0] * f8;
        float f10 = fArr[1];
        float f11 = (fArr3[1] * f10) + f9;
        float f12 = fArr[2];
        float f13 = (fArr3[2] * f12) + f11;
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[2] * f12) + (fArr4[1] * f10) + (fArr4[0] * f8);
        float[] fArr5 = fArr2[2];
        float f15 = (f12 * fArr5[2]) + (f10 * fArr5[1]) + (f8 * fArr5[0]);
        float f16 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fC) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d8 = fExp;
        if (d8 > 1.0d) {
            fExp = 1.0f;
        } else if (d8 < 0.0d) {
            fExp = 0.0f;
        }
        float f17 = 1.0f / ((5.0f * fC) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float fCbrt = (0.1f * f19 * f19 * ((float) Math.cbrt(fC * 5.0d))) + (f18 * fC);
        float fC2 = b.c() / fArr[1];
        double d10 = fC2;
        float fSqrt = ((float) Math.sqrt(d10)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d10, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r2[0] * fCbrt) * f13) / 100.0d, 0.42d), (float) Math.pow(((r2[1] * fCbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((r2[2] * fCbrt) * f15) / 100.0d, 0.42d)};
        float f20 = fArr6[0];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr6[1];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr6[2];
        float[] fArr7 = {f21, f23, (400.0f * f24) / (f24 + 27.13f)};
        f10470k = new h(fC2, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * fPow, fPow, fPow, f16, 1.0f, new float[]{(((100.0f / f13) * fExp) + 1.0f) - fExp, (((100.0f / f14) * fExp) + 1.0f) - fExp, (((100.0f / f15) * fExp) + 1.0f) - fExp}, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public h(float f8, float f9, float f10, float f11, float f12, float f13, float[] fArr, float f14, float f15, float f16) {
        this.f10476f = f8;
        this.f10471a = f9;
        this.f10472b = f10;
        this.f10473c = f11;
        this.f10474d = f12;
        this.f10475e = f13;
        this.f10477g = fArr;
        this.h = f14;
        this.f10478i = f15;
        this.f10479j = f16;
    }
}
