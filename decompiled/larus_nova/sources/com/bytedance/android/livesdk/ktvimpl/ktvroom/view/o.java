package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f145212a;

    public o(j r100) {
        this.f145212a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        this.f145212a.N.f145263e = r102;
        this.f145212a.M.f145263e = r102;
        this.f145212a.O.f145263e = r102;
        this.f145212a.P.f145263e = r102;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
