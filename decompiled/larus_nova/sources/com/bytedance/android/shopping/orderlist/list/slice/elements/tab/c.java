package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f180306a;

    public c(b r100) {
        this.f180306a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        this.f180306a.f180302d.scrollTo(r102, 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
