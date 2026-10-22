package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMomentFlowGuidePresenter f186308a;

    public e(ECShopMomentFlowGuidePresenter r100) {
        this.f186308a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LottieAnimationView r101 = this.f186308a.f186269h;
        if (r101 == null) goto L6;
        r101.playAnimation();
        return;
    }
}
