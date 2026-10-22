package com.stepos.common.widget;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class H implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f3711a;

    public H(I i) {
        this.f3711a = i;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f7) {
        A6.c cVar = this.f3711a.f3712a.h;
        cVar.removeMessages(0);
        cVar.removeMessages(1);
        cVar.removeMessages(2);
        cVar.sendEmptyMessage(2);
    }
}
