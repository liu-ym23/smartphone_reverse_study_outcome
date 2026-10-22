package com.bytedance.android.gamecp.business.gamedetail;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import xr.r;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageVideoAndLiveProcessor f55310a;

    public n(PageVideoAndLiveProcessor r100) {
        this.f55310a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r r101 = this.f55310a.f53456h.get();
        if (r101 == null) goto L9;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L8;
        ((Float) r102).floatValue();
        float r103 = this.f55310a.f53452d;
        r101.a();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
