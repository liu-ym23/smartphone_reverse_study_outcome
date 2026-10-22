package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class z implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o5 f78842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f78843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.network.response.e f78844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f78845d;

    public z(o5 r100, Context r101, com.bytedance.android.live.network.response.e r102, String r103) {
        this.f78842a = r100;
        this.f78843b = r101;
        this.f78844c = r102;
        this.f78845d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = ((bf2.a) this.f78844c.data).getBanDetailSchema();
        if (r101 == null) goto L21;
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(this.f78843b, UriProtector.parse(r101));
        o5 r102 = this.f78842a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r104 == null) goto L18;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L7:
        if (Looper.myLooper() == r103.getLooper()) goto L9;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L21:
        HashMap r105 = new HashMap();
        r105.put("ban_type", this.f78845d);
        r105.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, "ban_detail");
        com.bytedance.android.livesdk.log.j0.l().sendLog("audience_ban_feature_disable_popup_click", r105, new Object[0]);
    }
}
