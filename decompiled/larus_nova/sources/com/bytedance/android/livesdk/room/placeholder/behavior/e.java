package com.bytedance.android.livesdk.room.placeholder.behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f157718a;

    public e(f r100) {
        this.f157718a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f157718a.f157721d.onViewDetached();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
