package v0;

import u0.z;

/* loaded from: classes.dex */
public final class l extends c {

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f10311d;

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f10312e;

    /* renamed from: f, reason: collision with root package name */
    public static final float[] f10313f;

    /* renamed from: g, reason: collision with root package name */
    public static final float[] f10314g;

    static {
        float[] fArrG = j.g(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, j.c(a.f10262b.f10263a, new float[]{0.964212f, 1.0f, 0.8251883f}, new float[]{0.95042855f, 1.0f, 1.0889004f}));
        f10311d = fArrG;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f10312e = fArr;
        f10313f = j.f(fArrG);
        f10314g = j.f(fArr);
    }

    @Override // v0.c
    public final float a(int i2) {
        return i2 == 0 ? 1.0f : 0.5f;
    }

    @Override // v0.c
    public final float b(int i2) {
        return i2 == 0 ? 0.0f : -0.5f;
    }

    @Override // v0.c
    public final long d(float f10, float f11, float f12) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (f11 < -0.5f) {
            f11 = -0.5f;
        }
        if (f11 > 0.5f) {
            f11 = 0.5f;
        }
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        float f13 = f12 <= 0.5f ? f12 : 0.5f;
        float[] fArr = f10314g;
        float f14 = (fArr[6] * f13) + (fArr[3] * f11) + (fArr[0] * f10);
        float f15 = (fArr[7] * f13) + (fArr[4] * f11) + (fArr[1] * f10);
        float f16 = (fArr[8] * f13) + (fArr[5] * f11) + (fArr[2] * f10);
        float f17 = f14 * f14 * f14;
        float f18 = f15 * f15 * f15;
        float f19 = f16 * f16 * f16;
        float[] fArr2 = f10313f;
        return (Float.floatToRawIntBits((fArr2[6] * f19) + ((fArr2[3] * f18) + (fArr2[0] * f17))) << 32) | (4294967295L & Float.floatToRawIntBits((fArr2[7] * f19) + (fArr2[4] * f18) + (fArr2[1] * f17)));
    }

    @Override // v0.c
    public final float e(float f10, float f11, float f12) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (f11 < -0.5f) {
            f11 = -0.5f;
        }
        if (f11 > 0.5f) {
            f11 = 0.5f;
        }
        if (f12 < -0.5f) {
            f12 = -0.5f;
        }
        float f13 = f12 <= 0.5f ? f12 : 0.5f;
        float[] fArr = f10314g;
        float f14 = (fArr[6] * f13) + (fArr[3] * f11) + (fArr[0] * f10);
        float f15 = (fArr[7] * f13) + (fArr[4] * f11) + (fArr[1] * f10);
        float f16 = (fArr[8] * f13) + (fArr[5] * f11) + (fArr[2] * f10);
        float f17 = f14 * f14 * f14;
        float f18 = f15 * f15 * f15;
        float f19 = f16 * f16 * f16;
        float[] fArr2 = f10313f;
        return (fArr2[8] * f19) + (fArr2[5] * f18) + (fArr2[2] * f17);
    }

    @Override // v0.c
    public final long f(float f10, float f11, float f12, float f13, c cVar) {
        float[] fArr = f10311d;
        float f14 = (fArr[6] * f12) + (fArr[3] * f11) + (fArr[0] * f10);
        float f15 = (fArr[7] * f12) + (fArr[4] * f11) + (fArr[1] * f10);
        float f16 = (fArr[8] * f12) + (fArr[5] * f11) + (fArr[2] * f10);
        float fY = ib.c.y(f14);
        float fY2 = ib.c.y(f15);
        float fY3 = ib.c.y(f16);
        float[] fArr2 = f10312e;
        return z.a((fArr2[6] * fY3) + (fArr2[3] * fY2) + (fArr2[0] * fY), (fArr2[7] * fY3) + (fArr2[4] * fY2) + (fArr2[1] * fY), (fArr2[8] * fY3) + (fArr2[5] * fY2) + (fArr2[2] * fY), f13, cVar);
    }
}
