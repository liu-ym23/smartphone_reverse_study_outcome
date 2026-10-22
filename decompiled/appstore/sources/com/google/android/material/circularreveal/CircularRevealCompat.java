package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(@NonNull CircularRevealWidget r10, float r11, float r12, float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofObject(r10, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r11, r12, r13)});
        CircularRevealWidget.RevealInfo r15 = r10.getRevealInfo();
        if (r15 == null) goto L7;
        Animator r16 = ViewAnimationUtils.createCircularReveal((View) r10, (int) r11, (int) r12, r15.radius, r13);
        AnimatorSet r17 = new AnimatorSet();
        r17.playTogether(new Animator[]{r14, r16});
        return r17;
    L7:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener createCircularRevealListener(@NonNull final CircularRevealWidget r10) {
        return new AnonymousClass1(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(CircularRevealWidget r10, float r11, float r12, float r13, float r14) {
        ObjectAnimator r15 = ObjectAnimator.ofObject(r10, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r11, r12, r13), new CircularRevealWidget.RevealInfo(r11, r12, r14)});
        Animator r16 = ViewAnimationUtils.createCircularReveal((View) r10, (int) r11, (int) r12, r13, r14);
        AnimatorSet r17 = new AnimatorSet();
        r17.playTogether(new Animator[]{r15, r16});
        return r17;
    }
}
