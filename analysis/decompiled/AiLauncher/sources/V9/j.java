package V9;

import E9.E;
import E9.K;
import S9.q;
import V9.p;
import W9.C;
import Z8.C1173v;
import Z9.u;
import java.util.Collection;
import java.util.List;
import p9.InterfaceC5074l;
import xa.InterfaceC5858a;

/* loaded from: classes5.dex */
public final class j implements K {

    /* renamed from: a, reason: collision with root package name */
    public final k f6538a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5858a<ga.c, C> f6539b;

    public j(d components) {
        kotlin.jvm.internal.p.i(components, "components");
        k kVar = new k(components, p.a.f6551a, Y8.i.c(null));
        this.f6538a = kVar;
        this.f6539b = kVar.e().a();
    }

    public static final C f(j jVar, u uVar) {
        return new C(jVar.f6538a, uVar);
    }

    @Override // E9.K
    public void a(ga.c fqName, Collection<E> packageFragments) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(packageFragments, "packageFragments");
        Ia.a.a(packageFragments, e(fqName));
    }

    @Override // E9.F
    public List<C> b(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return C1173v.q(e(fqName));
    }

    @Override // E9.K
    public boolean c(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return q.a(this.f6538a.a().d(), fqName, false, 2, null) == null;
    }

    public final C e(ga.c cVar) {
        u uVarA = q.a(this.f6538a.a().d(), cVar, false, 2, null);
        if (uVarA == null) {
            return null;
        }
        return this.f6539b.a(cVar, new i(this, uVarA));
    }

    @Override // E9.F
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public List<ga.c> k(ga.c fqName, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        C cE = e(fqName);
        List<ga.c> listK0 = cE != null ? cE.K0() : null;
        return listK0 == null ? C1173v.m() : listK0;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f6538a.a().m();
    }
}
