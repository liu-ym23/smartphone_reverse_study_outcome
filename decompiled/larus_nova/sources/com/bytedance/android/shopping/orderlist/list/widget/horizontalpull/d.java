package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f180501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OftenShopPullLayout f180502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f180503c;

    public d(ValueAnimator r100, float r101, OftenShopPullLayout r102, float r103) {
        this.f180501a = r100;
        this.f180502b = r102;
        this.f180503c = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = this.f180501a.getAnimatedValue();
        if (r101 == null) goto L22;
        float r102 = ((Float) r101).floatValue();
        Integer r103 = this.f180502b.f180483i;
        if (r103 != null) goto L8;
    L9:
        if (r103 != null) goto L12;
    L17:
        b r104 = this.f180502b.f180484j;
        if (r104 == null) goto L24;
        r104.c();
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != 2) goto L17;
    L13:
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r105 = this.f180502b.getChildViews().entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<View, BaseHorizontalPullLayout.a> r106 = r105.next();
        r106.getKey().setX(r106.getValue().f180477a + (this.f180503c * r102));
        goto L15
    L8:
        if (r103.intValue() == 0) goto L13;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
