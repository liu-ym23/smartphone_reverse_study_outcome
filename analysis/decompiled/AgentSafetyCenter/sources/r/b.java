package r;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f10245a;

    static {
        float f5;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float[] fArr = new float[101];
        f10245a = fArr;
        float[] fArr2 = new float[101];
        float f18 = 0.0f;
        int i = 0;
        float f19 = 0.0f;
        while (true) {
            float f20 = 1.0f;
            if (i >= 100) {
                fArr2[100] = 1.0f;
                fArr[100] = 1.0f;
                return;
            }
            float f21 = i / 100;
            float f22 = 1.0f;
            while (true) {
                f5 = ((f22 - f18) / 2.0f) + f18;
                f10 = f20 - f5;
                f11 = f5 * 3.0f * f10;
                f12 = f5 * f5 * f5;
                float f23 = (((f5 * 0.35000002f) + (f10 * 0.175f)) * f11) + f12;
                f13 = f20;
                if (Math.abs(f23 - f21) < 1.0E-5d) {
                    break;
                }
                if (f23 > f21) {
                    f22 = f5;
                } else {
                    f18 = f5;
                }
                f20 = f13;
            }
            float f24 = 0.5f;
            fArr[i] = (((f10 * 0.5f) + f5) * f11) + f12;
            float f25 = f13;
            while (true) {
                f14 = ((f25 - f19) / 2.0f) + f19;
                f15 = f13 - f14;
                f16 = f14 * 3.0f * f15;
                f17 = f14 * f14 * f14;
                float f26 = (((f15 * f24) + f14) * f16) + f17;
                float f27 = f25;
                if (Math.abs(f26 - f21) >= 1.0E-5d) {
                    if (f26 > f21) {
                        f25 = f14;
                    } else {
                        f19 = f14;
                        f25 = f27;
                    }
                    f24 = 0.5f;
                }
            }
            fArr2[i] = (((f14 * 0.35000002f) + (f15 * 0.175f)) * f16) + f17;
            i++;
        }
    }

    public static a a(float f5) {
        float f10 = 0.0f;
        float f11 = 1.0f;
        float fP = p5.f.p(f5, 0.0f, 1.0f);
        float f12 = 100;
        int i = (int) (f12 * fP);
        if (i < 100) {
            float f13 = i / f12;
            int i3 = i + 1;
            float f14 = i3 / f12;
            float[] fArr = f10245a;
            float f15 = fArr[i];
            float f16 = (fArr[i3] - f15) / (f14 - f13);
            float f17 = k0.a.f(fP, f13, f16, f15);
            f10 = f16;
            f11 = f17;
        }
        a aVar = new a();
        aVar.f10241a = f11;
        aVar.f10242b = f10;
        VarHandle.storeStoreFence();
        return aVar;
    }
}
