package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftComboCountDownFinish;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVISearchComboView f127968a;

    public q0(GiftMVISearchComboView r100) {
        this.f127968a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f127968a.o(new OnGiftComboCountDownFinish(true));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
