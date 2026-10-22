package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OftenShopPullLayout f180504a;

    public e(OftenShopPullLayout r100) {
        this.f180504a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        b r101 = this.f180504a.f180484j;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        this.f180504a.getClass();
        OftenShopPullLayout r102 = this.f180504a;
        r102.f180480f = 0.0f;
        r102.f180482h = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        b r101 = this.f180504a.f180484j;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        this.f180504a.getClass();
        OftenShopPullLayout r102 = this.f180504a;
        r102.f180480f = 0.0f;
        r102.f180482h = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        b r101 = this.f180504a.f180484j;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        this.f180504a.f180482h = true;
    }
}
