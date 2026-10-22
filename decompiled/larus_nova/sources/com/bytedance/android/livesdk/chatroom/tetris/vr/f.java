package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialog f111923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f111924b;

    public f(VrAudienceControlDialog r100, boolean r101) {
        this.f111923a = r100;
        this.f111924b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = this.f111923a.B;
        if (r101 == null) goto L5;
        r101.enterVrMode();
    L5:
        VrAudienceControlDialog r102 = this.f111923a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r102);
    L20:
        VrAudienceControlDialog.X0(this.f111923a, "immersion", !this.f111924b);
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
        goto L20
    }
}
