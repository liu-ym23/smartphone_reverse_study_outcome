package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes46.dex */
public final class c0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o5 f78739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f78740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IBanUser f78741c;

    public c0(o5 r100, Context r101, IBanUser r102) {
        this.f78739a = r100;
        this.f78740b = r101;
        this.f78741c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f78741c.getUrl();
        if (r101 == null) goto L25;
        u30.b r102 = ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).buildFullScreenWebPage(this.f78740b, r101);
        Resources r103 = this.f78740b.getResources();
        if (r103 == null) goto L7;
        String r104 = r103.getString(R.string.ttlive_ban_info);
    L8:
        u30.a r105 = r102.setTitle(r104);
        r105.f548548b = true;
        r105.b();
        o5 r106 = this.f78739a;
        Handler r107 = DialogLancet.resolveDialogHandler(r106);
        if (r107 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r106);
        r106.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r106);
        return;
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r106);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r108 == null) goto L22;
        com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r107.getLooper()) goto L13;
        r107.post(DialogLancet.createDismissRunnable(r106));
        return;
    L7:
        r104 = null;
        goto L8
    }
}
