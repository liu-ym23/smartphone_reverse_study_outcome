package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkEnlargeSelectEnlargePositionDialog f72774a;

    public c(MultiLinkEnlargeSelectEnlargePositionDialog r100) {
        this.f72774a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((EnlargeGuestInfo) r100).getEnlargeGuestType() == EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L21;
        MultiLinkEnlargeSelectEnlargePositionDialog r101 = this.f72774a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }
}
