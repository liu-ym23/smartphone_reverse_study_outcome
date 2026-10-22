package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class ScaleProvider$1 extends AnimatorListenerAdapter {
    final /* synthetic */ float val$originalScaleX;
    final /* synthetic */ float val$originalScaleY;
    final /* synthetic */ View val$view;

    ScaleProvider$1(View r1, float r2, float r3) {
        this.val$view = r1;
        this.val$originalScaleX = r2;
        this.val$originalScaleY = r3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        this.val$view.setScaleX(this.val$originalScaleX);
        this.val$view.setScaleY(this.val$originalScaleY);
    }
}
