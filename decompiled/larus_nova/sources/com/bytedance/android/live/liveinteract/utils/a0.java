package com.bytedance.android.live.liveinteract.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class a0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o5 f78730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f78731b;

    public a0(o5 r100, String r101) {
        this.f78730a = r100;
        this.f78731b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        o5 r101 = this.f78730a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        HashMap r103 = new HashMap();
        r103.put("ban_type", this.f78731b);
        r103.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        com.bytedance.android.livesdk.log.j0.l().sendLog("audience_ban_feature_disable_popup_click", r103, new Object[0]);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }
}
