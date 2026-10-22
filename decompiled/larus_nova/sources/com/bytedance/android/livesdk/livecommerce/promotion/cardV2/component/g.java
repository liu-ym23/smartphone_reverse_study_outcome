package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionCardImageComponent f150560a;

    public g(PromotionCardImageComponent r100) {
        this.f150560a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        TextView r101 = this.f150560a.f150515g;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        PromotionCardImageComponent.e(r101, ((Integer) r102).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
