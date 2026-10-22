package com.google.android.material.carousel;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
interface Maskable {
    RectF getMaskRectF();

    float getMaskXPercentage();

    void setMaskXPercentage(float r1);

    void setOnMaskChangedListener(OnMaskChangedListener r1);
}
