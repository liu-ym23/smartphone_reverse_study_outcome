package com.bytedance.safetyguard.lxc.internal.client;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
final class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f9977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ScheduledExecutorService f9978b = null;

    public static /* synthetic */ Thread lambda$kEs3gNLE4fZ_t0Vq6Z6DKzJXwfM(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$smr1_7lIT4QcCJ5NEgBlRx0S4lI(ScheduledFuture r0) {
        a(r0);
    }

    private f() {
    }

    static {
        f9977a = new f();
        f9978b = Executors.newSingleThreadScheduledExecutor($$Lambda$f$kEs3gNLE4fZ_t0Vq6Z6DKzJXwfM.INSTANCE);
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "safetyguard-proxy-recovery-timeout");
        r0.setDaemon(true);
        return r0;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.client.q
    public p a(long r2, Runnable r4) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "task");
        final ScheduledFuture<?> r3 = f9978b.schedule(r1, r2, TimeUnit.MILLISECONDS);
        return new $$Lambda$f$smr1_7lIT4QcCJ5NEgBlRx0S4lI(r3);
    }

    private static final void a(ScheduledFuture r2) {
        ((ScheduledFuture) ZeusTransformUtils.wrapperContextForParams(r2, ScheduledFuture.class, "com.obric.aiagent.plugin")).cancel(false);
    }
}
