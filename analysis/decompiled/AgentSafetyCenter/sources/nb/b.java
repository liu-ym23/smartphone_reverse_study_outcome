package nb;

import java.io.Serializable;
import xb.p;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements g, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final g f8808c;

    /* renamed from: f, reason: collision with root package name */
    public final e f8809f;

    public b(e eVar, g gVar) {
        gVar.getClass();
        eVar.getClass();
        this.f8808c = gVar;
        this.f8809f = eVar;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i = 2;
            b bVar2 = bVar;
            int i3 = 2;
            while (true) {
                g gVar = bVar2.f8808c;
                bVar2 = gVar instanceof b ? (b) gVar : null;
                if (bVar2 == null) {
                    break;
                }
                i3++;
            }
            b bVar3 = this;
            while (true) {
                g gVar2 = bVar3.f8808c;
                bVar3 = gVar2 instanceof b ? (b) gVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i++;
            }
            if (i3 == i) {
                while (true) {
                    e eVar = this.f8809f;
                    if (!k.a(bVar.get(eVar.getKey()), eVar)) {
                        zA = false;
                        break;
                    }
                    g gVar3 = this.f8808c;
                    if (!(gVar3 instanceof b)) {
                        gVar3.getClass();
                        e eVar2 = (e) gVar3;
                        zA = k.a(bVar.get(eVar2.getKey()), eVar2);
                        break;
                    }
                    this = (b) gVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // nb.g
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(this.f8808c.fold(obj, pVar), this.f8809f);
    }

    @Override // nb.g
    public final e get(f fVar) {
        fVar.getClass();
        while (true) {
            e eVar = this.f8809f.get(fVar);
            if (eVar != null) {
                return eVar;
            }
            g gVar = this.f8808c;
            if (!(gVar instanceof b)) {
                return gVar.get(fVar);
            }
            this = (b) gVar;
        }
    }

    public final int hashCode() {
        return this.f8809f.hashCode() + this.f8808c.hashCode();
    }

    @Override // nb.g
    public final g minusKey(f fVar) {
        fVar.getClass();
        e eVar = this.f8809f;
        e eVar2 = eVar.get(fVar);
        g gVar = this.f8808c;
        if (eVar2 != null) {
            return gVar;
        }
        g gVarMinusKey = gVar.minusKey(fVar);
        return gVarMinusKey == gVar ? this : gVarMinusKey == h.f8811c ? eVar : new b(eVar, gVarMinusKey);
    }

    @Override // nb.g
    public final g plus(g gVar) {
        gVar.getClass();
        return gVar == h.f8811c ? this : (g) gVar.fold(this, new k8.d(7));
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("["), (String) fold("", new k8.d(6)), ']');
    }
}
