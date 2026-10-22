package C8;

import C8.k;
import Yb.u;
import u8.AbstractC5589a;
import u8.g;
import u8.m;

/* loaded from: classes4.dex */
public class e extends AbstractC5589a {

    /* renamed from: b, reason: collision with root package name */
    public h f1738b;

    /* renamed from: c, reason: collision with root package name */
    public j f1739c;

    /* renamed from: d, reason: collision with root package name */
    public d f1740d = new d();

    /* renamed from: a, reason: collision with root package name */
    public final k.c f1737a = new k.c();

    public class a implements m.c<Yb.n> {
        public a() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.n nVar) {
            e.this.p(mVar, nVar.m());
        }
    }

    public class b implements m.c<Yb.m> {
        public b() {
        }

        @Override // u8.m.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(u8.m mVar, Yb.m mVar2) {
            e.this.p(mVar, mVar2.n());
        }
    }

    public interface c {
        void a(e eVar);
    }

    public static e n() {
        return new e();
    }

    public static e o(c cVar) {
        e eVarN = n();
        cVar.a(eVarN);
        return eVarN;
    }

    @Override // u8.AbstractC5589a, u8.i
    public void b(u uVar, u8.m mVar) {
        j jVar = this.f1739c;
        if (jVar == null) {
            throw new IllegalStateException("Unexpected state, html-renderer is not defined");
        }
        jVar.a(mVar, this.f1738b);
    }

    @Override // u8.AbstractC5589a, u8.i
    public void c(m.b bVar) {
        bVar.a(Yb.m.class, new b()).a(Yb.n.class, new a());
    }

    @Override // u8.AbstractC5589a, u8.i
    public void f(g.b bVar) {
        k.c cVar = this.f1737a;
        if (!cVar.e()) {
            cVar.a(G8.d.e());
            cVar.a(new G8.f());
            cVar.a(new G8.a());
            cVar.a(new G8.k());
            cVar.a(new G8.l());
            cVar.a(new G8.j());
            cVar.a(new G8.i());
            cVar.a(new G8.m());
            cVar.a(new G8.g());
            cVar.a(new G8.b());
            cVar.a(new G8.c());
        }
        this.f1738b = i.h(this.f1740d);
        this.f1739c = cVar.c();
    }

    public e m(m mVar) {
        this.f1737a.b(mVar);
        return this;
    }

    public final void p(u8.m mVar, String str) {
        if (str != null) {
            this.f1738b.c(mVar.builder(), str);
        }
    }
}
