package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f170312a;

    public g(i r100) {
        this.f170312a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0.e(this.f170312a.f170315a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
