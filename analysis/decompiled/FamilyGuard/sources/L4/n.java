package L4;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class n implements y {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f3959a;

    /* renamed from: b, reason: collision with root package name */
    private final z f3960b;

    public n(InputStream inputStream, z zVar) {
        j4.k.h(inputStream, "input");
        j4.k.h(zVar, "timeout");
        this.f3959a = inputStream;
        this.f3960b = zVar;
    }

    @Override // L4.y
    public z b() {
        return this.f3960b;
    }

    @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3959a.close();
    }

    @Override // L4.y
    public long e(e eVar, long j5) throws IOException {
        j4.k.h(eVar, "sink");
        if (j5 == 0) {
            return 0L;
        }
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        try {
            this.f3960b.f();
            t tVarC0 = eVar.c0(1);
            int i5 = this.f3959a.read(tVarC0.f3974a, tVarC0.f3976c, (int) Math.min(j5, 8192 - tVarC0.f3976c));
            if (i5 == -1) {
                return -1L;
            }
            tVarC0.f3976c += i5;
            long j6 = i5;
            eVar.W(eVar.size() + j6);
            return j6;
        } catch (AssertionError e6) {
            if (o.c(e6)) {
                throw new IOException(e6);
            }
            throw e6;
        }
    }

    public String toString() {
        return "source(" + this.f3959a + ')';
    }
}
