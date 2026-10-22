package com.bytedance.android.window.shop.home.presenter;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class e0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f188518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f188519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f188520c;

    public e0(CoordinatorLayout.Behavior r100, CoordinatorLayout r101, AppBarLayout r102) {
        this.f188518a = r100;
        this.f188519b = r101;
        this.f188520c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getAnimatedValue();
    L7:
        if ((r102 instanceof Integer) == false) goto L10;
        r101 = r102;
    L10:
        Integer r103 = (Integer) r101;
        if (r103 == null) goto L14;
        ((WindowControllableAppBarSnapBehavior) this.f188518a).snapTo(r103.intValue(), this.f188519b, this.f188520c);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
