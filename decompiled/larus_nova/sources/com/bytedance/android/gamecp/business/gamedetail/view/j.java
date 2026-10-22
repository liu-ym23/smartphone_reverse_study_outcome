package com.bytedance.android.gamecp.business.gamedetail.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBottomDetailDownloadView f55935a;

    public j(NewBottomDetailDownloadView r100) {
        this.f55935a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        NewBottomDetailDownloadView r101 = this.f55935a;
        r101.f55719v2 = null;
        r101.H6();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        NewBottomDetailDownloadView r101 = this.f55935a;
        r101.f55719v2 = null;
        r101.H6();
    }
}
