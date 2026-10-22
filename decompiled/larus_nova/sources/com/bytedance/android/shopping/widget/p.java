package com.bytedance.android.shopping.widget;

import android.view.animation.Animation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class p implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerticalMarqueeView f187444a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public p(VerticalMarqueeView r100) {
        this.f187444a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Function0<Unit> r101 = this.f187444a.f187253c;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}
