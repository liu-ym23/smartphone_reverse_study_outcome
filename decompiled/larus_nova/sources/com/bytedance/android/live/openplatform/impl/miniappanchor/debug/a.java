package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugMenuDialog f84360a;

    public a(DebugMenuDialog r100) {
        this.f84360a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DebugMenuDialog r101 = this.f84360a;
        int r102 = DebugMenuDialog.f84343c;
        r101.getClass();
        IQRCodeService r103 = (IQRCodeService) k.f(IQRCodeService.class);
        if (r103 == null) goto L5;
        r103.startScanQRCode(r101.getContext(), new b(r101));
    L5:
        DebugMenuDialog r104 = this.f84360a;
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
