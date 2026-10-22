package com.bytedance.android.livesdk.coupon.customview;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f121855a;

    public l(h r100) {
        this.f121855a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        h r101 = this.f121855a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        h r103 = this.f121855a;
        dt1.a r104 = r103.f121849d;
        com.bytedance.android.livesdk.coupon.b.C1771b r105 = r103.f121848c.retainWindowInfoV2;
        if (r105 != null) goto L20;
        return;
    L20:
        r104.a(r105);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r106 == null) goto L16;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }
}
