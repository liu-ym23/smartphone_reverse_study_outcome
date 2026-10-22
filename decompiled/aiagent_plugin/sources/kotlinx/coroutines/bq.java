package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bq extends bp implements aw {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f39168d;

    public bq(Executor r3) {
        this.f39168d = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.internal.d.a(a());
    }

    @Override // kotlinx.coroutines.bp
    public Executor a() {
        return this.f39168d;
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        Executor r0 = a();     // Catch: RejectedExecutionException -> L10
        b r1 = c.a();     // Catch: RejectedExecutionException -> L10
        if (r1 == null) goto L7;
        Runnable r2 = r1.a(r6);     // Catch: RejectedExecutionException -> L10
        if (r2 == null) goto L7;
    L8:
        r0.execute(r2);     // Catch: RejectedExecutionException -> L10
        return;
    L7:
        r2 = r6;
    L10:
        e = move-exception;
        b r7 = c.a();
        if (r7 == null) goto L14;
        r7.c();
    L14:
        a(r5, e);
        bd.c().a(r5, r6);
    }

    @Override // kotlinx.coroutines.aw
    public void a(long r11, n<? super d.x> r13) {
        n<? super d.x> r14 = (n) ZeusTransformUtils.wrapperContextForParams(r13, n.class, "com.obric.aiagent.plugin");
        Executor r0 = a();
        ScheduledFuture<?> r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ScheduledExecutorService.class) == false) goto L5;
        ScheduledExecutorService r5 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(r0, ScheduledExecutorService.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L8;
        r3 = a(r5, (Runnable) ZeusTransformUtils.preCheckCast(new cu((ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin"), r14), Runnable.class, "com.obric.aiagent.plugin"), r14.getContext(), r11);
    L8:
        if (r3 == null) goto L11;
        ce.a(r14, (Future) ZeusTransformUtils.preCheckCast(r3, Future.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        as.f38861a.a(r11, r14);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.aw
    public bf a(long r9, Runnable r11, d.c.g r12) {
        Runnable r13 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.aiagent.plugin");
        d.c.g r14 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r12, d.c.g.class, "com.obric.aiagent.plugin");
        Executor r0 = a();
        ScheduledFuture<?> r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ScheduledExecutorService.class) == false) goto L5;
        ScheduledExecutorService r1 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(r0, ScheduledExecutorService.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        r3 = a(r1, r13, r14, r9);
    L8:
        if (r3 == null) goto L11;
        return (bf) ZeusTransformUtils.preCheckCast(new be((Future) ZeusTransformUtils.preCheckCast(r3, Future.class, "com.obric.aiagent.plugin")), bf.class, "com.obric.aiagent.plugin");
    L11:
        return as.f38861a.a(r9, r13, r14);
    L5:
        r1 = null;
        goto L6
    }

    private final ScheduledFuture<?> a(ScheduledExecutorService r3, Runnable r4, d.c.g r5, long r6) {
        ScheduledExecutorService r7 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ScheduledExecutorService.class, "com.obric.aiagent.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        return r7.schedule(r8, r6, TimeUnit.MILLISECONDS);
    L5:
        e = move-exception;
        a(r9, e);
        return null;
    }

    private final void a(d.c.g r2, RejectedExecutionException r3) {
        ce.a((d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin"), bo.a("The task was rejected", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin")));
    }

    @Override // kotlinx.coroutines.bp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r2 = a();
        if (ZeusTransformUtils.instanceOf(r2, ExecutorService.class) == false) goto L5;
        ExecutorService r3 = (ExecutorService) ZeusTransformUtils.preCheckCast(r2, ExecutorService.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 == null) goto L9;
        r3.shutdown();
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.ai
    public String toString() {
        return a().toString();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, bq.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((bq) ZeusTransformUtils.preCheckCast(r3, bq.class, "com.obric.aiagent.plugin")).a() != a()) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(a());
    }
}
