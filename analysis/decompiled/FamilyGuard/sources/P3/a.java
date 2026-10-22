package P3;

import Q3.g;

/* loaded from: classes.dex */
public abstract class a<T, R> implements G3.a<T>, G3.c<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final G3.a<? super R> f4830a;

    /* renamed from: b, reason: collision with root package name */
    protected Q4.c f4831b;

    /* renamed from: c, reason: collision with root package name */
    protected G3.c<T> f4832c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f4833d;

    /* renamed from: e, reason: collision with root package name */
    protected int f4834e;

    public a(G3.a<? super R> aVar) {
        this.f4830a = aVar;
    }

    @Override // Q4.b
    public void a() {
        if (this.f4833d) {
            return;
        }
        this.f4833d = true;
        this.f4830a.a();
    }

    protected void c() {
    }

    @Override // Q4.c
    public void cancel() {
        this.f4831b.cancel();
    }

    @Override // G3.f
    public void clear() {
        this.f4832c.clear();
    }

    @Override // x3.i, Q4.b
    public final void e(Q4.c cVar) {
        if (g.l(this.f4831b, cVar)) {
            this.f4831b = cVar;
            if (cVar instanceof G3.c) {
                this.f4832c = (G3.c) cVar;
            }
            if (g()) {
                this.f4830a.e(this);
                c();
            }
        }
    }

    protected boolean g() {
        return true;
    }

    @Override // Q4.c
    public void h(long j5) {
        this.f4831b.h(j5);
    }

    protected final void i(Throwable th) {
        B3.b.b(th);
        this.f4831b.cancel();
        onError(th);
    }

    @Override // G3.f
    public boolean isEmpty() {
        return this.f4832c.isEmpty();
    }

    protected final int j(int i5) {
        G3.c<T> cVar = this.f4832c;
        if (cVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int iB = cVar.b(i5);
        if (iB != 0) {
            this.f4834e = iB;
        }
        return iB;
    }

    @Override // G3.f
    public final boolean offer(R r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // Q4.b
    public void onError(Throwable th) {
        if (this.f4833d) {
            S3.a.r(th);
        } else {
            this.f4833d = true;
            this.f4830a.onError(th);
        }
    }
}
