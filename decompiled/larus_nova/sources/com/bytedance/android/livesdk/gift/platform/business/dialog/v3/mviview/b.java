package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftComboCountDownFinish;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVIComboView f127909a;

    public b(GiftMVIComboView r100) {
        this.f127909a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f127909a.o(new OnGiftComboCountDownFinish(false, 1, null));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
