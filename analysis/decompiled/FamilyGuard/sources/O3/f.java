package O3;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class f extends x3.p {

    /* renamed from: d, reason: collision with root package name */
    static final j f4391d;

    /* renamed from: e, reason: collision with root package name */
    static final j f4392e;

    /* renamed from: h, reason: collision with root package name */
    static final c f4395h;

    /* renamed from: i, reason: collision with root package name */
    static final a f4396i;

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f4397b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<a> f4398c;

    /* renamed from: g, reason: collision with root package name */
    private static final TimeUnit f4394g = TimeUnit.SECONDS;

    /* renamed from: f, reason: collision with root package name */
    private static final long f4393f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f4399a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f4400b;

        /* renamed from: c, reason: collision with root package name */
        final A3.b f4401c;

        /* renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f4402d;

        /* renamed from: e, reason: collision with root package name */
        private final Future<?> f4403e;

        /* renamed from: f, reason: collision with root package name */
        private final ThreadFactory f4404f;

        a(long j5, TimeUnit timeUnit, ThreadFactory threadFactory) {
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j5) : 0L;
            this.f4399a = nanos;
            this.f4400b = new ConcurrentLinkedQueue<>();
            this.f4401c = new A3.b();
            this.f4404f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, f.f4392e);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.f4402d = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.f4403e = scheduledFutureScheduleWithFixedDelay;
        }

        void a() {
            if (this.f4400b.isEmpty()) {
                return;
            }
            long jC = c();
            Iterator<c> it = this.f4400b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.j() > jC) {
                    return;
                }
                if (this.f4400b.remove(next)) {
                    this.f4401c.a(next);
                }
            }
        }

        c b() {
            if (this.f4401c.g()) {
                return f.f4395h;
            }
            while (!this.f4400b.isEmpty()) {
                c cVarPoll = this.f4400b.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f4404f);
            this.f4401c.c(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.k(c() + this.f4399a);
            this.f4400b.offer(cVar);
        }

        void e() {
            this.f4401c.dispose();
            Future<?> future = this.f4403e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f4402d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static final class b extends p.c {

        /* renamed from: b, reason: collision with root package name */
        private final a f4406b;

        /* renamed from: c, reason: collision with root package name */
        private final c f4407c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f4408d = new AtomicBoolean();

        /* renamed from: a, reason: collision with root package name */
        private final A3.b f4405a = new A3.b();

        b(a aVar) {
            this.f4406b = aVar;
            this.f4407c = aVar.b();
        }

        @Override // x3.p.c
        public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            return this.f4405a.g() ? E3.c.INSTANCE : this.f4407c.e(runnable, j5, timeUnit, this.f4405a);
        }

        @Override // A3.c
        public void dispose() {
            if (this.f4408d.compareAndSet(false, true)) {
                this.f4405a.dispose();
                this.f4406b.d(this.f4407c);
            }
        }

        @Override // A3.c
        public boolean g() {
            return this.f4408d.get();
        }
    }

    static final class c extends h {

        /* renamed from: c, reason: collision with root package name */
        private long f4409c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f4409c = 0L;
        }

        public long j() {
            return this.f4409c;
        }

        public void k(long j5) {
            this.f4409c = j5;
        }
    }

    static {
        c cVar = new c(new j("RxCachedThreadSchedulerShutdown"));
        f4395h = cVar;
        cVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        j jVar = new j("RxCachedThreadScheduler", iMax);
        f4391d = jVar;
        f4392e = new j("RxCachedWorkerPoolEvictor", iMax);
        a aVar = new a(0L, null, jVar);
        f4396i = aVar;
        aVar.e();
    }

    public f() {
        this(f4391d);
    }

    @Override // x3.p
    public p.c a() {
        return new b(this.f4398c.get());
    }

    public void e() {
        a aVar = new a(f4393f, f4394g, this.f4397b);
        if (this.f4398c.compareAndSet(f4396i, aVar)) {
            return;
        }
        aVar.e();
    }

    public f(ThreadFactory threadFactory) {
        this.f4397b = threadFactory;
        this.f4398c = new AtomicReference<>(f4396i);
        e();
    }
}
