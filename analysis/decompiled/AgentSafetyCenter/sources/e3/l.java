package e3;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: k, reason: collision with root package name */
    public static final l f3481k;

    /* renamed from: a, reason: collision with root package name */
    public float f3482a;

    /* renamed from: b, reason: collision with root package name */
    public float f3483b;

    /* renamed from: c, reason: collision with root package name */
    public float f3484c;

    /* renamed from: d, reason: collision with root package name */
    public float f3485d;

    /* renamed from: e, reason: collision with root package name */
    public float f3486e;

    /* renamed from: f, reason: collision with root package name */
    public float f3487f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f3488g;

    /* renamed from: h, reason: collision with root package name */
    public float f3489h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f3490j;

    static {
        float fK = (float) ((b.k() * 63.66197723675813d) / 100.0d);
        float[] fArr = b.f3459c;
        float f5 = fArr[0];
        float[][] fArr2 = b.f3457a;
        float[] fArr3 = fArr2[0];
        float f10 = fArr3[0] * f5;
        float f11 = fArr[1];
        float f12 = (fArr3[1] * f11) + f10;
        float f13 = fArr[2];
        float f14 = (fArr3[2] * f13) + f12;
        float[] fArr4 = fArr2[1];
        float f15 = (fArr4[2] * f13) + (fArr4[1] * f11) + (fArr4[0] * f5);
        float[] fArr5 = fArr2[2];
        float f16 = (f13 * fArr5[2]) + (f11 * fArr5[1]) + (f5 * fArr5[0]);
        float f17 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fK) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d7 = fExp;
        if (d7 > 1.0d) {
            fExp = 1.0f;
        } else if (d7 < 0.0d) {
            fExp = 0.0f;
        }
        float f18 = 1.0f / ((5.0f * fK) + 1.0f);
        float f19 = f18 * f18 * f18 * f18;
        float f20 = 1.0f - f19;
        float fCbrt = (0.1f * f20 * f20 * ((float) Math.cbrt(fK * 5.0d))) + (f19 * fK);
        float fK2 = b.k() / fArr[1];
        double d10 = fK2;
        float fSqrt = ((float) Math.sqrt(d10)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d10, 0.2d));
        float f21 = f17;
        float[] fArr6 = {(float) Math.pow(((r2[0] * fCbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((r2[1] * fCbrt) * f15) / 100.0d, 0.42d), (float) Math.pow(((r2[2] * fCbrt) * f16) / 100.0d, 0.42d)};
        float f22 = fArr6[0];
        float f23 = (f22 * 400.0f) / (f22 + 27.13f);
        float f24 = fArr6[1];
        float f25 = (f24 * 400.0f) / (f24 + 27.13f);
        float f26 = fArr6[2];
        float[] fArr7 = {f23, f25, (400.0f * f26) / (f26 + 27.13f)};
        float f27 = ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * fPow;
        float fPow2 = (float) Math.pow(fCbrt, 0.25d);
        l lVar = new l();
        lVar.f3487f = fK2;
        lVar.f3482a = f27;
        lVar.f3483b = fPow;
        lVar.f3484c = fPow;
        lVar.f3485d = f21;
        lVar.f3486e = 1.0f;
        lVar.f3488g = new float[]{(((100.0f / f14) * fExp) + 1.0f) - fExp, (((100.0f / f15) * fExp) + 1.0f) - fExp, (((100.0f / f16) * fExp) + 1.0f) - fExp};
        lVar.f3489h = fCbrt;
        lVar.i = fPow2;
        lVar.f3490j = fSqrt;
        VarHandle.storeStoreFence();
        f3481k = lVar;
    }
}
