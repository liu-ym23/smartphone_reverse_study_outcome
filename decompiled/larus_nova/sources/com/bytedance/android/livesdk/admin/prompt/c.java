package com.bytedance.android.livesdk.admin.prompt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromptDisplayWidget f103090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f103091b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        PromptDisplayWidget r101 = this.f103090a;
        if (r101.isViewValid == false) goto L8;
        ViewGroup r102 = r101.containerView;
        if (r102 == null) goto L9;
        r102.removeView(this.f103091b);
        return;
    L9:
        return;
    }

    public c(PromptDisplayWidget r100, View r101) {
        this.f103090a = r100;
        this.f103091b = r101;
    }
}
