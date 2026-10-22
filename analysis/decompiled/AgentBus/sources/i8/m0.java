package i8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class m0 extends o9.o {

    /* renamed from: b, reason: collision with root package name */
    public final f8.z f4826b;

    /* renamed from: c, reason: collision with root package name */
    public final e9.c f4827c;

    public m0(f8.z zVar, e9.c cVar) {
        q7.k.e(zVar, "moduleDescriptor");
        q7.k.e(cVar, "fqName");
        this.f4826b = zVar;
        this.f4827c = cVar;
    }

    @Override // o9.o, o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        if (fVar.a(o9.f.f7905h)) {
            e9.c cVar = this.f4827c;
            if (!cVar.d() || !fVar.f7917a.contains(o9.c.f7897a)) {
                f8.z zVar = this.f4826b;
                Collection collectionJ = zVar.j(cVar, kVar);
                ArrayList arrayList = new ArrayList(collectionJ.size());
                Iterator it = collectionJ.iterator();
                while (it.hasNext()) {
                    e9.f fVarF = ((e9.c) it.next()).f();
                    q7.k.d(fVarF, "subFqName.shortName()");
                    if (((Boolean) kVar.invoke(fVarF)).booleanValue()) {
                        x xVar = null;
                        if (!fVarF.f3198g) {
                            x xVar2 = (x) zVar.z(cVar.c(fVarF));
                            if (!((Boolean) n7.b.q(xVar2.f4899k, x.f4895m[1])).booleanValue()) {
                                xVar = xVar2;
                            }
                        }
                        ea.k.a(arrayList, xVar);
                    }
                }
                return arrayList;
            }
        }
        return d7.z.f2978f;
    }

    @Override // o9.o, o9.n
    public final Set g() {
        return d7.b0.f2947f;
    }

    public final String toString() {
        return "subpackages of " + this.f4827c + " from " + this.f4826b;
    }
}
