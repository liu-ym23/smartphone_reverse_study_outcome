package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkResultDialogFragment f72053a;

    public o(LinkResultDialogFragment r100) {
        this.f72053a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((hk0.b) r100).f485522a == true) goto L5;
        return;
    L5:
        if (this.f72053a.isShowing() == true) goto L14;
        return;
    L14:
        this.f72053a.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L18;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
