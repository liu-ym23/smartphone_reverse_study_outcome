package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f185966a;

    public c(View r100) {
        this.f185966a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Float) == true) goto L5;
        r101 = null;
    L5:
        Float r102 = (Float) r101;
        if (r102 == null) goto L9;
        float r103 = r102.floatValue();
        this.f185966a.setAlpha(r103);
        return;
    }
}
