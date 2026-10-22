package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftComboProgressBar f126874a;

    public l(GiftComboProgressBar r100) {
        this.f126874a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftComboProgressBar r101 = this.f126874a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.f126798s = ((Float) r102).floatValue();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
