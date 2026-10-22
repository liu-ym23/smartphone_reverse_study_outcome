package com.bytedance.android.shopping.anchorv4.nav.controls;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f167139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleDraweeView f167140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f167141c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f167139a.setVisibility(4);
        this.f167140b.setVisibility(0);
        this.f167141c.start();
    }

    public f(View r100, SimpleDraweeView r101, ViewPropertyAnimator r102) {
        this.f167139a = r100;
        this.f167140b = r101;
        this.f167141c = r102;
    }
}
