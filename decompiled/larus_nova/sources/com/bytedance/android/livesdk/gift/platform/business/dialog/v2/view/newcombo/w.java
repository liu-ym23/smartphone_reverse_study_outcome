package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftComboView f126953a;

    public w(GiftComboView r100) {
        this.f126953a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        AnimatorSet r101 = this.f126953a.f126826u;
        if (r101 == null) goto L6;
        r101.start();
        return;
    }
}
