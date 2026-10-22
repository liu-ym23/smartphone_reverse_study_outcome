package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSelfDiggOptimizeView.c f137917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f137918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f137919c;

    public d(BottomSelfDiggOptimizeView.c r100, long r101, long r102) {
        this.f137917a = r100;
        this.f137918b = r101;
        this.f137919c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        BottomSelfDiggOptimizeView.c r100 = this.f137917a;
        ImageView r101 = r100.f137784e;
        if (r101 != null) goto L5;
        return;
    L5:
        ImageView r102 = r100.f137783d;
        if (r102 != null) goto L8;
        return;
    L8:
        long r103 = r110.getCurrentPlayTime();
        Object r104 = null;
        if (0 <= r103) goto L12;
    L21:
        long r105 = r110.getCurrentPlayTime();
        if (100 <= r105) goto L25;
    L34:
        long r106 = this.f137918b;
        BottomSelfDiggOptimizeView r107 = this.f137917a.f137786g;
        int r108 = BottomSelfDiggOptimizeView.f137764h;
        r107.getClass();
        long r109 = 50;
        long r111 = r106 + r109;
        long r112 = this.f137918b;
        long r113 = r110.getCurrentPlayTime();
        if (r112 <= r113) goto L38;
    L47:
        long r114 = this.f137918b;
        long r115 = r110.getCurrentPlayTime();
        if (r114 <= r115) goto L51;
    L60:
        long r116 = this.f137918b;
        this.f137917a.f137786g.getClass();
        long r117 = r116 + ((long) 200);
        long r118 = this.f137918b;
        long r119 = r110.getCurrentPlayTime();
        if (r118 <= r119) goto L64;
    L73:
        long r120 = this.f137918b;
        this.f137917a.f137786g.getClass();
        long r121 = r120 + r109;
        long r122 = this.f137918b;
        this.f137917a.f137786g.getClass();
        long r123 = r122 + ((long) 100);
        long r124 = r110.getCurrentPlayTime();
        if (r121 <= r124) goto L77;
    L86:
        long r125 = this.f137919c;
        long r126 = r110.getCurrentPlayTime();
        if (r125 <= r126) goto L90;
    L100:
        Object r127 = r110.getAnimatedValue();
        if (r127 == null) goto L105;
        PointF r128 = (PointF) r127;
        r102.setTranslationX(r128.x - (this.f137917a.f137785f.f137920a * 0.5f));
        r102.setTranslationY(r128.y - (this.f137917a.f137785f.f137921b * 0.5f));
        r102.setScaleX(this.f137917a.f137780a);
        r102.setScaleY(this.f137917a.f137780a);
        r101.setTranslationX(r128.x - (this.f137917a.f137785f.f137920a * 0.5f));
        r101.setTranslationY(r128.y - (this.f137917a.f137785f.f137921b * 0.5f));
        r101.setScaleX(this.f137917a.f137781b);
        r101.setScaleY(this.f137917a.f137781b);
        return;
    L105:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    L90:
        if (1000 < r126) goto L100;
        Object r129 = r110.getAnimatedValue("iconAlpha2");
        if ((r129 instanceof Integer) == false) goto L95;
        r104 = r129;
    L95:
        Integer r130 = (Integer) r104;
        if (r130 == null) goto L98;
        int r131 = r130.intValue();
    L99:
        r101.setAlpha(r131 / 255.0f);
        goto L100
    L98:
        r131 = (int) (r101.getAlpha() * 255);
        goto L99
    L77:
        if (r123 < r124) goto L86;
        Object r132 = r110.getAnimatedValue("iconAlpha");
        if ((r132 instanceof Integer) == true) goto L81;
        r132 = null;
    L81:
        Integer r133 = (Integer) r132;
        if (r133 == null) goto L84;
        int r134 = r133.intValue();
    L85:
        r101.setAlpha(r134 / 255.0f);
        goto L86
    L84:
        r134 = (int) (r101.getAlpha() * 255);
        goto L85
    L64:
        if (r117 < r119) goto L73;
        BottomSelfDiggOptimizeView.c r135 = this.f137917a;
        Object r136 = r110.getAnimatedValue("iconScale");
        if ((r136 instanceof Float) == true) goto L68;
        r136 = null;
    L68:
        Float r137 = (Float) r136;
        if (r137 == null) goto L71;
        float r138 = r137.floatValue();
    L72:
        r135.f137781b = r138;
        goto L73
    L71:
        r138 = this.f137917a.f137781b;
        goto L72
    L51:
        if (1000 < r115) goto L60;
        Object r139 = r110.getAnimatedValue("selfAlpha");
        if ((r139 instanceof Integer) == true) goto L55;
        r139 = null;
    L55:
        Integer r140 = (Integer) r139;
        if (r140 == null) goto L58;
        int r141 = r140.intValue();
    L59:
        r102.setAlpha(r141 / 255.0f);
        goto L60
    L58:
        r141 = (int) (r102.getAlpha() * 255);
        goto L59
    L38:
        if (r111 < r113) goto L47;
        BottomSelfDiggOptimizeView.c r142 = this.f137917a;
        Object r143 = r110.getAnimatedValue("selfScale");
        if ((r143 instanceof Float) == true) goto L42;
        r143 = null;
    L42:
        Float r144 = (Float) r143;
        if (r144 == null) goto L45;
        float r145 = r144.floatValue();
    L46:
        r142.f137780a = r145;
        goto L47
    L45:
        r145 = this.f137917a.f137780a;
        goto L46
    L25:
        if (150 < r105) goto L34;
        BottomSelfDiggOptimizeView.c r146 = this.f137917a;
        Object r147 = r110.getAnimatedValue("self2");
        if ((r147 instanceof Float) == true) goto L29;
        r147 = null;
    L29:
        Float r148 = (Float) r147;
        if (r148 == null) goto L32;
        float r149 = r148.floatValue();
    L33:
        r146.f137780a = r149;
        goto L34
    L32:
        r149 = this.f137917a.f137780a;
        goto L33
    L12:
        if (100 < r103) goto L21;
        BottomSelfDiggOptimizeView.c r150 = this.f137917a;
        Object r151 = r110.getAnimatedValue("self1");
        if ((r151 instanceof Float) == true) goto L16;
        r151 = null;
    L16:
        Float r152 = (Float) r151;
        if (r152 == null) goto L19;
        float r153 = r152.floatValue();
    L20:
        r150.f137780a = r153;
        goto L21
    L19:
        r153 = this.f137917a.f137780a;
        goto L20
    }
}
