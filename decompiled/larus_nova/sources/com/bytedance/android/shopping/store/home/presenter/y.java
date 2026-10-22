package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class y implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2 f184464a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
    }

    public y(ECShopFloatCartEntryPresenterV2 r100) {
        this.f184464a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ECShopFloatCartEntryPresenterV2.T(this.f184464a).setVisibility(8);
        ECShopFloatCartEntryPresenterV2.S(this.f184464a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ECShopFloatCartEntryPresenterV2.T(this.f184464a).setVisibility(8);
        ECShopFloatCartEntryPresenterV2.S(this.f184464a);
    }
}
