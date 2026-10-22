package com.obric.aiagent.executionengine.capabilitymanager;

import com.obric.aiagent.executionengine.capabilitymanager.data.CapabilityDatabase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: CapabilityRepoDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bp f16396b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final bp f16397c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CapabilityDatabase f16398d = null;

    /* JADX INFO: renamed from: lambda$JRSRQ-Z7S0g00YAReWkvhNVO1mQ, reason: not valid java name */
    public static /* synthetic */ Thread m158lambda$JRSRQZ7S0g00YAReWkvhNVO1mQ(Runnable r0) {
        return b(r0);
    }

    public static /* synthetic */ Thread lambda$lQ8SB46t2VXyMgE4z0k8LwsY_1A(Runnable r0) {
        return a(r0);
    }

    private a() {
    }

    static {
        f16395a = new a();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$a$lQ8SB46t2VXyMgE4z0k8LwsY_1A.INSTANCE);
        o.c(r0, "newSingleThreadExecutor(...)");
        f16396b = br.a(r0);
        ExecutorService r1 = Executors.newSingleThreadExecutor($$Lambda$a$JRSRQZ7S0g00YAReWkvhNVO1mQ.INSTANCE);
        o.c(r1, "newSingleThreadExecutor(...)");
        f16397c = br.a(r1);
        f16398d = CapabilityDatabase.f16426e.a();
    }

    public final bp a() {
        return f16396b;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "Capability-db-dispatcher");
    }

    public final bp b() {
        return f16397c;
    }

    private static final Thread b(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "plugin-operation-thread");
    }
}
