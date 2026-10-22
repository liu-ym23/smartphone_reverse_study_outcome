package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftComboProgressBar f126876a;

    public n(GiftComboProgressBar r100) {
        this.f126876a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftComboProgressBar r101 = this.f126876a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L13;
        r101.f126802w = ((Float) r102).floatValue();
        GiftComboProgressBar r103 = this.f126876a;
        Object r104 = r100.getAnimatedValue();
        if (r104 == null) goto L11;
        r103.f126798s = ((Float) r104).floatValue();
        GiftComboProgressBar r105 = this.f126876a;
        if (r105.f126802w != 1.0f) goto L14;
        r105.f126803x.setValue(Boolean.TRUE);
        return;
    L14:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
