package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f146854a = null;

    static {
        f146854a = new s();
    }

    public s() {
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = KSongTuningPanelHelperKt.d();
        if (r101 == null) goto L9;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L8;
        r101.m(((Float) r102).floatValue(), false, false);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
