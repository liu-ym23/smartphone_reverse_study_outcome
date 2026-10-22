package gb;

import java.io.IOException;
import q7.k;

/* loaded from: classes.dex */
public final class g extends b {

    /* renamed from: i, reason: collision with root package name */
    public boolean f4050i;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4035g) {
            return;
        }
        if (!this.f4050i) {
            a();
        }
        this.f4035g = true;
    }

    @Override // gb.b, ob.k0
    public final long read(ob.h hVar, long j2) throws IOException {
        k.e(hVar, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        if (this.f4035g) {
            throw new IllegalStateException("closed");
        }
        if (this.f4050i) {
            return -1L;
        }
        long j4 = super.read(hVar, j2);
        if (j4 != -1) {
            return j4;
        }
        this.f4050i = true;
        a();
        return -1L;
    }
}
