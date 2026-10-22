package w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: k, reason: collision with root package name */
    public static final k f6064k;

    /* renamed from: a, reason: collision with root package name */
    public final float f6065a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6066b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6067c;
    public final float d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6068e;

    /* renamed from: f, reason: collision with root package name */
    public final float f6069f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f6070g;

    /* renamed from: h, reason: collision with root package name */
    public final float f6071h;

    /* renamed from: i, reason: collision with root package name */
    public final float f6072i;

    /* renamed from: j, reason: collision with root package name */
    public final float f6073j;

    static {
        float fI = (float) ((b.i() * 63.66197723675813d) / 100.0d);
        float[] fArr = b.f6046c;
        float f3 = fArr[0];
        float[][] fArr2 = b.f6044a;
        float[] fArr3 = fArr2[0];
        float f7 = fArr3[0] * f3;
        float f9 = fArr[1];
        float f10 = (fArr3[1] * f9) + f7;
        float f11 = fArr[2];
        float f12 = (fArr3[2] * f11) + f10;
        float[] fArr4 = fArr2[1];
        float f13 = (fArr4[2] * f11) + (fArr4[1] * f9) + (fArr4[0] * f3);
        float[] fArr5 = fArr2[2];
        float f14 = (f11 * fArr5[2]) + (f9 * fArr5[1]) + (f3 * fArr5[0]);
        float f15 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fI) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = fExp;
        if (d > 1.0d) {
            fExp = 1.0f;
        } else if (d < 0.0d) {
            fExp = 0.0f;
        }
        float f16 = 1.0f / ((5.0f * fI) + 1.0f);
        float f17 = f16 * f16 * f16 * f16;
        float f18 = 1.0f - f17;
        float fCbrt = (0.1f * f18 * f18 * ((float) Math.cbrt(fI * 5.0d))) + (f17 * fI);
        float fI2 = b.i() / fArr[1];
        double d9 = fI2;
        float fSqrt = ((float) Math.sqrt(d9)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d9, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r2[0] * fCbrt) * f12) / 100.0d, 0.42d), (float) Math.pow(((r2[1] * fCbrt) * f13) / 100.0d, 0.42d), (float) Math.pow(((r2[2] * fCbrt) * f14) / 100.0d, 0.42d)};
        float f19 = fArr6[0];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr6[1];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr6[2];
        float[] fArr7 = {f20, f22, (400.0f * f23) / (f23 + 27.13f)};
        f6064k = new k(fI2, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * fPow, fPow, fPow, f15, 1.0f, new float[]{(((100.0f / f12) * fExp) + 1.0f) - fExp, (((100.0f / f13) * fExp) + 1.0f) - fExp, (((100.0f / f14) * fExp) + 1.0f) - fExp}, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public k(float f3, float f7, float f9, float f10, float f11, float f12, float[] fArr, float f13, float f14, float f15) {
        this.f6069f = f3;
        this.f6065a = f7;
        this.f6066b = f9;
        this.f6067c = f10;
        this.d = f11;
        this.f6068e = f12;
        this.f6070g = fArr;
        this.f6071h = f13;
        this.f6072i = f14;
        this.f6073j = f15;
    }
}
