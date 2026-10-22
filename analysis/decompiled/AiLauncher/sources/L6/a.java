package L6;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public class a implements Interpolator {
    private float[] mX;
    private float[] mY;
    private int count = 100;
    private float precision = 0.01f;

    public a(float f10, float f11, float f12, float f13) {
        a(f10, f11, f12, f13);
    }

    public final void a(float f10, float f11, float f12, float f13) {
        int i10 = this.count;
        this.mX = new float[i10];
        this.mY = new float[i10];
        float f14 = f10 * 3.0f;
        float f15 = f12 * 3.0f;
        float f16 = (f14 + 1.0f) - f15;
        float f17 = f15 - (f10 * 6.0f);
        float f18 = f11 * 3.0f;
        float f19 = f13 * 3.0f;
        float f20 = (1.0f + f18) - f19;
        float f21 = f19 - (f11 * 6.0f);
        float f22 = 0.0f;
        for (int i11 = 0; i11 < this.count; i11++) {
            float f23 = f22 * f22;
            float f24 = f23 * f22;
            this.mX[i11] = (f16 * f24) + (f17 * f23) + (f14 * f22);
            this.mY[i11] = (f24 * f20) + (f23 * f21) + (f18 * f22);
            f22 += this.precision;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i10 = 0;
        while (length - i10 > 1) {
            int i11 = (i10 + length) / 2;
            if (f10 < this.mX[i11]) {
                length = i11;
            } else {
                i10 = i11;
            }
        }
        float[] fArr = this.mX;
        float f11 = fArr[length];
        float f12 = fArr[i10];
        float f13 = f11 - f12;
        if (f13 == 0.0f) {
            return this.mY[i10];
        }
        float[] fArr2 = this.mY;
        float f14 = fArr2[i10];
        return f14 + (((f10 - f12) / f13) * (fArr2[length] - f14));
    }
}
