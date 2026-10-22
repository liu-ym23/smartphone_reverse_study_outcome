package o9;

import d7.b0;
import d7.x;
import d7.z;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: b, reason: collision with root package name */
    public final String f7893b;

    /* renamed from: c, reason: collision with root package name */
    public final n[] f7894c;

    public a(String str, n[] nVarArr) {
        this.f7893b = str;
        this.f7894c = nVarArr;
    }

    @Override // o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        n[] nVarArr = this.f7894c;
        int length = nVarArr.length;
        if (length == 0) {
            return z.f2978f;
        }
        if (length == 1) {
            return nVarArr[0].a(fVar, cVar);
        }
        Collection collectionJ = null;
        for (n nVar : nVarArr) {
            collectionJ = a.a.j(collectionJ, nVar.a(fVar, cVar));
        }
        return collectionJ == null ? b0.f2947f : collectionJ;
    }

    @Override // o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        f8.g gVar = null;
        for (n nVar : this.f7894c) {
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
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar : this.f7894c) {
            x.D0(linkedHashSet, nVar.c());
        }
        return linkedHashSet;
    }

    @Override // o9.n
    public final Set d() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar : this.f7894c) {
            x.D0(linkedHashSet, nVar.d());
        }
        return linkedHashSet;
    }

    @Override // o9.q
    public final Collection e(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        n[] nVarArr = this.f7894c;
        int length = nVarArr.length;
        if (length == 0) {
            return z.f2978f;
        }
        if (length == 1) {
            return nVarArr[0].e(fVar, kVar);
        }
        Collection collectionJ = null;
        for (n nVar : nVarArr) {
            collectionJ = a.a.j(collectionJ, nVar.e(fVar, kVar));
        }
        return collectionJ == null ? b0.f2947f : collectionJ;
    }

    @Override // o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        n[] nVarArr = this.f7894c;
        int length = nVarArr.length;
        if (length == 0) {
            return z.f2978f;
        }
        if (length == 1) {
            return nVarArr[0].f(fVar, aVar);
        }
        Collection collectionJ = null;
        for (n nVar : nVarArr) {
            collectionJ = a.a.j(collectionJ, nVar.f(fVar, aVar));
        }
        return collectionJ == null ? b0.f2947f : collectionJ;
    }

    @Override // o9.n
    public final Set g() {
        n[] nVarArr = this.f7894c;
        q7.k.e(nVarArr, "<this>");
        return n7.m.p(nVarArr.length == 0 ? z.f2978f : new d7.p(0, nVarArr));
    }

    public final String toString() {
        return this.f7893b;
    }
}
