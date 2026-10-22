package gd;

import java.io.IOException;
import od.i;
import od.i0;
import od.k0;
import od.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public final r f4712c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4713f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f4714g;

    public a(g gVar) {
        this.f4714g = gVar;
        this.f4712c = new r(gVar.f4728c.b());
    }

    @Override // od.i0
    public final k0 b() {
        return this.f4712c;
    }

    public final void d() {
        g gVar = this.f4714g;
        int i = gVar.f4730e;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + gVar.f4730e);
        }
        r rVar = this.f4712c;
        k0 k0Var = rVar.f9481e;
        rVar.f9481e = k0.f9455d;
        k0Var.a();
        k0Var.b();
        gVar.f4730e = 6;
    }

    @Override // od.i0
    public long l(i iVar, long j10) throws IOException {
        g gVar = this.f4714g;
        iVar.getClass();
        try {
            return gVar.f4728c.l(iVar, j10);
        } catch (IOException e10) {
            gVar.f4727b.j();
            this.d();
            throw e10;
        }
    }
}
