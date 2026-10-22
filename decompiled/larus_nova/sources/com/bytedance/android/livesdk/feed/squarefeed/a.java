package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseOpenFeedFragment f124435a;

    public a(BaseOpenFeedFragment r100) {
        this.f124435a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        InterceptTouchLayout r101 = this.f124435a.T90();
        if (r101 == null) goto L6;
        r101.setInterceptTouchEvent(false);
        return;
    }
}
