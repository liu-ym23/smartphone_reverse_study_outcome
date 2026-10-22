package i8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class l implements f8.h0 {

    /* renamed from: a, reason: collision with root package name */
    public final List f4823a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4824b;

    public l(List list, String str) {
        q7.k.e(str, "debugName");
        this.f4823a = list;
        this.f4824b = str;
        list.size();
        d7.r.q1(list).size();
    }

    @Override // f8.h0
    public final boolean a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        List list = this.f4823a;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!f8.v.h((f8.h0) it.next(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // f8.h0
    public final void b(e9.c cVar, ArrayList arrayList) {
        q7.k.e(cVar, "fqName");
        Iterator it = this.f4823a.iterator();
        while (it.hasNext()) {
            f8.v.b((f8.h0) it.next(), cVar, arrayList);
        }
    }

    @Override // f8.h0
    public final Collection j(e9.c cVar, p7.k kVar) {
        q7.k.e(cVar, "fqName");
        q7.k.e(kVar, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator it = this.f4823a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((f8.h0) it.next()).j(cVar, kVar));
        }
        return hashSet;
    }

    public final String toString() {
        return this.f4824b;
    }
}
