package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceControlDialog f111921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f111922b;

    public e(VrAudienceControlDialog r100, boolean r101) {
        this.f111921a = r100;
        this.f111922b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r101 = this.f111921a.B;
        if (r101 == null) goto L5;
        r101.notifyRecenter();
    L5:
        VrAudienceControlDialog.X0(this.f111921a, "restting", !this.f111922b);
        VrAudienceControlDialog r102 = this.f111921a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r102);
    L20:
        int r104 = r.f111945b;
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r105 = this.f111921a.B;
        boolean r106 = false;
        if (r105 == null) goto L27;
        com.bytedance.live.datacontext.m<? extends Boolean> r107 = r105.isVrSensorOpen();
        if (r107 == null) goto L27;
        Boolean r108 = r107.getValue();
        if (r108 == null) goto L27;
        boolean r109 = r108.booleanValue();
    L28:
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r110 = this.f111921a.B;
        if (r110 == null) goto L35;
        com.bytedance.live.datacontext.m<? extends Boolean> r111 = r110.isVrMode();
        if (r111 == null) goto L35;
        Boolean r112 = r111.getValue();
        if (r112 == null) goto L35;
        r106 = r112.booleanValue();
    L35:
        r.b("restting", r109, r106);
        return;
    L27:
        r109 = false;
        goto L28
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r113 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r113 == null) goto L19;
        com.bytedance.crash.d.d(r113, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r103.getLooper()) goto L10;
        r103.post(DialogLancet.createDismissRunnable(r102));
        goto L20
    }
}
