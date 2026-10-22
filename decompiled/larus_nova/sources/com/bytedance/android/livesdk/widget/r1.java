package com.bytedance.android.livesdk.widget;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r1 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveThumbProcessViewHolder f161947a;

    public r1(LiveThumbProcessViewHolder r100) {
        this.f161947a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        PlayerSeekBar r101 = this.f161947a.e();
        if (r101 == null) goto L9;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L8;
        r101.setAlpha(((Float) r102).floatValue());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
