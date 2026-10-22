package g8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import v9.t0;

/* loaded from: classes.dex */
public final class n implements j {

    /* renamed from: f, reason: collision with root package name */
    public final j f3896f;

    /* renamed from: g, reason: collision with root package name */
    public final t0 f3897g;

    public n(j jVar, t0 t0Var) {
        this.f3896f = jVar;
        this.f3897g = t0Var;
    }

    @Override // g8.j
    public final c b(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        if (((Boolean) this.f3897g.invoke(cVar)).booleanValue()) {
            return this.f3896f.b(cVar);
        }
        return null;
    }

    @Override // g8.j
    public final boolean g(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        if (((Boolean) this.f3897g.invoke(cVar)).booleanValue()) {
            return this.f3896f.g(cVar);
        }
        return false;
    }

    @Override // g8.j
    public final boolean isEmpty() {
        j jVar = this.f3896f;
        if ((jVar instanceof Collection) && ((Collection) jVar).isEmpty()) {
            return false;
        }
        Iterator it = jVar.iterator();
        while (it.hasNext()) {
            e9.c cVarA = ((c) it.next()).a();
            if (cVarA != null && ((Boolean) this.f3897g.invoke(cVarA)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f3896f) {
            e9.c cVarA = ((c) obj).a();
            if (cVarA != null && ((Boolean) this.f3897g.invoke(cVarA)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }
}
