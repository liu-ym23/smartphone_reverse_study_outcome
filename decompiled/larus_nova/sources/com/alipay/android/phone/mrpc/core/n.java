package com.alipay.android.phone.mrpc.core;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes28.dex */
public final class n implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f25038a;

    public n() {
        this.f25038a = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #" + this.f25038a.getAndIncrement());
        ThreadMethodProxy.setPriority(r101, 4);
        return r101;
    }
}
