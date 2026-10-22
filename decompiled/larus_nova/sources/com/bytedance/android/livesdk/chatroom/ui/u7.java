package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class u7 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f114245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f114246b;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (getOwnerActivity() != null) goto L5;
        return;
    L5:
        if (getOwnerActivity().isFinishing() == true) goto L18;
        a(this);     // Catch: Exception -> L9
    L10:
        LiveDoubleColorBallAnimationView r100 = this.f114245a;
        if (r100 == null) goto L17;
        r100.setVisibility(8);
        return;
    L17:
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (getOwnerActivity() != null) goto L5;
        return;
    L5:
        if (getOwnerActivity().isFinishing() == false) goto L8;
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
    L12:
        LiveDoubleColorBallAnimationView r100 = this.f114245a;
        if (r100 == null) goto L20;
        r100.setVisibility(0);
        return;
    L20:
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L12
    }

    public u7(Activity r100) {
        super(r100, R.style.ttlive_RedEnvelopeDialogStyle);
        setOwnerActivity(r100);
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_live_record_share_save_dialog);
        LiveDoubleColorBallAnimationView r101 = (LiveDoubleColorBallAnimationView) findViewById(R.id.double_loading_view);
        this.f114245a = r101;
        r101.setVisibility(0);
        TextView r102 = (TextView) findViewById(R.id.text);
        String r103 = this.f114246b;
        if (r103 == null) goto L6;
        r102.setText(r103);
        return;
    }
}
