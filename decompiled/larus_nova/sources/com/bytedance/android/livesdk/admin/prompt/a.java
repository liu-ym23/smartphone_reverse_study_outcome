package com.bytedance.android.livesdk.admin.prompt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromptDisplayWidget f103084a;

    public a(PromptDisplayWidget r100) {
        this.f103084a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        PromptDisplayWidget r101 = this.f103084a;
        int r102 = PromptDisplayWidget.f103074e;
        if (r101.isViewValid == false) goto L6;
        r101.containerView.removeAllViews();
        return;
    }
}
