package com.bytedance.android.livesdk.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes11.dex */
public final class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedLivePreviewFragment f156579a;

    public m(FeedLivePreviewFragment r100) {
        this.f156579a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        this.f156579a.f156333t.setVisibility(8);
        this.f156579a.f156334u.setInterceptTouchEvent(true);
    }
}
