package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f84435a;

    public j(Ref.ObjectRef r100) {
        this.f84435a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        x0 r102 = (x0) this.f84435a.element;
        if (r102 == null) goto L21;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        return;
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
        return;
    }
}
