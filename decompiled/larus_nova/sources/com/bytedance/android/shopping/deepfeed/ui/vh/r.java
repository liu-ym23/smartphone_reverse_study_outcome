package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductSlcWithAnimVH f173863a;

    public r(DeepFeedProductSlcWithAnimVH r100) {
        this.f173863a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        DeepFeedProductSlcWithAnimVH r103 = this.f173863a;
        int r104 = DeepFeedProductSlcWithAnimVH.H0;
        r103.K4(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
