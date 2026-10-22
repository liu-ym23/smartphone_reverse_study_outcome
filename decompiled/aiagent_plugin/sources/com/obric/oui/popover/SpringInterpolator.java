package com.obric.oui.popover;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: SpringInterpolator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SpringInterpolator implements Interpolator {
    private float factor;

    public SpringInterpolator(float r2) {
        this.factor = 0.5f;
        this.factor = r2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        boolean r1 = false;
        if (r10 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r10;
    L8:
        if (r10 != 1.0f) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L15;
        double r2 = Math.pow(2.0d, (-10) * r10);
        float r9 = this.factor;
        return (float) ((r2 * Math.sin(((((double) r10) - (((double) r9) / 4.0d)) * 6.283185307179586d) / ((double) r9))) + ((double) 1));
    L15:
        return r10;
    L5:
        r0 = false;
        goto L6
    }
}
