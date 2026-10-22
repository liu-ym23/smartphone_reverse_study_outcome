package com.bytedance.android.livesdk.chatroom.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.LiveRecordWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class v0 extends Dialog implements com.bytedance.android.livesdk.chatroom.record.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f119250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f119251b;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.livesdk.f.d().f();
        this.f119251b = true;
        a(this.f119250a);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.livesdk.chatroom.record.h
    public final void dismissAllowingStateLoss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        z0 r100 = this.f119250a;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f119251b = true;
        z0 r100 = this.f119250a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        a(this.f119250a);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.record.h
    public final boolean p() {
        return isShowing();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static void a(z0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.record.h
    public final void show(FragmentManager r100, String r101) {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
    }

    public v0(Activity r100, Room r101, LiveRecordWidget.e r102, boolean r103, String r104) {
        super(r100, R.style.ttlive_live_record_share_background);
        z0 r105 = new z0(r100, r101, r103, r104);
        this.f119250a = r105;
        r105.f119286t = r102;
        r105.setOnDismissListener(new u0(this));
    }
}
