package androidx.core.content.res;

/* loaded from: classes.dex */
final class l {

    /* renamed from: k, reason: collision with root package name */
    static final l f9629k = k(b.f9598c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f9630a;

    /* renamed from: b, reason: collision with root package name */
    private final float f9631b;

    /* renamed from: c, reason: collision with root package name */
    private final float f9632c;

    /* renamed from: d, reason: collision with root package name */
    private final float f9633d;

    /* renamed from: e, reason: collision with root package name */
    private final float f9634e;

    /* renamed from: f, reason: collision with root package name */
    private final float f9635f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f9636g;

    /* renamed from: h, reason: collision with root package name */
    private final float f9637h;

    /* renamed from: i, reason: collision with root package name */
    private final float f9638i;

    /* renamed from: j, reason: collision with root package name */
    private final float f9639j;

    private l(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.f9635f = f5;
        this.f9630a = f6;
        this.f9631b = f7;
        this.f9632c = f8;
        this.f9633d = f9;
        this.f9634e = f10;
        this.f9636g = fArr;
        this.f9637h = f11;
        this.f9638i = f12;
        this.f9639j = f13;
    }

    static l k(float[] fArr, float f5, float f6, float f7, boolean z5) {
        float[][] fArr2 = b.f9596a;
        float f8 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f9 = fArr3[0] * f8;
        float f10 = fArr[1];
        float f11 = f9 + (fArr3[1] * f10);
        float f12 = fArr[2];
        float f13 = f11 + (fArr3[2] * f12);
        float[] fArr4 = fArr2[1];
        float f14 = (fArr4[0] * f8) + (fArr4[1] * f10) + (fArr4[2] * f12);
        float[] fArr5 = fArr2[2];
        float f15 = (f8 * fArr5[0]) + (f10 * fArr5[1]) + (f12 * fArr5[2]);
        float f16 = (f7 / 10.0f) + 0.8f;
        float fD = ((double) f16) >= 0.9d ? b.d(0.59f, 0.69f, (f16 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f16 - 0.8f) * 10.0f);
        float fExp = z5 ? 1.0f : (1.0f - (((float) Math.exp(((-f5) - 42.0f) / 92.0f)) * 0.2777778f)) * f16;
        double d6 = fExp;
        if (d6 > 1.0d) {
            fExp = 1.0f;
        } else if (d6 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f13) * fExp) + 1.0f) - fExp, (((100.0f / f14) * fExp) + 1.0f) - fExp, (((100.0f / f15) * fExp) + 1.0f) - fExp};
        float f17 = 1.0f / ((5.0f * f5) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float fCbrt = (f18 * f5) + (0.1f * f19 * f19 * ((float) Math.cbrt(f5 * 5.0d)));
        float fH = b.h(f6) / fArr[1];
        double d7 = fH;
        float fSqrt = ((float) Math.sqrt(d7)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d7, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f13) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f15) / 100.0d, 0.42d)};
        float f20 = fArr7[0];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[1];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr7[2];
        float[] fArr8 = {f21, f23, (400.0f * f24) / (f24 + 27.13f)};
        return new l(fH, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * fPow, fPow, fPow, fD, f16, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    float a() {
        return this.f9630a;
    }

    float b() {
        return this.f9633d;
    }

    float c() {
        return this.f9637h;
    }

    float d() {
        return this.f9638i;
    }

    float e() {
        return this.f9635f;
    }

    float f() {
        return this.f9631b;
    }

    float g() {
        return this.f9634e;
    }

    float h() {
        return this.f9632c;
    }

    float[] i() {
        return this.f9636g;
    }

    float j() {
        return this.f9639j;
    }
}
