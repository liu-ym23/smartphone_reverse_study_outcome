package s4;

import hc.i;
import hc.o;
import java.util.ArrayList;
import java.util.List;
import jb.v;
import kb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f11399a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11400b;

    /* renamed from: c, reason: collision with root package name */
    public final List f11401c;

    /* renamed from: d, reason: collision with root package name */
    public final List f11402d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    public g(String str, boolean z10, List list, List list2) {
        str.getClass();
        list.getClass();
        list2.getClass();
        this.f11399a = str;
        this.f11400b = z10;
        this.f11401c = list;
        this.f11402d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                list2.add("ASC");
            }
        }
        this.f11402d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            String str = gVar.f11399a;
            if (this.f11400b == gVar.f11400b && k.a(this.f11401c, gVar.f11401c) && k.a(this.f11402d, gVar.f11402d)) {
                String str2 = this.f11399a;
                return o.U(str2, "index_", false) ? o.U(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f11399a;
        return this.f11402d.hashCode() + androidx.activity.b.e(this.f11401c, (((o.U(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f11400b ? 1 : 0)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |Index {\n            |   name = '");
        sb2.append(this.f11399a);
        sb2.append("',\n            |   unique = '");
        sb2.append(this.f11400b);
        sb2.append("',\n            |   columns = {");
        i.M(l.B0(this.f11401c, ",", null, null, null, 62));
        i.M("},");
        v vVar = v.f6774a;
        sb2.append(vVar);
        sb2.append("\n            |   orders = {");
        i.M(l.B0(this.f11402d, ",", null, null, null, 62));
        i.M(" }");
        sb2.append(vVar);
        sb2.append("\n            |}\n        ");
        return i.M(i.O(sb2.toString()));
    }
}
