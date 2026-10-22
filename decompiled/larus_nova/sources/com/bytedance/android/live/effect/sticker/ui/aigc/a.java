package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AigcTaskPanel f68537a;

    public a(AigcTaskPanel r100) {
        this.f68537a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        AigcTaskPanel r101 = this.f68537a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        AigcTaskPanel.S5(r101, ((Float) r102).floatValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
