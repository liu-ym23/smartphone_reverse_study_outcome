package com.bytedance.android.livesdk.interactivity.quickcomment;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f140567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f140568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f140569c;

    public f(ValueAnimator r100, View r101, int r102) {
        this.f140567a = r100;
        this.f140568b = r101;
        this.f140569c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup.LayoutParams r101 = this.f140568b.getLayoutParams();
        r101.height = (int) (this.f140569c * this.f140567a.getAnimatedFraction());
        this.f140568b.setLayoutParams(r101);
    }
}
