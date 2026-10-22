package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f151028a;

    public e(View r100) {
        this.f151028a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        this.f151028a.setAlpha(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
