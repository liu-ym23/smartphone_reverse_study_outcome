package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkUserFollowGuideDialog f81089a;

    public s(LinkUserFollowGuideDialog r100) {
        this.f81089a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.longValue() != 1) goto L24;
        LinkUserFollowGuideDialog r102 = this.f81089a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    }
}
