package O3;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import x3.p;

/* loaded from: classes.dex */
public final class p extends x3.p {

    /* renamed from: b, reason: collision with root package name */
    private static final p f4435b = new p();

    static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f4436a;

        /* renamed from: b, reason: collision with root package name */
        private final c f4437b;

        /* renamed from: c, reason: collision with root package name */
        private final long f4438c;

        a(Runnable runnable, c cVar, long j5) {
            this.f4436a = runnable;
            this.f4437b = cVar;
            this.f4438c = j5;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (this.f4437b.f4446d) {
                return;
            }
            long jA = this.f4437b.a(TimeUnit.MILLISECONDS);
            long j5 = this.f4438c;
            if (j5 > jA) {
                try {
                    Thread.sleep(j5 - jA);
                } catch (InterruptedException e6) {
                    Thread.currentThread().interrupt();
                    S3.a.r(e6);
                    return;
                }
            }
            if (this.f4437b.f4446d) {
                return;
            }
            this.f4436a.run();
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f4439a;

        /* renamed from: b, reason: collision with root package name */
        final long f4440b;

        /* renamed from: c, reason: collision with root package name */
        final int f4441c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f4442d;

        b(Runnable runnable, Long l5, int i5) {
            this.f4439a = runnable;
            this.f4440b = l5.longValue();
            this.f4441c = i5;
        }

        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iB = F3.b.b(this.f4440b, bVar.f4440b);
            return iB == 0 ? F3.b.a(this.f4441c, bVar.f4441c) : iB;
        }
    }

    static final class c extends p.c implements A3.c {

        /* renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue<b> f4443a = new PriorityBlockingQueue<>();

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f4444b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f4445c = new AtomicInteger();

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f4446d;

        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final b f4447a;

            a(b bVar) {
                this.f4447a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4447a.f4442d = true;
                c.this.f4443a.remove(this.f4447a);
            }
        }

        c() {
        }

        @Override // x3.p.c
        public A3.c b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // x3.p.c
        public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j5);
            return e(new a(runnable, this, jA), jA);
        }

        @Override // A3.c
        public void dispose() {
            this.f4446d = true;
        }

        A3.c e(Runnable runnable, long j5) {
            if (this.f4446d) {
                return E3.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j5), this.f4445c.incrementAndGet());
            this.f4443a.add(bVar);
            if (this.f4444b.getAndIncrement() != 0) {
                return A3.d.d(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f4446d) {
                b bVarPoll = this.f4443a.poll();
                if (bVarPoll == null) {
                    iAddAndGet = this.f4444b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return E3.c.INSTANCE;
                    }
                } else if (!bVarPoll.f4442d) {
                    bVarPoll.f4439a.run();
                }
            }
            this.f4443a.clear();
            return E3.c.INSTANCE;
        }

        @Override // A3.c
        public boolean g() {
            return this.f4446d;
        }
    }

    p() {
    }

    public static p e() {
        return f4435b;
    }

    @Override // x3.p
    public p.c a() {
        return new c();
    }

    @Override // x3.p
    public A3.c b(Runnable runnable) {
        S3.a.t(runnable).run();
        return E3.c.INSTANCE;
    }

    @Override // x3.p
    public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) throws InterruptedException {
        try {
            timeUnit.sleep(j5);
            S3.a.t(runnable).run();
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            S3.a.r(e6);
        }
        return E3.c.INSTANCE;
    }
}
