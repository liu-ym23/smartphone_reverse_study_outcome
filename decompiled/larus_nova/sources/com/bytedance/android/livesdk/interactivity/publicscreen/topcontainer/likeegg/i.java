package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f139933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompositeImagePreviewDialog f139934b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f139934b.N;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r101, true);
    L5:
        TextView r102 = this.f139934b.f139887J;
        if (r102 == null) goto L8;
        UtilityKotlinExtentionsKt.A(r102, false);
    L8:
        TextView r103 = this.f139934b.K;
        if (r103 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r103, false);
    L11:
        this.f139934b.W = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        CompositeImagePreviewDialog r101 = this.f139934b;
        r101.W = null;
        View r102 = r101.M;
        if (r102 == null) goto L5;
        UtilityKotlinExtentionsKt.A(r102, false);
    L5:
        View r103 = this.f139934b.O;
        if (r103 == null) goto L9;
        UtilityKotlinExtentionsKt.A(r103, true);
        return;
    }

    public i(HSImageView r100, CompositeImagePreviewDialog r101) {
        this.f139933a = r100;
        this.f139934b = r101;
    }
}
