package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f179338a;

    public m(l r100) {
        this.f179338a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L12;
        int r102 = ((Integer) r101).intValue();
        int r103 = r102 % 100;
        int r104 = 100;
        if (r103 != 0) goto L8;
        if (r102 == 0) goto L8;
    L9:
        this.f179338a.setProgress(Math.abs(r104));
        return;
    L8:
        r104 = (r103 + 100) % 100;
        goto L9
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
