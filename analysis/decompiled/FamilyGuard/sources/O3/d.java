package O3;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class d extends x3.p {

    /* renamed from: d, reason: collision with root package name */
    static final x3.p f4365d = T3.a.d();

    /* renamed from: b, reason: collision with root package name */
    final boolean f4366b;

    /* renamed from: c, reason: collision with root package name */
    final Executor f4367c;

    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b f4368a;

        a(b bVar) {
            this.f4368a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f4368a;
            bVar.f4371b.a(d.this.b(bVar));
        }
    }

    static final class b extends AtomicReference<Runnable> implements Runnable, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final E3.f f4370a;

        /* renamed from: b, reason: collision with root package name */
        final E3.f f4371b;

        b(Runnable runnable) {
            super(runnable);
            this.f4370a = new E3.f();
            this.f4371b = new E3.f();
        }

        @Override // A3.c
        public void dispose() {
            if (getAndSet(null) != null) {
                this.f4370a.dispose();
                this.f4371b.dispose();
            }
        }

        @Override // A3.c
        public boolean g() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    E3.f fVar = this.f4370a;
                    E3.b bVar = E3.b.DISPOSED;
                    fVar.lazySet(bVar);
                    this.f4371b.lazySet(bVar);
                } catch (Throwable th) {
                    lazySet(null);
                    this.f4370a.lazySet(E3.b.DISPOSED);
                    this.f4371b.lazySet(E3.b.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class c extends p.c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final boolean f4372a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f4373b;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f4375d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f4376e = new AtomicInteger();

        /* renamed from: f, reason: collision with root package name */
        final A3.b f4377f = new A3.b();

        /* renamed from: c, reason: collision with root package name */
        final N3.a<Runnable> f4374c = new N3.a<>();

        static final class a extends AtomicBoolean implements Runnable, A3.c {

            /* renamed from: a, reason: collision with root package name */
            final Runnable f4378a;

            a(Runnable runnable) {
                this.f4378a = runnable;
            }

            @Override // A3.c
            public void dispose() {
                lazySet(true);
            }

            @Override // A3.c
            public boolean g() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.f4378a.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        static final class b extends AtomicInteger implements Runnable, A3.c {

            /* renamed from: a, reason: collision with root package name */
            final Runnable f4379a;

            /* renamed from: b, reason: collision with root package name */
            final E3.a f4380b;

            /* renamed from: c, reason: collision with root package name */
            volatile Thread f4381c;

            b(Runnable runnable, E3.a aVar) {
                this.f4379a = runnable;
                this.f4380b = aVar;
            }

            void a() {
                E3.a aVar = this.f4380b;
                if (aVar != null) {
                    aVar.b(this);
                }
            }

            @Override // A3.c
            public void dispose() {
                while (true) {
                    int i5 = get();
                    if (i5 >= 2) {
                        return;
                    }
                    if (i5 == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.f4381c;
                        if (thread != null) {
                            thread.interrupt();
                            this.f4381c = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            @Override // A3.c
            public boolean g() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.f4381c = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.f4381c = null;
                        return;
                    }
                    try {
                        this.f4379a.run();
                        this.f4381c = null;
                        if (compareAndSet(1, 2)) {
                            a();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th) {
                        this.f4381c = null;
                        if (compareAndSet(1, 2)) {
                            a();
                        } else {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        }
                        throw th;
                    }
                }
            }
        }

        /* renamed from: O3.d$c$c, reason: collision with other inner class name */
        final class RunnableC0070c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final E3.f f4382a;

            /* renamed from: b, reason: collision with root package name */
            private final Runnable f4383b;

            RunnableC0070c(E3.f fVar, Runnable runnable) {
                this.f4382a = fVar;
                this.f4383b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4382a.a(c.this.b(this.f4383b));
            }
        }

        public c(Executor executor, boolean z5) {
            this.f4373b = executor;
            this.f4372a = z5;
        }

        @Override // x3.p.c
        public A3.c b(Runnable runnable) {
            A3.c aVar;
            if (this.f4375d) {
                return E3.c.INSTANCE;
            }
            Runnable runnableT = S3.a.t(runnable);
            if (this.f4372a) {
                aVar = new b(runnableT, this.f4377f);
                this.f4377f.c(aVar);
            } else {
                aVar = new a(runnableT);
            }
            this.f4374c.offer(aVar);
            if (this.f4376e.getAndIncrement() != 0) {
                return aVar;
            }
            try {
                this.f4373b.execute(this);
                return aVar;
            } catch (RejectedExecutionException e6) {
                this.f4375d = true;
                this.f4374c.clear();
                S3.a.r(e6);
                return E3.c.INSTANCE;
            }
        }

        @Override // x3.p.c
        public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (j5 <= 0) {
                return b(runnable);
            }
            if (this.f4375d) {
                return E3.c.INSTANCE;
            }
            E3.f fVar = new E3.f();
            E3.f fVar2 = new E3.f(fVar);
            m mVar = new m(new RunnableC0070c(fVar2, S3.a.t(runnable)), this.f4377f);
            this.f4377f.c(mVar);
            Executor executor = this.f4373b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    mVar.a(((ScheduledExecutorService) executor).schedule((Callable) mVar, j5, timeUnit));
                } catch (RejectedExecutionException e6) {
                    this.f4375d = true;
                    S3.a.r(e6);
                    return E3.c.INSTANCE;
                }
            } else {
                mVar.a(new O3.c(d.f4365d.c(mVar, j5, timeUnit)));
            }
            fVar.a(mVar);
            return fVar2;
        }

        @Override // A3.c
        public void dispose() {
            if (this.f4375d) {
                return;
            }
            this.f4375d = true;
            this.f4377f.dispose();
            if (this.f4376e.getAndIncrement() == 0) {
                this.f4374c.clear();
            }
        }

        @Override // A3.c
        public boolean g() {
            return this.f4375d;
        }

        @Override // java.lang.Runnable
        public void run() {
            N3.a<Runnable> aVar = this.f4374c;
            int iAddAndGet = 1;
            while (!this.f4375d) {
                do {
                    Runnable runnablePoll = aVar.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    } else if (this.f4375d) {
                        aVar.clear();
                        return;
                    } else {
                        iAddAndGet = this.f4376e.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f4375d);
                aVar.clear();
                return;
            }
            aVar.clear();
        }
    }

    public d(Executor executor, boolean z5) {
        this.f4367c = executor;
        this.f4366b = z5;
    }

    @Override // x3.p
    public p.c a() {
        return new c(this.f4367c, this.f4366b);
    }

    @Override // x3.p
    public A3.c b(Runnable runnable) {
        Runnable runnableT = S3.a.t(runnable);
        try {
            if (this.f4367c instanceof ExecutorService) {
                l lVar = new l(runnableT);
                lVar.a(((ExecutorService) this.f4367c).submit(lVar));
                return lVar;
            }
            if (this.f4366b) {
                c.b bVar = new c.b(runnableT, null);
                this.f4367c.execute(bVar);
                return bVar;
            }
            c.a aVar = new c.a(runnableT);
            this.f4367c.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e6) {
            S3.a.r(e6);
            return E3.c.INSTANCE;
        }
    }

    @Override // x3.p
    public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        Runnable runnableT = S3.a.t(runnable);
        if (!(this.f4367c instanceof ScheduledExecutorService)) {
            b bVar = new b(runnableT);
            bVar.f4370a.a(f4365d.c(new a(bVar), j5, timeUnit));
            return bVar;
        }
        try {
            l lVar = new l(runnableT);
            lVar.a(((ScheduledExecutorService) this.f4367c).schedule(lVar, j5, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e6) {
            S3.a.r(e6);
            return E3.c.INSTANCE;
        }
    }

    @Override // x3.p
    public A3.c d(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        if (!(this.f4367c instanceof ScheduledExecutorService)) {
            return super.d(runnable, j5, j6, timeUnit);
        }
        try {
            k kVar = new k(S3.a.t(runnable));
            kVar.a(((ScheduledExecutorService) this.f4367c).scheduleAtFixedRate(kVar, j5, j6, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e6) {
            S3.a.r(e6);
            return E3.c.INSTANCE;
        }
    }
}
