package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes14.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f184454a;

    public x(ECShopFloatCartEntryPresenterV2 r100) {
        this.f184454a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        ViewGroup.LayoutParams r103 = ECShopFloatCartEntryPresenterV2.T(this.f184454a).getLayoutParams();
        ECShopFloatCartEntryPresenterV2 r104 = this.f184454a;
        r103.width = (int) (r104.f183931v * r102);
        ECShopFloatCartEntryPresenterV2.T(r104).setLayoutParams(r103);
        ECShopFloatCartEntryPresenterV2.T(this.f184454a).setAlpha(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
