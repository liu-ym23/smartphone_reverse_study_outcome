package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public class RadioLiveBackgroundDialog extends CommonBottomDialog implements View.OnClickListener {
    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_live_radio_cover;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = r100.getId();
        if (r101 != R.id.radio_live_change_photo) goto L5;
        throw null;
    L5:
        if (r101 == R.id.radio_live_remove_photo) goto L24;
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    L24:
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        findViewById(R.id.radio_live_change_photo).setOnClickListener(this);
        findViewById(R.id.radio_live_remove_photo).setOnClickListener(this);
        findViewById(R.id.radio_live_cancel).setOnClickListener(this);
    }
}
