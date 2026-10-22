package com.bytedance.android.live.ktv.common.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f69868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f69869b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f69868a.f69871b.clearAnimation();
        this.f69868a.f69872c.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f69868a.f69870a.setText(this.f69869b);
    }

    public l(m r100, String r101) {
        this.f69868a = r100;
        this.f69869b = r101;
    }
}
