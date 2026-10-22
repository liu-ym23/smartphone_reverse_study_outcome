package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f169384a;

    public r(Function1 r100) {
        this.f169384a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Function1 r101 = this.f169384a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.invoke((Float) r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
