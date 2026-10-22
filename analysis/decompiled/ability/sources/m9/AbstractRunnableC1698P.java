package m9;

/* renamed from: m9.P, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractRunnableC1698P implements Runnable, Comparable, InterfaceC1693K {
    private volatile Object _heap;

    /* renamed from: a, reason: collision with root package name */
    public long f5318a;
    public int b = -1;

    public AbstractRunnableC1698P(long j5) {
        this.f5318a = j5;
    }

    public final int c(long j5, C1699Q c1699q, AbstractC1700S abstractC1700S) {
        synchronized (this) {
            if (this._heap == AbstractC1683A.b) {
                return 2;
            }
            synchronized (c1699q) {
                try {
                    AbstractRunnableC1698P[] abstractRunnableC1698PArr = c1699q.f6010a;
                    AbstractRunnableC1698P abstractRunnableC1698P = abstractRunnableC1698PArr != null ? abstractRunnableC1698PArr[0] : null;
                    if (AbstractC1700S.g.get(abstractC1700S) != 0) {
                        return 1;
                    }
                    if (abstractRunnableC1698P == null) {
                        c1699q.c = j5;
                    } else {
                        long j6 = abstractRunnableC1698P.f5318a;
                        if (j6 - j5 < 0) {
                            j5 = j6;
                        }
                        if (j5 - c1699q.c > 0) {
                            c1699q.c = j5;
                        }
                    }
                    long j10 = this.f5318a;
                    long j11 = c1699q.c;
                    if (j10 - j11 < 0) {
                        this.f5318a = j11;
                    }
                    c1699q.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = this.f5318a - ((AbstractRunnableC1698P) obj).f5318a;
        if (j5 > 0) {
            return 1;
        }
        return j5 < 0 ? -1 : 0;
    }

    public final void d(C1699Q c1699q) {
        if (this._heap == AbstractC1683A.b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = c1699q;
    }

    @Override // m9.InterfaceC1693K
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                a5.d dVar = AbstractC1683A.b;
                if (obj == dVar) {
                    return;
                }
                C1699Q c1699q = obj instanceof C1699Q ? (C1699Q) obj : null;
                if (c1699q != null) {
                    synchronized (c1699q) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof s9.u ? (s9.u) obj2 : null) != null) {
                            c1699q.b(this.b);
                        }
                    }
                }
                this._heap = dVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return B7.a.p(new StringBuilder("Delayed[nanos="), this.f5318a, ']');
    }
}
