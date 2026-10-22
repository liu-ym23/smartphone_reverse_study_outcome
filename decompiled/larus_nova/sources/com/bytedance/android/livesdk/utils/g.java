package com.bytedance.android.livesdk.utils;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f158953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f158954b;

    public g(View r100, Function2 r101) {
        this.f158953a = r100;
        this.f158954b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        Function2 r101 = this.f158954b;
        View r102 = this.f158953a;
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L7;
        r101.invoke(r102, (Float) r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
