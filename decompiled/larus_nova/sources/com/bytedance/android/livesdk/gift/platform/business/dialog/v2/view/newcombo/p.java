package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f126878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GiftComboProgressBar f126879b;

    public p(ValueAnimator r100, GiftComboProgressBar r101) {
        this.f126878a = r100;
        this.f126879b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        GiftComboProgressBar r101 = this.f126879b;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L16;
        r101.f126786g = ((Float) r102).floatValue();
        if (this.f126879b.getCountDownTime() <= 4000) goto L13;
        float r103 = this.f126878a.getDuration();
        GiftComboProgressBar r104 = this.f126879b;
        if ((r103 * r104.f126786g) < (r104.getCountDownTime() - 4000)) goto L13;
        Pair<Boolean, Boolean> r105 = this.f126879b.getShowCountDown().getValue();
        if (r105 == null) goto L13;
        if (r105.getFirst().booleanValue() == true) goto L13;
        this.f126879b.getShowCountDown().setValue(new Pair(Boolean.TRUE, Boolean.valueOf(this.f126879b.f126788i)));
    L13:
        this.f126879b.invalidate();
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
