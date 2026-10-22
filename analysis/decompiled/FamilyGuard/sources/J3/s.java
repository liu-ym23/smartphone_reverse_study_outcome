package J3;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class s<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final int f3425c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f3426d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f3427e;

    /* renamed from: f, reason: collision with root package name */
    final D3.a f3428f;

    static final class a<T> extends Q3.a<T> implements x3.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f3429a;

        /* renamed from: b, reason: collision with root package name */
        final G3.e<T> f3430b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f3431c;

        /* renamed from: d, reason: collision with root package name */
        final D3.a f3432d;

        /* renamed from: e, reason: collision with root package name */
        Q4.c f3433e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f3434f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f3435g;

        /* renamed from: h, reason: collision with root package name */
        Throwable f3436h;

        /* renamed from: i, reason: collision with root package name */
        final AtomicLong f3437i = new AtomicLong();

        /* renamed from: j, reason: collision with root package name */
        boolean f3438j;

        a(Q4.b<? super T> bVar, int i5, boolean z5, boolean z6, D3.a aVar) {
            this.f3429a = bVar;
            this.f3432d = aVar;
            this.f3431c = z6;
            this.f3430b = z5 ? new N3.c<>(i5) : new N3.b<>(i5);
        }

        @Override // Q4.b
        public void a() {
            this.f3435g = true;
            if (this.f3438j) {
                this.f3429a.a();
            } else {
                g();
            }
        }

        @Override // G3.b
        public int b(int i5) {
            if ((i5 & 2) == 0) {
                return 0;
            }
            this.f3438j = true;
            return 2;
        }

        boolean c(boolean z5, boolean z6, Q4.b<? super T> bVar) {
            if (this.f3434f) {
                this.f3430b.clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (this.f3431c) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.f3436h;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.a();
                }
                return true;
            }
            Throwable th2 = this.f3436h;
            if (th2 != null) {
                this.f3430b.clear();
                bVar.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            bVar.a();
            return true;
        }

        @Override // Q4.c
        public void cancel() {
            if (this.f3434f) {
                return;
            }
            this.f3434f = true;
            this.f3433e.cancel();
            if (getAndIncrement() == 0) {
                this.f3430b.clear();
            }
        }

        @Override // G3.f
        public void clear() {
            this.f3430b.clear();
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f3430b.offer(t5)) {
                if (this.f3438j) {
                    this.f3429a.d(null);
                    return;
                } else {
                    g();
                    return;
                }
            }
            this.f3433e.cancel();
            B3.c cVar = new B3.c("Buffer is full");
            try {
                this.f3432d.run();
            } catch (Throwable th) {
                B3.b.b(th);
                cVar.initCause(th);
            }
            onError(cVar);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            if (Q3.g.l(this.f3433e, cVar)) {
                this.f3433e = cVar;
                this.f3429a.e(this);
                cVar.h(Long.MAX_VALUE);
            }
        }

        void g() {
            if (getAndIncrement() == 0) {
                G3.e<T> eVar = this.f3430b;
                Q4.b<? super T> bVar = this.f3429a;
                int iAddAndGet = 1;
                while (!c(this.f3435g, eVar.isEmpty(), bVar)) {
                    long j5 = this.f3437i.get();
                    long j6 = 0;
                    while (j6 != j5) {
                        boolean z5 = this.f3435g;
                        T tPoll = eVar.poll();
                        boolean z6 = tPoll == null;
                        if (c(z5, z6, bVar)) {
                            return;
                        }
                        if (z6) {
                            break;
                        }
                        bVar.d(tPoll);
                        j6++;
                    }
                    if (j6 == j5 && c(this.f3435g, eVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j6 != 0 && j5 != Long.MAX_VALUE) {
                        this.f3437i.addAndGet(-j6);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // Q4.c
        public void h(long j5) {
            if (this.f3438j || !Q3.g.k(j5)) {
                return;
            }
            R3.c.a(this.f3437i, j5);
            g();
        }

        @Override // G3.f
        public boolean isEmpty() {
            return this.f3430b.isEmpty();
        }

        @Override // Q4.b
        public void onError(Throwable th) {
            this.f3436h = th;
            this.f3435g = true;
            if (this.f3438j) {
                this.f3429a.onError(th);
            } else {
                g();
            }
        }

        @Override // G3.f
        public T poll() {
            return this.f3430b.poll();
        }
    }

    public s(x3.f<T> fVar, int i5, boolean z5, boolean z6, D3.a aVar) {
        super(fVar);
        this.f3425c = i5;
        this.f3426d = z5;
        this.f3427e = z6;
        this.f3428f = aVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        this.f3267b.V(new a(bVar, this.f3425c, this.f3426d, this.f3427e, this.f3428f));
    }
}
