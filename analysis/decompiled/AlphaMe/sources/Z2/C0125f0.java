package Z2;

import androidx.appcompat.widget.RunnableC0209k;
import d3.AbstractC0541c;
import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;

/* renamed from: Z2.f0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0125f0 extends AbstractC0123e0 implements L {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f2214a;

    public C0125f0(Executor executor) {
        Method method;
        this.f2214a = executor;
        Method method2 = AbstractC0541c.f12447a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = AbstractC0541c.f12447a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f2214a;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.f2214a.execute(runnable);
        } catch (RejectedExecutionException e4) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e4);
            o0 o0Var = (o0) coroutineContext.get(n0.f2230a);
            if (o0Var != null) {
                o0Var.b(cancellationException);
            }
            Q.f2190b.dispatch(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0125f0) && ((C0125f0) obj).f2214a == this.f2214a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f2214a);
    }

    @Override // Z2.L
    public final T invokeOnTimeout(long j4, Runnable runnable, CoroutineContext coroutineContext) {
        Executor executor = this.f2214a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j4, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e4) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e4);
                o0 o0Var = (o0) coroutineContext.get(n0.f2230a);
                if (o0Var != null) {
                    o0Var.b(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new S(scheduledFutureSchedule) : J.f2181h.invokeOnTimeout(j4, runnable, coroutineContext);
    }

    @Override // Z2.L
    public final void scheduleResumeAfterDelay(long j4, InterfaceC0126g interfaceC0126g) {
        Executor executor = this.f2214a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            RunnableC0209k runnableC0209k = new RunnableC0209k(this, interfaceC0126g, 17);
            C0128h c0128h = (C0128h) interfaceC0126g;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnableC0209k, j4, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e4) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e4);
                o0 o0Var = (o0) c0128h.f2220e.get(n0.f2230a);
                if (o0Var != null) {
                    o0Var.b(cancellationException);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            ((C0128h) interfaceC0126g).o(new C0122e(0, scheduledFutureSchedule));
        } else {
            J.f2181h.scheduleResumeAfterDelay(j4, interfaceC0126g);
        }
    }

    @Override // Z2.A
    public final String toString() {
        return this.f2214a.toString();
    }
}
