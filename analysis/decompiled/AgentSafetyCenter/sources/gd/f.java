package gd;

import java.io.IOException;
import od.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: h, reason: collision with root package name */
    public boolean f4725h;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4713f) {
            return;
        }
        if (!this.f4725h) {
            d();
        }
        this.f4713f = true;
    }

    @Override // gd.a, od.i0
    public final long l(i iVar, long j10) throws IOException {
        iVar.getClass();
        if (j10 < 0) {
            od.f.c(k0.a.m("byteCount < 0: ", j10));
            return 0L;
        }
        if (this.f4713f) {
            od.f.e("closed");
            return 0L;
        }
        if (this.f4725h) {
            return -1L;
        }
        long jL = super.l(iVar, j10);
        if (jL != -1) {
            return jL;
        }
        this.f4725h = true;
        d();
        return -1L;
    }
}
