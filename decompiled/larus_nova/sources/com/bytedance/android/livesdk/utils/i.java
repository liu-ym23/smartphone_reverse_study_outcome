package com.bytedance.android.livesdk.utils;

import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f158979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Property f158980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f158981c;

    public i(View r100, m6.a r101, Function1 r102) {
        this.f158979a = r100;
        this.f158980b = r101;
        this.f158981c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        Property r101 = this.f158980b;
        View r102 = this.f158979a;
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L7;
        r101.set(r102, (Integer) r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
