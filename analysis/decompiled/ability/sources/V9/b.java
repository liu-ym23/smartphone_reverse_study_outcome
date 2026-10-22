package V9;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1413a = 0;
    public final v b;
    public final Object c;

    public b(OutputStream outputStream, v vVar) {
        this.c = outputStream;
        this.b = vVar;
    }

    @Override // V9.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f1413a) {
            case 0:
                b bVar = (b) this.c;
                v vVar = this.b;
                vVar.h();
                try {
                    bVar.close();
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
                ((OutputStream) this.c).close();
                return;
        }
    }

    @Override // V9.u, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f1413a) {
            case 0:
                b bVar = (b) this.c;
                v vVar = this.b;
                vVar.h();
                try {
                    bVar.flush();
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
                ((OutputStream) this.c).flush();
                return;
        }
    }

    @Override // V9.u
    public final y timeout() {
        switch (this.f1413a) {
        }
        return this.b;
    }

    public final String toString() {
        switch (this.f1413a) {
            case 0:
                return "AsyncTimeout.sink(" + ((b) this.c) + ')';
            default:
                return "sink(" + ((OutputStream) this.c) + ')';
        }
    }

    @Override // V9.u
    public final void write(g source, long j5) throws IOException {
        switch (this.f1413a) {
            case 0:
                kotlin.jvm.internal.k.f(source, "source");
                H4.o.t(source.b, 0L, j5);
                long j6 = j5;
                while (true) {
                    long j10 = 0;
                    if (j6 <= 0) {
                        return;
                    }
                    s sVar = source.f1418a;
                    kotlin.jvm.internal.k.c(sVar);
                    while (true) {
                        if (j10 < 65536) {
                            j10 += sVar.c - sVar.b;
                            if (j10 >= j6) {
                                j10 = j6;
                            } else {
                                sVar = sVar.f;
                                kotlin.jvm.internal.k.c(sVar);
                            }
                        }
                    }
                    b bVar = (b) this.c;
                    v vVar = this.b;
                    vVar.h();
                    try {
                        try {
                            bVar.write(source, j10);
                            if (vVar.i()) {
                                throw vVar.k(null);
                            }
                            j6 -= j10;
                        } catch (IOException e) {
                            if (!vVar.i()) {
                                throw e;
                            }
                            throw vVar.k(e);
                        }
                    } catch (Throwable th) {
                        vVar.i();
                        throw th;
                    }
                }
            default:
                kotlin.jvm.internal.k.f(source, "source");
                H4.o.t(source.b, 0L, j5);
                while (j5 > 0) {
                    this.b.f();
                    s sVar2 = source.f1418a;
                    kotlin.jvm.internal.k.c(sVar2);
                    int iMin = (int) Math.min(j5, sVar2.c - sVar2.b);
                    ((OutputStream) this.c).write(sVar2.f1426a, sVar2.b, iMin);
                    int i = sVar2.b + iMin;
                    sVar2.b = i;
                    long j11 = iMin;
                    j5 -= j11;
                    source.b -= j11;
                    if (i == sVar2.c) {
                        source.f1418a = sVar2.a();
                        t.a(sVar2);
                    }
                }
                return;
        }
    }

    public b(v vVar, b bVar) {
        this.b = vVar;
        this.c = bVar;
    }
}
