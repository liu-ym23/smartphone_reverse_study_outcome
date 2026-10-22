package kc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 extends p0 implements a0 {

    /* renamed from: f, reason: collision with root package name */
    public Executor f7474f;

    @Override // kc.a0
    public final void F(long j10, g gVar) {
        Executor executor = this.f7474f;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(7);
            dVar.f2885f = this;
            dVar.f2886g = gVar;
            VarHandle.storeStoreFence();
            nb.g gVar2 = gVar.i;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(dVar, j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e10);
                w.e(gVar2, cancellationException);
            }
        }
        if (scheduledFutureSchedule == null) {
            x.f7499m.F(j10, gVar);
            return;
        }
        e eVar = new e(0);
        eVar.f7429b = scheduledFutureSchedule;
        VarHandle.storeStoreFence();
        gVar.v(eVar);
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        try {
            this.f7474f.execute(runnable);
        } catch (RejectedExecutionException e10) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e10);
            w.e(gVar, cancellationException);
            rc.e eVar = e0.f7430a;
            rc.d.f10552f.M(gVar, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f7474f;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q0) && ((q0) obj).f7474f == this.f7474f;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7474f);
    }

    @Override // kc.a0
    public final g0 n(long j10, o1 o1Var, nb.g gVar) {
        Executor executor = this.f7474f;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(o1Var, j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e10);
                w.e(gVar, cancellationException);
            }
        }
        if (scheduledFutureSchedule == null) {
            return x.f7499m.n(j10, o1Var, gVar);
        }
        f0 f0Var = new f0();
        f0Var.f7433c = scheduledFutureSchedule;
        VarHandle.storeStoreFence();
        return f0Var;
    }

    @Override // kc.p
    public final String toString() {
        return this.f7474f.toString();
    }
}
