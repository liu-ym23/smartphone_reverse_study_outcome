package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TipMVIView f87556a;

    public y(TipMVIView r100) {
        this.f87556a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ViewGroup r101 = (ViewGroup) this.f87556a.f87505i.getValue();
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        a1.p(r101, (int) ((Float) r102).floatValue());
        ((ViewGroup) this.f87556a.f87505i.getValue()).requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
