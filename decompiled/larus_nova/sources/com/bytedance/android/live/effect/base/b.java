package com.bytedance.android.live.effect.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdjustPercentBar f66992a;

    public b(AdjustPercentBar r100) {
        this.f66992a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f66992a.A = true;
        super.onAnimationEnd(r100);
    }
}
