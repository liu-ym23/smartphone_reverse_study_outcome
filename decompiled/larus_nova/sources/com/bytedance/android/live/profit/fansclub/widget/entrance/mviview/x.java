package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TipMVIView f87555a;

    public x(TipMVIView r100) {
        this.f87555a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TextView r101 = (TextView) this.f87555a.f87506j.getValue();
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L11;
        r101.setAlpha(((Float) r102).floatValue());
        TextView r103 = this.f87555a.p();
        Object r104 = r100.getAnimatedValue();
        if (r104 == null) goto L9;
        r103.setAlpha(((Float) r104).floatValue());
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
