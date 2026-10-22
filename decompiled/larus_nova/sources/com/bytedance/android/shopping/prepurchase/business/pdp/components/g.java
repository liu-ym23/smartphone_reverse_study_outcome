package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LastPageVideoZoomer f181102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f181103b;

    public g(LastPageVideoZoomer r100, View r101) {
        this.f181102a = r100;
        this.f181103b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        LastPageVideoZoomer.b(this.f181102a, r102, this.f181103b);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
