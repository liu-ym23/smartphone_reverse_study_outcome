package a6;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class x0 implements Runnable, Comparable, s0 {
    private volatile Object _heap;

    /* renamed from: a, reason: collision with root package name */
    public long f225a;

    /* renamed from: b, reason: collision with root package name */
    public int f226b = -1;

    public x0(long j4) {
        this.f225a = j4;
    }

    public final int a(long j4, y0 y0Var, z0 z0Var) {
        synchronized (this) {
            if (this._heap == i0.f173b) {
                return 2;
            }
            synchronized (y0Var) {
                try {
                    x0[] x0VarArr = y0Var.f2663a;
                    x0 x0Var = x0VarArr != null ? x0VarArr[0] : null;
                    if (z0.f232j.get(z0Var) == 1) {
                        return 1;
                    }
                    if (x0Var == null) {
                        y0Var.f228c = j4;
                    } else {
                        long j8 = x0Var.f225a;
                        if (j8 - j4 < 0) {
                            j4 = j8;
                        }
                        if (j4 - y0Var.f228c > 0) {
                            y0Var.f228c = j4;
                        }
                    }
                    long j9 = this.f225a;
                    long j10 = y0Var.f228c;
                    if (j9 - j10 < 0) {
                        this.f225a = j10;
                    }
                    y0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // a6.s0
    public final void b() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                androidx.emoji2.text.r rVar = i0.f173b;
                if (obj == rVar) {
                    return;
                }
                y0 y0Var = obj instanceof y0 ? (y0) obj : null;
                if (y0Var != null) {
                    synchronized (y0Var) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof f6.t ? (f6.t) obj2 : null) != null) {
                            y0Var.b(this.f226b);
                        }
                    }
                }
                this._heap = rVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j4 = this.f225a - ((x0) obj).f225a;
        if (j4 > 0) {
            return 1;
        }
        return j4 < 0 ? -1 : 0;
    }

    public final void d(y0 y0Var) {
        if (this._heap == i0.f173b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = y0Var;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f225a + AbstractJsonLexerKt.END_LIST;
    }
}
