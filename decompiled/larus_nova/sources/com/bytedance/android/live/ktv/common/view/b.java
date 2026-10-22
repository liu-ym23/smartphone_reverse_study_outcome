package com.bytedance.android.live.ktv.common.view;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f70807a;

    public b(HSImageView r100) {
        this.f70807a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof PointF) == true) goto L5;
        r101 = null;
    L5:
        PointF r102 = (PointF) r101;
        if (r102 == null) goto L9;
        this.f70807a.setX(r102.x);
        this.f70807a.setY(r102.y);
        this.f70807a.setRotation(r100.getCurrentPlayTime() % ((long) 360));
        return;
    }
}
