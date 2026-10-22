package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class m0 implements Runnable, Comparable, g0 {
    private volatile Object _heap;

    /* renamed from: c, reason: collision with root package name */
    public long f7456c;

    /* renamed from: f, reason: collision with root package name */
    public int f7457f = -1;

    public m0(long j10) {
        this.f7456c = j10;
    }

    public final int b(long j10, n0 n0Var, o0 o0Var) {
        synchronized (this) {
            if (this._heap == w.f7490b) {
                return 2;
            }
            synchronized (n0Var) {
                try {
                    m0[] m0VarArr = n0Var.f9992a;
                    m0 m0Var = m0VarArr != null ? m0VarArr[0] : null;
                    if (o0.f7468l.get(o0Var) != 0) {
                        return 1;
                    }
                    if (m0Var == null) {
                        n0Var.f7462c = j10;
                    } else {
                        long j11 = m0Var.f7456c;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - n0Var.f7462c > 0) {
                            n0Var.f7462c = j10;
                        }
                    }
                    long j12 = this.f7456c;
                    long j13 = n0Var.f7462c;
                    if (j12 - j13 < 0) {
                        this.f7456c = j13;
                    }
                    n0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void c(n0 n0Var) {
        if (this._heap != w.f7490b) {
            this._heap = n0Var;
        } else {
            g5.f.s("Failed requirement.");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j10 = this.f7456c - ((m0) obj).f7456c;
        if (j10 > 0) {
            return 1;
        }
        return j10 < 0 ? -1 : 0;
    }

    @Override // kc.g0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                pc.t tVar = w.f7490b;
                if (obj == tVar) {
                    return;
                }
                n0 n0Var = obj instanceof n0 ? (n0) obj : null;
                if (n0Var != null) {
                    synchronized (n0Var) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof pc.x ? (pc.x) obj2 : null) != null) {
                            n0Var.b(this.f7457f);
                        }
                    }
                }
                this._heap = tVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f7456c + ']';
    }
}
