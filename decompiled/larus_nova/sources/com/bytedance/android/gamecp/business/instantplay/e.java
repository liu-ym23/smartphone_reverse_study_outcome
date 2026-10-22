package com.bytedance.android.gamecp.business.instantplay;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;
import wu.e1;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f56120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f56121b;

    public e(Ref.ObjectRef r100, Activity r101) {
        this.f56120a = r100;
        this.f56121b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Dialog r102 = (Dialog) this.f56120a.element;
        if (r102 == null) goto L21;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r104 == null) goto L18;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L7:
        if (Looper.myLooper() == r103.getLooper()) goto L9;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L21:
        String r105 = e1.f561301a.getValue();
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(this.f56121b, r105);
    }
}
