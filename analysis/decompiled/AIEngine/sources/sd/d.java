package sd;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11921a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11922b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11923c;

    public d(InputStream inputStream, f0 timeout) {
        kotlin.jvm.internal.g.f(timeout, "timeout");
        this.f11922b = inputStream;
        this.f11923c = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i10 = this.f11921a;
        Object obj = this.f11922b;
        switch (i10) {
            case 0:
                d0 d0Var = (d0) obj;
                d dVar = (d) this.f11923c;
                d0Var.i();
                try {
                    dVar.close();
                    lb.n nVar = lb.n.f10413a;
                    if (d0Var.j()) {
                        throw d0Var.l(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!d0Var.j()) {
                        throw e10;
                    }
                    throw d0Var.l(e10);
                } finally {
                    d0Var.j();
                }
            default:
                ((InputStream) obj).close();
                return;
        }
    }

    @Override // sd.e0
    public final long read(e sink, long j10) throws IOException {
        switch (this.f11921a) {
            case 0:
                kotlin.jvm.internal.g.f(sink, "sink");
                d0 d0Var = (d0) this.f11922b;
                d dVar = (d) this.f11923c;
                d0Var.i();
                try {
                    long j11 = dVar.read(sink, j10);
                    if (d0Var.j()) {
                        throw d0Var.l(null);
                    }
                    return j11;
                } catch (IOException e10) {
                    if (d0Var.j()) {
                        throw d0Var.l(e10);
                    }
                    throw e10;
                } finally {
                    d0Var.j();
                }
            default:
                kotlin.jvm.internal.g.f(sink, "sink");
                if (j10 == 0) {
                    return 0L;
                }
                if (j10 < 0) {
                    throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
                }
                try {
                    ((f0) this.f11923c).f();
                    a0 a0VarM0 = sink.M0(1);
                    int i10 = ((InputStream) this.f11922b).read(a0VarM0.f11901a, a0VarM0.f11903c, (int) Math.min(j10, 8192 - a0VarM0.f11903c));
                    if (i10 == -1) {
                        if (a0VarM0.f11902b == a0VarM0.f11903c) {
                            sink.f11925a = a0VarM0.a();
                            b0.a(a0VarM0);
                        }
                        return -1L;
                    }
                    a0VarM0.f11903c += i10;
                    long j12 = i10;
                    sink.f11926b += j12;
                    return j12;
                } catch (AssertionError e11) {
                    if (jd.b.y(e11)) {
                        throw new IOException(e11);
                    }
                    throw e11;
                }
        }
    }

    @Override // sd.e0
    public final f0 timeout() {
        switch (this.f11921a) {
            case 0:
                return (d0) this.f11922b;
            default:
                return (f0) this.f11923c;
        }
    }

    public final String toString() {
        switch (this.f11921a) {
            case 0:
                return "AsyncTimeout.source(" + ((d) this.f11923c) + ')';
            default:
                return "source(" + ((InputStream) this.f11922b) + ')';
        }
    }

    public d(d0 d0Var, d dVar) {
        this.f11922b = d0Var;
        this.f11923c = dVar;
    }
}
