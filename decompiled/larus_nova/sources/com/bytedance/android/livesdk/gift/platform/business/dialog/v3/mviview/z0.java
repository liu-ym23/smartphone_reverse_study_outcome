package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Pair f128156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f128157b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ((ViewGroup) this.f128156a.getFirst()).setTranslationY(this.f128157b);
        super.onAnimationEnd(r100);
    }

    public z0(Pair r100, float r101) {
        this.f128156a = r100;
        this.f128157b = r101;
    }
}
