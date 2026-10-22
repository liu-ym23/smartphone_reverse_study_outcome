package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h1 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f118814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f118815b;

    public h1(float r100, View r101) {
        this.f118814a = r100;
        this.f118815b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L9;
        float r102 = ((Float) r101).floatValue();
        if (Math.abs(r102) > Math.abs(this.f118814a)) goto L10;
        this.f118815b.setTranslationY(r102);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
