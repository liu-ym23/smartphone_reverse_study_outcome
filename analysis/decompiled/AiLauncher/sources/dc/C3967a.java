package dc;

import Yb.A;
import Yb.AbstractC1127a;
import Yb.h;
import Yb.i;
import Yb.j;
import Yb.k;
import Yb.l;
import Yb.m;
import Yb.n;
import Yb.o;
import Yb.p;
import Yb.q;
import Yb.t;
import Yb.u;
import Yb.v;
import Yb.w;
import Yb.x;
import Yb.y;
import Yb.z;
import cc.InterfaceC1510a;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* renamed from: dc.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C3967a extends AbstractC1127a implements InterfaceC1510a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC3968b f32163a;

    /* renamed from: b, reason: collision with root package name */
    public final e f32164b;

    /* renamed from: c, reason: collision with root package name */
    public Wb.b f32165c;

    public C3967a(InterfaceC3968b interfaceC3968b) {
        this.f32163a = interfaceC3968b;
        this.f32164b = interfaceC3968b.c();
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void A(o oVar) throws IOException {
        M(oVar, oVar.n(), oVar.m());
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void D(x xVar) throws IOException {
        L(xVar, null);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void I(h hVar) {
        g(hVar);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void J(q qVar) throws IOException {
        M(qVar, qVar.n(), qVar.m());
    }

    public final void K() throws IOException {
        if (this.f32163a.b()) {
            this.f32164b.e();
        } else {
            this.f32164b.d();
        }
    }

    public final void L(u uVar, Character ch) throws IOException {
        if (!this.f32163a.b()) {
            if (uVar.e() != null) {
                this.f32164b.d();
            }
        } else {
            if (ch != null) {
                this.f32164b.f(ch.charValue());
            }
            if (uVar.e() != null) {
                this.f32164b.e();
            }
        }
    }

    public final void M(u uVar, String str, String str2) throws IOException {
        boolean z10 = false;
        boolean z11 = uVar.c() != null;
        boolean z12 = (str == null || str.equals(str2)) ? false : true;
        if (str2 != null && !str2.equals("")) {
            z10 = true;
        }
        if (z11) {
            this.f32164b.f(JsonFactory.DEFAULT_QUOTE_CHAR);
            g(uVar);
            this.f32164b.f(JsonFactory.DEFAULT_QUOTE_CHAR);
            if (z12 || z10) {
                this.f32164b.e();
                this.f32164b.f('(');
            }
        }
        if (z12) {
            this.f32164b.g(str);
            if (z10) {
                this.f32164b.c();
                this.f32164b.e();
            }
        }
        if (z10) {
            this.f32164b.g(str2);
        }
        if (z11) {
            if (z12 || z10) {
                this.f32164b.f(')');
            }
        }
    }

    public final void N(String str) throws IOException {
        if (this.f32163a.b()) {
            this.f32164b.h(str);
        } else {
            this.f32164b.g(str);
        }
    }

    @Override // cc.InterfaceC1510a
    public void a(u uVar) {
        uVar.a(this);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void c(Yb.e eVar) throws IOException {
        this.f32164b.f(JsonFactory.DEFAULT_QUOTE_CHAR);
        this.f32164b.g(eVar.m());
        this.f32164b.f(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void e(v vVar) throws IOException {
        if (this.f32165c != null) {
            K();
        }
        this.f32165c = new Wb.c(this.f32165c, vVar);
        g(vVar);
        L(vVar, null);
        if (this.f32165c.b() != null) {
            this.f32165c = this.f32165c.b();
        } else {
            this.f32165c = null;
        }
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void f(l lVar) throws IOException {
        g(lVar);
        L(lVar, ':');
    }

    @Override // Yb.AbstractC1127a
    public void g(u uVar) {
        u uVarC = uVar.c();
        while (uVarC != null) {
            u uVarE = uVarC.e();
            this.f32163a.a(uVarC);
            uVarC = uVarE;
        }
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void i(p pVar) throws IOException {
        if (!this.f32163a.b()) {
            this.f32164b.g(pVar.n());
        } else {
            this.f32164b.h(pVar.n());
            L(pVar, null);
        }
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void j(t tVar) throws IOException {
        Wb.b bVar = this.f32165c;
        if (bVar != null && (bVar instanceof Wb.c)) {
            Wb.c cVar = (Wb.c) bVar;
            String strA = this.f32163a.b() ? "" : cVar.a();
            this.f32164b.g(strA + cVar.c() + cVar.d() + " ");
            g(tVar);
            L(tVar, null);
            cVar.e();
            return;
        }
        if (bVar == null || !(bVar instanceof Wb.a)) {
            return;
        }
        Wb.a aVar = (Wb.a) bVar;
        if (!this.f32163a.b()) {
            this.f32164b.g(aVar.a() + aVar.c() + " ");
        }
        g(tVar);
        L(tVar, null);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void k(k kVar) throws IOException {
        L(kVar, null);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void m(w wVar) throws IOException {
        g(wVar);
        if (wVar.f() == null || (wVar.f() instanceof h)) {
            L(wVar, null);
        }
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void n(Yb.c cVar) throws IOException {
        this.f32164b.f((char) 171);
        g(cVar);
        this.f32164b.f((char) 187);
        L(cVar, null);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void o(m mVar) throws IOException {
        N(mVar.n());
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void s(z zVar) throws IOException {
        N(zVar.m());
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void t(Yb.d dVar) throws IOException {
        if (this.f32165c != null) {
            K();
        }
        this.f32165c = new Wb.a(this.f32165c, dVar);
        g(dVar);
        L(dVar, null);
        if (this.f32165c.b() != null) {
            this.f32165c = this.f32165c.b();
        } else {
            this.f32165c = null;
        }
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void u(A a10) throws IOException {
        if (!this.f32163a.b()) {
            this.f32164b.g("***");
        }
        L(a10, null);
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void w(n nVar) throws IOException {
        N(nVar.m());
    }

    @Override // Yb.AbstractC1127a, Yb.B
    public void x(j jVar) throws IOException {
        if (!this.f32163a.b()) {
            this.f32164b.g(jVar.r());
        } else {
            this.f32164b.h(jVar.r());
            L(jVar, null);
        }
    }

    @Override // cc.InterfaceC1510a
    public Set<Class<? extends u>> y() {
        return new HashSet(Arrays.asList(h.class, l.class, w.class, Yb.c.class, Yb.d.class, j.class, m.class, A.class, p.class, q.class, t.class, v.class, o.class, i.class, y.class, z.class, Yb.e.class, n.class, x.class, k.class));
    }
}
