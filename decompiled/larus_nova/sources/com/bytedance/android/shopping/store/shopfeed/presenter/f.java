package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMomentFlowGuidePresenter f186309a;

    public f(ECShopMomentFlowGuidePresenter r100) {
        this.f186309a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TextView r101 = this.f186309a.f186270i;
        if (r101 == null) goto L6;
        r101.setVisibility(4);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        TextView r101 = this.f186309a.f186270i;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
        return;
    }
}
