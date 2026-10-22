package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainProductCardWithBuyButtonView f149869a;

    public a(ExplainProductCardWithBuyButtonView r100) {
        this.f149869a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ViewGroup.LayoutParams r101 = this.f149869a.f149841a.getLayoutParams();     // Catch: NumberFormatException -> L18
        int r102 = CastIntegerProtector.valueOf(r100.getAnimatedValue().toString()).intValue();     // Catch: NumberFormatException -> L18
        ViewGroup.LayoutParams r103 = null;
        if ((r101 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        ViewGroup.LayoutParams r104 = null;
    L6:
        RelativeLayout.LayoutParams r105 = (RelativeLayout.LayoutParams) r104;     // Catch: NumberFormatException -> L18
        if (r105 == null) goto L10;
        r105.width = r102;     // Catch: NumberFormatException -> L18
    L10:
        if ((r101 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        r103 = r101;
    L13:
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r103;     // Catch: NumberFormatException -> L18
        if (r106 == null) goto L16;
        r106.height = r102;     // Catch: NumberFormatException -> L18
    L16:
        this.f149869a.f149841a.setLayoutParams(r101);     // Catch: NumberFormatException -> L18
        return;
    L5:
        r104 = r101;
    L18:
        e = move-exception;
        String r107 = e.getMessage();
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        ECExceptionMonitor.c(r107);
    }
}
