package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSelfDiggOptimizeView.b f137910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f137911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f137912c;

    public b(BottomSelfDiggOptimizeView.b r100, long r101, Ref.IntRef r102) {
        this.f137910a = r100;
        this.f137911b = r101;
        this.f137912c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        BottomSelfDiggOptimizeView.b r100 = this.f137910a;
        r100.getClass();
        ImageView r101 = r100.f137776e;
        if (r101 != null) goto L5;
        return;
    L5:
        long r102 = r110.getCurrentPlayTime();
        Object r103 = null;
        if (0 <= r102) goto L9;
    L18:
        long r104 = this.f137911b;
        long r105 = r104 - (r104 / ((long) 4));
        long r106 = r110.getCurrentPlayTime();
        if (r105 <= r106) goto L22;
    L32:
        Object r111 = r110.getAnimatedValue();
        if (r111 == null) goto L37;
        PointF r112 = (PointF) r111;
        r101.setTranslationX(r112.x - (this.f137910a.f137777f.f137928i * 0.5f));
        r101.setTranslationY(r112.y - (this.f137910a.f137777f.f137929j * 0.5f));
        r101.setScaleX(this.f137910a.f137772a);
        r101.setScaleY(this.f137910a.f137772a);
        this.f137912c.element++;
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    L22:
        if (r104 < r106) goto L32;
        Object r107 = r110.getAnimatedValue("iconAlpha");
        if ((r107 instanceof Integer) == false) goto L27;
        r103 = r107;
    L27:
        Integer r108 = (Integer) r103;
        if (r108 == null) goto L30;
        int r109 = r108.intValue();
    L31:
        r101.setAlpha(r109 / 255.0f);
        goto L32
    L30:
        r109 = (int) (r101.getAlpha() * 255);
        goto L31
    L9:
        if (250 < r102) goto L18;
        BottomSelfDiggOptimizeView.b r113 = this.f137910a;
        Object r114 = r110.getAnimatedValue("iconScale");
        if ((r114 instanceof Float) == true) goto L13;
        r114 = null;
    L13:
        Float r115 = (Float) r114;
        if (r115 == null) goto L16;
        float r116 = r115.floatValue();
    L17:
        r113.f137772a = r116;
        goto L18
    L16:
        r116 = this.f137910a.f137772a;
        goto L17
    }
}
