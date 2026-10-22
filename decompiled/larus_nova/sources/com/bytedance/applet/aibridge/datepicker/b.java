package com.bytedance.applet.aibridge.datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements f09.a.InterfaceC5845a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f191037a;

    @Override // f09.a.InterfaceC5845a
    public final void onCreate(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public b(a.c r100) {
        this.f191037a = r100;
    }

    @Override // f09.a.InterfaceC5845a
    public final void onPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onPreDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (this.f191037a.f191030p.get() == r100) goto L5;
        return;
    L5:
        AppCompatDialog r101 = this.f191037a.f191033s.get();
        if (r101 == null) goto L27;
        a.c r102 = this.f191037a;
        if (r101.isShowing() == false) goto L26;
        Handler r103 = DialogLancet.resolveDialogHandler(r101);
        if (r103 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r104 == null) goto L23;
        d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r103.getLooper()) goto L14;
        r103.post(DialogLancet.createDismissRunnable(r101));
        return;
    L26:
        a.a(r102);
        return;
    L27:
        a.c r105 = a.f191008a;
        a.a(this.f191037a);
    }

    @Override // f09.a.InterfaceC5845a
    public final void onResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onStart(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // f09.a.InterfaceC5845a
    public final void onStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }
}
