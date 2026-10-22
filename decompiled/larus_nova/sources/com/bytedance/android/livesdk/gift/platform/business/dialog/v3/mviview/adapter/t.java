package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftGroupComboFinish;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f127890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f127891b;

    public t(s r100, int r101) {
        this.f127890a = r100;
        this.f127891b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f127890a.o(new OnGiftGroupComboFinish(this.f127891b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
