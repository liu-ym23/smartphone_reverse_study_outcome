package com.bytedance.android.shopping.store.home;

import android.animation.Animator;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopAppBarSnapBehavior f183610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f183611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f183612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f183613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f183614e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f183610a.snapTo(0, this.f183611b, this.f183612c);
        this.f183610a.f183505c = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f183610a.f183505c = false;
        ViewCompat.stopNestedScroll(this.f183613d, this.f183614e);
    }

    public c(ECShopAppBarSnapBehavior r100, CoordinatorLayout r101, AppBarLayout r102, View r103, int r104) {
        this.f183610a = r100;
        this.f183611b = r101;
        this.f183612c = r102;
        this.f183613d = r103;
        this.f183614e = r104;
    }
}
