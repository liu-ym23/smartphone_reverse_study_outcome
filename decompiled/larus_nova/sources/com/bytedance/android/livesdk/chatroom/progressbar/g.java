package com.bytedance.android.livesdk.chatroom.progressbar;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f107729a;

    public g(TextView r100) {
        this.f107729a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        TextView r101 = this.f107729a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.setAlpha(((Float) r102).floatValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
