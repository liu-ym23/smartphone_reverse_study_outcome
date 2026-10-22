package com.bytedance.android.livesdk.chatroom.end.vip;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.chatroom.end.vip.view.CountDownProgressView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f106140a;

    public c(e r100) {
        this.f106140a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        CountDownProgressView r101 = this.f106140a.f106142a.f106130e;
        if (r101 == null) goto L9;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L8;
        r101.f106170h = ((Float) r102).floatValue();
        r101.invalidate();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
