package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
class AnimatorTracker {

    @Nullable
    private Animator currentAnimator;

    public AnimatorTracker() {
    }

    public void cancelCurrent() {
        Animator r10 = this.currentAnimator;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    public void clear() {
        this.currentAnimator = null;
    }

    public void onNextAnimationStart(Animator r10) {
        cancelCurrent();
        this.currentAnimator = r10;
    }
}
