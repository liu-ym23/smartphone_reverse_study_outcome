package com.google.android.material.appbar;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ androidx.coordinatorlayout.widget.a f2331a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ g f2332b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ AppBarLayout$BaseBehavior f2333c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2333c.k(this.f2331a, this.f2332b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
