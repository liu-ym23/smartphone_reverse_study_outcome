package com.bytedance.android.livesdk.chatroom.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f114760a;

    public j(k r100) {
        this.f114760a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r100 = this.f114760a;     // Catch: Throwable -> L4
        PopupWindowLancet.handleDismissBeforeOrigin(r100);     // Catch: Throwable -> L4
        r100.dismiss();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
