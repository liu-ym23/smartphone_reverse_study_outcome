package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f61148a;

    public a(RoundCornerConstraintLayout r100) {
        this.f61148a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        View r101 = this.f61148a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        a1.k(r101, ((Integer) r102).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
