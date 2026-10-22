package L9;

import java.io.IOException;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class g extends b {
    public boolean d;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.b) {
            return;
        }
        if (!this.d) {
            b();
        }
        this.b = true;
    }

    @Override // L9.b, V9.w
    public final long e(V9.g sink, long j5) throws IOException {
        k.f(sink, "sink");
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (this.d) {
            return -1L;
        }
        long jE = super.e(sink, 8192L);
        if (jE != -1) {
            return jE;
        }
        this.d = true;
        b();
        return -1L;
    }
}
