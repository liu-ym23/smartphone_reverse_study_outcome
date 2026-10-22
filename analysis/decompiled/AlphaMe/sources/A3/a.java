package A3;

import h.RunnableC0583a;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import l.ThreadFactoryC0745c;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f70a;

    /* renamed from: b, reason: collision with root package name */
    public final long f71b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f72c;

    /* renamed from: d, reason: collision with root package name */
    public final B3.l f73d;

    /* renamed from: e, reason: collision with root package name */
    public final ScheduledExecutorService f74e;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledFuture f75f;

    public a(ThreadFactory threadFactory, long j4, TimeUnit timeUnit) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        this.f70a = threadFactory;
        long nanos = timeUnit != null ? timeUnit.toNanos(j4) : 0L;
        this.f71b = nanos;
        this.f72c = new ConcurrentLinkedQueue();
        this.f73d = new B3.l(1);
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC0745c(threadFactory));
            m.h(scheduledExecutorServiceNewScheduledThreadPool);
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new RunnableC0583a(27, this), nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            scheduledExecutorServiceNewScheduledThreadPool = null;
            scheduledFutureScheduleWithFixedDelay = null;
        }
        this.f74e = scheduledExecutorServiceNewScheduledThreadPool;
        this.f75f = scheduledFutureScheduleWithFixedDelay;
    }

    public final void a() {
        B3.l lVar = this.f73d;
        try {
            ScheduledFuture scheduledFuture = this.f75f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f74e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            lVar.c();
        } catch (Throwable th) {
            lVar.c();
            throw th;
        }
    }
}
