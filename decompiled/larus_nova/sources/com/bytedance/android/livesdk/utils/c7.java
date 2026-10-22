package com.bytedance.android.livesdk.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class c7 extends ProgressDialog {
    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public final void setMessage(CharSequence r100) {
    }

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

    public c7(Context r100) {
        super(r100, 0);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_weak_loading);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        r101.clearFlags(2);
        return;
    }
}
