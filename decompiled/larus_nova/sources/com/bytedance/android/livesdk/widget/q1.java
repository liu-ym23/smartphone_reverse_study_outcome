package com.bytedance.android.livesdk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveThumbProcessViewHolder f161942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f161943b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LiveThumbProcessViewHolder.b(this.f161942a).setText(this.f161943b);
        UtilityKotlinExtentionsKt.t(LiveThumbProcessViewHolder.b(this.f161942a));
        View r101 = (View) this.f161942a.f161103f.getValue();
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r101);
    L5:
        super.onAnimationEnd(r100);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        UtilityKotlinExtentionsKt.w(LiveThumbProcessViewHolder.b(this.f161942a));
    }

    public q1(LiveThumbProcessViewHolder r100, String r101) {
        this.f161942a = r100;
        this.f161943b = r101;
    }
}
