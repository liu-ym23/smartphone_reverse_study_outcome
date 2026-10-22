package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainProductCardWithBuyButtonView f149871a;

    public c(ExplainProductCardWithBuyButtonView r100) {
        this.f149871a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        ViewGroup.LayoutParams r101 = this.f149871a.f149847g.getLayoutParams();     // Catch: NumberFormatException -> L11
        int r102 = CastIntegerProtector.valueOf(r100.getAnimatedValue().toString()).intValue();     // Catch: NumberFormatException -> L11
        if ((r101 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        ViewGroup.LayoutParams r103 = null;
    L6:
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r103;     // Catch: NumberFormatException -> L11
        if (r104 == null) goto L9;
        r104.height = r102;     // Catch: NumberFormatException -> L11
    L9:
        this.f149871a.f149847g.setLayoutParams(r101);     // Catch: NumberFormatException -> L11
        return;
    L5:
        r103 = r101;
    L11:
        e = move-exception;
        String r105 = e.getMessage();
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        ECExceptionMonitor.c(r105);
    }
}
