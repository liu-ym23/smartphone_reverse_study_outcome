package ob;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class d implements i0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7957f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final j0 f7958g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f7959h;

    public d(OutputStream outputStream, j0 j0Var) {
        this.f7959h = outputStream;
        this.f7958g = j0Var;
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f7957f) {
            case 0:
                d dVar = (d) this.f7959h;
                j0 j0Var = this.f7958g;
                j0Var.i();
                try {
                    dVar.close();
                    if (j0Var.j()) {
                        throw j0Var.l(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!j0Var.j()) {
                        throw e10;
                    }
                    throw j0Var.l(e10);
                } finally {
                    j0Var.j();
                }
            default:
                ((OutputStream) this.f7959h).close();
                return;
        }
    }

    @Override // ob.i0, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f7957f) {
            case 0:
                d dVar = (d) this.f7959h;
                j0 j0Var = this.f7958g;
                j0Var.i();
                try {
                    dVar.flush();
                    if (j0Var.j()) {
                        throw j0Var.l(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!j0Var.j()) {
                        throw e10;
                    }
                    throw j0Var.l(e10);
                } finally {
                    j0Var.j();
                }
            default:
                ((OutputStream) this.f7959h).flush();
                return;
        }
    }

    @Override // ob.i0
    public final m0 timeout() {
        switch (this.f7957f) {
        }
        return this.f7958g;
    }

    public final String toString() {
        switch (this.f7957f) {
            case 0:
                return "AsyncTimeout.sink(" + ((d) this.f7959h) + ')';
            default:
                return "sink(" + ((OutputStream) this.f7959h) + ')';
        }
    }

    @Override // ob.i0
    public final void write(h hVar, long j2) throws IOException {
        switch (this.f7957f) {
            case 0:
                q7.k.e(hVar, "source");
                b.e(hVar.f7993g, 0L, j2);
                long j4 = j2;
                while (true) {
                    long j10 = 0;
                    if (j4 <= 0) {
                        return;
                    }
                    f0 f0Var = hVar.f7992f;
                    q7.k.b(f0Var);
                    while (true) {
                        if (j10 < 65536) {
                            j10 += f0Var.f7977c - f0Var.f7976b;
                            if (j10 >= j4) {
                                j10 = j4;
                            } else {
                                f0Var = f0Var.f7980f;
                                q7.k.b(f0Var);
                            }
                        }
                    }
                    d dVar = (d) this.f7959h;
                    j0 j0Var = this.f7958g;
                    j0Var.i();
                    try {
                        try {
                            dVar.write(hVar, j10);
                            if (j0Var.j()) {
                                throw j0Var.l(null);
                            }
                            j4 -= j10;
                        } catch (IOException e10) {
                            if (!j0Var.j()) {
                                throw e10;
                            }
                            throw j0Var.l(e10);
                        }
                    } catch (Throwable th) {
                        j0Var.j();
                        throw th;
                    }
                }
            default:
                q7.k.e(hVar, "source");
                b.e(hVar.f7993g, 0L, j2);
                while (j2 > 0) {
                    this.f7958g.f();
                    f0 f0Var2 = hVar.f7992f;
                    q7.k.b(f0Var2);
                    int iMin = (int) Math.min(j2, f0Var2.f7977c - f0Var2.f7976b);
                    ((OutputStream) this.f7959h).write(f0Var2.f7975a, f0Var2.f7976b, iMin);
                    int i2 = f0Var2.f7976b + iMin;
                    f0Var2.f7976b = i2;
                    long j11 = iMin;
                    j2 -= j11;
                    hVar.f7993g -= j11;
                    if (i2 == f0Var2.f7977c) {
                        hVar.f7992f = f0Var2.a();
                        g0.a(f0Var2);
                    }
                }
                return;
        }
    }

    public d(j0 j0Var, d dVar) {
        this.f7958g = j0Var;
        this.f7959h = dVar;
    }
}
