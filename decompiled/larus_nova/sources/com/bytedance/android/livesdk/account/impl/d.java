package com.bytedance.android.livesdk.account.impl;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements lm3.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ve1.a.InterfaceC7988a f103007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ILoginCallback f103008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Map f103009e;

    @Override // lm3.c.a
    public final void onAction(lm3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r100);
    L17:
        this.f103007c.a();
        this.f103006b.f103010a.requestInteractivePrivilege(this.f103008d, this.f103009e);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L7;
        r101.post(DialogLancet.createDismissRunnable(r100));
        goto L17
    }

    public d(e r100, e.b r101, b r102, Map r103) {
        this.f103006b = r100;
        this.f103007c = r101;
        this.f103008d = r102;
        this.f103009e = r103;
    }
}
