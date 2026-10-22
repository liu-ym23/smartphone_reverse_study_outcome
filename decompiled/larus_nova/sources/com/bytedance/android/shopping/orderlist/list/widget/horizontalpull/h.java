package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f180509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PageHorizontalPullLayout f180510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f180511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Float f180512d;

    public h(ValueAnimator r100, PageHorizontalPullLayout r101, float r102, Float r103) {
        this.f180509a = r100;
        this.f180510b = r101;
        this.f180511c = r102;
        this.f180512d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = this.f180509a.getAnimatedValue();
        if (r101 == null) goto L19;
        float r102 = ((Float) r101).floatValue();
        Integer r103 = this.f180510b.f180495m;
        if (r103 != null) goto L8;
    L9:
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.intValue() != 2) goto L17;
    L13:
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r104 = this.f180510b.getChildViews().entrySet().iterator();
    L15:
        if (r104.hasNext() == false) goto L22;
        Map.Entry<View, BaseHorizontalPullLayout.a> r105 = r104.next();
        r105.getKey().setX((r105.getValue().f180477a + this.f180511c) + (this.f180512d.floatValue() * r102));
        goto L15
    L22:
        return;
    L17:
        return;
    L8:
        if (r103.intValue() == 0) goto L13;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
