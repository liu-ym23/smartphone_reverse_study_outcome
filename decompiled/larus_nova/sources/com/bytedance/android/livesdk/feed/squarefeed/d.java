package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseOpenFeedFragment f124454a;

    public d(BaseOpenFeedFragment r100) {
        this.f124454a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        InterceptTouchLayout r101 = this.f124454a.T90();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if ((r103 instanceof RelativeLayout.LayoutParams) == false) goto L10;
        r102 = r103;
    L10:
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r102;
        if (r104 == null) goto L17;
        Object r105 = r100.getAnimatedValue();
        if (r105 == null) goto L16;
        r104.topMargin = ((Integer) r105).intValue();
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L17:
        InterceptTouchLayout r106 = this.f124454a.T90();
        if (r106 == null) goto L21;
        r106.requestLayout();
        return;
    L21:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
