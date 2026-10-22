package com.bytedance.android.ec.window.base.widget;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BouncingMarqueeTextView f49931a;

    public a(BouncingMarqueeTextView r100) {
        this.f49931a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        this.f49931a.scrollTo(r102, 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
