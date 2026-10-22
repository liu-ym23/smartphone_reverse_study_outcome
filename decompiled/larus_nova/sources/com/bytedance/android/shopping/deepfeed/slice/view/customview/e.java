package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f173505a;

    public e(c r100) {
        this.f173505a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        c r101 = this.f173505a;
        r101.f173501x = true;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.f173496s = ((Float) r102).floatValue();
        c r103 = this.f173505a;
        r103.f173497t = r100.getCurrentPlayTime();
        this.f173505a.invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
