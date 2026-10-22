package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f117940a;

    public k(g r100) {
        this.f117940a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wr1.b r100 = this.f117940a.f117935c;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        LiveBlurAnimView r101 = r100.getView();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.setVisibility(8);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
