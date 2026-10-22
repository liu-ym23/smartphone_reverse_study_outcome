package androidx.interpolator.view.animation;

import B7.a;
import android.view.animation.Interpolator;

/* loaded from: classes2.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f7 = this.mStepSize;
        float f9 = (f - (iMin * f7)) / f7;
        float[] fArr2 = this.mValues;
        float f10 = fArr2[iMin];
        return a.b(fArr2[iMin + 1], f10, f9, f10);
    }
}
