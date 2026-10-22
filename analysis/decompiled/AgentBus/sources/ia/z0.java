package ia;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class z0 extends y0 implements j0 {

    /* renamed from: h, reason: collision with root package name */
    public final Executor f5028h;

    public z0(Executor executor) {
        Method method;
        this.f5028h = executor;
        Method method2 = na.a.f6886a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = na.a.f6886a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // ia.j0
    public final p0 C(long j2, Runnable runnable, g7.l lVar) {
        Executor executor = this.f5028h;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e10);
                g1 g1Var = (g1) lVar.o(z.f5027g);
                if (g1Var != null) {
                    g1Var.d(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new o0(scheduledFutureSchedule) : e0.f4949o.C(j2, runnable, lVar);
    }

    @Override // ia.x
    public final void R(g7.l lVar, Runnable runnable) {
        try {
            this.f5028h.execute(runnable);
        } catch (RejectedExecutionException e10) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e10);
            g1 g1Var = (g1) lVar.o(z.f5027g);
            if (g1Var != null) {
                g1Var.d(cancellationException);
            }
            pa.e eVar = n0.f4982a;
            pa.d.f8556h.R(lVar, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f5028h;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z0) && ((z0) obj).f5028h == this.f5028h;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5028h);
    }

    @Override // ia.j0
    public final void k(long j2, m mVar) {
        Executor executor = this.f5028h;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            v1 v1Var = new v1(this, mVar);
            g7.l lVar = mVar.f4975j;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(v1Var, j2, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e10);
                g1 g1Var = (g1) lVar.o(z.f5027g);
                if (g1Var != null) {
                    g1Var.d(cancellationException);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            mVar.v(new h(0, scheduledFutureSchedule));
        } else {
            e0.f4949o.k(j2, mVar);
        }
    }

    @Override // ia.x
    public final String toString() {
        return this.f5028h.toString();
    }
}
