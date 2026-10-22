package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.message.model.kj;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes8.dex */
public final class w1 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveEndRemindWidget f117542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f117543b;

    public w1(LiveEndRemindWidget r100, int r101, kj r102) {
        this.f117542a = r100;
        this.f117543b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        if (13 != this.f117543b) goto L5;
        LiveEndRemindWidget r100 = this.f117542a;
        int r101 = LiveEndRemindWidget.f114977d;
        r100.getClass();
        LiveEndRemindWidget.zq("livesdk_anchor_elderly_midnight2_popup_status", null);
    L5:
        c9 r102 = this.f117542a.f114980c;
        if (r102 == null) goto L24;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r102);
        goto L24
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L24:
        LiveEndRemindWidget.xq(this.f117542a);
    }
}
