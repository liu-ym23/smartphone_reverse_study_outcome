package com.amap.api.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes28.dex */
class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f28638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f28639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f28640c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r100) {
        SwipeDismissTouchListener.b(this.f28640c).setAlpha(0.0f);
        SwipeDismissTouchListener.b(this.f28640c).setTranslationX(0.0f);
        ViewGroup.LayoutParams r101 = this.f28638a;
        r101.height = this.f28639b;
        SwipeDismissTouchListener.b(this.f28640c).setLayoutParams(this.f28638a);
    }

    public e(SwipeDismissTouchListener r100, ViewGroup.LayoutParams r101, int r102) {
        this.f28640c = r100;
        this.f28638a = r101;
        this.f28639b = r102;
    }
}
