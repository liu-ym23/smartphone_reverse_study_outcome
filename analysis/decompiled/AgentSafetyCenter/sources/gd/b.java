package gd;

import od.g0;
import od.i;
import od.j;
import od.k0;
import od.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements g0 {

    /* renamed from: c, reason: collision with root package name */
    public r f4715c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4716f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ g f4717g;

    @Override // od.g0
    public final k0 b() {
        return this.f4715c;
    }

    @Override // od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f4716f) {
            return;
        }
        this.f4716f = true;
        this.f4717g.f4729d.v("0\r\n\r\n");
        r rVar = this.f4715c;
        k0 k0Var = rVar.f9481e;
        rVar.f9481e = k0.f9455d;
        k0Var.a();
        k0Var.b();
        this.f4717g.f4730e = 3;
    }

    @Override // od.g0
    public final void f(i iVar, long j10) {
        j jVar = this.f4717g.f4729d;
        iVar.getClass();
        if (this.f4716f) {
            od.f.e("closed");
        } else {
            if (j10 == 0) {
                return;
            }
            jVar.y(j10);
            jVar.v("\r\n");
            jVar.f(iVar, j10);
            jVar.v("\r\n");
        }
    }

    @Override // od.g0, java.io.Flushable
    public final synchronized void flush() {
        if (this.f4716f) {
            return;
        }
        this.f4717g.f4729d.flush();
    }
}
