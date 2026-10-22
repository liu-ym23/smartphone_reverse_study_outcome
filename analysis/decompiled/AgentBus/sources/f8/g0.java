package f8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3479a;

    public g0(ArrayList arrayList) {
        this.f3479a = arrayList;
    }

    @Override // f8.h0
    public final boolean a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        ArrayList arrayList = this.f3479a;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (q7.k.a(((i8.c0) ((e0) it.next())).f4758j, cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // f8.h0
    public final void b(e9.c cVar, ArrayList arrayList) {
        q7.k.e(cVar, "fqName");
        for (Object obj : this.f3479a) {
            if (q7.k.a(((i8.c0) ((e0) obj)).f4758j, cVar)) {
                arrayList.add(obj);
            }
        }
    }

    @Override // f8.h0
    public final Collection j(e9.c cVar, p7.k kVar) {
        q7.k.e(cVar, "fqName");
        q7.k.e(kVar, "nameFilter");
        return fa.l.v0(new fa.f(fa.l.t0(d7.r.H0(this.f3479a), r.f3509i), true, new f0(cVar, 0)));
    }
}
