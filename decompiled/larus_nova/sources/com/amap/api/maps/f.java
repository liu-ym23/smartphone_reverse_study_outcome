package com.amap.api.maps;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes28.dex */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f28641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeDismissTouchListener f28642b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r100) {
        ViewGroup.LayoutParams r101 = this.f28641a;
        r101.height = ((Integer) r100.getAnimatedValue()).intValue();
        SwipeDismissTouchListener.b(this.f28642b).setLayoutParams(this.f28641a);
    }

    public f(SwipeDismissTouchListener r100, ViewGroup.LayoutParams r101) {
        this.f28642b = r100;
        this.f28641a = r101;
    }
}
