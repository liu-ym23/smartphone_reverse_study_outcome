package com.bytedance.android.livesdk.feed.squarefeed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.feed.squarefeed.ui.InterceptTouchLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseOpenFeedFragment f124453a;

    public c(BaseOpenFeedFragment r100) {
        this.f124453a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        TextView r101 = this.f124453a.W90();
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        InterceptTouchLayout r102 = this.f124453a.T90();
        if (r102 == null) goto L9;
        r102.setInterceptTouchEvent(true);
        return;
    }
}
