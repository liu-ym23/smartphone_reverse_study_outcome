package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainCardSettingDialog f84436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f84437b;

    public k(ExplainCardSettingDialog r100, Ref.ObjectRef r101) {
        this.f84436a = r100;
        this.f84437b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ExplainCardSettingDialog r102 = this.f84436a;
        int r103 = ExplainCardSettingDialog.f84385k;
        r102.A1();
        x0 r104 = (x0) this.f84437b.element;
        if (r104 == null) goto L21;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r104);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r106 == null) goto L18;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L7:
        if (Looper.myLooper() == r105.getLooper()) goto L9;
        r105.post(DialogLancet.createDismissRunnable(r104));
        return;
    }
}
