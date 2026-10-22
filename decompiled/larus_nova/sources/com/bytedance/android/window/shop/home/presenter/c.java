package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f188505a;

    public c(d r100) {
        this.f188505a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Float) == true) goto L5;
        r101 = null;
    L5:
        Float r102 = (Float) r101;
        if (r102 == null) goto L9;
        float r103 = r102.floatValue();
        this.f188505a.f188509a.y().setAlpha(r103);
        return;
    }
}
