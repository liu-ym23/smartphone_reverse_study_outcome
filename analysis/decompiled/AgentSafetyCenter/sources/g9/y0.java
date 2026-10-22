package g9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final List f4653a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4654b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4655c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4656d;

    public y0(List list, boolean z10, boolean z11, boolean z12) {
        list.getClass();
        this.f4653a = list;
        this.f4654b = z10;
        this.f4655c = z11;
        this.f4656d = z12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    public static y0 a(y0 y0Var, ArrayList arrayList, boolean z10, boolean z11, int i) {
        ArrayList arrayList2 = arrayList;
        if ((i & 1) != 0) {
            arrayList2 = y0Var.f4653a;
        }
        if ((i & 2) != 0) {
            z10 = y0Var.f4654b;
        }
        if ((i & 4) != 0) {
            z11 = y0Var.f4655c;
        }
        boolean z12 = (i & 8) != 0 ? y0Var.f4656d : true;
        y0Var.getClass();
        arrayList2.getClass();
        return new y0(arrayList2, z10, z11, z12);
    }

    public final LinkedHashMap b() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f4653a.iterator();
        while (it.hasNext()) {
            kb.q.p0(((p1) it.next()).f4584d, arrayList);
        }
        int iL = kb.x.L(kb.m.m0(arrayList, 10));
        if (iL < 16) {
            iL = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            o1 o1Var = (o1) obj;
            linkedHashMap.put(o1Var.f4563a, o1Var.i);
        }
        return linkedHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return yb.k.a(this.f4653a, y0Var.f4653a) && this.f4654b == y0Var.f4654b && this.f4655c == y0Var.f4655c && this.f4656d == y0Var.f4656d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f4656d) + k0.a.h(k0.a.h(this.f4653a.hashCode() * 31, 31, this.f4654b), 31, this.f4655c);
    }

    public final String toString() {
        return "PermissionManagerUiState(sections=" + this.f4653a + ", isLoading=" + this.f4654b + ", isRefreshing=" + this.f4655c + ", loadedFromCache=" + this.f4656d + ")";
    }
}
