package com.bytedance.android.livesdk.utils;

import android.app.ProgressDialog;
import android.content.Context;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class k5 extends ProgressDialog {
    @Override // android.app.Dialog
    public final void show() {
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L9
    L13:
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L9
        super.show();     // Catch: Exception -> L9
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L9
        goto L13
    }

    public k5(Context r100) {
        super(r100);
    }
}
