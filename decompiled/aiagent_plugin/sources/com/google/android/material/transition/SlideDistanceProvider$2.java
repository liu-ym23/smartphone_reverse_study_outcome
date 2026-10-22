package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class SlideDistanceProvider$2 extends AnimatorListenerAdapter {
    final /* synthetic */ float val$originalTranslation;
    final /* synthetic */ View val$view;

    SlideDistanceProvider$2(View r1, float r2) {
        this.val$view = r1;
        this.val$originalTranslation = r2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r1) {
        this.val$view.setTranslationY(this.val$originalTranslation);
    }
}
