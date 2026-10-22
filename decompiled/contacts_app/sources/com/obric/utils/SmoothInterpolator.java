package com.obric.utils;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes4.dex */
public class SmoothInterpolator extends BaseInterpolator {
    private static final float NORMALIZATION_FACTOR = 1.0011656f;
    private static final float OMEGA = 9.06472f;

    public SmoothInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r4) {
        return (1.0f - (((OMEGA * r4) + 1.0f) * ((float) Math.exp(r4 * (-9.06472f))))) * NORMALIZATION_FACTOR;
    }
}
