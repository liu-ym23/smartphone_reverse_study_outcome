package com.bytedance.android.shopping.anchorv4.bottom;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECDraweeView f165802a;

    public d(ECDraweeView r100) {
        this.f165802a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        PointF r102 = (PointF) r101;     // Catch: Throwable -> L7
        this.f165802a.setScaleX(r102.x);     // Catch: Throwable -> L7
        this.f165802a.setScaleY(r102.x);     // Catch: Throwable -> L7
        this.f165802a.setAlpha(r102.y);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");     // Catch: Throwable -> L7
    L7:
        this.f165802a.setVisibility(4);
    }
}
