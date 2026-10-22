package L4;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
final class q implements w {

    /* renamed from: a, reason: collision with root package name */
    private final OutputStream f3964a;

    /* renamed from: b, reason: collision with root package name */
    private final z f3965b;

    public q(OutputStream outputStream, z zVar) {
        j4.k.h(outputStream, "out");
        j4.k.h(zVar, "timeout");
        this.f3964a = outputStream;
        this.f3965b = zVar;
    }

    @Override // L4.w
    public z b() {
        return this.f3965b;
    }

    @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3964a.close();
    }

    @Override // L4.w, java.io.Flushable
    public void flush() throws IOException {
        this.f3964a.flush();
    }

    public String toString() {
        return "sink(" + this.f3964a + ')';
    }

    @Override // L4.w
    public void y0(e eVar, long j5) throws IOException {
        j4.k.h(eVar, "source");
        c.b(eVar.size(), 0L, j5);
        while (j5 > 0) {
            this.f3965b.f();
            t tVar = eVar.f3938a;
            if (tVar == null) {
                j4.k.p();
            }
            int iMin = (int) Math.min(j5, tVar.f3976c - tVar.f3975b);
            this.f3964a.write(tVar.f3974a, tVar.f3975b, iMin);
            tVar.f3975b += iMin;
            long j6 = iMin;
            j5 -= j6;
            eVar.W(eVar.size() - j6);
            if (tVar.f3975b == tVar.f3976c) {
                eVar.f3938a = tVar.b();
                u.a(tVar);
            }
        }
    }
}
