package s8;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d implements o9.n {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9534f;

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f9535b;

    /* renamed from: c, reason: collision with root package name */
    public final r f9536c;

    /* renamed from: d, reason: collision with root package name */
    public final w f9537d;

    /* renamed from: e, reason: collision with root package name */
    public final u9.i f9538e;

    static {
        q7.x xVar = q7.w.f8821a;
        f9534f = new w7.t[]{xVar.f(new q7.p(xVar.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public d(a3.b bVar, l8.y yVar, r rVar) {
        this.f9535b = bVar;
        this.f9536c = rVar;
        this.f9537d = new w(bVar, yVar, rVar);
        u9.n nVar = ((r8.a) bVar.f162f).f9002a;
        a8.c cVar = new a8.c(29, this);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9538e = new u9.i(kVar, cVar);
    }

    @Override // o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        i(fVar, cVar);
        o9.n[] nVarArrH = h();
        this.f9537d.getClass();
        Collection collectionJ = d7.z.f2978f;
        for (o9.n nVar : nVarArrH) {
            collectionJ = a.a.j(collectionJ, nVar.a(fVar, cVar));
        }
        return collectionJ == null ? d7.b0.f2947f : collectionJ;
    }

    @Override // o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        i(fVar, aVar);
        w wVar = this.f9537d;
        wVar.getClass();
        f8.g gVar = null;
        f8.e eVarV = wVar.v(fVar, null);
        if (eVarV != null) {
            return eVarV;
        }
        for (o9.n nVar : h()) {
            f8.g gVarB = nVar.b(fVar, aVar);
            if (gVarB != null) {
                if (!(gVarB instanceof f8.h) || !((f8.h) gVarB).Z()) {
                    return gVarB;
                }
                if (gVar == null) {
                    gVar = gVarB;
                }
            }
        }
        return gVar;
    }

    @Override // o9.n
    public final Set c() {
        o9.n[] nVarArrH = h();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (o9.n nVar : nVarArrH) {
            d7.x.D0(linkedHashSet, nVar.c());
        }
        linkedHashSet.addAll(this.f9537d.c());
        return linkedHashSet;
    }

    @Override // o9.n
    public final Set d() {
        o9.n[] nVarArrH = h();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (o9.n nVar : nVarArrH) {
            d7.x.D0(linkedHashSet, nVar.d());
        }
        linkedHashSet.addAll(this.f9537d.d());
        return linkedHashSet;
    }

    @Override // o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        o9.n[] nVarArrH = h();
        Collection collectionE = this.f9537d.e(fVar, kVar);
        for (o9.n nVar : nVarArrH) {
            collectionE = a.a.j(collectionE, nVar.e(fVar, kVar));
        }
        return collectionE == null ? d7.b0.f2947f : collectionE;
    }

    @Override // o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        i(fVar, aVar);
        o9.n[] nVarArrH = h();
        Collection collectionF = this.f9537d.f(fVar, aVar);
        for (o9.n nVar : nVarArrH) {
            collectionF = a.a.j(collectionF, nVar.f(fVar, aVar));
        }
        return collectionF == null ? d7.b0.f2947f : collectionF;
    }

    @Override // o9.n
    public final Set g() {
        o9.n[] nVarArrH = h();
        q7.k.e(nVarArrH, "<this>");
        HashSet hashSetP = n7.m.p(nVarArrH.length == 0 ? d7.z.f2978f : new d7.p(0, nVarArrH));
        if (hashSetP == null) {
            return null;
        }
        hashSetP.addAll(this.f9537d.g());
        return hashSetP;
    }

    public final o9.n[] h() {
        return (o9.n[]) n7.b.q(this.f9538e, f9534f[0]);
    }

    public final void i(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        ib.k.M(((r8.a) this.f9535b.f162f).f9015n, aVar, this.f9536c, fVar);
    }

    public final String toString() {
        return "scope for " + this.f9536c;
    }
}
