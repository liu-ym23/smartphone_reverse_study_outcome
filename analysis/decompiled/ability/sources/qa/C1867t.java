package qa;

import java.io.IOException;

/* renamed from: qa.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1867t extends F9.P {
    public final F9.P b;
    public final V9.r c;
    public IOException d;

    public C1867t(F9.P p) {
        this.b = p;
        this.c = new V9.r(new C1866s(this, p.f()));
    }

    @Override // F9.P
    public final long b() {
        return this.b.b();
    }

    @Override // F9.P
    public final F9.B c() {
        return this.b.c();
    }

    @Override // F9.P, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    @Override // F9.P
    public final V9.i f() {
        return this.c;
    }
}
