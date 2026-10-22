package O3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import x3.p;

/* loaded from: classes.dex */
public final class b extends x3.p {

    /* renamed from: d, reason: collision with root package name */
    static final C0069b f4350d;

    /* renamed from: e, reason: collision with root package name */
    static final j f4351e;

    /* renamed from: f, reason: collision with root package name */
    static final int f4352f = e(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: g, reason: collision with root package name */
    static final c f4353g;

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f4354b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<C0069b> f4355c;

    static final class a extends p.c {

        /* renamed from: a, reason: collision with root package name */
        private final E3.d f4356a;

        /* renamed from: b, reason: collision with root package name */
        private final A3.b f4357b;

        /* renamed from: c, reason: collision with root package name */
        private final E3.d f4358c;

        /* renamed from: d, reason: collision with root package name */
        private final c f4359d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f4360e;

        a(c cVar) {
            this.f4359d = cVar;
            E3.d dVar = new E3.d();
            this.f4356a = dVar;
            A3.b bVar = new A3.b();
            this.f4357b = bVar;
            E3.d dVar2 = new E3.d();
            this.f4358c = dVar2;
            dVar2.c(dVar);
            dVar2.c(bVar);
        }

        @Override // x3.p.c
        public A3.c b(Runnable runnable) {
            return this.f4360e ? E3.c.INSTANCE : this.f4359d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f4356a);
        }

        @Override // x3.p.c
        public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            return this.f4360e ? E3.c.INSTANCE : this.f4359d.e(runnable, j5, timeUnit, this.f4357b);
        }

        @Override // A3.c
        public void dispose() {
            if (this.f4360e) {
                return;
            }
            this.f4360e = true;
            this.f4358c.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f4360e;
        }
    }

    /* renamed from: O3.b$b, reason: collision with other inner class name */
    static final class C0069b {

        /* renamed from: a, reason: collision with root package name */
        final int f4361a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f4362b;

        /* renamed from: c, reason: collision with root package name */
        long f4363c;

        C0069b(int i5, ThreadFactory threadFactory) {
            this.f4361a = i5;
            this.f4362b = new c[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                this.f4362b[i6] = new c(threadFactory);
            }
        }

        public c a() {
            int i5 = this.f4361a;
            if (i5 == 0) {
                return b.f4353g;
            }
            c[] cVarArr = this.f4362b;
            long j5 = this.f4363c;
            this.f4363c = 1 + j5;
            return cVarArr[(int) (j5 % i5)];
        }

        public void b() {
            for (c cVar : this.f4362b) {
                cVar.dispose();
            }
        }
    }

    static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new j("RxComputationShutdown"));
        f4353g = cVar;
        cVar.dispose();
        j jVar = new j("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f4351e = jVar;
        C0069b c0069b = new C0069b(0, jVar);
        f4350d = c0069b;
        c0069b.b();
    }

    public b() {
        this(f4351e);
    }

    static int e(int i5, int i6) {
        return (i6 <= 0 || i6 > i5) ? i5 : i6;
    }

    @Override // x3.p
    public p.c a() {
        return new a(this.f4355c.get().a());
    }

    @Override // x3.p
    public A3.c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        return this.f4355c.get().a().f(runnable, j5, timeUnit);
    }

    @Override // x3.p
    public A3.c d(Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        return this.f4355c.get().a().h(runnable, j5, j6, timeUnit);
    }

    public void f() {
        C0069b c0069b = new C0069b(f4352f, this.f4354b);
        if (this.f4355c.compareAndSet(f4350d, c0069b)) {
            return;
        }
        c0069b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f4354b = threadFactory;
        this.f4355c = new AtomicReference<>(f4350d);
        f();
    }
}
