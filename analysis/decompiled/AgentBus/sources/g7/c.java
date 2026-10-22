package g7;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements l, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final l f3863f;

    /* renamed from: g, reason: collision with root package name */
    public final j f3864g;

    public c(l lVar, j jVar) {
        q7.k.e(lVar, "left");
        this.f3863f = lVar;
        this.f3864g = jVar;
    }

    @Override // g7.l
    public final l Q(l lVar) {
        return h.plus(this, lVar);
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            int i2 = 2;
            c cVar2 = cVar;
            int i10 = 2;
            while (true) {
                l lVar = cVar2.f3863f;
                cVar2 = lVar instanceof c ? (c) lVar : null;
                if (cVar2 == null) {
                    break;
                }
                i10++;
            }
            c cVar3 = this;
            while (true) {
                l lVar2 = cVar3.f3863f;
                cVar3 = lVar2 instanceof c ? (c) lVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i2++;
            }
            if (i10 == i2) {
                while (true) {
                    j jVar = this.f3864g;
                    if (!q7.k.a(cVar.o(jVar.getKey()), jVar)) {
                        zA = false;
                        break;
                    }
                    l lVar3 = this.f3863f;
                    if (!(lVar3 instanceof c)) {
                        q7.k.c(lVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        j jVar2 = (j) lVar3;
                        zA = q7.k.a(cVar.o(jVar2.getKey()), jVar2);
                        break;
                    }
                    this = (c) lVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3864g.hashCode() + this.f3863f.hashCode();
    }

    @Override // g7.l
    public final j o(k kVar) {
        q7.k.e(kVar, "key");
        while (true) {
            j jVarO = this.f3864g.o(kVar);
            if (jVarO != null) {
                return jVarO;
            }
            l lVar = this.f3863f;
            if (!(lVar instanceof c)) {
                return lVar.o(kVar);
            }
            this = (c) lVar;
        }
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return nVar.invoke(this.f3863f.r(obj, nVar), this.f3864g);
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("["), (String) r("", new b(0)), ']');
    }

    @Override // g7.l
    public final l z(k kVar) {
        q7.k.e(kVar, "key");
        j jVar = this.f3864g;
        j jVarO = jVar.o(kVar);
        l lVar = this.f3863f;
        if (jVarO != null) {
            return lVar;
        }
        l lVarZ = lVar.z(kVar);
        return lVarZ == lVar ? this : lVarZ == m.f3866f ? jVar : new c(lVarZ, jVar);
    }
}
