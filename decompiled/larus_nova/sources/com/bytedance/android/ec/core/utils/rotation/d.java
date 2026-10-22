package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f45706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f45707b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f45707b.setVisibility(8);
        e r101 = this.f45706a;
        View r102 = this.f45707b;
        r101.getClass();
        e.h(r102);
    }

    public d(e r100, View r101) {
        this.f45706a = r100;
        this.f45707b = r101;
    }
}
