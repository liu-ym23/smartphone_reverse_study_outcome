package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopGroupAnimation f183793a;

    public n(ECShopGroupAnimation r100) {
        this.f183793a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = this.f183793a.f183536c;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L24;
        int r103 = r101 - ((Integer) r102).intValue();
        Iterator<Map.Entry<Integer, ECShopGroupAnimation.a>> r104 = this.f183793a.f183538e.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L22;
        Map.Entry<Integer, ECShopGroupAnimation.a> r105 = r104.next();
        Integer r106 = r105.getKey();
        ECShopGroupAnimation.a r107 = r105.getValue();
        Pair<Integer, Integer> r108 = this.f183793a.f183539f.get(r106);
        int r109 = 0;
        if (r108 == null) goto L12;
        Integer r110 = r108.getFirst();
        if (r110 == null) goto L12;
        int r111 = r110.intValue();
    L13:
        Pair<Integer, Integer> r112 = this.f183793a.f183539f.get(r106);
        if (r112 == null) goto L18;
        Integer r113 = r112.getSecond();
        if (r113 == null) goto L18;
        r109 = r113.intValue();
    L18:
        if (r111 > r103) goto L6;
        if (r109 <= r103) goto L6;
        int r114 = r103 - r111;
        r107.onChange(r114, r114 / (r109 - r111));
    L12:
        r111 = 0;
        goto L13
    L22:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
