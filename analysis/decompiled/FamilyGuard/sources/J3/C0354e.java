package J3;

/* renamed from: J3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0354e<T> extends AbstractC0350a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final D3.c<? super T> f3311c;

    /* renamed from: d, reason: collision with root package name */
    final D3.c<? super Throwable> f3312d;

    /* renamed from: e, reason: collision with root package name */
    final D3.a f3313e;

    /* renamed from: f, reason: collision with root package name */
    final D3.a f3314f;

    /* renamed from: J3.e$a */
    static final class a<T> extends P3.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final D3.c<? super T> f3315f;

        /* renamed from: g, reason: collision with root package name */
        final D3.c<? super Throwable> f3316g;

        /* renamed from: h, reason: collision with root package name */
        final D3.a f3317h;

        /* renamed from: i, reason: collision with root package name */
        final D3.a f3318i;

        a(G3.a<? super T> aVar, D3.c<? super T> cVar, D3.c<? super Throwable> cVar2, D3.a aVar2, D3.a aVar3) {
            super(aVar);
            this.f3315f = cVar;
            this.f3316g = cVar2;
            this.f3317h = aVar2;
            this.f3318i = aVar3;
        }

        @Override // P3.a, Q4.b
        public void a() {
            if (this.f4833d) {
                return;
            }
            try {
                this.f3317h.run();
                this.f4833d = true;
                this.f4830a.a();
                try {
                    this.f3318i.run();
                } catch (Throwable th) {
                    B3.b.b(th);
                    S3.a.r(th);
                }
            } catch (Throwable th2) {
                i(th2);
            }
        }

        @Override // G3.b
        public int b(int i5) {
            return j(i5);
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f4833d) {
                return;
            }
            if (this.f4834e != 0) {
                this.f4830a.d(null);
                return;
            }
            try {
                this.f3315f.accept(t5);
                this.f4830a.d(t5);
            } catch (Throwable th) {
                i(th);
            }
        }

        @Override // G3.a
        public boolean f(T t5) {
            if (this.f4833d) {
                return false;
            }
            try {
                this.f3315f.accept(t5);
                return this.f4830a.f(t5);
            } catch (Throwable th) {
                i(th);
                return false;
            }
        }

        @Override // P3.a, Q4.b
        public void onError(Throwable th) {
            if (this.f4833d) {
                S3.a.r(th);
                return;
            }
            this.f4833d = true;
            try {
                this.f3316g.accept(th);
                this.f4830a.onError(th);
            } catch (Throwable th2) {
                B3.b.b(th2);
                this.f4830a.onError(new B3.a(th, th2));
            }
            try {
                this.f3318i.run();
            } catch (Throwable th3) {
                B3.b.b(th3);
                S3.a.r(th3);
            }
        }

        @Override // G3.f
        public T poll() throws Exception {
            B3.a aVar;
            try {
                T tPoll = this.f4832c.poll();
                if (tPoll == null) {
                    if (this.f4834e == 1) {
                        this.f3317h.run();
                        this.f3318i.run();
                    }
                    return tPoll;
                }
                try {
                    this.f3315f.accept(tPoll);
                    this.f3318i.run();
                    return tPoll;
                } catch (Throwable th) {
                    try {
                        B3.b.b(th);
                        try {
                            this.f3316g.accept(th);
                            throw R3.e.c(th);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f3318i.run();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                B3.b.b(th3);
                try {
                    this.f3316g.accept(th3);
                    throw R3.e.c(th3);
                } finally {
                }
            }
        }
    }

    /* renamed from: J3.e$b */
    static final class b<T> extends P3.b<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final D3.c<? super T> f3319f;

        /* renamed from: g, reason: collision with root package name */
        final D3.c<? super Throwable> f3320g;

        /* renamed from: h, reason: collision with root package name */
        final D3.a f3321h;

        /* renamed from: i, reason: collision with root package name */
        final D3.a f3322i;

        b(Q4.b<? super T> bVar, D3.c<? super T> cVar, D3.c<? super Throwable> cVar2, D3.a aVar, D3.a aVar2) {
            super(bVar);
            this.f3319f = cVar;
            this.f3320g = cVar2;
            this.f3321h = aVar;
            this.f3322i = aVar2;
        }

        @Override // P3.b, Q4.b
        public void a() {
            if (this.f4838d) {
                return;
            }
            try {
                this.f3321h.run();
                this.f4838d = true;
                this.f4835a.a();
                try {
                    this.f3322i.run();
                } catch (Throwable th) {
                    B3.b.b(th);
                    S3.a.r(th);
                }
            } catch (Throwable th2) {
                i(th2);
            }
        }

        @Override // G3.b
        public int b(int i5) {
            return j(i5);
        }

        @Override // Q4.b
        public void d(T t5) {
            if (this.f4838d) {
                return;
            }
            if (this.f4839e != 0) {
                this.f4835a.d(null);
                return;
            }
            try {
                this.f3319f.accept(t5);
                this.f4835a.d(t5);
            } catch (Throwable th) {
                i(th);
            }
        }

        @Override // P3.b, Q4.b
        public void onError(Throwable th) {
            if (this.f4838d) {
                S3.a.r(th);
                return;
            }
            this.f4838d = true;
            try {
                this.f3320g.accept(th);
                this.f4835a.onError(th);
            } catch (Throwable th2) {
                B3.b.b(th2);
                this.f4835a.onError(new B3.a(th, th2));
            }
            try {
                this.f3322i.run();
            } catch (Throwable th3) {
                B3.b.b(th3);
                S3.a.r(th3);
            }
        }

        @Override // G3.f
        public T poll() throws Exception {
            B3.a aVar;
            try {
                T tPoll = this.f4837c.poll();
                if (tPoll == null) {
                    if (this.f4839e == 1) {
                        this.f3321h.run();
                        this.f3322i.run();
                    }
                    return tPoll;
                }
                try {
                    this.f3319f.accept(tPoll);
                    this.f3322i.run();
                    return tPoll;
                } catch (Throwable th) {
                    try {
                        B3.b.b(th);
                        try {
                            this.f3320g.accept(th);
                            throw R3.e.c(th);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f3322i.run();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                B3.b.b(th3);
                try {
                    this.f3320g.accept(th3);
                    throw R3.e.c(th3);
                } finally {
                }
            }
        }
    }

    public C0354e(x3.f<T> fVar, D3.c<? super T> cVar, D3.c<? super Throwable> cVar2, D3.a aVar, D3.a aVar2) {
        super(fVar);
        this.f3311c = cVar;
        this.f3312d = cVar2;
        this.f3313e = aVar;
        this.f3314f = aVar2;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        if (bVar instanceof G3.a) {
            this.f3267b.V(new a((G3.a) bVar, this.f3311c, this.f3312d, this.f3313e, this.f3314f));
        } else {
            this.f3267b.V(new b(bVar, this.f3311c, this.f3312d, this.f3313e, this.f3314f));
        }
    }
}
