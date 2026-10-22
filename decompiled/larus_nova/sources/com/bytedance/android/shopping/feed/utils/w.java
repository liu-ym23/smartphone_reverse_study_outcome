package com.bytedance.android.shopping.feed.utils;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;

/* JADX INFO: loaded from: classes13.dex */
public final class w implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECDraweeView f175473a;

    public w(ECDraweeView r100) {
        this.f175473a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        PointF r102 = (PointF) r101;     // Catch: Throwable -> L7
        this.f175473a.setScaleX(r102.x);     // Catch: Throwable -> L7
        this.f175473a.setScaleY(r102.x);     // Catch: Throwable -> L7
        this.f175473a.setAlpha(r102.y);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");     // Catch: Throwable -> L7
    L7:
        this.f175473a.setVisibility(4);
    }
}
