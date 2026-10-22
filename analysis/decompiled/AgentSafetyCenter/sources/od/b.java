package od;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements g0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9418c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9419f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9420g;

    public /* synthetic */ b(int i) {
        this.f9418c = i;
    }

    @Override // od.g0
    public final k0 b() {
        switch (this.f9418c) {
            case 0:
                return (h0) this.f9419f;
            default:
                return (k0) this.f9420g;
        }
    }

    @Override // od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f9418c) {
            case 0:
                h0 h0Var = (h0) this.f9419f;
                b bVar = (b) this.f9420g;
                h0Var.h();
                try {
                    bVar.close();
                    if (h0Var.i()) {
                        throw h0Var.k(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!h0Var.i()) {
                        throw e10;
                    }
                    throw h0Var.k(e10);
                } finally {
                    h0Var.i();
                }
            default:
                ((OutputStream) this.f9419f).close();
                return;
        }
    }

    @Override // od.g0
    public final void f(i iVar, long j10) throws IOException {
        switch (this.f9418c) {
            case 0:
                iVar.getClass();
                a.a.m(iVar.f9454f, 0L, j10);
                long j11 = j10;
                while (true) {
                    long j12 = 0;
                    if (j11 <= 0) {
                        return;
                    }
                    d0 d0Var = iVar.f9453c;
                    d0Var.getClass();
                    while (true) {
                        if (j12 < 65536) {
                            j12 += d0Var.f9439c - d0Var.f9438b;
                            if (j12 >= j11) {
                                j12 = j11;
                            } else {
                                d0Var = d0Var.f9442f;
                                d0Var.getClass();
                            }
                        }
                    }
                    h0 h0Var = (h0) this.f9419f;
                    b bVar = (b) this.f9420g;
                    h0Var.h();
                    try {
                        try {
                            bVar.f(iVar, j12);
                            if (h0Var.i()) {
                                throw h0Var.k(null);
                            }
                            j11 -= j12;
                        } catch (IOException e10) {
                            if (!h0Var.i()) {
                                throw e10;
                            }
                            throw h0Var.k(e10);
                        }
                    } catch (Throwable th) {
                        h0Var.i();
                        throw th;
                    }
                }
            default:
                iVar.getClass();
                a.a.m(iVar.f9454f, 0L, j10);
                while (j10 > 0) {
                    ((k0) this.f9420g).f();
                    d0 d0Var2 = iVar.f9453c;
                    d0Var2.getClass();
                    int iMin = (int) Math.min(j10, d0Var2.f9439c - d0Var2.f9438b);
                    ((OutputStream) this.f9419f).write(d0Var2.f9437a, d0Var2.f9438b, iMin);
                    int i = d0Var2.f9438b + iMin;
                    d0Var2.f9438b = i;
                    long j13 = iMin;
                    j10 -= j13;
                    iVar.f9454f -= j13;
                    if (i == d0Var2.f9439c) {
                        iVar.f9453c = d0Var2.a();
                        e0.a(d0Var2);
                    }
                }
                return;
        }
    }

    @Override // od.g0, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f9418c) {
            case 0:
                h0 h0Var = (h0) this.f9419f;
                b bVar = (b) this.f9420g;
                h0Var.h();
                try {
                    bVar.flush();
                    if (h0Var.i()) {
                        throw h0Var.k(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!h0Var.i()) {
                        throw e10;
                    }
                    throw h0Var.k(e10);
                } finally {
                    h0Var.i();
                }
            default:
                ((OutputStream) this.f9419f).flush();
                return;
        }
    }

    public final String toString() {
        switch (this.f9418c) {
            case 0:
                return "AsyncTimeout.sink(" + ((b) this.f9420g) + ')';
            default:
                return "sink(" + ((OutputStream) this.f9419f) + ')';
        }
    }
}
