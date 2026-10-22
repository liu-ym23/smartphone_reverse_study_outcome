package com.bytedance.android.shopping.anchorv4.helper;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes12.dex */
public final class a0 implements Interpolator {
    public a0() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 != 0.0f) goto L5;
        return r100;
    L5:
        if (r100 == 1.0f) goto L10;
        double r101 = r100;
        double r102 = 4.0f;
        return (float) ((Math.pow(2.0d, ((double) (-10)) * r101) * Math.sin(((r101 - (r102 / 4.0d)) * 6.283185307179586d) / r102)) + ((double) 1));
    L10:
        return r100;
    }
}
