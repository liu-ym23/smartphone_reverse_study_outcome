package s8;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f11963a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11964b;

    /* renamed from: c, reason: collision with root package name */
    public final List f11965c;

    /* renamed from: d, reason: collision with root package name */
    public final List f11966d;

    /* renamed from: e, reason: collision with root package name */
    public final List f11967e;

    public t(int i, int i3, List list, List list2, List list3) {
        list.getClass();
        list3.getClass();
        this.f11963a = i;
        this.f11964b = i3;
        this.f11965c = list;
        this.f11966d = list2;
        this.f11967e = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    public static t a(t tVar, int i, List list, ArrayList arrayList, int i3) {
        if ((i3 & 1) != 0) {
            i = tVar.f11963a;
        }
        int i10 = i;
        int i11 = tVar.f11964b;
        if ((i3 & 4) != 0) {
            list = tVar.f11965c;
        }
        List list2 = list;
        List list3 = tVar.f11966d;
        ArrayList arrayList2 = arrayList;
        if ((i3 & 16) != 0) {
            arrayList2 = tVar.f11967e;
        }
        ArrayList arrayList3 = arrayList2;
        tVar.getClass();
        list2.getClass();
        arrayList3.getClass();
        return new t(i10, i11, list2, list3, arrayList3);
    }

    public final List b() {
        return this.f11967e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f11963a == tVar.f11963a && this.f11964b == tVar.f11964b && yb.k.a(this.f11965c, tVar.f11965c) && this.f11966d.equals(tVar.f11966d) && yb.k.a(this.f11967e, tVar.f11967e);
    }

    public final int hashCode() {
        return this.f11967e.hashCode() + androidx.activity.b.e(this.f11966d, androidx.activity.b.e(this.f11965c, s.f.b(this.f11964b, Integer.hashCode(this.f11963a) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbU = k0.a.u("AgentSafetyDashboard(executedTodayOps=", this.f11963a, ", executedTodayRisks=", ", last7Days=", this.f11964b);
        sbU.append(this.f11965c);
        sbU.append(", intercepted=");
        sbU.append(this.f11966d);
        sbU.append(", taskGroups=");
        sbU.append(this.f11967e);
        sbU.append(")");
        return sbU.toString();
    }
}
