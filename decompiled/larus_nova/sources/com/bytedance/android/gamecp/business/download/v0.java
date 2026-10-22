package com.bytedance.android.gamecp.business.download;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class v0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f52956a;

    public v0(u0 r100) {
        this.f52956a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        u0.a r101 = this.f52956a.f52946f;
        if (r101 == null) goto L5;
        r101.onContinue();
    L5:
        u0 r102 = this.f52956a;
        r102.f52945e = true;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r104 == null) goto L19;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L8:
        if (Looper.myLooper() == r103.getLooper()) goto L10;
        r103.post(DialogLancet.createDismissRunnable(r102));
    }
}
