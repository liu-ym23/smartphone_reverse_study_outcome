package o9;

import d7.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class i extends o {

    /* renamed from: b, reason: collision with root package name */
    public final n f7924b;

    public i(n nVar) {
        q7.k.e(nVar, "workerScope");
        this.f7924b = nVar;
    }

    @Override // o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        f8.g gVarB = this.f7924b.b(fVar, aVar);
        if (gVarB != null) {
            f8.e eVar = gVarB instanceof f8.e ? (f8.e) gVarB : null;
            if (eVar != null) {
                return eVar;
            }
            if (gVarB instanceof t9.s) {
                return (t9.s) gVarB;
            }
        }
        return null;
    }

    @Override // o9.o, o9.n
    public final Set c() {
        return this.f7924b.c();
    }

    @Override // o9.o, o9.n
    public final Set d() {
        return this.f7924b.d();
    }

    @Override // o9.o, o9.q
    public final Collection e(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        int i2 = f.f7909l & fVar.f7918b;
        f fVar2 = i2 == 0 ? null : new f(i2, fVar.f7917a);
        if (fVar2 == null) {
            return z.f2978f;
        }
        Collection collectionE = this.f7924b.e(fVar2, kVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionE) {
            if (obj instanceof f8.h) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // o9.o, o9.n
    public final Set g() {
        return this.f7924b.g();
    }

    public final String toString() {
        return "Classes from " + this.f7924b;
    }
}
