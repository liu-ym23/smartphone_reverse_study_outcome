package com.obric.common.oea.style.scene.qsanim.common;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: PropertyAnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CubicEaseOutInterpolator implements TimeInterpolator {
    public CubicEaseOutInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r5) {
        float r4 = 1;
        return ((float) Math.pow(r5 - r4, 3)) + r4;
    }
}
