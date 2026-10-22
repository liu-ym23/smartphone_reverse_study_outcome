package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class i1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g1 f57512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f57514c;

    public i1(g1 r100, Ref.ObjectRef r101, Context r102) {
        this.f57512a = r100;
        this.f57513b = r101;
        this.f57514c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Dialog r102 = (Dialog) this.f57513b.element;
        if (r102 == null) goto L21;
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
        g1 r105 = this.f57512a;
        Context r106 = this.f57514c;
        Dialog r107 = (Dialog) this.f57513b.element;
        if (r107 == null) goto L30;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L30;
        View r109 = r108.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L31;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r110 = ThreadMethodProxy.currentThread();
        if (r110 == com.larus.home.impl.utils.c.f346341a) goto L31;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");
    L31:
        g1.j(r105, r106, r109);
        return;
    L30:
        r109 = null;
        goto L31
    }
}
