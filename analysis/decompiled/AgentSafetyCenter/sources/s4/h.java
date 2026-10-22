package s4;

import a9.n;
import hc.i;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import kb.l;
import kb.s;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f11403a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11404b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f11405c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f11406d;

    public h(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        abstractSet.getClass();
        this.f11403a = str;
        this.f11404b = map;
        this.f11405c = abstractSet;
        this.f11406d = abstractSet2;
    }

    public static final h a(z4.c cVar, String str) {
        p4.a aVar = new p4.a();
        aVar.f9697c = cVar;
        return id.c.E(aVar, str);
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f11403a.equals(hVar.f11403a) || !this.f11404b.equals(hVar.f11404b) || !k.a(this.f11405c, hVar.f11405c)) {
            return false;
        }
        Set set2 = this.f11406d;
        if (set2 == null || (set = hVar.f11406d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f11405c.hashCode() + ((this.f11404b.hashCode() + (this.f11403a.hashCode() * 31)) * 31);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.Map] */
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb2.append(this.f11403a);
        sb2.append("',\n            |    columns = {");
        sb2.append(id.k.s(l.I0(this.f11404b.values(), new n(8))));
        sb2.append("\n            |    foreignKeys = {");
        sb2.append(id.k.s(this.f11405c));
        sb2.append("\n            |    indices = {");
        Set set = this.f11406d;
        sb2.append(id.k.s(set != null ? l.I0(set, new n(9)) : s.f7404c));
        sb2.append("\n            |}\n        ");
        return i.O(sb2.toString());
    }
}
