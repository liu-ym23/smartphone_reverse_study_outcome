package p4;

import java.io.IOException;
import z4.j;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: h, reason: collision with root package name */
    public j f9709h;

    @Override // x4.c
    public final boolean G() {
        d();
        this.f9709h.f16409f.execute();
        return false;
    }

    @Override // x4.c
    public final void c(int i, long j10) {
        d();
        this.f9709h.c(i, j10);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9709h.close();
        this.f9712g = true;
    }

    @Override // x4.c
    public final int getColumnCount() {
        d();
        return 0;
    }

    @Override // x4.c
    public final String getColumnName(int i) {
        d();
        t0.a.l(21, "no row");
        throw null;
    }

    @Override // x4.c
    public final long getLong(int i) {
        d();
        t0.a.l(21, "no row");
        throw null;
    }

    @Override // x4.c
    public final boolean isNull(int i) {
        d();
        t0.a.l(21, "no row");
        throw null;
    }

    @Override // x4.c
    public final void p(int i, String str) {
        str.getClass();
        d();
        this.f9709h.h(i, str);
    }

    @Override // x4.c
    public final String z(int i) {
        d();
        t0.a.l(21, "no row");
        throw null;
    }

    @Override // x4.c
    public final void reset() {
    }
}
