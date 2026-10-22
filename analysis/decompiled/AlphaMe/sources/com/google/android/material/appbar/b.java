package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f10284a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f10285b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout$BaseBehavior f10286c;

    public b(CoordinatorLayout coordinatorLayout, AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, h hVar) {
        this.f10286c = appBarLayout$BaseBehavior;
        this.f10284a = coordinatorLayout;
        this.f10285b = hVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f10286c.e(this.f10284a, this.f10285b, iIntValue);
    }
}
