package com.bytedance.android.gamecp.business.gamedetail.view.comment;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f55837a;

    public g(l r100) {
        this.f55837a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        l r101 = this.f55837a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        Function0<Unit> r103 = this.f55837a.f55852f;
        if (r103 == null) goto L26;
        Unit r104 = r103.invoke();
        return;
    L26:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }
}
