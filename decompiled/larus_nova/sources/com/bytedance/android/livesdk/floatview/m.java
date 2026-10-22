package com.bytedance.android.livesdk.floatview;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f125238a;

    public m(o r100) {
        this.f125238a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = com.bytedance.android.livesdk.sharedpref.b.f158168k0;
        Boolean r102 = Boolean.FALSE;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        o r103 = this.f125238a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r103);
    L17:
        Lazy r105 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger.a.a().getClass();
        VideoFloatWindowLogger.c("refuse");
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r106 == null) goto L16;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L5:
        if (Looper.myLooper() == r104.getLooper()) goto L7;
        r104.post(DialogLancet.createDismissRunnable(r103));
        goto L17
    }
}
