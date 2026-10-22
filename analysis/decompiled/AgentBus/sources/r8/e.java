package r8;

import d7.z;
import f8.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import l8.y;
import s8.r;
import u9.g;
import u9.k;

/* loaded from: classes.dex */
public final class e implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final a3.b f9034a;

    /* renamed from: b, reason: collision with root package name */
    public final u9.e f9035b;

    public e(a aVar) {
        this.f9034a = new a3.b(aVar, b.f9027b, new c7.d());
        k kVar = (k) aVar.f9002a;
        kVar.getClass();
        this.f9035b = new u9.e(kVar, new ConcurrentHashMap(3, 1.0f, 2), new u9.f(), 0);
    }

    @Override // f8.h0
    public final boolean a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        ((a) this.f9034a.f162f).f9003b.getClass();
        return false;
    }

    @Override // f8.h0
    public final void b(e9.c cVar, ArrayList arrayList) {
        q7.k.e(cVar, "fqName");
        arrayList.add(c(cVar));
    }

    public final r c(e9.c cVar) throws Throwable {
        ((a) this.f9034a.f162f).f9003b.getClass();
        q7.k.e(cVar, "fqName");
        a8.e eVar = new a8.e(16, this, new y(cVar));
        u9.e eVar2 = this.f9035b;
        eVar2.getClass();
        Object objInvoke = eVar2.invoke(new g(cVar, eVar));
        if (objInvoke != null) {
            return (r) objInvoke;
        }
        u9.e.a(3);
        throw null;
    }

    @Override // f8.h0
    public final Collection j(e9.c cVar, p7.k kVar) {
        q7.k.e(cVar, "fqName");
        q7.k.e(kVar, "nameFilter");
        List list = (List) c(cVar).f9603p.c();
        return list == null ? z.f2978f : list;
    }

    public final String toString() {
        return "LazyJavaPackageFragmentProvider of module " + ((a) this.f9034a.f162f).f9016o;
    }
}
