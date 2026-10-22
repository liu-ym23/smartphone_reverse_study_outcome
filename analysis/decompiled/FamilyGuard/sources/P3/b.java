package P3;

import Q3.g;
import x3.i;

/* loaded from: classes.dex */
public abstract class b<T, R> implements i<T>, G3.c<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final Q4.b<? super R> f4835a;

    /* renamed from: b, reason: collision with root package name */
    protected Q4.c f4836b;

    /* renamed from: c, reason: collision with root package name */
    protected G3.c<T> f4837c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f4838d;

    /* renamed from: e, reason: collision with root package name */
    protected int f4839e;

    public b(Q4.b<? super R> bVar) {
        this.f4835a = bVar;
    }

    @Override // Q4.b
    public void a() {
        if (this.f4838d) {
            return;
        }
        this.f4838d = true;
        this.f4835a.a();
    }

    protected void c() {
    }

    @Override // Q4.c
    public void cancel() {
        this.f4836b.cancel();
    }

    @Override // G3.f
    public void clear() {
        this.f4837c.clear();
    }

    @Override // x3.i, Q4.b
    public final void e(Q4.c cVar) {
        if (g.l(this.f4836b, cVar)) {
            this.f4836b = cVar;
            if (cVar instanceof G3.c) {
                this.f4837c = (G3.c) cVar;
            }
            if (g()) {
                this.f4835a.e(this);
                c();
            }
        }
    }

    protected boolean g() {
        return true;
    }

    @Override // Q4.c
    public void h(long j5) {
        this.f4836b.h(j5);
    }

    protected final void i(Throwable th) {
        B3.b.b(th);
        this.f4836b.cancel();
        onError(th);
    }

    @Override // G3.f
    public boolean isEmpty() {
        return this.f4837c.isEmpty();
    }

    protected final int j(int i5) {
        G3.c<T> cVar = this.f4837c;
        if (cVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int iB = cVar.b(i5);
        if (iB != 0) {
            this.f4839e = iB;
        }
        return iB;
    }

    @Override // G3.f
    public final boolean offer(R r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // Q4.b
    public void onError(Throwable th) {
        if (this.f4838d) {
            S3.a.r(th);
        } else {
            this.f4838d = true;
            this.f4835a.onError(th);
        }
    }
}
