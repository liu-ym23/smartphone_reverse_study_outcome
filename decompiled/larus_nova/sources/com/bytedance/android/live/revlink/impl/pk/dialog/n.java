package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkRandomMatchDialogV2 f95982a;

    public n(PkRandomMatchDialogV2 r100) {
        this.f95982a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f95982a.f95455m;
        if (r101 == null) goto L11;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L11;
        Object r103 = r100.getAnimatedValue();
        if (r103 == null) goto L10;
        r102.height = ((Integer) r103).intValue();
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        View r104 = this.f95982a.f95455m;
        if (r104 == null) goto L15;
        r104.requestLayout();
        return;
    }
}
