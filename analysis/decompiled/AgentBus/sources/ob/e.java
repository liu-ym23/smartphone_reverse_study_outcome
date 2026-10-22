package ob;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7961f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f7962g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f7963h;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f7961f = i2;
        this.f7962g = obj;
        this.f7963h = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f7961f) {
            case 0:
                j0 j0Var = (j0) this.f7962g;
                e eVar = (e) this.f7963h;
                j0Var.i();
                try {
                    eVar.close();
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
                ((InputStream) this.f7962g).close();
                return;
        }
    }

    @Override // ob.k0
    public final long read(h hVar, long j2) throws IOException {
        switch (this.f7961f) {
            case 0:
                q7.k.e(hVar, "sink");
                j0 j0Var = (j0) this.f7962g;
                e eVar = (e) this.f7963h;
                j0Var.i();
                try {
                    long j4 = eVar.read(hVar, j2);
                    if (j0Var.j()) {
                        throw j0Var.l(null);
                    }
                    return j4;
                } catch (IOException e10) {
                    if (j0Var.j()) {
                        throw j0Var.l(e10);
                    }
                    throw e10;
                } finally {
                    j0Var.j();
                }
            default:
                q7.k.e(hVar, "sink");
                if (j2 == 0) {
                    return 0L;
                }
                if (j2 < 0) {
                    throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
                }
                try {
                    ((m0) this.f7963h).f();
                    f0 f0VarE = hVar.E(1);
                    int i2 = ((InputStream) this.f7962g).read(f0VarE.f7975a, f0VarE.f7977c, (int) Math.min(j2, 8192 - f0VarE.f7977c));
                    if (i2 == -1) {
                        if (f0VarE.f7976b == f0VarE.f7977c) {
                            hVar.f7992f = f0VarE.a();
                            g0.a(f0VarE);
                        }
                        return -1L;
                    }
                    f0VarE.f7977c += i2;
                    long j10 = i2;
                    hVar.f7993g += j10;
                    return j10;
                } catch (AssertionError e11) {
                    if (b.f(e11)) {
                        throw new IOException(e11);
                    }
                    throw e11;
                }
        }
    }

    @Override // ob.k0
    public final m0 timeout() {
        switch (this.f7961f) {
            case 0:
                return (j0) this.f7962g;
            default:
                return (m0) this.f7963h;
        }
    }

    public final String toString() {
        switch (this.f7961f) {
            case 0:
                return "AsyncTimeout.source(" + ((e) this.f7963h) + ')';
            default:
                return "source(" + ((InputStream) this.f7962g) + ')';
        }
    }
}
