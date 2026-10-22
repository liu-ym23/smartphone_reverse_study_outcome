package od;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9424c = 0;

    /* renamed from: f, reason: collision with root package name */
    public Object f9425f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9426g;

    public c(InputStream inputStream, k0 k0Var) {
        inputStream.getClass();
        this.f9425f = inputStream;
        this.f9426g = k0Var;
    }

    @Override // od.i0
    public final k0 b() {
        switch (this.f9424c) {
            case 0:
                return (h0) this.f9425f;
            default:
                return (k0) this.f9426g;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f9424c) {
            case 0:
                h0 h0Var = (h0) this.f9425f;
                c cVar = (c) this.f9426g;
                h0Var.h();
                try {
                    cVar.close();
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
                ((InputStream) this.f9425f).close();
                return;
        }
    }

    @Override // od.i0
    public final long l(i iVar, long j10) throws IOException {
        int i = this.f9424c;
        iVar.getClass();
        switch (i) {
            case 0:
                h0 h0Var = (h0) this.f9425f;
                c cVar = (c) this.f9426g;
                h0Var.h();
                try {
                    long jL = cVar.l(iVar, j10);
                    if (h0Var.i()) {
                        throw h0Var.k(null);
                    }
                    return jL;
                } catch (IOException e10) {
                    if (h0Var.i()) {
                        throw h0Var.k(e10);
                    }
                    throw e10;
                } finally {
                    h0Var.i();
                }
            default:
                if (j10 == 0) {
                    return 0L;
                }
                if (j10 < 0) {
                    f.c(k0.a.m("byteCount < 0: ", j10));
                    return 0L;
                }
                try {
                    ((k0) this.f9426g).f();
                    d0 d0VarY = iVar.Y(1);
                    int i3 = ((InputStream) this.f9425f).read(d0VarY.f9437a, d0VarY.f9439c, (int) Math.min(j10, 8192 - d0VarY.f9439c));
                    if (i3 == -1) {
                        if (d0VarY.f9438b == d0VarY.f9439c) {
                            iVar.f9453c = d0VarY.a();
                            e0.a(d0VarY);
                        }
                        return -1L;
                    }
                    d0VarY.f9439c += i3;
                    long j11 = i3;
                    iVar.f9454f += j11;
                    return j11;
                } catch (AssertionError e11) {
                    if (ac.a.A(e11)) {
                        throw new IOException(e11);
                    }
                    throw e11;
                }
        }
    }

    public final String toString() {
        switch (this.f9424c) {
            case 0:
                return "AsyncTimeout.source(" + ((c) this.f9426g) + ')';
            default:
                return "source(" + ((InputStream) this.f9425f) + ')';
        }
    }

    public /* synthetic */ c() {
    }
}
