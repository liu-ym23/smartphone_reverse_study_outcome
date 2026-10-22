package K1;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private int f3580a = 100;

    /* renamed from: b, reason: collision with root package name */
    private float f3581b = 0.01f;

    /* renamed from: c, reason: collision with root package name */
    private float[] f3582c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f3583d;

    public a(float f5, float f6, float f7, float f8) {
        a(f5, f6, f7, f8);
    }

    private void a(float f5, float f6, float f7, float f8) {
        int i5 = this.f3580a;
        this.f3582c = new float[i5];
        this.f3583d = new float[i5];
        float f9 = f5 * 3.0f;
        float f10 = f7 * 3.0f;
        float f11 = (f9 + 1.0f) - f10;
        float f12 = f10 - (f5 * 6.0f);
        float f13 = f6 * 3.0f;
        float f14 = f8 * 3.0f;
        float f15 = (1.0f + f13) - f14;
        float f16 = f14 - (f6 * 6.0f);
        float f17 = 0.0f;
        for (int i6 = 0; i6 < this.f3580a; i6++) {
            float f18 = f17 * f17;
            float f19 = f18 * f17;
            this.f3582c[i6] = (f11 * f19) + (f12 * f18) + (f9 * f17);
            this.f3583d[i6] = (f19 * f15) + (f18 * f16) + (f13 * f17);
            f17 += this.f3581b;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f5) {
        if (f5 <= 0.0f) {
            return 0.0f;
        }
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f3582c.length - 1;
        int i5 = 0;
        while (length - i5 > 1) {
            int i6 = (i5 + length) / 2;
            if (f5 < this.f3582c[i6]) {
                length = i6;
            } else {
                i5 = i6;
            }
        }
        float[] fArr = this.f3582c;
        float f6 = fArr[length];
        float f7 = fArr[i5];
        float f8 = f6 - f7;
        if (f8 == 0.0f) {
            return this.f3583d[i5];
        }
        float[] fArr2 = this.f3583d;
        float f9 = fArr2[i5];
        return f9 + (((f5 - f7) / f8) * (fArr2[length] - f9));
    }
}
