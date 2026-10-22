package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f115239a;

    public e(j r100) {
        this.f115239a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup.LayoutParams r101 = this.f115239a.f115266c.getLayoutParams();
        if (r101 == null) goto L11;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L9;
        r102.bottomMargin = ((Integer) r103).intValue();
        this.f115239a.c().requestLayout();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
