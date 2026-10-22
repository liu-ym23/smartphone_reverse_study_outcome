package com.bytedance.android.shopping.feed.view;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InnerFeedPageHeadWidget f175643a;

    public j(InnerFeedPageHeadWidget r100) {
        this.f175643a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Float) == true) goto L5;
        r101 = null;
    L5:
        Float r102 = (Float) r101;
        if (r102 == null) goto L8;
        float r103 = r102.floatValue();
    L9:
        TextView r104 = this.f175643a.f175572g;
        if (r104 == null) goto L13;
        r104.setScaleX(r103);
        r104.setScaleY(r103);
        return;
    L13:
        return;
    L8:
        r103 = 1.0f;
        goto L9
    }
}
