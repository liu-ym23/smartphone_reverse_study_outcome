package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrayWaveControllerView f129996a;

    public m(TrayWaveControllerView r100) {
        this.f129996a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f129996a.setVisibility(8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
