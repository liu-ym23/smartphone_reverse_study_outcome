package com.obric.aiagent.executionengine.eventstaskmanager.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: EventTaskDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bp f16678b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final bp f16679c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final bp f16680d = null;

    /* JADX INFO: renamed from: lambda$bRChPG9cPYD-wjkPjtykb2i2Ydk, reason: not valid java name */
    public static /* synthetic */ Thread m163lambda$bRChPG9cPYDwjkPjtykb2i2Ydk(Runnable r0) {
        return b(r0);
    }

    public static /* synthetic */ Thread lambda$fYEv2Ovki3ACrZ3lPKsf88WzGds(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$xL-4kfDRSgXUSAwNSCIcdVcwx4w, reason: not valid java name */
    public static /* synthetic */ Thread m164lambda$xL4kfDRSgXUSAwNSCIcdVcwx4w(Runnable r0) {
        return c(r0);
    }

    private a() {
    }

    static {
        f16677a = new a();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$a$fYEv2Ovki3ACrZ3lPKsf88WzGds.INSTANCE);
        o.c(r0, "newSingleThreadExecutor(...)");
        f16678b = br.a(r0);
        ExecutorService r1 = Executors.newSingleThreadExecutor($$Lambda$a$bRChPG9cPYDwjkPjtykb2i2Ydk.INSTANCE);
        o.c(r1, "newSingleThreadExecutor(...)");
        f16679c = br.a(r1);
        ExecutorService r2 = Executors.newSingleThreadExecutor($$Lambda$a$xL4kfDRSgXUSAwNSCIcdVcwx4w.INSTANCE);
        o.c(r2, "newSingleThreadExecutor(...)");
        f16680d = br.a(r2);
    }

    public final bp a() {
        return f16678b;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "event-task-db-dispatcher");
    }

    public final bp b() {
        return f16679c;
    }

    private static final Thread b(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "event-task-operation-thread");
    }

    public final bp c() {
        return f16680d;
    }

    private static final Thread c(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "event-task-monitor-thread");
    }
}
