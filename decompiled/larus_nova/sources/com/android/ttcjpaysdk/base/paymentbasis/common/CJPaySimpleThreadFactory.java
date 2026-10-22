package com.android.ttcjpaysdk.base.paymentbasis.common;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySimpleThreadFactory implements ThreadFactory {
    private boolean ignoreStatusCheck;
    private String threadName;
    private AtomicInteger threadSeq;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.threadName + "-" + this.threadSeq.incrementAndGet());
        if (this.ignoreStatusCheck == false) goto L5;
    L10:
        return r101;
    L5:
        if (r101.isDaemon() == false) goto L8;
        r101.setDaemon(false);
    L8:
        if (r101.getPriority() == 5) goto L10;
        ThreadMethodProxy.setPriority(r101, 5);
        goto L10
    }

    public CJPaySimpleThreadFactory(String r100, boolean r101) {
        this.threadSeq = new AtomicInteger();
        this.threadName = r100;
        this.ignoreStatusCheck = r101;
    }
}
