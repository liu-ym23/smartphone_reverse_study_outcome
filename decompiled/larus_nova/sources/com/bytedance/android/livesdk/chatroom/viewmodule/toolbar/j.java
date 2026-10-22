package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseActionSheet.ActionSheetAdapter f116357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseActionSheet.d f116358b;

    public j(BaseActionSheet.ActionSheetAdapter r100, BaseActionSheet.d r101) {
        this.f116357a = r100;
        this.f116358b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BaseActionSheet.c r101 = this.f116357a.f115612a.f115602f;
        if (r101 == null) goto L5;
        r101.a(this.f116358b);
    L5:
        Dialog r102 = this.f116357a.f115612a.getDialog();
        if (r102 == null) goto L24;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    }
}
