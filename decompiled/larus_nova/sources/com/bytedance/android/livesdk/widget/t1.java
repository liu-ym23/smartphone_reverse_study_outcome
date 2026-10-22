package com.bytedance.android.livesdk.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t1 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveThumbProcessViewHolder f162148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f162149b;

    public t1(LiveThumbProcessViewHolder r100, boolean r101) {
        this.f162148a = r100;
        this.f162149b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        TextView r101 = LiveThumbProcessViewHolder.b(this.f162148a);
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L15;
        r101.setAlpha(((Float) r102).floatValue());
        if (this.f162149b == false) goto L13;
        View r103 = (View) this.f162148a.f161103f.getValue();
        if (r103 == null) goto L16;
        Object r104 = r100.getAnimatedValue();
        if (r104 == null) goto L12;
        r103.setAlpha(((Float) r104).floatValue());
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L16:
        return;
    L13:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
