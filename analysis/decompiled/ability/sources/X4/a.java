package X4;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public final class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f1502a = new float[100];
    public final float[] b = new float[100];

    public a(float f, float f7, float f9) {
        float f10 = f * 3.0f;
        float f11 = f9 * 3.0f;
        float f12 = (f10 + 1.0f) - f11;
        float f13 = f11 - (f * 6.0f);
        float f14 = f7 * 3.0f;
        float f15 = (1.0f + f14) - 3.0f;
        float f16 = 3.0f - (f7 * 6.0f);
        float f17 = 0.0f;
        for (int i = 0; i < 100; i++) {
            float f18 = f17 * f17;
            float f19 = f18 * f17;
            this.f1502a[i] = (f10 * f17) + (f13 * f18) + (f12 * f19);
            this.b[i] = (f14 * f17) + (f18 * f16) + (f19 * f15);
            f17 += 0.01f;
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f1502a.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i6 = (i + length) / 2;
            if (f < this.f1502a[i6]) {
                length = i6;
            } else {
                i = i6;
            }
        }
        float[] fArr = this.f1502a;
        float f7 = fArr[length];
        float f9 = fArr[i];
        float f10 = f7 - f9;
        if (f10 == 0.0f) {
            return this.b[i];
        }
        float[] fArr2 = this.b;
        float f11 = fArr2[i];
        return B7.a.b(fArr2[length], f11, (f - f9) / f10, f11);
    }
}
