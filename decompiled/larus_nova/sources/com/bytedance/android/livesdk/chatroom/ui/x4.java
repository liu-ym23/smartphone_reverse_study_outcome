package com.bytedance.android.livesdk.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes8.dex */
public final class x4 extends AnimatorListenerAdapter {
    public x4() {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        xs2.b.a().post(new zg1.s(false));
    }
}
