package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.ValueAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f131098a;

    public k(View r100) {
        this.f131098a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "va");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
        s.a(this.f131098a, r103);
        return;
    }
}
