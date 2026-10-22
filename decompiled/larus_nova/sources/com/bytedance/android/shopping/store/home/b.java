package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopAppBarSnapBehavior f183603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f183604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f183605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f183606d;

    public b(ECShopAppBarSnapBehavior r100, CoordinatorLayout r101, AppBarLayout r102, View r103) {
        this.f183603a = r100;
        this.f183604b = r101;
        this.f183605c = r102;
        this.f183606d = r103;
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
        this.f183603a.snapTo(r103.intValue(), this.f183604b, this.f183605c);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
