package com.bytedance.android.livesdk.common;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.PopupMenu;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f119706a;

    public g(e r100) {
        this.f119706a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PopupMenu.OnMenuItemClickListener r101 = this.f119706a.f119700i;
        if (r101 != null) goto L5;
    L6:
        e r102 = this.f119706a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r104 == null) goto L20;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L9:
        if (Looper.myLooper() == r103.getLooper()) goto L11;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L5:
        if (r101.onMenuItemClick(null) == true) goto L6;
    }
}
