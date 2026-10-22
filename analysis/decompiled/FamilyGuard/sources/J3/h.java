package J3;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class h<T, U> extends AbstractC0350a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final D3.h<? super T, ? extends Q4.a<? extends U>> f3327c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f3328d;

    /* renamed from: e, reason: collision with root package name */
    final int f3329e;

    /* renamed from: f, reason: collision with root package name */
    final int f3330f;

    static final class a<T, U> extends AtomicReference<Q4.c> implements x3.i<U>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final long f3331a;

        /* renamed from: b, reason: collision with root package name */
        final b<T, U> f3332b;

        /* renamed from: c, reason: collision with root package name */
        final int f3333c;

        /* renamed from: d, reason: collision with root package name */
        final int f3334d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f3335e;

        /* renamed from: f, reason: collision with root package name */
        volatile G3.f<U> f3336f;

        /* renamed from: g, reason: collision with root package name */
        long f3337g;

        /* renamed from: h, reason: collision with root package name */
        int f3338h;

        a(b<T, U> bVar, long j5) {
            this.f3331a = j5;
            this.f3332b = bVar;
            int i5 = bVar.f3345e;
            this.f3334d = i5;
            this.f3333c = i5 >> 2;
        }

        @Override // Q4.b
        public void a() {
            this.f3335e = true;
            this.f3332b.j();
        }

        void b(long j5) {
            if (this.f3338h != 1) {
                long j6 = this.f3337g + j5;
                if (j6 < this.f3333c) {
                    this.f3337g = j6;
                } else {
                    this.f3337g = 0L;
                    get().h(j6);
                }
            }
        }

        @Override // Q4.b
        public void d(U u5) {
            if (this.f3338h != 2) {
                this.f3332b.p(u5, this);
            } else {
                this.f3332b.j();
            }
        }

        @Override // A3.c
        public void dispose() {
            Q3.g.b(this);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.j(this, cVar)) {
                if (cVar instanceof G3.c) {
                    G3.c cVar2 = (G3.c) cVar;
                    int iB = cVar2.b(7);
                    if (iB == 1) {
                        this.f3338h = iB;
                        this.f3336f = cVar2;
                        this.f3335e = true;
                        this.f3332b.j();
                        return;
                    }
                    if (iB == 2) {
                        this.f3338h = iB;
                        this.f3336f = cVar2;
                    }
                }
                cVar.h(this.f3334d);
            }
        }

        @Override // A3.c
        public boolean g() {
            return get() == Q3.g.CANCELLED;
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            lazySet(Q3.g.CANCELLED);
            this.f3332b.n(this, th);
        }
    }

    static final class b<T, U> extends AtomicInteger implements x3.i<T>, Q4.c {

        /* renamed from: r, reason: collision with root package name */
        static final a<?, ?>[] f3339r = new a[0];

        /* renamed from: s, reason: collision with root package name */
        static final a<?, ?>[] f3340s = new a[0];

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super U> f3341a;

        /* renamed from: b, reason: collision with root package name */
        final D3.h<? super T, ? extends Q4.a<? extends U>> f3342b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f3343c;

        /* renamed from: d, reason: collision with root package name */
        final int f3344d;

        /* renamed from: e, reason: collision with root package name */
        final int f3345e;

        /* renamed from: f, reason: collision with root package name */
        volatile G3.e<U> f3346f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f3347g;

        /* renamed from: h, reason: collision with root package name */
        final R3.b f3348h = new R3.b();

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f3349i;

        /* renamed from: j, reason: collision with root package name */
        final AtomicReference<a<?, ?>[]> f3350j;

        /* renamed from: k, reason: collision with root package name */
        final AtomicLong f3351k;

        /* renamed from: l, reason: collision with root package name */
        Q4.c f3352l;

        /* renamed from: m, reason: collision with root package name */
        long f3353m;

        /* renamed from: n, reason: collision with root package name */
        long f3354n;

        /* renamed from: o, reason: collision with root package name */
        int f3355o;

        /* renamed from: p, reason: collision with root package name */
        int f3356p;

        /* renamed from: q, reason: collision with root package name */
        final int f3357q;

        b(Q4.b<? super U> bVar, D3.h<? super T, ? extends Q4.a<? extends U>> hVar, boolean z5, int i5, int i6) {
            AtomicReference<a<?, ?>[]> atomicReference = new AtomicReference<>();
            this.f3350j = atomicReference;
            this.f3351k = new AtomicLong();
            this.f3341a = bVar;
            this.f3342b = hVar;
            this.f3343c = z5;
            this.f3344d = i5;
            this.f3345e = i6;
            this.f3357q = Math.max(1, i5 >> 1);
            atomicReference.lazySet(f3339r);
        }

        @Override // Q4.b
        public void a() {
            if (this.f3347g) {
                return;
            }
            this.f3347g = true;
            j();
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean b(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.f3350j.get();
                if (aVarArr == f3340s) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f3350j.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        boolean c() {
            if (this.f3349i) {
                g();
                return true;
            }
            if (this.f3343c || this.f3348h.get() == null) {
                return false;
            }
            g();
            Throwable thB = this.f3348h.b();
            if (thB != R3.e.f4983a) {
                this.f3341a.onError(thB);
            }
            return true;
        }

        @Override // Q4.c
        public void cancel() {
            G3.e<U> eVar;
            if (this.f3349i) {
                return;
            }
            this.f3349i = true;
            this.f3352l.cancel();
            i();
            if (getAndIncrement() != 0 || (eVar = this.f3346f) == null) {
                return;
            }
            eVar.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Q4.b
        public void d(T t5) {
            if (this.f3347g) {
                return;
            }
            try {
                Q4.a aVar = (Q4.a) F3.b.d(this.f3342b.apply(t5), "The mapper returned a null Publisher");
                if (!(aVar instanceof Callable)) {
                    long j5 = this.f3353m;
                    this.f3353m = 1 + j5;
                    a aVar2 = new a(this, j5);
                    if (b(aVar2)) {
                        aVar.c(aVar2);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) aVar).call();
                    if (objCall != null) {
                        q(objCall);
                        return;
                    }
                    if (this.f3344d == Integer.MAX_VALUE || this.f3349i) {
                        return;
                    }
                    int i5 = this.f3356p + 1;
                    this.f3356p = i5;
                    int i6 = this.f3357q;
                    if (i5 == i6) {
                        this.f3356p = 0;
                        this.f3352l.h(i6);
                    }
                } catch (Throwable th) {
                    B3.b.b(th);
                    this.f3348h.a(th);
                    j();
                }
            } catch (Throwable th2) {
                B3.b.b(th2);
                this.f3352l.cancel();
                onError(th2);
            }
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3352l, cVar)) {
                this.f3352l = cVar;
                this.f3341a.e(this);
                if (this.f3349i) {
                    return;
                }
                int i5 = this.f3344d;
                if (i5 == Integer.MAX_VALUE) {
                    cVar.h(Long.MAX_VALUE);
                } else {
                    cVar.h(i5);
                }
            }
        }

        void g() {
            G3.e<U> eVar = this.f3346f;
            if (eVar != null) {
                eVar.clear();
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this.f3351k, j5);
                j();
            }
        }

        void i() {
            a<?, ?>[] andSet;
            a<?, ?>[] aVarArr = this.f3350j.get();
            a<?, ?>[] aVarArr2 = f3340s;
            if (aVarArr == aVarArr2 || (andSet = this.f3350j.getAndSet(aVarArr2)) == aVarArr2) {
                return;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.dispose();
            }
            Throwable thB = this.f3348h.b();
            if (thB == null || thB == R3.e.f4983a) {
                return;
            }
            S3.a.r(thB);
        }

        void j() {
            if (getAndIncrement() == 0) {
                k();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:155:0x018d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void k() {
            /*
                Method dump skipped, instructions count: 441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.h.b.k():void");
        }

        G3.f<U> l(a<T, U> aVar) {
            G3.f<U> fVar = aVar.f3336f;
            if (fVar != null) {
                return fVar;
            }
            N3.b bVar = new N3.b(this.f3345e);
            aVar.f3336f = bVar;
            return bVar;
        }

        G3.f<U> m() {
            G3.e<U> cVar = this.f3346f;
            if (cVar == null) {
                cVar = this.f3344d == Integer.MAX_VALUE ? new N3.c<>(this.f3345e) : new N3.b<>(this.f3344d);
                this.f3346f = cVar;
            }
            return cVar;
        }

        void n(a<T, U> aVar, Throwable th) {
            if (!this.f3348h.a(th)) {
                S3.a.r(th);
                return;
            }
            aVar.f3335e = true;
            if (!this.f3343c) {
                this.f3352l.cancel();
                for (a<?, ?> aVar2 : this.f3350j.getAndSet(f3340s)) {
                    aVar2.dispose();
                }
            }
            j();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void o(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.f3350j.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    } else if (aVarArr[i5] == aVar) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f3339r;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i5);
                    System.arraycopy(aVarArr, i5 + 1, aVarArr3, i5, (length - i5) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f3350j.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            if (this.f3347g) {
                S3.a.r(th);
            } else if (!this.f3348h.a(th)) {
                S3.a.r(th);
            } else {
                this.f3347g = true;
                j();
            }
        }

        void p(U u5, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j5 = this.f3351k.get();
                G3.f<U> fVarL = aVar.f3336f;
                if (j5 == 0 || !(fVarL == null || fVarL.isEmpty())) {
                    if (fVarL == null) {
                        fVarL = l(aVar);
                    }
                    if (!fVarL.offer(u5)) {
                        onError(new B3.c("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f3341a.d(u5);
                    if (j5 != Long.MAX_VALUE) {
                        this.f3351k.decrementAndGet();
                    }
                    aVar.b(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                G3.f bVar = aVar.f3336f;
                if (bVar == null) {
                    bVar = new N3.b(this.f3345e);
                    aVar.f3336f = bVar;
                }
                if (!bVar.offer(u5)) {
                    onError(new B3.c("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            k();
        }

        void q(U u5) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j5 = this.f3351k.get();
                G3.f<U> fVarM = this.f3346f;
                if (j5 == 0 || !(fVarM == null || fVarM.isEmpty())) {
                    if (fVarM == null) {
                        fVarM = m();
                    }
                    if (!fVarM.offer(u5)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.f3341a.d(u5);
                    if (j5 != Long.MAX_VALUE) {
                        this.f3351k.decrementAndGet();
                    }
                    if (this.f3344d != Integer.MAX_VALUE && !this.f3349i) {
                        int i5 = this.f3356p + 1;
                        this.f3356p = i5;
                        int i6 = this.f3357q;
                        if (i5 == i6) {
                            this.f3356p = 0;
                            this.f3352l.h(i6);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!m().offer(u5)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            k();
        }
    }

    public h(x3.f<T> fVar, D3.h<? super T, ? extends Q4.a<? extends U>> hVar, boolean z5, int i5, int i6) {
        super(fVar);
        this.f3327c = hVar;
        this.f3328d = z5;
        this.f3329e = i5;
        this.f3330f = i6;
    }

    public static <T, U> x3.i<T> d0(Q4.b<? super U> bVar, D3.h<? super T, ? extends Q4.a<? extends U>> hVar, boolean z5, int i5, int i6) {
        return new b(bVar, hVar, z5, i5, i6);
    }

    @Override // x3.f
    protected void W(Q4.b<? super U> bVar) {
        if (B.b(this.f3267b, bVar, this.f3327c)) {
            return;
        }
        this.f3267b.V(d0(bVar, this.f3327c, this.f3328d, this.f3329e, this.f3330f));
    }
}
