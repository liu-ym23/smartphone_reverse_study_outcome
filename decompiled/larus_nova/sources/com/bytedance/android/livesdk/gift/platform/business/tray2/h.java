package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchRoomGiftTrayAnimationView f130370a;

    public h(MatchRoomGiftTrayAnimationView r100) {
        this.f130370a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup.MarginLayoutParams r101 = this.f130370a.f130345i;
        if (r101 == null) goto L9;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L8;
        r101.topMargin = ((Integer) r102).intValue();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L9:
        MatchRoomGiftTrayAnimationView r103 = this.f130370a;
        r103.setLayoutParams(r103.f130345i);
    }
}
