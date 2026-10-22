package o9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class j implements n {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7925b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7926c;

    public j(n nVar) {
        this.f7926c = nVar;
    }

    @Override // o9.n
    public Collection a(e9.f fVar, n8.c cVar) {
        switch (this.f7925b) {
            case 1:
                q7.k.e(fVar, "name");
                return h9.m.o(k(fVar, cVar), k.f7930k);
            default:
                return k(fVar, cVar);
        }
    }

    @Override // o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        return l().b(fVar, aVar);
    }

    @Override // o9.n
    public final Set c() {
        return l().c();
    }

    @Override // o9.n
    public final Set d() {
        return l().d();
    }

    @Override // o9.q
    public Collection e(f fVar, p7.k kVar) {
        switch (this.f7925b) {
            case 1:
                q7.k.e(fVar, "kindFilter");
                q7.k.e(kVar, "nameFilter");
                Collection collectionI = i(fVar, kVar);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionI) {
                    if (((f8.j) obj) instanceof f8.b) {
                        arrayList.add(obj);
                    } else {
                        arrayList2.add(obj);
                    }
                }
                return d7.r.c1(h9.m.o(arrayList, k.f7928i), arrayList2);
            default:
                return i(fVar, kVar);
        }
    }

    @Override // o9.q
    public Collection f(e9.f fVar, n8.a aVar) {
        switch (this.f7925b) {
            case 1:
                q7.k.e(fVar, "name");
                return h9.m.o(j(fVar, aVar), k.f7929j);
            default:
                return j(fVar, aVar);
        }
    }

    @Override // o9.n
    public final Set g() {
        return l().g();
    }

    public final n h() {
        if (!(l() instanceof j)) {
            return l();
        }
        n nVarL = l();
        q7.k.c(nVarL, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((j) nVarL).h();
    }

    public final Collection i(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        return l().e(fVar, kVar);
    }

    public final Collection j(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        return l().f(fVar, aVar);
    }

    public final Collection k(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        return l().a(fVar, cVar);
    }

    public final n l() {
        switch (this.f7925b) {
            case 0:
                return (n) ((u9.i) this.f7926c).c();
            default:
                return (n) this.f7926c;
        }
    }

    public j(u9.n nVar, p7.a aVar) {
        q7.k.e(nVar, "storageManager");
        this.f7926c = new u9.i((u9.k) nVar, new a8.c(20, aVar));
    }
}
