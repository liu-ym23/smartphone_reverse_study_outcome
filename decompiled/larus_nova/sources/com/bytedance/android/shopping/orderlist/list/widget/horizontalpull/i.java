package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageHorizontalPullLayout f180513a;

    public i(PageHorizontalPullLayout r100) {
        this.f180513a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        PageHorizontalPullLayout r101 = this.f180513a;
        int r102 = PageHorizontalPullLayout.f180486s;
        r101.getClass();
        PageHorizontalPullLayout r103 = this.f180513a;
        r103.f180491i = 0.0f;
        r103.f180494l = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        PageHorizontalPullLayout r101 = this.f180513a;
        c r102 = r101.f180497o;
        if (r102 == null) goto L5;
        r102.f(r101.f180495m);
    L5:
        this.f180513a.getClass();
        PageHorizontalPullLayout r103 = this.f180513a;
        r103.f180491i = 0.0f;
        r103.f180494l = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        c r101 = this.f180513a.f180497o;
        if (r101 == null) goto L5;
        r101.e();
    L5:
        this.f180513a.f180494l = true;
    }
}
