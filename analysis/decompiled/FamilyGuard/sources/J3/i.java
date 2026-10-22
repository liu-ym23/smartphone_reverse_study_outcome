package J3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class i<T, R> extends AbstractC0350a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final D3.h<? super T, ? extends x3.l<? extends R>> f3358c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f3359d;

    /* renamed from: e, reason: collision with root package name */
    final int f3360e;

    static final class a<T, R> extends AtomicInteger implements x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super R> f3361a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f3362b;

        /* renamed from: c, reason: collision with root package name */
        final int f3363c;

        /* renamed from: h, reason: collision with root package name */
        final D3.h<? super T, ? extends x3.l<? extends R>> f3368h;

        /* renamed from: j, reason: collision with root package name */
        Q4.c f3370j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f3371k;

        /* renamed from: d, reason: collision with root package name */
        final AtomicLong f3364d = new AtomicLong();

        /* renamed from: e, reason: collision with root package name */
        final A3.b f3365e = new A3.b();

        /* renamed from: g, reason: collision with root package name */
        final R3.b f3367g = new R3.b();

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f3366f = new AtomicInteger(1);

        /* renamed from: i, reason: collision with root package name */
        final AtomicReference<N3.c<R>> f3369i = new AtomicReference<>();

        /* renamed from: J3.i$a$a, reason: collision with other inner class name */
        final class C0048a extends AtomicReference<A3.c> implements x3.k<R>, A3.c {
            C0048a() {
            }

            @Override // x3.k
            public void a() {
                a.this.j(this);
            }

            @Override // x3.k
            public void b(A3.c cVar) {
                E3.b.j(this, cVar);
            }

            @Override // x3.k
            public void c(R r5) {
                a.this.l(this, r5);
            }

            @Override // A3.c
            public void dispose() {
                E3.b.b(this);
            }

            @Override // A3.c
            public boolean g() {
                return E3.b.d(get());
            }

            @Override // x3.k
            public void onError(Throwable th) {
                a.this.k(this, th);
            }
        }

        a(Q4.b<? super R> bVar, D3.h<? super T, ? extends x3.l<? extends R>> hVar, boolean z5, int i5) {
            this.f3361a = bVar;
            this.f3368h = hVar;
            this.f3362b = z5;
            this.f3363c = i5;
        }

        @Override // Q4.b
        public void a() {
            this.f3366f.decrementAndGet();
            c();
        }

        void b() {
            N3.c<R> cVar = this.f3369i.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void c() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        @Override // Q4.c
        public void cancel() {
            this.f3371k = true;
            this.f3370j.cancel();
            this.f3365e.dispose();
        }

        @Override // Q4.b
        public void d(T t5) {
            try {
                x3.l lVar = (x3.l) F3.b.d(this.f3368h.apply(t5), "The mapper returned a null MaybeSource");
                this.f3366f.getAndIncrement();
                C0048a c0048a = new C0048a();
                if (this.f3371k || !this.f3365e.c(c0048a)) {
                    return;
                }
                lVar.a(c0048a);
            } catch (Throwable th) {
                B3.b.b(th);
                this.f3370j.cancel();
                onError(th);
            }
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3370j, cVar)) {
                this.f3370j = cVar;
                this.f3361a.e(this);
                int i5 = this.f3363c;
                if (i5 == Integer.MAX_VALUE) {
                    cVar.h(Long.MAX_VALUE);
                } else {
                    cVar.h(i5);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
        
            if (r10 != r6) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
        
            if (r17.f3371k == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
        
            b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        
            if (r17.f3362b != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
        
            if (r17.f3367g.get() == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
        
            r2 = r17.f3367g.b();
            b();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
        
            if (r2.get() != 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
        
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
        
            if (r7 == null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b3, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
        
            if (r6 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b6, code lost:
        
            if (r13 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
        
            r0 = r17.f3367g.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00be, code lost:
        
            if (r0 == null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c0, code lost:
        
            r1.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c3, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
        
            r1.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        
            if (r10 == 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        
            R3.c.d(r17.f3364d, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
        
            if (r17.f3363c == Integer.MAX_VALUE) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
        
            r17.f3370j.h(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void g() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.i.a.g():void");
        }

        @Override // Q4.c
        public void h(long j5) {
            if (Q3.g.k(j5)) {
                R3.c.a(this.f3364d, j5);
                c();
            }
        }

        N3.c<R> i() {
            N3.c<R> cVar;
            do {
                N3.c<R> cVar2 = this.f3369i.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new N3.c<>(x3.f.g());
            } while (!this.f3369i.compareAndSet(null, cVar));
            return cVar;
        }

        void j(a<T, R>.C0048a c0048a) {
            this.f3365e.b(c0048a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z5 = this.f3366f.decrementAndGet() == 0;
                    N3.c<R> cVar = this.f3369i.get();
                    if (z5 && (cVar == null || cVar.isEmpty())) {
                        Throwable thB = this.f3367g.b();
                        if (thB != null) {
                            this.f3361a.onError(thB);
                            return;
                        } else {
                            this.f3361a.a();
                            return;
                        }
                    }
                    if (this.f3363c != Integer.MAX_VALUE) {
                        this.f3370j.h(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    g();
                    return;
                }
            }
            this.f3366f.decrementAndGet();
            if (this.f3363c != Integer.MAX_VALUE) {
                this.f3370j.h(1L);
            }
            c();
        }

        void k(a<T, R>.C0048a c0048a, Throwable th) {
            this.f3365e.b(c0048a);
            if (!this.f3367g.a(th)) {
                S3.a.r(th);
                return;
            }
            if (!this.f3362b) {
                this.f3370j.cancel();
                this.f3365e.dispose();
            } else if (this.f3363c != Integer.MAX_VALUE) {
                this.f3370j.h(1L);
            }
            this.f3366f.decrementAndGet();
            c();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void l(J3.i.a<T, R>.C0048a r5, R r6) {
            /*
                r4 = this;
                A3.b r0 = r4.f3365e
                r0.b(r5)
                int r5 = r4.get()
                if (r5 != 0) goto L7a
                r5 = 0
                r0 = 1
                boolean r1 = r4.compareAndSet(r5, r0)
                if (r1 == 0) goto L7a
                java.util.concurrent.atomic.AtomicInteger r1 = r4.f3366f
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L1c
                r5 = r0
            L1c:
                java.util.concurrent.atomic.AtomicLong r0 = r4.f3364d
                long r0 = r0.get()
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L67
                Q4.b<? super R> r0 = r4.f3361a
                r0.d(r6)
                java.util.concurrent.atomic.AtomicReference<N3.c<R>> r6 = r4.f3369i
                java.lang.Object r6 = r6.get()
                N3.c r6 = (N3.c) r6
                if (r5 == 0) goto L53
                if (r6 == 0) goto L3f
                boolean r5 = r6.isEmpty()
                if (r5 == 0) goto L53
            L3f:
                R3.b r5 = r4.f3367g
                java.lang.Throwable r5 = r5.b()
                if (r5 == 0) goto L4d
                Q4.b<? super R> r4 = r4.f3361a
                r4.onError(r5)
                return
            L4d:
                Q4.b<? super R> r4 = r4.f3361a
                r4.a()
                return
            L53:
                java.util.concurrent.atomic.AtomicLong r5 = r4.f3364d
                r0 = 1
                R3.c.d(r5, r0)
                int r5 = r4.f3363c
                r6 = 2147483647(0x7fffffff, float:NaN)
                if (r5 == r6) goto L70
                Q4.c r5 = r4.f3370j
                r5.h(r0)
                goto L70
            L67:
                N3.c r5 = r4.i()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            L70:
                int r5 = r4.decrementAndGet()
                if (r5 != 0) goto L8f
                goto L8e
            L77:
                r4 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
                throw r4
            L7a:
                N3.c r5 = r4.i()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L93
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                java.util.concurrent.atomic.AtomicInteger r5 = r4.f3366f
                r5.decrementAndGet()
                int r5 = r4.getAndIncrement()
                if (r5 == 0) goto L8f
            L8e:
                return
            L8f:
                r4.g()
                return
            L93:
                r4 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.i.a.l(J3.i$a$a, java.lang.Object):void");
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            this.f3366f.decrementAndGet();
            if (!this.f3367g.a(th)) {
                S3.a.r(th);
                return;
            }
            if (!this.f3362b) {
                this.f3365e.dispose();
            }
            c();
        }
    }

    public i(x3.f<T> fVar, D3.h<? super T, ? extends x3.l<? extends R>> hVar, boolean z5, int i5) {
        super(fVar);
        this.f3358c = hVar;
        this.f3359d = z5;
        this.f3360e = i5;
    }

    @Override // x3.f
    protected void W(Q4.b<? super R> bVar) {
        this.f3267b.V(new a(bVar, this.f3358c, this.f3359d, this.f3360e));
    }
}
