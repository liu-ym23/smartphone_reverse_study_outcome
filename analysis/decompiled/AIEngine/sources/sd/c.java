package sd;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11918a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f11919b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11920c;

    public c(OutputStream outputStream, d0 d0Var) {
        this.f11920c = outputStream;
        this.f11919b = d0Var;
    }

    @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i10 = this.f11918a;
        Object obj = this.f11920c;
        switch (i10) {
            case 0:
                c cVar = (c) obj;
                d0 d0Var = this.f11919b;
                d0Var.i();
                try {
                    cVar.close();
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
                ((OutputStream) obj).close();
                return;
        }
    }

    @Override // sd.c0, java.io.Flushable
    public final void flush() throws IOException {
        int i10 = this.f11918a;
        Object obj = this.f11920c;
        switch (i10) {
            case 0:
                c cVar = (c) obj;
                d0 d0Var = this.f11919b;
                d0Var.i();
                try {
                    cVar.flush();
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
                ((OutputStream) obj).flush();
                return;
        }
    }

    @Override // sd.c0
    public final void j0(e source, long j10) throws IOException {
        long j11;
        int i10 = this.f11918a;
        Object obj = this.f11920c;
        d0 d0Var = this.f11919b;
        kotlin.jvm.internal.g.f(source, "source");
        switch (i10) {
            case 0:
                a.b(source.f11926b, 0L, j10);
                for (long j12 = j10; j12 > 0; j12 -= j11) {
                    a0 a0Var = source.f11925a;
                    kotlin.jvm.internal.g.c(a0Var);
                    j11 = 0;
                    while (true) {
                        if (j11 < 65536) {
                            j11 += a0Var.f11903c - a0Var.f11902b;
                            if (j11 >= j12) {
                                j11 = j12;
                            } else {
                                a0Var = a0Var.f11906f;
                                kotlin.jvm.internal.g.c(a0Var);
                            }
                        }
                    }
                    c cVar = (c) obj;
                    d0Var.i();
                    try {
                        cVar.j0(source, j11);
                        lb.n nVar = lb.n.f10413a;
                        if (d0Var.j()) {
                            throw d0Var.l(null);
                        }
                    } catch (IOException e10) {
                        if (!d0Var.j()) {
                            throw e10;
                        }
                        throw d0Var.l(e10);
                    } finally {
                        d0Var.j();
                    }
                }
                return;
            default:
                a.b(source.f11926b, 0L, j10);
                long j13 = j10;
                while (j13 > 0) {
                    d0Var.f();
                    a0 a0Var2 = source.f11925a;
                    kotlin.jvm.internal.g.c(a0Var2);
                    int iMin = (int) Math.min(j13, a0Var2.f11903c - a0Var2.f11902b);
                    ((OutputStream) obj).write(a0Var2.f11901a, a0Var2.f11902b, iMin);
                    int i11 = a0Var2.f11902b + iMin;
                    a0Var2.f11902b = i11;
                    long j14 = iMin;
                    j13 -= j14;
                    source.f11926b -= j14;
                    if (i11 == a0Var2.f11903c) {
                        source.f11925a = a0Var2.a();
                        b0.a(a0Var2);
                    }
                }
                return;
        }
    }

    @Override // sd.c0
    public final f0 timeout() {
        switch (this.f11918a) {
        }
        return this.f11919b;
    }

    public final String toString() {
        switch (this.f11918a) {
            case 0:
                return "AsyncTimeout.sink(" + ((c) this.f11920c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f11920c) + ')';
        }
    }

    public c(d0 d0Var, c cVar) {
        this.f11919b = d0Var;
        this.f11920c = cVar;
    }
}
