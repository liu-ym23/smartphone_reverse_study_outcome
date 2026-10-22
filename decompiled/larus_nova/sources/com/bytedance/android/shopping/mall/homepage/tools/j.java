package com.bytedance.android.shopping.mall.homepage.tools;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f178528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f178529b;

    public j(List r100, int r101) {
        this.f178528a = r100;
        this.f178529b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Iterator r101 = this.f178528a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        View r102 = (View) r101.next();
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L9;
        r102.setTranslationX(((Float) r103).floatValue() * this.f178529b);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
