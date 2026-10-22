package com.bytedance.android.shopping.inflow.compat;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoZoomableToggleBottomSheetFragment f176289a;

    public d(VideoZoomableToggleBottomSheetFragment r100) {
        this.f176289a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        this.f176289a.Z90(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
