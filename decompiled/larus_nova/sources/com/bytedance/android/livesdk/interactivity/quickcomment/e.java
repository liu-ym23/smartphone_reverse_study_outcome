package com.bytedance.android.livesdk.interactivity.quickcomment;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f140564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f140565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f140566c;

    public e(ValueAnimator r100, View r101, int r102) {
        this.f140564a = r100;
        this.f140565b = r101;
        this.f140566c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup.LayoutParams r101 = this.f140565b.getLayoutParams();
        r101.height = (int) (this.f140566c * (1 - this.f140564a.getAnimatedFraction()));
        this.f140565b.setLayoutParams(r101);
    }
}
