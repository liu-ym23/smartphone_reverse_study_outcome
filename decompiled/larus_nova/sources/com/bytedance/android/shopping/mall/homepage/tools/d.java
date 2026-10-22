package com.bytedance.android.shopping.mall.homepage.tools;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataEngineWrapper f178515a;

    public d(DataEngineWrapper r100) {
        this.f178515a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f178515a.B();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
