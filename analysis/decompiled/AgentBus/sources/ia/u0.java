package ia;

/* loaded from: classes.dex */
public abstract class u0 implements Runnable, Comparable, p0 {
    private volatile Object _heap;

    /* renamed from: f, reason: collision with root package name */
    public long f5008f;

    /* renamed from: g, reason: collision with root package name */
    public int f5009g = -1;

    public u0(long j2) {
        this.f5008f = j2;
    }

    @Override // ia.p0
    public final void a() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                f8.x xVar = d0.f4936b;
                if (obj == xVar) {
                    return;
                }
                v0 v0Var = obj instanceof v0 ? (v0) obj : null;
                if (v0Var != null) {
                    synchronized (v0Var) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof na.v ? (na.v) obj2 : null) != null) {
                            v0Var.b(this.f5009g);
                        }
                    }
                }
                this._heap = xVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int b(long j2, v0 v0Var, w0 w0Var) {
        synchronized (this) {
            if (this._heap == d0.f4936b) {
                return 2;
            }
            synchronized (v0Var) {
                try {
                    u0[] u0VarArr = v0Var.f6931a;
                    u0 u0Var = u0VarArr != null ? u0VarArr[0] : null;
                    if (w0.f5020n.get(w0Var) == 1) {
                        return 1;
                    }
                    if (u0Var == null) {
                        v0Var.f5012c = j2;
                    } else {
                        long j4 = u0Var.f5008f;
                        if (j4 - j2 < 0) {
                            j2 = j4;
                        }
                        if (j2 - v0Var.f5012c > 0) {
                            v0Var.f5012c = j2;
                        }
                    }
                    long j10 = this.f5008f;
                    long j11 = v0Var.f5012c;
                    if (j10 - j11 < 0) {
                        this.f5008f = j11;
                    }
                    v0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j2 = this.f5008f - ((u0) obj).f5008f;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }

    public final void d(v0 v0Var) {
        if (this._heap == d0.f4936b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = v0Var;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f5008f + ']';
    }
}
