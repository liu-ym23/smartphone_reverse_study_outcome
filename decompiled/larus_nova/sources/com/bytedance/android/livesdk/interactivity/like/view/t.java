package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggTapOptimizeView.b f137956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f137957b;

    public t(DiggTapOptimizeView.b r100, Ref.IntRef r101) {
        this.f137956a = r100;
        this.f137957b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        DiggTapOptimizeView.b r101 = this.f137956a;
        Object r102 = null;
        if (r101.f137871h.f475378d == true) goto L15;
        Object r103 = r100.getAnimatedValue("scale");
        if ((r103 instanceof Float) == true) goto L7;
        r103 = null;
    L7:
        Float r104 = (Float) r103;
        if (r104 == null) goto L10;
        float r105 = r104.floatValue();
    L11:
        r101.f137866c = r105;
        ImageView r106 = r101.f137867d;
        if (r106 == null) goto L15;
        r106.setScaleX(r105);
        r106.setScaleY(r105);
        goto L15
    L10:
        r105 = this.f137956a.f137866c;
    L15:
        if (this.f137956a.f137871h.f475379e == true) goto L32;
        long r107 = r100.getCurrentPlayTime();
        if (0 > r107) goto L32;
        if (400 < r107) goto L32;
        DiggTapOptimizeView.b r108 = this.f137956a;
        Object r109 = r100.getAnimatedValue("rotate");
        if ((r109 instanceof Float) == true) goto L24;
        r109 = null;
    L24:
        Float r110 = (Float) r109;
        if (r110 == null) goto L27;
        float r111 = r110.floatValue();
    L28:
        r108.f137865b = r111;
        DiggTapOptimizeView.b r112 = this.f137956a;
        ImageView r113 = r112.f137867d;
        if (r113 == null) goto L32;
        r113.setRotation(r112.f137865b);
        goto L32
    L27:
        r111 = this.f137956a.f137865b;
    L32:
        if (this.f137956a.f137871h.f475380f == true) goto L49;
        long r114 = r100.getCurrentPlayTime();
        if (400 > r114) goto L49;
        if (650 < r114) goto L49;
        DiggTapOptimizeView.b r115 = this.f137956a;
        Object r116 = r100.getAnimatedValue("alpha");
        if ((r116 instanceof Integer) == false) goto L42;
        r102 = r116;
    L42:
        Integer r117 = (Integer) r102;
        if (r117 == null) goto L45;
        int r118 = r117.intValue();
    L46:
        r115.f137864a = r118;
        DiggTapOptimizeView.b r119 = this.f137956a;
        ImageView r120 = r119.f137867d;
        if (r120 == null) goto L49;
        r120.setAlpha(r119.f137864a / 255.0f);
        goto L49
    L45:
        r118 = this.f137956a.f137864a;
    L49:
        this.f137957b.element++;
    }
}
