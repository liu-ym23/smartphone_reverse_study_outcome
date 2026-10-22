package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSelfDiggOptimizeView.c f137936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f137937b;

    public e(BottomSelfDiggOptimizeView.c r100, long r101) {
        this.f137936a = r100;
        this.f137937b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        ImageView r100 = this.f137936a.f137784e;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = r110.getCurrentPlayTime();
        Object r102 = null;
        if (0 <= r101) goto L9;
    L18:
        long r103 = this.f137937b;
        long r104 = r103 - (r103 / ((long) 4));
        long r105 = r110.getCurrentPlayTime();
        if (r104 <= r105) goto L22;
    L32:
        Object r111 = r110.getAnimatedValue();
        if (r111 == null) goto L37;
        PointF r112 = (PointF) r111;
        r100.setTranslationX(r112.x - (this.f137936a.f137785f.f137920a * 0.5f));
        r100.setTranslationY(r112.y - (this.f137936a.f137785f.f137921b * 0.5f));
        r100.setScaleX(this.f137936a.f137781b);
        r100.setScaleY(this.f137936a.f137781b);
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    L22:
        if (r103 < r105) goto L32;
        Object r106 = r110.getAnimatedValue("iconAlpha");
        if ((r106 instanceof Integer) == false) goto L27;
        r102 = r106;
    L27:
        Integer r107 = (Integer) r102;
        if (r107 == null) goto L30;
        int r108 = r107.intValue();
    L31:
        r100.setAlpha(r108 / 255.0f);
        goto L32
    L30:
        r108 = (int) (r100.getAlpha() * 255);
        goto L31
    L9:
        if (250 < r101) goto L18;
        BottomSelfDiggOptimizeView.c r109 = this.f137936a;
        Object r113 = r110.getAnimatedValue("iconScale");
        if ((r113 instanceof Float) == true) goto L13;
        r113 = null;
    L13:
        Float r114 = (Float) r113;
        if (r114 == null) goto L16;
        float r115 = r114.floatValue();
    L17:
        r109.f137781b = r115;
        goto L18
    L16:
        r115 = this.f137936a.f137781b;
        goto L17
    }
}
