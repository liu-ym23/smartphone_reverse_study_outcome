package com.bytedance.android.sdk.bdticketguard;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f163978a;

    public q0(Function0 r100) {
        this.f163978a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f163978a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
