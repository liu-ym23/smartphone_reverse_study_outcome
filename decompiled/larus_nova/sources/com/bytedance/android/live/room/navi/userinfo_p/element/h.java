package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserInfoFlipTabElement f99903a;

    public h(UserInfoFlipTabElement r100) {
        this.f99903a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f99903a.f99865n;
        if (r101 == null) goto L5;
        r101.setAlpha(1.0f);
    L5:
        ViewGroup r102 = this.f99903a.f99865n;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ViewGroup r103 = this.f99903a.f99864m;
        if (r103 == null) goto L12;
        r103.setVisibility(0);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f99903a.f99865n;
        if (r101 == null) goto L5;
        r101.setAlpha(1.0f);
    L5:
        ViewGroup r102 = this.f99903a.f99865n;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ViewGroup r103 = this.f99903a.f99864m;
        if (r103 == null) goto L12;
        r103.setVisibility(0);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
    }
}
