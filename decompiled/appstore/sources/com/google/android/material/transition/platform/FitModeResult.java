package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float r10, float r11, float r12, float r13, float r14, float r15) {
        this.startScale = r10;
        this.endScale = r11;
        this.currentStartWidth = r12;
        this.currentStartHeight = r13;
        this.currentEndWidth = r14;
        this.currentEndHeight = r15;
    }
}
