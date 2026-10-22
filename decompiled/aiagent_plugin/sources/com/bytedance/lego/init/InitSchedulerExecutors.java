package com.bytedance.lego.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.a;
import d.h.b.aa;
import d.h.b.y;
import d.m.h;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: InitSchedulerExecutors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitSchedulerExecutors {
    static final /* synthetic */ h[] $$delegatedProperties = null;
    public static final InitSchedulerExecutors INSTANCE = null;
    private static final f threadPoolExecutor$delegate = null;

    public final ThreadPoolExecutor getThreadPoolExecutor$initscheduler_release() {
        f r2 = threadPoolExecutor$delegate;
        h r0 = $$delegatedProperties[0];
        return (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r2.b(), ThreadPoolExecutor.class, "com.obric.aiagent.plugin");
    }

    static {
        $$delegatedProperties = new h[]{(h) ZeusTransformUtils.preCheckCast(aa.a(new y(aa.b(InitSchedulerExecutors.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;")), h.class, "com.obric.aiagent.plugin")};
        INSTANCE = new InitSchedulerExecutors();
        threadPoolExecutor$delegate = g.a((a) ZeusTransformUtils.preCheckCast(InitSchedulerExecutors$threadPoolExecutor$2.INSTANCE, a.class, "com.obric.aiagent.plugin"));
    }

    private InitSchedulerExecutors() {
    }
}
