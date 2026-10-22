package com.bytedance.android.shopping.store.home.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopToolDialog f184700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.model.h f184701b;

    public c(ECShopToolDialog r100, com.bytedance.android.ec.model.h r101) {
        this.f184700a = r100;
        this.f184701b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f184701b.f47864a;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke();
    L5:
        ECShopToolDialog r103 = this.f184700a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r105 == null) goto L19;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L8:
        if (Looper.myLooper() == r104.getLooper()) goto L10;
        r104.post(DialogLancet.createDismissRunnable(r103));
    }
}
