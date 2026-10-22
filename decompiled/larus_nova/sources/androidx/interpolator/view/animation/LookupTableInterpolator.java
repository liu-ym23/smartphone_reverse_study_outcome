package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes17.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] r100) {
        this.mValues = r100;
        this.mStepSize = 1.0f / (r100.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        if (r100 < 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r100 > 0.0f) goto L8;
        return 0.0f;
    L8:
        float[] r101 = this.mValues;
        int r102 = Math.min((int) ((r101.length - 1) * r100), r101.length - 2);
        float r103 = this.mStepSize;
        float r104 = (r100 - (r102 * r103)) / r103;
        float[] r105 = this.mValues;
        float r106 = r105[r102];
        return r106 + (r104 * (r105[r102 + 1] - r106));
    }
}
