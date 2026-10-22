package o4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements x4.c {

    /* renamed from: c, reason: collision with root package name */
    public x4.c f9192c;

    /* renamed from: f, reason: collision with root package name */
    public long f9193f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ q f9194g;

    @Override // x4.c
    public final boolean G() {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            return this.f9192c.G();
        }
        t0.a.l(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // x4.c
    public final void c(int i, long j10) {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            this.f9192c.c(i, j10);
        } else {
            t0.a.l(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            this.f9192c.close();
        } else {
            t0.a.l(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // x4.c
    public final int getColumnCount() {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            return this.f9192c.getColumnCount();
        }
        t0.a.l(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // x4.c
    public final String getColumnName(int i) {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            return this.f9192c.getColumnName(i);
        }
        t0.a.l(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // x4.c
    public final long getLong(int i) {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            return this.f9192c.getLong(i);
        }
        t0.a.l(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // x4.c
    public final boolean isNull(int i) {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            return this.f9192c.isNull(i);
        }
        t0.a.l(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // x4.c
    public final void p(int i, String str) {
        str.getClass();
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            this.f9192c.p(i, str);
        } else {
            t0.a.l(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // x4.c
    public final void reset() {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            this.f9192c.reset();
        } else {
            t0.a.l(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // x4.c
    public final String z(int i) {
        if (this.f9194g.f9222d.get()) {
            t0.a.l(21, "Statement is recycled");
            throw null;
        }
        if (this.f9193f == id.c.n()) {
            return this.f9192c.z(i);
        }
        t0.a.l(21, "Attempted to use statement on a different thread");
        throw null;
    }
}
