package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f181573a;

    public r(n r100) {
        this.f181573a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a0 r101 = this.f181573a.f181566a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L5:
        ECDraweeView r102 = r101.getIvCover();
        if (r102 == null) goto L9;
        r102.setVisibility(8);
        return;
    }
}
