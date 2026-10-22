package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
interface FitModeEvaluator {
    void applyMask(RectF r10, float r11, FitModeResult r12);

    FitModeResult evaluate(float r10, float r11, float r12, float r13, float r14, float r15, float r16);

    boolean shouldMaskStartBounds(FitModeResult r10);
}
