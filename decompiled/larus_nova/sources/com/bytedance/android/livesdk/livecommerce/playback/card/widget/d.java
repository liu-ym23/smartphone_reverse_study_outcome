package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainProductCardWithBuyButtonView f149872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f149873b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f149872a.f149847g.setVisibility(8);
        Function0 r101 = this.f149873b;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
        return;
    }

    public d(ExplainProductCardWithBuyButtonView r100, Function0 r101) {
        this.f149872a = r100;
        this.f149873b = r101;
    }
}
