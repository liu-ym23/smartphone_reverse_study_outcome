package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordGuideDialog f136129a;

    public f(LiveHighlightRecordGuideDialog r100) {
        this.f136129a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        CloseDialogSource r101 = (CloseDialogSource) r100;
        LiveHighlightRecordGuideDialog r102 = this.f136129a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
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
        r103.post(DialogLancet.createDismissRunnable(r102));
    }
}
