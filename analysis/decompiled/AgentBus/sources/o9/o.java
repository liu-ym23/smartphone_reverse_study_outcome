package o9;

import d7.z;
import i8.l0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class o implements n {
    @Override // o9.n
    public Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        return z.f2978f;
    }

    @Override // o9.q
    public f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        return null;
    }

    @Override // o9.n
    public Set c() {
        Collection collectionE = e(f.f7913p, ea.b.f3227g);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionE) {
            if (obj instanceof l0) {
                e9.f name = ((l0) obj).getName();
                q7.k.d(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // o9.n
    public Set d() {
        Collection collectionE = e(f.f7914q, ea.b.f3227g);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionE) {
            if (obj instanceof l0) {
                e9.f name = ((l0) obj).getName();
                q7.k.d(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // o9.q
    public Collection e(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        return z.f2978f;
    }

    @Override // o9.q
    public Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        return z.f2978f;
    }

    @Override // o9.n
    public Set g() {
        return null;
    }
}
