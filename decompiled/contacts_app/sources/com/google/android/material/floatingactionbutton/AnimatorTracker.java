package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* JADX INFO: loaded from: classes2.dex */
class AnimatorTracker {
    private Animator currentAnimator;

    AnimatorTracker() {
    }

    public void onNextAnimationStart(Animator r1) {
        cancelCurrent();
        this.currentAnimator = r1;
    }

    public void cancelCurrent() {
        Animator r0 = this.currentAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public void clear() {
        this.currentAnimator = null;
    }
}
