package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f127922a;

    public d1(ViewGroup r100) {
        this.f127922a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f127922a;
        if (r101 == null) goto L5;
        r101.setAlpha(1.0f);
    L5:
        ViewGroup r102 = this.f127922a;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        super.onAnimationEnd(r100);
    }
}
