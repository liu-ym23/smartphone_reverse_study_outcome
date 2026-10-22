package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f126852a;

    public e(HSImageView r100) {
        this.f126852a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        PointF r102 = (PointF) r101;
        this.f126852a.setX(r102.x);
        this.f126852a.setY(r102.y);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
