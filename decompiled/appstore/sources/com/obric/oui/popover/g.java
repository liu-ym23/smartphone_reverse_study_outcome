package com.obric.oui.popover;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16132a;

    public g(float r10) {
        this.f16132a = r10;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 != 0.0f) goto L6;
        return r10;
    L6:
        if (r10 == 1.0f) goto L11;
        double r11 = Math.pow(2.0d, (-10) * r10);
        float r12 = this.f16132a;
        return (float) ((r11 * Math.sin(((((double) r10) - (((double) r12) / 4.0d)) * 6.283185307179586d) / ((double) r12))) + ((double) 1));
    L11:
        return r10;
    }
}
