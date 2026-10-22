package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f173506a;

    public f(c r100) {
        this.f173506a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        c r101 = this.f173506a;
        if (r101.f173500w == r100) goto L5;
        return;
    L5:
        r101.f173496s = 1.0f;
        r101.f173497t = Long.MAX_VALUE;
        r101.requestLayout();
        this.f173506a.invalidate();
    }
}
