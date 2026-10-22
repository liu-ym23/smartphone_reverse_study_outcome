package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class r3 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter f184385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f184386b;

    public r3(ECShopTopMarqueeUDSlidePresenter r100, Animator.AnimatorListener r101) {
        this.f184385a = r100;
        this.f184386b = r101;
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
        if (r103 == null) goto L16;
        int r104 = r103.intValue();
        View r105 = this.f184385a.f184064u;
        if (r105 == null) goto L17;
        wg.a.f(r105, 0, r104, 0, 0);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
