package com.bytedance.android.live.revlink.impl.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdk.link.model.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes47.dex */
public final class RevLinkBannedUtil$showPkBanDialog$$inlined$let$lambda$1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o5 f97640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f97641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f97642c;

    public RevLinkBannedUtil$showPkBanDialog$$inlined$let$lambda$1(o5 r100, Context r101, j0 r102) {
        this.f97640a = r100;
        this.f97641b = r101;
        this.f97642c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f97642c.getUrl();
        if (r101 == null) goto L21;
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).x6(this.f97641b, r101, new AnonymousClass1(this));
        o5 r102 = this.f97640a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        return;
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
        return;
    }
}
