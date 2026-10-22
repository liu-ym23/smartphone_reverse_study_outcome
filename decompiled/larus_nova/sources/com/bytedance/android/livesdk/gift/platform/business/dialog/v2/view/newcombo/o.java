package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftComboProgressBar f126877a;

    public o(GiftComboProgressBar r100) {
        this.f126877a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftComboProgressBar r101 = this.f126877a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L12;
        r101.f126786g = ((Float) r102).floatValue();
        Pair<Boolean, Boolean> r103 = this.f126877a.getShowCountDown().getValue();
        if (r103 != null) goto L7;
    L8:
        this.f126877a.getShowCountDown().setValue(new Pair(Boolean.FALSE, Boolean.valueOf(this.f126877a.f126788i)));
    L9:
        this.f126877a.invalidate();
        return;
    L7:
        if (r103.getFirst().booleanValue() == false) goto L9;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
