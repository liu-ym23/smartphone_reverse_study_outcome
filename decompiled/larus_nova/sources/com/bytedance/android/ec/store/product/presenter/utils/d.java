package com.bytedance.android.ec.store.product.presenter.utils;

import android.animation.ValueAnimator;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECDraweeView f48367a;

    public d(ECDraweeView r100) {
        this.f48367a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        float r102 = ((Float) r101).floatValue();     // Catch: Throwable -> L7
        this.f48367a.setAlpha(r102);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L7
    L7:
        this.f48367a.setVisibility(4);
    }
}
