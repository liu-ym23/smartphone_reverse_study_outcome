package J3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class z<T> extends x3.f<T> {

    /* renamed from: b, reason: collision with root package name */
    final C3.a<T> f3491b;

    /* renamed from: c, reason: collision with root package name */
    final int f3492c;

    /* renamed from: d, reason: collision with root package name */
    final long f3493d;

    /* renamed from: e, reason: collision with root package name */
    final TimeUnit f3494e;

    /* renamed from: f, reason: collision with root package name */
    final x3.p f3495f;

    /* renamed from: g, reason: collision with root package name */
    a f3496g;

    static final class a extends AtomicReference<A3.c> implements Runnable, D3.c<A3.c> {

        /* renamed from: a, reason: collision with root package name */
        final z<?> f3497a;

        /* renamed from: b, reason: collision with root package name */
        A3.c f3498b;

        /* renamed from: c, reason: collision with root package name */
        long f3499c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3500d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3501e;

        a(z<?> zVar) {
            this.f3497a = zVar;
        }

        @Override // D3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(A3.c cVar) {
            E3.b.e(this, cVar);
            synchronized (this.f3497a) {
                try {
                    if (this.f3501e) {
                        ((E3.e) this.f3497a.f3491b).b(cVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3497a.f0(this);
        }
    }

    static final class b<T> extends AtomicBoolean implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3502a;

        /* renamed from: b, reason: collision with root package name */
        final z<T> f3503b;

        /* renamed from: c, reason: collision with root package name */
        final a f3504c;

        /* renamed from: d, reason: collision with root package name */
        Q4.c f3505d;

        b(Q4.b<? super T> bVar, z<T> zVar, a aVar) {
            this.f3502a = bVar;
            this.f3503b = zVar;
            this.f3504c = aVar;
        }

        @Override // Q4.b
        public void a() {
            if (compareAndSet(false, true)) {
                this.f3503b.e0(this.f3504c);
                this.f3502a.a();
            }
        }

        @Override // Q4.c
        public void cancel() {
            this.f3505d.cancel();
            if (compareAndSet(false, true)) {
                this.f3503b.d0(this.f3504c);
            }
        }

        @Override // Q4.b
        public void d(T t5) {
            this.f3502a.d(t5);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3505d, cVar)) {
                this.f3505d = cVar;
                this.f3502a.e(this);
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            this.f3505d.h(j5);
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                S3.a.r(th);
            } else {
                this.f3503b.e0(this.f3504c);
                this.f3502a.onError(th);
            }
        }
    }

    public z(C3.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        a aVar;
        boolean z5;
        A3.c cVar;
        synchronized (this) {
            try {
                aVar = this.f3496g;
                if (aVar == null) {
                    aVar = new a(this);
                    this.f3496g = aVar;
                }
                long j5 = aVar.f3499c;
                if (j5 == 0 && (cVar = aVar.f3498b) != null) {
                    cVar.dispose();
                }
                long j6 = j5 + 1;
                aVar.f3499c = j6;
                if (aVar.f3500d || j6 != this.f3492c) {
                    z5 = false;
                } else {
                    z5 = true;
                    aVar.f3500d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3491b.V(new b(bVar, this, aVar));
        if (z5) {
            this.f3491b.d0(aVar);
        }
    }

    void d0(a aVar) {
        synchronized (this) {
            try {
                a aVar2 = this.f3496g;
                if (aVar2 != null && aVar2 == aVar) {
                    long j5 = aVar.f3499c - 1;
                    aVar.f3499c = j5;
                    if (j5 == 0 && aVar.f3500d) {
                        if (this.f3493d == 0) {
                            f0(aVar);
                            return;
                        }
                        E3.f fVar = new E3.f();
                        aVar.f3498b = fVar;
                        fVar.a(this.f3495f.c(aVar, this.f3493d, this.f3494e));
                    }
                }
            } finally {
            }
        }
    }

    void e0(a aVar) {
        synchronized (this) {
            try {
                a aVar2 = this.f3496g;
                if (aVar2 != null && aVar2 == aVar) {
                    this.f3496g = null;
                    A3.c cVar = aVar.f3498b;
                    if (cVar != null) {
                        cVar.dispose();
                    }
                }
                long j5 = aVar.f3499c - 1;
                aVar.f3499c = j5;
                if (j5 == 0) {
                    C3.a<T> aVar3 = this.f3491b;
                    if (aVar3 instanceof A3.c) {
                        ((A3.c) aVar3).dispose();
                    } else if (aVar3 instanceof E3.e) {
                        ((E3.e) aVar3).b(aVar.get());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void f0(a aVar) {
        synchronized (this) {
            try {
                if (aVar.f3499c == 0 && aVar == this.f3496g) {
                    this.f3496g = null;
                    A3.c cVar = aVar.get();
                    E3.b.b(aVar);
                    C3.a<T> aVar2 = this.f3491b;
                    if (aVar2 instanceof A3.c) {
                        ((A3.c) aVar2).dispose();
                    } else if (aVar2 instanceof E3.e) {
                        if (cVar == null) {
                            aVar.f3501e = true;
                        } else {
                            ((E3.e) aVar2).b(cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public z(C3.a<T> aVar, int i5, long j5, TimeUnit timeUnit, x3.p pVar) {
        this.f3491b = aVar;
        this.f3492c = i5;
        this.f3493d = j5;
        this.f3494e = timeUnit;
        this.f3495f = pVar;
    }
}
