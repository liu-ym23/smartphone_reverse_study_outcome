package com.bytedance.android.ec.hybrid.tools;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f47636a;

    public g(float r100) {
        this.f47636a = r100;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 != 0.0f) goto L5;
        return r100;
    L5:
        if (r100 == 1.0f) goto L10;
        double r101 = r100;
        double r102 = Math.pow(2.0d, ((double) (-10)) * r101);
        float r103 = this.f47636a;
        return (float) ((r102 * Math.sin(((r101 - (((double) r103) / 4.0d)) * 6.283185307179586d) / ((double) r103))) + ((double) 1));
    L10:
        return r100;
    }
}
