package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f135411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f135412b;

    public g(ValueAnimator r100, TextView r101) {
        this.f135411a = r100;
        this.f135412b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
        TextView r101 = this.f135412b;
        if (r101 == null) goto L9;
        Object r102 = this.f135411a.getAnimatedValue();
        if (r102 == null) goto L8;
        r101.setRotation(((Float) r102).floatValue());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
