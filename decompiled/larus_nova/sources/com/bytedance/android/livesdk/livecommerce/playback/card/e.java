package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainPlaybackCardPresenter f149832a;

    public e(ExplainPlaybackCardPresenter r100) {
        this.f149832a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        FrameLayout r101 = this.f149832a.f149812h;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }
}
