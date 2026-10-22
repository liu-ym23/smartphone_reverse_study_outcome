package O3;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class o extends x3.p {

    /* renamed from: d, reason: collision with root package name */
    static final j f4428d;

    /* renamed from: e, reason: collision with root package name */
    static final ScheduledExecutorService f4429e;

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f4430b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f4431c;

    static final class a extends p.c {

        /* renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f4432a;

        /* renamed from: b, reason: collision with root package name */
        final A3.b f4433b = new A3.b();

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f4434c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f4432a = scheduledExecutorService;
        }

        @Override // x3.p.c
        public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (this.f4434c) {
                return E3.c.INSTANCE;
            }
            m mVar = new m(S3.a.t(runnable), this.f4433b);
            this.f4433b.c(mVar);
            try {
                mVar.a(j5 <= 0 ? this.f4432a.submit((Callable) mVar) : this.f4432a.schedule((Callable) mVar, j5, timeUnit));
                return mVar;
            } catch (RejectedExecutionException e6) {
                dispose();
                S3.a.r(e6);
                return E3.c.INSTANCE;
            }
        }

        @Override // A3.c
        public void dispose() {
            if (this.f4434c) {
                return;
            }
            this.f4434c = true;
            this.f4433b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f4434c;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f4429e = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f4428d = new j("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public o() {
        this(f4428d);
    }

    static ScheduledExecutorService e(ThreadFactory threadFactory) {
        return n.a(threadFactory);
    }

    @Override // x3.p
    public p.c a() {
        return new a(this.f4431c.get());
    }

    @Override // x3.p
    public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        l lVar = new l(S3.a.t(runnable));
        try {
            lVar.a(j5 <= 0 ? this.f4431c.get().submit(lVar) : this.f4431c.get().schedule(lVar, j5, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e6) {
            S3.a.r(e6);
            return E3.c.INSTANCE;
        }
    }

    @Override // x3.p
    public A3.c d(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        Runnable runnableT = S3.a.t(runnable);
        if (j6 > 0) {
            k kVar = new k(runnableT);
            try {
                kVar.a(this.f4431c.get().scheduleAtFixedRate(kVar, j5, j6, timeUnit));
                return kVar;
            } catch (RejectedExecutionException e6) {
                S3.a.r(e6);
                return E3.c.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = this.f4431c.get();
        e eVar = new e(runnableT, scheduledExecutorService);
        try {
            eVar.b(j5 <= 0 ? scheduledExecutorService.submit(eVar) : scheduledExecutorService.schedule(eVar, j5, timeUnit));
            return eVar;
        } catch (RejectedExecutionException e7) {
            S3.a.r(e7);
            return E3.c.INSTANCE;
        }
    }

    public o(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f4431c = atomicReference;
        this.f4430b = threadFactory;
        atomicReference.lazySet(e(threadFactory));
    }
}
