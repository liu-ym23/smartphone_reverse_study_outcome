package com.bytedance.android.livesdk.utils;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f158966a;

    public h(Function2 r100) {
        this.f158966a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        Function2 r101 = this.f158966a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.invoke(null, (Float) r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
