package com.bytedance.common.utility.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TTThreadPoolExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RejectedExecutionHandler f6700a = null;

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    public b(int r12, int r13, long r14, TimeUnit r16, BlockingQueue<Runnable> r17, ThreadFactory r18) {
        super(r12, r13, r14, r16, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r17, BlockingQueue.class, "com.obric.aiagent.plugin"), (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r18, ThreadFactory.class, "com.obric.aiagent.plugin"), f6700a);
    }

    public b(int r12, int r13, long r14, TimeUnit r16, BlockingQueue<Runnable> r17, ThreadFactory r18, RejectedExecutionHandler r19) {
        super(r12, r13, r14, r16, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r17, BlockingQueue.class, "com.obric.aiagent.plugin"), (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r18, ThreadFactory.class, "com.obric.aiagent.plugin"), (RejectedExecutionHandler) ZeusTransformUtils.wrapperContextForParams(r19, RejectedExecutionHandler.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    static {
        f6700a = new ThreadPoolExecutor.AbortPolicy();
    }
}
