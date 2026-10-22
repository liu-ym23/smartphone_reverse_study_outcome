package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes14.dex */
public final class v2 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t2 f184428a;

    public v2(t2 r100) {
        this.f184428a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L9;
        float r102 = ((Float) r101).floatValue();
        ViewGroup r103 = this.f184428a.f184411y;
        if (r103 == null) goto L10;
        r103.setAlpha(r102);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
