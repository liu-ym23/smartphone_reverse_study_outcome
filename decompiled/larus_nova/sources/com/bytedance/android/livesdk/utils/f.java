package com.bytedance.android.livesdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnAnimator f158943a;

    public f(AnAnimator r100) {
        this.f158943a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f158943a.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function0<Unit> r101 = this.f158943a.f158734g;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Function0<Unit> r101 = this.f158943a.f158733f;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}
