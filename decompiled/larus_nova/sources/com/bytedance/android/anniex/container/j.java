package com.bytedance.android.anniex.container;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f40401a;

    public j(d r100) {
        this.f40401a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Dialog r101 = this.f40401a.f40359d;
        if (r101 == null) goto L21;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }
}
