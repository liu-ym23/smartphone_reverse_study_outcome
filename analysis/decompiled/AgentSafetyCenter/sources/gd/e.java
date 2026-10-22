package gd;

import od.g0;
import od.i;
import od.k0;
import od.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements g0 {

    /* renamed from: c, reason: collision with root package name */
    public r f4722c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4723f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ g f4724g;

    @Override // od.g0
    public final k0 b() {
        return this.f4722c;
    }

    @Override // od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        g gVar = this.f4724g;
        if (this.f4723f) {
            return;
        }
        this.f4723f = true;
        r rVar = this.f4722c;
        k0 k0Var = rVar.f9481e;
        rVar.f9481e = k0.f9455d;
        k0Var.a();
        k0Var.b();
        gVar.f4730e = 3;
    }

    @Override // od.g0
    public final void f(i iVar, long j10) {
        iVar.getClass();
        if (this.f4723f) {
            od.f.e("closed");
        } else {
            bd.b.c(iVar.f9454f, 0L, j10);
            this.f4724g.f4729d.f(iVar, j10);
        }
    }

    @Override // od.g0, java.io.Flushable
    public final void flush() {
        if (this.f4723f) {
            return;
        }
        this.f4724g.f4729d.flush();
    }
}
