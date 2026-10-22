package com.bytedance.android.livesdk.authorize;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SilentAuthGuideDialog f104224a;

    public u(SilentAuthGuideDialog r100) {
        this.f104224a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f104224a.f104192d.onCancel();
        SilentAuthGuideDialog r101 = this.f104224a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        String r103 = p.f104219a;
        CheckBox r104 = (CheckBox) this.f104224a.findViewById(R.id.cbProtocol);
        if (r104 == null) goto L22;
        boolean r105 = true;
        if (r104.isChecked() != true) goto L22;
    L23:
        p.e(false, r105, "guide", false);
        return;
    L22:
        r105 = false;
        goto L23
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r106 == null) goto L16;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }
}
