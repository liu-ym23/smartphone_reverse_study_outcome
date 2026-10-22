package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGroupComboFinish;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f127882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f127883b;

    public r(q r100, int r101) {
        this.f127882a = r100;
        this.f127883b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f127882a.o(new OnGroupComboFinish(this.f127883b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
