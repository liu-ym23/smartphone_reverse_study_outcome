package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStockProgressLayout f150650a;

    public k(ECStockProgressLayout r100) {
        this.f150650a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ECLottieAnimationView r101 = this.f150650a.f150624c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L5:
        r101.setVisibility(8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ECLottieAnimationView r101 = this.f150650a.f150624c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressLottie");
    L5:
        r101.setVisibility(0);
    }
}
