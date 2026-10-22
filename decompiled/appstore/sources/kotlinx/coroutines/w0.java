package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class w0 extends ExecutorCoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f21769d;

    public w0(Executor r10) {
        this.f21769d = r10;
        kotlinx.coroutines.internal.c.a(f());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        Executor r12 = f();     // Catch: RejectedExecutionException -> L4
        c.a();     // Catch: RejectedExecutionException -> L4
        r12.execute(r11);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        c.a();
        e(r10, e);
        l0.b().a(r10, r11);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor r10 = f();
        if ((r10 instanceof ExecutorService) == false) goto L5;
        ExecutorService r11 = (ExecutorService) r10;
    L6:
        if (r11 == null) goto L9;
        r11.shutdown();
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long r10, Continuation r11) {
        return Delay.a.a(this, r10, r11);
    }

    public final void e(CoroutineContext r10, RejectedExecutionException r11) {
        h1.c(r10, v0.a("The task was rejected", r11));
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof w0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((w0) r10).f() != f()) goto L7;
        return true;
    }

    public Executor f() {
        return this.f21769d;
    }

    public final ScheduledFuture g(ScheduledExecutorService r10, Runnable r11, CoroutineContext r12, long r13) {
        return r10.schedule(r11, r13, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        e(r12, e);
        return null;
    }

    public int hashCode() {
        return System.identityHashCode(f());
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r10, Runnable r12, CoroutineContext r13) {
        Executor r11 = f();
        ScheduledFuture r14 = null;
        if ((r11 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r15 = (ScheduledExecutorService) r11;
    L6:
        if (r15 == null) goto L8;
        r14 = g(r15, r12, r13, r10);
    L8:
        if (r14 == null) goto L11;
        return new m0(r14);
    L11:
        return f0.f21422i.invokeOnTimeout(r10, r12, r13);
    L5:
        r15 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long r10, CancellableContinuation r12) {
        Executor r11 = f();
        ScheduledFuture r13 = null;
        if ((r11 instanceof ScheduledExecutorService) == false) goto L5;
        ScheduledExecutorService r14 = (ScheduledExecutorService) r11;
    L6:
        if (r14 == null) goto L8;
        r13 = g(r14, new u1(this, r12), r12.getContext(), r10);
    L8:
        if (r13 == null) goto L11;
        h1.f(r12, r13);
        return;
    L11:
        f0.f21422i.scheduleResumeAfterDelay(r10, r12);
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return f().toString();
    }
}
