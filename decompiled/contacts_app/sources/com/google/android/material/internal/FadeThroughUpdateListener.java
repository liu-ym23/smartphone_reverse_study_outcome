package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class FadeThroughUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private final float[] alphas;
    private final View fadeInView;
    private final View fadeOutView;

    public FadeThroughUpdateListener(View r1, View r2) {
        this.fadeOutView = r1;
        this.fadeInView = r2;
        this.alphas = new float[2];
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        FadeThroughUtils.calculateFadeOutAndInAlphas(((Float) r3.getAnimatedValue()).floatValue(), this.alphas);
        View r4 = this.fadeOutView;
        if (r4 == null) goto L5;
        r4.setAlpha(this.alphas[0]);
    L5:
        View r5 = this.fadeInView;
        if (r5 == null) goto L9;
        r5.setAlpha(this.alphas[1]);
        return;
    }
}
