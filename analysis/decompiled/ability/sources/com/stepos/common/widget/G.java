package com.stepos.common.widget;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class G implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f3710a;

    public G(I i) {
        this.f3710a = i;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f, float f7) {
        this.f3710a.f3712a.a();
    }
}
