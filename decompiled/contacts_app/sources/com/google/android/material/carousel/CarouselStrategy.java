package com.google.android.material.carousel;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CarouselStrategy {
    static float getChildMaskPercentage(float r0, float r1, float r2) {
        return 1.0f - ((r0 - r2) / (r1 - r2));
    }

    abstract KeylineState onFirstChildMeasuredWithMargins(Carousel r1, View r2);

    public CarouselStrategy() {
    }
}
