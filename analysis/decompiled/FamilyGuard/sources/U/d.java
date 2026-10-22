package U;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f5435a;

    /* renamed from: b, reason: collision with root package name */
    private final float f5436b;

    protected d(float[] fArr) {
        this.f5435a = fArr;
        this.f5436b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f5) {
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        if (f5 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f5435a;
        int iMin = Math.min((int) ((fArr.length - 1) * f5), fArr.length - 2);
        float f6 = this.f5436b;
        float f7 = (f5 - (iMin * f6)) / f6;
        float[] fArr2 = this.f5435a;
        float f8 = fArr2[iMin];
        return f8 + (f7 * (fArr2[iMin + 1] - f8));
    }
}
