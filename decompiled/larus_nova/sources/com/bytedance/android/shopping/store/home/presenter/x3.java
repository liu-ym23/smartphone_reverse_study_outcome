package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes14.dex */
public final class x3 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStoreAwemeFeedVideoZoomController f184463a;

    public x3(ECStoreAwemeFeedVideoZoomController r100) {
        this.f184463a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ECStoreAwemeFeedVideoZoomController r101 = this.f184463a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        ECStoreAwemeFeedVideoZoomController.a(r101, ((Integer) r102).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
