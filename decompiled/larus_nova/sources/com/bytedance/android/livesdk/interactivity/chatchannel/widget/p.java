package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes9.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelOwnerSettingDialog f134697a;

    public p(ChatChannelOwnerSettingDialog r100) {
        this.f134697a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ChatChannelOwnerSettingDialog r101 = this.f134697a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
    }
}
