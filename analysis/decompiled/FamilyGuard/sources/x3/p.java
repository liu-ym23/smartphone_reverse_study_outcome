package x3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    static final long f23813a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class a implements A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f23814a;

        /* renamed from: b, reason: collision with root package name */
        final c f23815b;

        /* renamed from: c, reason: collision with root package name */
        Thread f23816c;

        a(Runnable runnable, c cVar) {
            this.f23814a = runnable;
            this.f23815b = cVar;
        }

        @Override // A3.c
        public void dispose() {
            if (this.f23816c == Thread.currentThread()) {
                c cVar = this.f23815b;
                if (cVar instanceof O3.h) {
                    ((O3.h) cVar).i();
                    return;
                }
            }
            this.f23815b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f23815b.g();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23816c = Thread.currentThread();
            try {
                this.f23814a.run();
            } finally {
                dispose();
                this.f23816c = null;
            }
        }
    }

    static final class b implements A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f23817a;

        /* renamed from: b, reason: collision with root package name */
        final c f23818b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f23819c;

        b(Runnable runnable, c cVar) {
            this.f23817a = runnable;
            this.f23818b = cVar;
        }

        @Override // A3.c
        public void dispose() {
            this.f23819c = true;
            this.f23818b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f23819c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f23819c) {
                return;
            }
            try {
                this.f23817a.run();
            } catch (Throwable th) {
                B3.b.b(th);
                this.f23818b.dispose();
                throw R3.e.d(th);
            }
        }
    }

    public static abstract class c implements A3.c {

        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final Runnable f23820a;

            /* renamed from: b, reason: collision with root package name */
            final E3.f f23821b;

            /* renamed from: c, reason: collision with root package name */
            final long f23822c;

            /* renamed from: d, reason: collision with root package name */
            long f23823d;

            /* renamed from: e, reason: collision with root package name */
            long f23824e;

            /* renamed from: f, reason: collision with root package name */
            long f23825f;

            a(long j5, Runnable runnable, long j6, E3.f fVar, long j7) {
                this.f23820a = runnable;
                this.f23821b = fVar;
                this.f23822c = j7;
                this.f23824e = j6;
                this.f23825f = j5;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r12 = this;
                    java.lang.Runnable r0 = r12.f23820a
                    r0.run()
                    E3.f r0 = r12.f23821b
                    boolean r0 = r0.g()
                    if (r0 != 0) goto L51
                    x3.p$c r0 = x3.p.c.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r2 = r0.a(r1)
                    long r4 = x3.p.f23813a
                    long r6 = r2 + r4
                    long r8 = r12.f23824e
                    int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    r6 = 1
                    if (r0 < 0) goto L34
                    long r10 = r12.f23822c
                    long r8 = r8 + r10
                    long r8 = r8 + r4
                    int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r0 < 0) goto L2a
                    goto L34
                L2a:
                    long r4 = r12.f23825f
                    long r8 = r12.f23823d
                    long r8 = r8 + r6
                    r12.f23823d = r8
                    long r8 = r8 * r10
                    long r4 = r4 + r8
                    goto L43
                L34:
                    long r4 = r12.f23822c
                    long r8 = r2 + r4
                    long r10 = r12.f23823d
                    long r10 = r10 + r6
                    r12.f23823d = r10
                    long r4 = r4 * r10
                    long r4 = r8 - r4
                    r12.f23825f = r4
                    r4 = r8
                L43:
                    r12.f23824e = r2
                    long r4 = r4 - r2
                    E3.f r0 = r12.f23821b
                    x3.p$c r2 = x3.p.c.this
                    A3.c r12 = r2.c(r12, r4, r1)
                    r0.a(r12)
                L51:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: x3.p.c.a.run():void");
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public A3.c b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract A3.c c(Runnable runnable, long j5, TimeUnit timeUnit);

        public A3.c d(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
            E3.f fVar = new E3.f();
            E3.f fVar2 = new E3.f(fVar);
            Runnable runnableT = S3.a.t(runnable);
            long nanos = timeUnit.toNanos(j6);
            long jA = a(TimeUnit.NANOSECONDS);
            A3.c cVarC = c(new a(jA + timeUnit.toNanos(j5), runnableT, jA, fVar2, nanos), j5, timeUnit);
            if (cVarC == E3.c.INSTANCE) {
                return cVarC;
            }
            fVar.a(cVarC);
            return fVar2;
        }
    }

    public abstract c a();

    public A3.c b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        c cVarA = a();
        a aVar = new a(S3.a.t(runnable), cVarA);
        cVarA.c(aVar, j5, timeUnit);
        return aVar;
    }

    public A3.c d(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        c cVarA = a();
        b bVar = new b(S3.a.t(runnable), cVarA);
        A3.c cVarD = cVarA.d(bVar, j5, j6, timeUnit);
        return cVarD == E3.c.INSTANCE ? cVarD : bVar;
    }
}
