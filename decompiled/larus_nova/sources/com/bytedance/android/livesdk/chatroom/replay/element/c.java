package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f108547a;

    public c(HSImageView r100) {
        this.f108547a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f108547a;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.j(r101);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f108547a;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.j(r101);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        View r101 = this.f108547a;
        if (r101 == null) goto L5;
        r101.setAlpha(0.0f);
    L5:
        View r102 = this.f108547a;
        if (r102 == null) goto L9;
        UtilityKotlinExtentionsKt.j(r102);
        return;
    }
}
