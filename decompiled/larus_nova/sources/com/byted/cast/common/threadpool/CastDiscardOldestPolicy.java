package com.byted.cast.common.threadpool;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import java.util.HashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes39.dex */
public class CastDiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {
    public CastDiscardOldestPolicy() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
        super.rejectedExecution(r100, r101);
        HashMap r102 = new HashMap();
        r102.put("executor", r101.toString());
        ThreadFactory r103 = r101.getThreadFactory();
        if ((r103 instanceof CastThreadFactory) == false) goto L5;
        r102.put("taskName", ((CastThreadFactory) r103).getNamePrefix());
    L5:
        ContextManager.getMonitor(null).sendToMetricEvent(CastMonitor.BYTECAST_THREAD_POOL_DISCARD_ERROR, r102);
    }
}
