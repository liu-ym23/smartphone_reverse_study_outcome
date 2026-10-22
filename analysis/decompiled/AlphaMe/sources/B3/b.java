package B3;

import A3.q;
import h.RunnableC0583a;
import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.unsafe.v;

/* loaded from: classes2.dex */
public abstract class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractQueue f218a;

    /* renamed from: b, reason: collision with root package name */
    public final int f219b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f220c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final long f221d = 67;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f222e = new AtomicReference();

    public b() {
        if (v.f14123a == null || v.f14124b) {
            this.f218a = new ConcurrentLinkedQueue();
        } else {
            this.f218a = new rx.internal.util.unsafe.e(Math.max(2, Math.max(0, 1024)));
        }
        while (true) {
            AtomicReference atomicReference = this.f222e;
            if (atomicReference.get() != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceB = A3.k.b();
            try {
                RunnableC0583a runnableC0583a = new RunnableC0583a(28, this);
                long j4 = this.f221d;
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = scheduledExecutorServiceB.scheduleAtFixedRate(runnableC0583a, j4, j4, TimeUnit.SECONDS);
                if (atomicReference.compareAndSet(null, scheduledFutureScheduleAtFixedRate)) {
                    return;
                } else {
                    scheduledFutureScheduleAtFixedRate.cancel(false);
                }
            } catch (RejectedExecutionException e4) {
                E3.c.a(e4);
                return;
            }
        }
    }

    @Override // A3.q
    public final void a() {
        Future future = (Future) this.f222e.getAndSet(null);
        if (future != null) {
            future.cancel(false);
        }
    }
}
