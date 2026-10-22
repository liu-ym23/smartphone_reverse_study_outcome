package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class n8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m8 f113734a;

    public n8(m8 r100) {
        this.f113734a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        m8 r101 = this.f113734a;
        r101.f113722l = true;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        Runnable r103 = this.f113734a.f113718h;
        if (r103 == null) goto L20;
        r103.run();
    L20:
        this.f113734a.a("leave");
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }
}
