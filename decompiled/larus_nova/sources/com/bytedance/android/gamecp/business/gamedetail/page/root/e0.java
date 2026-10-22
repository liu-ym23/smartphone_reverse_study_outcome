package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dt.b f55487a;

    public e0(dt.b r100) {
        this.f55487a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = GameDetailPreRequestUtil.f55453a;     // Catch: Throwable -> L4
        GameDetailPreRequestUtil.i(this.f55487a, GameDetailPreRequestTriggerFrom.GAME_CROWD);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
