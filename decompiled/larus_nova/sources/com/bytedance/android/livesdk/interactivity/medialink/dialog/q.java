package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.view.animation.Animation;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaLinkDialog f138123a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public q(MediaLinkDialog r100) {
        this.f138123a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f138123a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
