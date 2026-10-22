package m9;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: m9.V, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1703V extends AbstractC1702U implements InterfaceC1688F {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5320a;

    public C1703V(Executor executor) {
        this.f5320a = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // m9.AbstractC1702U
    public final Executor E() {
        return this.f5320a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f5320a;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        try {
            this.f5320a.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            kotlinx.coroutines.a.d(hVar, cancellationException);
            u9.d dVar = AbstractC1691I.f5315a;
            u9.c.f6743a.dispatch(hVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1703V) && ((C1703V) obj).f5320a == this.f5320a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5320a);
    }

    @Override // m9.InterfaceC1688F
    public final InterfaceC1693K l(long j5, Runnable runnable, H7.h hVar) {
        Executor executor = this.f5320a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j5, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                kotlinx.coroutines.a.d(hVar, cancellationException);
            }
        }
        return scheduledFutureSchedule != null ? new C1692J(scheduledFutureSchedule) : RunnableC1684B.h.l(j5, runnable, hVar);
    }

    @Override // m9.InterfaceC1688F
    public final void s(long j5, C1718k c1718k) {
        Executor executor = this.f5320a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            A.a aVar = new A.a(13, this, false, c1718k);
            H7.h hVar = c1718k.e;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(aVar, j5, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                kotlinx.coroutines.a.d(hVar, cancellationException);
            }
        }
        if (scheduledFutureSchedule != null) {
            c1718k.A(new C1715h(scheduledFutureSchedule, 0));
        } else {
            RunnableC1684B.h.s(j5, c1718k);
        }
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return this.f5320a.toString();
    }
}
