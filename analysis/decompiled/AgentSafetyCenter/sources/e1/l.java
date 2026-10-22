package e1;

import d1.f0;
import h5.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends c {

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f3380d;

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f3381e;

    /* renamed from: f, reason: collision with root package name */
    public static final float[] f3382f;

    /* renamed from: g, reason: collision with root package name */
    public static final float[] f3383g;

    static {
        float[] fArrG = j.g(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, j.c(a.f3332b.f3333a, new float[]{0.964212f, 1.0f, 0.8251883f}, new float[]{0.95042855f, 1.0f, 1.0889004f}));
        f3380d = fArrG;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f3381e = fArr;
        f3382f = j.f(fArrG);
        f3383g = j.f(fArr);
    }

    @Override // e1.c
    public final float a(int i) {
        return i == 0 ? 1.0f : 0.5f;
    }

    @Override // e1.c
    public final float b(int i) {
        return i == 0 ? 0.0f : -0.5f;
    }

    @Override // e1.c
    public final long d(float f5, float f10, float f11) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f10 < -0.5f) {
            f10 = -0.5f;
        }
        if (f10 > 0.5f) {
            f10 = 0.5f;
        }
        if (f11 < -0.5f) {
            f11 = -0.5f;
        }
        float f12 = f11 <= 0.5f ? f11 : 0.5f;
        float[] fArr = f3383g;
        float f13 = (fArr[6] * f12) + (fArr[3] * f10) + (fArr[0] * f5);
        float f14 = (fArr[7] * f12) + (fArr[4] * f10) + (fArr[1] * f5);
        float f15 = (fArr[8] * f12) + (fArr[5] * f10) + (fArr[2] * f5);
        float f16 = f13 * f13 * f13;
        float f17 = f14 * f14 * f14;
        float f18 = f15 * f15 * f15;
        float[] fArr2 = f3382f;
        return (Float.floatToRawIntBits((fArr2[6] * f18) + ((fArr2[3] * f17) + (fArr2[0] * f16))) << 32) | (4294967295L & Float.floatToRawIntBits((fArr2[7] * f18) + (fArr2[4] * f17) + (fArr2[1] * f16)));
    }

    @Override // e1.c
    public final float e(float f5, float f10, float f11) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f10 < -0.5f) {
            f10 = -0.5f;
        }
        if (f10 > 0.5f) {
            f10 = 0.5f;
        }
        if (f11 < -0.5f) {
            f11 = -0.5f;
        }
        float f12 = f11 <= 0.5f ? f11 : 0.5f;
        float[] fArr = f3383g;
        float f13 = (fArr[6] * f12) + (fArr[3] * f10) + (fArr[0] * f5);
        float f14 = (fArr[7] * f12) + (fArr[4] * f10) + (fArr[1] * f5);
        float f15 = (fArr[8] * f12) + (fArr[5] * f10) + (fArr[2] * f5);
        float f16 = f13 * f13 * f13;
        float f17 = f14 * f14 * f14;
        float f18 = f15 * f15 * f15;
        float[] fArr2 = f3382f;
        return (fArr2[8] * f18) + (fArr2[5] * f17) + (fArr2[2] * f16);
    }

    @Override // e1.c
    public final long f(float f5, float f10, float f11, float f12, c cVar) {
        float[] fArr = f3380d;
        float f13 = (fArr[6] * f11) + (fArr[3] * f10) + (fArr[0] * f5);
        float f14 = (fArr[7] * f11) + (fArr[4] * f10) + (fArr[1] * f5);
        float f15 = (fArr[8] * f11) + (fArr[5] * f10) + (fArr[2] * f5);
        float fW = t.w(f13);
        float fW2 = t.w(f14);
        float fW3 = t.w(f15);
        float[] fArr2 = f3381e;
        return f0.a((fArr2[6] * fW3) + (fArr2[3] * fW2) + (fArr2[0] * fW), (fArr2[7] * fW3) + (fArr2[4] * fW2) + (fArr2[1] * fW), (fArr2[8] * fW3) + (fArr2[5] * fW2) + (fArr2[2] * fW), f12, cVar);
    }
}
