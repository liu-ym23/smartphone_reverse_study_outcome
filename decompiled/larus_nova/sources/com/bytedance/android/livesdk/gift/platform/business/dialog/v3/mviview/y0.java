package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class y0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pair f128154a;

    public y0(Pair r100) {
        this.f128154a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ((ViewGroup) this.f128154a.getFirst()).setVisibility(8);
        ((BaseGiftMVIViewChildNode) this.f128154a.getSecond()).p(8);
        ((ViewGroup) this.f128154a.getFirst()).setAlpha(1.0f);
        super.onAnimationEnd(r100);
    }
}
