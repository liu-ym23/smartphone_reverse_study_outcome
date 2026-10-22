package U3;

import Q4.b;
import Q4.c;
import R3.g;
import x3.i;

/* loaded from: classes.dex */
public final class a<T> implements i<T>, c {

    /* renamed from: a, reason: collision with root package name */
    final b<? super T> f5464a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f5465b;

    /* renamed from: c, reason: collision with root package name */
    c f5466c;

    /* renamed from: d, reason: collision with root package name */
    boolean f5467d;

    /* renamed from: e, reason: collision with root package name */
    R3.a<Object> f5468e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f5469f;

    public a(b<? super T> bVar) {
        this(bVar, false);
    }

    @Override // Q4.b
    public void a() {
        if (this.f5469f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f5469f) {
                    return;
                }
                if (!this.f5467d) {
                    this.f5469f = true;
                    this.f5467d = true;
                    this.f5464a.a();
                } else {
                    R3.a<Object> aVar = this.f5468e;
                    if (aVar == null) {
                        aVar = new R3.a<>(4);
                        this.f5468e = aVar;
                    }
                    aVar.b(g.d());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void b() {
        R3.a<Object> aVar;
        do {
            synchronized (this) {
                try {
                    aVar = this.f5468e;
                    if (aVar == null) {
                        this.f5467d = false;
                        return;
                    }
                    this.f5468e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!aVar.a(this.f5464a));
    }

    @Override // Q4.c
    public void cancel() {
        this.f5466c.cancel();
    }

    @Override // Q4.b
    public void d(T t5) {
        if (this.f5469f) {
            return;
        }
        if (t5 == null) {
            this.f5466c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f5469f) {
                    return;
                }
                if (!this.f5467d) {
                    this.f5467d = true;
                    this.f5464a.d(t5);
                    b();
                } else {
                    R3.a<Object> aVar = this.f5468e;
                    if (aVar == null) {
                        aVar = new R3.a<>(4);
                        this.f5468e = aVar;
                    }
                    aVar.b(g.j(t5));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x3.i, Q4.b
    public void e(c cVar) {
        if (Q3.g.l(this.f5466c, cVar)) {
            this.f5466c = cVar;
            this.f5464a.e(this);
        }
    }

    @Override // Q4.c
    public void h(long j5) {
        this.f5466c.h(j5);
    }

    @Override // Q4.b
    public void onError(Throwable th) {
        if (this.f5469f) {
            S3.a.r(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z5 = true;
                if (!this.f5469f) {
                    if (this.f5467d) {
                        this.f5469f = true;
                        R3.a<Object> aVar = this.f5468e;
                        if (aVar == null) {
                            aVar = new R3.a<>(4);
                            this.f5468e = aVar;
                        }
                        Object objE = g.e(th);
                        if (this.f5465b) {
                            aVar.b(objE);
                        } else {
                            aVar.c(objE);
                        }
                        return;
                    }
                    this.f5469f = true;
                    this.f5467d = true;
                    z5 = false;
                }
                if (z5) {
                    S3.a.r(th);
                } else {
                    this.f5464a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public a(b<? super T> bVar, boolean z5) {
        this.f5464a = bVar;
        this.f5465b = z5;
    }
}
