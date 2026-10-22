package m;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f6041a;

    static {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float[] fArr = new float[101];
        f6041a = fArr;
        float[] fArr2 = new float[101];
        float f19 = 0.0f;
        int i2 = 0;
        float f20 = 0.0f;
        while (true) {
            float f21 = 1.0f;
            if (i2 >= 100) {
                fArr2[100] = 1.0f;
                fArr[100] = 1.0f;
                return;
            }
            float f22 = i2 / 100;
            float f23 = 1.0f;
            while (true) {
                f10 = ((f23 - f19) / 2.0f) + f19;
                f11 = f21 - f10;
                f12 = f10 * 3.0f * f11;
                f13 = f10 * f10 * f10;
                float f24 = (((f10 * 0.35000002f) + (f11 * 0.175f)) * f12) + f13;
                f14 = f21;
                if (Math.abs(f24 - f22) < 1.0E-5d) {
                    break;
                }
                if (f24 > f22) {
                    f23 = f10;
                } else {
                    f19 = f10;
                }
                f21 = f14;
            }
            float f25 = 0.5f;
            fArr[i2] = (((f11 * 0.5f) + f10) * f12) + f13;
            float f26 = f14;
            while (true) {
                f15 = ((f26 - f20) / 2.0f) + f20;
                f16 = f14 - f15;
                f17 = f15 * 3.0f * f16;
                f18 = f15 * f15 * f15;
                float f27 = (((f16 * f25) + f15) * f17) + f18;
                float f28 = f26;
                if (Math.abs(f27 - f22) >= 1.0E-5d) {
                    if (f27 > f22) {
                        f26 = f15;
                    } else {
                        f20 = f15;
                        f26 = f28;
                    }
                    f25 = 0.5f;
                }
            }
            fArr2[i2] = (((f15 * 0.35000002f) + (f16 * 0.175f)) * f17) + f18;
            i2++;
        }
    }

    public static a a(float f10) {
        float f11 = 0.0f;
        float f12 = 1.0f;
        float fJ = nb.i.j(f10, 0.0f, 1.0f);
        float f13 = 100;
        int i2 = (int) (f13 * fJ);
        if (i2 < 100) {
            float f14 = i2 / f13;
            int i10 = i2 + 1;
            float f15 = i10 / f13;
            float[] fArr = f6041a;
            float f16 = fArr[i2];
            float f17 = (fArr[i10] - f16) / (f15 - f14);
            float f18 = ((fJ - f14) * f17) + f16;
            f11 = f17;
            f12 = f18;
        }
        return new a(f12, f11);
    }
}
