package com.bytedance.android.ec.window.base.shop;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowAwemeFeedVideoZoomController f49637a;

    public b(ECWindowAwemeFeedVideoZoomController r100) {
        this.f49637a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ECWindowAwemeFeedVideoZoomController r101 = this.f49637a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        int r103 = ((Integer) r102).intValue();
        int r104 = ECWindowAwemeFeedVideoZoomController.f49561i;
        r101.b(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
