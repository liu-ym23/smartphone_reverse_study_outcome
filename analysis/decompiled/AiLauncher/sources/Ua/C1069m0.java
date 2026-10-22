package Ua;

import Za.C1181a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J5\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u00020%2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"LUa/m0;", "LUa/l0;", "LUa/T;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "Lkotlin/coroutines/d;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "", "timeMillis", "LUa/l;", "continuation", "v0", "(JLUa/l;)V", "LUa/a0;", "U", "(JLjava/lang/Runnable;Lkotlin/coroutines/d;)LUa/a0;", "close", "()V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "w1", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;Lkotlin/coroutines/d;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "v1", "(Lkotlin/coroutines/d;Ljava/util/concurrent/RejectedExecutionException;)V", "c", "Ljava/util/concurrent/Executor;", "u1", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.m0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1069m0 extends AbstractC1067l0 implements T {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Executor executor;

    public C1069m0(Executor executor) {
        this.executor = executor;
        C1181a.a(getExecutor());
    }

    @Override // Ua.T
    public InterfaceC1045a0 U(long timeMillis, Runnable block, kotlin.coroutines.d context) {
        long j10;
        Runnable runnable;
        kotlin.coroutines.d dVar;
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureW1 = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            j10 = timeMillis;
            runnable = block;
            dVar = context;
            scheduledFutureW1 = w1(scheduledExecutorService, runnable, dVar, j10);
        } else {
            j10 = timeMillis;
            runnable = block;
            dVar = context;
        }
        return scheduledFutureW1 != null ? new Z(scheduledFutureW1) : O.f6337h.U(j10, runnable, dVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = getExecutor();
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object other) {
        return (other instanceof C1069m0) && ((C1069m0) other).getExecutor() == getExecutor();
    }

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        try {
            Executor executor = getExecutor();
            C1046b.a();
            executor.execute(block);
        } catch (RejectedExecutionException e10) {
            C1046b.a();
            v1(context, e10);
            Y.b().h1(context, block);
        }
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @Override // Ua.I
    /* renamed from: toString */
    public String getName() {
        return getExecutor().toString();
    }

    @Override // Ua.AbstractC1067l0
    /* renamed from: u1, reason: from getter */
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // Ua.T
    public void v0(long timeMillis, InterfaceC1066l<? super Y8.t> continuation) {
        long j10;
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureW1 = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            j10 = timeMillis;
            scheduledFutureW1 = w1(scheduledExecutorService, new H0(this, continuation), continuation.getContext(), j10);
        } else {
            j10 = timeMillis;
        }
        if (scheduledFutureW1 != null) {
            C1072o.c(continuation, new C1064k(scheduledFutureW1));
        } else {
            O.f6337h.v0(j10, continuation);
        }
    }

    public final void v1(kotlin.coroutines.d context, RejectedExecutionException exception) {
        C1086v0.c(context, C1063j0.a("The task was rejected", exception));
    }

    public final ScheduledFuture<?> w1(ScheduledExecutorService scheduledExecutorService, Runnable runnable, kotlin.coroutines.d dVar, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            this.v1(dVar, e10);
            return null;
        }
    }
}
