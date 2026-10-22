package C;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: k, reason: collision with root package name */
    public static final p f275k;

    /* renamed from: a, reason: collision with root package name */
    public final float f276a;

    /* renamed from: b, reason: collision with root package name */
    public final float f277b;

    /* renamed from: c, reason: collision with root package name */
    public final float f278c;

    /* renamed from: d, reason: collision with root package name */
    public final float f279d;

    /* renamed from: e, reason: collision with root package name */
    public final float f280e;

    /* renamed from: f, reason: collision with root package name */
    public final float f281f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f282g;

    /* renamed from: h, reason: collision with root package name */
    public final float f283h;

    /* renamed from: i, reason: collision with root package name */
    public final float f284i;

    /* renamed from: j, reason: collision with root package name */
    public final float f285j;

    static {
        float[] fArr = b.f247c;
        float fI = (float) ((b.i() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f245a;
        float f4 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f5 = fArr3[0] * f4;
        float f6 = fArr[1];
        float f7 = (fArr3[1] * f6) + f5;
        float f8 = fArr[2];
        float f9 = (fArr3[2] * f8) + f7;
        float[] fArr4 = fArr2[1];
        float f10 = (fArr4[2] * f8) + (fArr4[1] * f6) + (fArr4[0] * f4);
        float[] fArr5 = fArr2[2];
        float f11 = (f8 * fArr5[2]) + (f6 * fArr5[1]) + (f4 * fArr5[0]);
        float f12 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fI) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d4 = fExp;
        if (d4 > 1.0d) {
            fExp = 1.0f;
        } else if (d4 < 0.0d) {
            fExp = Property.DEFAULT_FLOAT_VALUE;
        }
        float[] fArr6 = {(((100.0f / f9) * fExp) + 1.0f) - fExp, (((100.0f / f10) * fExp) + 1.0f) - fExp, (((100.0f / f11) * fExp) + 1.0f) - fExp};
        float f13 = 1.0f / ((5.0f * fI) + 1.0f);
        float f14 = f13 * f13 * f13 * f13;
        float f15 = 1.0f - f14;
        float fCbrt = (0.1f * f15 * f15 * ((float) Math.cbrt(fI * 5.0d))) + (f14 * fI);
        float fI2 = b.i() / fArr[1];
        double d5 = fI2;
        float fSqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d5, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f9) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f11) / 100.0d, 0.42d)};
        float f16 = fArr7[0];
        float f17 = (f16 * 400.0f) / (f16 + 27.13f);
        float f18 = fArr7[1];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[2];
        float[] fArr8 = {f17, f19, (400.0f * f20) / (f20 + 27.13f)};
        f275k = new p(fI2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, f12, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public p(float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, float f10, float f11, float f12) {
        this.f281f = f4;
        this.f276a = f5;
        this.f277b = f6;
        this.f278c = f7;
        this.f279d = f8;
        this.f280e = f9;
        this.f282g = fArr;
        this.f283h = f10;
        this.f284i = f11;
        this.f285j = f12;
    }
}
