package u8;

import Yb.A;
import Yb.w;
import Yb.x;
import Yb.y;
import Yb.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import u8.m;

/* loaded from: classes4.dex */
public class o implements m {

    /* renamed from: a, reason: collision with root package name */
    public final g f42495a;

    /* renamed from: b, reason: collision with root package name */
    public final r f42496b;

    /* renamed from: c, reason: collision with root package name */
    public final v f42497c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends Yb.u>, m.c<? extends Yb.u>> f42498d;

    /* renamed from: e, reason: collision with root package name */
    public final m.a f42499e;

    public static class a implements m.b {

        /* renamed from: a, reason: collision with root package name */
        public final Map<Class<? extends Yb.u>, m.c<? extends Yb.u>> f42500a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public m.a f42501b;

        @Override // u8.m.b
        public <N extends Yb.u> m.b a(Class<N> cls, m.c<? super N> cVar) {
            if (cVar == null) {
                this.f42500a.remove(cls);
                return this;
            }
            this.f42500a.put(cls, cVar);
            return this;
        }

        @Override // u8.m.b
        public m.b b(m.a aVar) {
            this.f42501b = aVar;
            return this;
        }

        @Override // u8.m.b
        public m c(g gVar, r rVar) {
            m.a bVar = this.f42501b;
            if (bVar == null) {
                bVar = new b();
            }
            return new o(gVar, rVar, new v(), Collections.unmodifiableMap(this.f42500a), bVar);
        }
    }

    public o(g gVar, r rVar, v vVar, Map<Class<? extends Yb.u>, m.c<? extends Yb.u>> map, m.a aVar) {
        this.f42495a = gVar;
        this.f42496b = rVar;
        this.f42497c = vVar;
        this.f42498d = map;
        this.f42499e = aVar;
    }

    @Override // Yb.B
    public void A(Yb.o oVar) {
        K(oVar);
    }

    @Override // u8.m
    public void B() {
        this.f42497c.append('\n');
    }

    @Override // u8.m
    public void C() {
        if (this.f42497c.length() <= 0 || '\n' == this.f42497c.h()) {
            return;
        }
        this.f42497c.append('\n');
    }

    @Override // Yb.B
    public void D(x xVar) {
        K(xVar);
    }

    @Override // Yb.B
    public void E(Yb.g gVar) {
        K(gVar);
    }

    @Override // u8.m
    public <N extends Yb.u> void F(N n10, int i10) {
        y(n10.getClass(), i10);
    }

    @Override // Yb.B
    public void G(Yb.i iVar) {
        K(iVar);
    }

    @Override // Yb.B
    public void H(y yVar) {
        K(yVar);
    }

    @Override // Yb.B
    public void I(Yb.h hVar) {
        K(hVar);
    }

    @Override // Yb.B
    public void J(Yb.q qVar) {
        K(qVar);
    }

    public final void K(Yb.u uVar) {
        m.c<? extends Yb.u> cVar = this.f42498d.get(uVar.getClass());
        if (cVar != null) {
            cVar.a(this, uVar);
        } else {
            g(uVar);
        }
    }

    public <N extends Yb.u> void a(Class<N> cls, int i10) {
        d(i10, this.f42495a.e().a(cls).a(this.f42495a, this.f42496b));
    }

    @Override // u8.m
    public <N extends Yb.u> void b(N n10, int i10) {
        a(n10.getClass(), i10);
    }

    @Override // u8.m
    public v builder() {
        return this.f42497c;
    }

    @Override // Yb.B
    public void c(Yb.e eVar) {
        K(eVar);
    }

    @Override // u8.m
    public void d(int i10, Object obj) {
        v vVar = this.f42497c;
        v.k(vVar, obj, i10, vVar.length());
    }

    @Override // Yb.B
    public void e(Yb.v vVar) {
        K(vVar);
    }

    @Override // Yb.B
    public void f(Yb.l lVar) {
        K(lVar);
    }

    @Override // u8.m
    public void g(Yb.u uVar) {
        Yb.u uVarC = uVar.c();
        while (uVarC != null) {
            Yb.u uVarE = uVarC.e();
            uVarC.a(this);
            uVarC = uVarE;
        }
    }

    @Override // u8.m
    public boolean h(Yb.u uVar) {
        return uVar.e() != null;
    }

    @Override // Yb.B
    public void i(Yb.p pVar) {
        K(pVar);
    }

    @Override // Yb.B
    public void j(Yb.t tVar) {
        K(tVar);
    }

    @Override // Yb.B
    public void k(Yb.k kVar) {
        K(kVar);
    }

    @Override // Yb.B
    public void l(Yb.f fVar) {
        K(fVar);
    }

    @Override // u8.m
    public int length() {
        return this.f42497c.length();
    }

    @Override // Yb.B
    public void m(w wVar) {
        K(wVar);
    }

    @Override // Yb.B
    public void n(Yb.c cVar) {
        K(cVar);
    }

    @Override // Yb.B
    public void o(Yb.m mVar) {
        K(mVar);
    }

    @Override // Yb.B
    public void p(Yb.r rVar) {
        K(rVar);
    }

    @Override // u8.m
    public void q(Yb.u uVar) {
        this.f42499e.b(this, uVar);
    }

    @Override // u8.m
    public r r() {
        return this.f42496b;
    }

    @Override // Yb.B
    public void s(z zVar) {
        K(zVar);
    }

    @Override // Yb.B
    public void t(Yb.d dVar) {
        K(dVar);
    }

    @Override // Yb.B
    public void u(A a10) {
        K(a10);
    }

    @Override // u8.m
    public void v(Yb.u uVar) {
        this.f42499e.a(this, uVar);
    }

    @Override // Yb.B
    public void w(Yb.n nVar) {
        K(nVar);
    }

    @Override // Yb.B
    public void x(Yb.j jVar) {
        K(jVar);
    }

    public <N extends Yb.u> void y(Class<N> cls, int i10) {
        u uVar = this.f42495a.e().get(cls);
        if (uVar != null) {
            d(i10, uVar.a(this.f42495a, this.f42496b));
        }
    }

    @Override // u8.m
    public g z() {
        return this.f42495a;
    }
}
