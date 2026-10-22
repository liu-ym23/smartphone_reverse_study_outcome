package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f125256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f125257b;

    public n(o r100, FragmentActivity r101) {
        this.f125256a = r100;
        this.f125257b = r101;
    }

    public static void a(o r100) {
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = com.bytedance.android.livesdk.sharedpref.b.f158168k0;
        Boolean r102 = Boolean.TRUE;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        if (p.e() == false) goto L9;
        a(this.f125256a);
        if (rx1.m.f(this.f125257b) == true) goto L7;
        p.h(this.f125257b);
    L7:
        Lazy r103 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger.a.a().getClass();
        VideoFloatWindowLogger.c("open");
        return;
    L9:
        if (p.c() == true) goto L11;
        return;
    L11:
        if (rx1.m.e(this.f125257b) == false) goto L13;
        a(this.f125256a);
    L14:
        Lazy r104 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger.a.a().getClass();
        VideoFloatWindowLogger.c("open");
        return;
    L13:
        a(this.f125256a);
        p.g(this.f125257b);
        goto L14
    }
}
