package com.bytedance.android.shopping.extensions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f174293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f174294b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f174294b == false) goto L6;
        this.f174293a.setVisibility(4);
        return;
    }

    public l(View r100, boolean r101) {
        this.f174293a = r100;
        this.f174294b = r101;
    }
}
