package com.bytedance.android.goldboxentrance.saas.firstguide;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBoxGuider f58157a;

    public d(NewBoxGuider r100) {
        this.f58157a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L12;
        PointF r102 = (PointF) r101;
        HSImageView r103 = this.f58157a.f58139b;
        if (r103 == null) goto L7;
        r103.setTranslationX(r102.x);
    L7:
        HSImageView r104 = this.f58157a.f58139b;
        if (r104 == null) goto L13;
        r104.setTranslationY(r102.y);
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
