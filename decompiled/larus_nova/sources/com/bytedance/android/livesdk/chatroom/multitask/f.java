package com.bytedance.android.livesdk.chatroom.multitask;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f107038a;

    public f(e r100) {
        this.f107038a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e r101 = this.f107038a;
        Function1<? super Dialog, Unit> r102 = r101.f107028c.f107037g;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(r101);
    L5:
        e r104 = this.f107038a;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r104);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r106 == null) goto L19;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L8:
        if (Looper.myLooper() == r105.getLooper()) goto L10;
        r105.post(DialogLancet.createDismissRunnable(r104));
    }
}
