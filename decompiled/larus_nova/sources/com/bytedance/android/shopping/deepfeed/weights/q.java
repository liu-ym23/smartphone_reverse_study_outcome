package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductInfoMarqueeView f174241a;

    public q(DeepFeedProductInfoMarqueeView r100) {
        this.f174241a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L20;
        float r102 = ((Float) r101).floatValue();
        DeepFeedProductInfoMarqueeView r103 = this.f174241a;
        if (r103.f174116j == false) goto L12;
        View r104 = r103.f174107a;
        if (r104 == null) goto L9;
        r104.setTranslationY(r102);
    L9:
        DeepFeedProductInfoMarqueeView r105 = this.f174241a;
        View r106 = r105.f174108b;
        if (r106 == null) goto L21;
        r106.setTranslationY(r105.f174109c + r102);
        return;
    L21:
        return;
    L12:
        View r107 = r103.f174107a;
        if (r107 == null) goto L15;
        r107.setTranslationY(r103.f174109c + r102);
    L15:
        View r108 = this.f174241a.f174108b;
        if (r108 == null) goto L23;
        r108.setTranslationY(r102);
        return;
    L23:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
