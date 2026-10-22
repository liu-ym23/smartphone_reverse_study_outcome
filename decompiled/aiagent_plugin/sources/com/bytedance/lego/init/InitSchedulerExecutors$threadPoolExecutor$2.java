package com.bytedance.lego.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.p;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: InitSchedulerExecutors.kt */
/* JADX INFO: loaded from: classes.dex */
final class InitSchedulerExecutors$threadPoolExecutor$2 extends p implements a<ThreadPoolExecutor> {
    public static final InitSchedulerExecutors$threadPoolExecutor$2 INSTANCE = null;

    static {
        INSTANCE = new InitSchedulerExecutors$threadPoolExecutor$2();
    }

    InitSchedulerExecutors$threadPoolExecutor$2() {
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ ThreadPoolExecutor invoke() {
        return invoke2();
    }

    @Override // d.h.a.a
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ThreadPoolExecutor invoke2() {
        return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.aiagent.plugin"), (ThreadFactory) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, ThreadFactory.class, "com.obric.aiagent.plugin"));
    }
}
