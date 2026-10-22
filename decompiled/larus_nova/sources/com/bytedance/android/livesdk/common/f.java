package com.bytedance.android.livesdk.common;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.PopupMenu;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenu.OnMenuItemClickListener f119704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f119705b;

    public f(PopupMenu.OnMenuItemClickListener r100, e r101) {
        this.f119704a = r100;
        this.f119705b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f119704a.onMenuItemClick(null) == false) goto L21;
        e r101 = this.f119705b;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }
}
