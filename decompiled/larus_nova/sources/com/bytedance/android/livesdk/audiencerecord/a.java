package com.bytedance.android.livesdk.audiencerecord;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BacktrackServiceImp f104040a;

    public a(BacktrackServiceImp r100) {
        this.f104040a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        o r101 = this.f104040a.f103977a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.e(((Float) r102).floatValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
