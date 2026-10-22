package V9;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class c implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1414a;
    public final Object b;
    public final Object c;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f1414a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f1414a) {
            case 0:
                v vVar = (v) this.b;
                c cVar = (c) this.c;
                vVar.h();
                try {
                    cVar.close();
                    if (vVar.i()) {
                        throw vVar.k(null);
                    }
                    return;
                } catch (IOException e) {
                    if (!vVar.i()) {
                        throw e;
                    }
                    throw vVar.k(e);
                } finally {
                    vVar.i();
                }
            default:
                ((InputStream) this.b).close();
                return;
        }
    }

    @Override // V9.w
    public final long e(g sink, long j5) {
        switch (this.f1414a) {
            case 0:
                kotlin.jvm.internal.k.f(sink, "sink");
                v vVar = (v) this.b;
                c cVar = (c) this.c;
                vVar.h();
                try {
                    long jE = cVar.e(sink, 8192L);
                    if (vVar.i()) {
                        throw vVar.k(null);
                    }
                    return jE;
                } catch (IOException e) {
                    if (vVar.i()) {
                        throw vVar.k(e);
                    }
                    throw e;
                } finally {
                    vVar.i();
                }
            default:
                kotlin.jvm.internal.k.f(sink, "sink");
                try {
                    ((y) this.c).f();
                    s sVarJ = sink.J(1);
                    int i = ((InputStream) this.b).read(sVarJ.f1426a, sVarJ.c, (int) Math.min(8192L, 8192 - sVarJ.c));
                    if (i == -1) {
                        if (sVarJ.b == sVarJ.c) {
                            sink.f1418a = sVarJ.a();
                            t.a(sVarJ);
                        }
                        return -1L;
                    }
                    sVarJ.c += i;
                    long j6 = i;
                    sink.b += j6;
                    return j6;
                } catch (AssertionError e6) {
                    if (M0.i.y(e6)) {
                        throw new IOException(e6);
                    }
                    throw e6;
                }
        }
    }

    @Override // V9.w
    public final y timeout() {
        switch (this.f1414a) {
            case 0:
                return (v) this.b;
            default:
                return (y) this.c;
        }
    }

    public final String toString() {
        switch (this.f1414a) {
            case 0:
                return "AsyncTimeout.source(" + ((c) this.c) + ')';
            default:
                return "source(" + ((InputStream) this.b) + ')';
        }
    }
}
