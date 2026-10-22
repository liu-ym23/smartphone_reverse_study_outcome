package com.bytedance.android.livesdk.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes11.dex */
public final class n extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedLivePreviewFragment f156582a;

    public n(FeedLivePreviewFragment r100) {
        this.f156582a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f156582a.f156334u.setInterceptTouchEvent(false);
    }
}
