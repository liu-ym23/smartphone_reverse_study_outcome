package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import android.animation.Animator;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadButtonAnimation f54284a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public c(DownloadButtonAnimation r100) {
        this.f54284a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LinearLayout r101 = this.f54284a.f54262q;
        if (r101 == null) goto L5;
        r101.setAlpha(1.0f);
    L5:
        LinearLayout r102 = this.f54284a.f54262q;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LinearLayout r101 = this.f54284a.f54262q;
        if (r101 == null) goto L5;
        r101.setAlpha(0.0f);
    L5:
        LinearLayout r102 = this.f54284a.f54262q;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    }
}
