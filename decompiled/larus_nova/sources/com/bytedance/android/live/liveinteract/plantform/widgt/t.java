package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.os.Handler;
import android.os.Looper;
import android.widget.RadioButton;
import com.bytedance.android.live.core.setting.b6;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import zg1.h1;

/* JADX INFO: loaded from: classes46.dex */
public final class t implements lm3.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RadioButton f77723b;

    public t(RadioButton r100) {
        this.f77723b = r100;
    }

    @Override // lm3.c.a
    public final void onAction(lm3.d r100) {
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = b6.f65222a;
        Boolean r102 = Boolean.valueOf(!this.f77723b.isChecked());
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        xs2.b.a().post(new h1(58));
        Handler r103 = DialogLancet.resolveDialogHandler(r100);
        if (r103 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r103.getLooper()) goto L7;
        r103.post(DialogLancet.createDismissRunnable(r100));
    }
}
