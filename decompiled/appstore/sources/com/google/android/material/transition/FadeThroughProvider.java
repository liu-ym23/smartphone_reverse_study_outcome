package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float FADE_THROUGH_THRESHOLD = 0.35f;
    private float progressThreshold;

    public FadeThroughProvider() {
        this.progressThreshold = FADE_THROUGH_THRESHOLD;
    }

    private static Animator createFadeThroughAnimator(final View r10, final float r11, final float r12, @FloatRange(from = 0.0d, to = 1.0d) final float r13, @FloatRange(from = 0.0d, to = 1.0d) final float r14, final float r15) {
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.addUpdateListener(new AnonymousClass1(r10, r11, r12, r13, r14));
        r16.addListener(new AnonymousClass2(r10, r15));
        return r16;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r10, @NonNull View r11) {
        if (r11.getAlpha() != 0.0f) goto L6;
        float r12 = 1.0f;
    L5:
        float r13 = r12;
        return createFadeThroughAnimator(r11, 0.0f, r13, this.progressThreshold, 1.0f, r13);
    L6:
        r12 = r11.getAlpha();
        goto L5
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r10, @NonNull View r11) {
        if (r11.getAlpha() != 0.0f) goto L6;
        float r12 = 1.0f;
    L5:
        float r13 = r12;
        return createFadeThroughAnimator(r11, r13, 0.0f, 0.0f, this.progressThreshold, r13);
    L6:
        r12 = r11.getAlpha();
        goto L5
    }

    public float getProgressThreshold() {
        return this.progressThreshold;
    }

    public void setProgressThreshold(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.progressThreshold = r10;
    }
}
