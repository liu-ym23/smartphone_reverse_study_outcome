package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductSlcWithAnimVH f173864a;

    public s(DeepFeedProductSlcWithAnimVH r100) {
        this.f173864a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f173864a.f173814p0 = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        DeepFeedProductSlcWithAnimVH r101 = this.f173864a;
        int r102 = DeepFeedProductSlcWithAnimVH.H0;
        r101.K4(0.0f);
        this.f173864a.f173814p0 = null;
    }
}
