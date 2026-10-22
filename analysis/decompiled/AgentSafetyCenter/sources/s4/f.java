package s4;

import hc.i;
import java.util.List;
import jb.v;
import kb.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f11394a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11395b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11396c;

    /* renamed from: d, reason: collision with root package name */
    public final List f11397d;

    /* renamed from: e, reason: collision with root package name */
    public final List f11398e;

    public f(String str, String str2, String str3, List list, List list2) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        list.getClass();
        list2.getClass();
        this.f11394a = str;
        this.f11395b = str2;
        this.f11396c = str3;
        this.f11397d = list;
        this.f11398e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (k.a(this.f11394a, fVar.f11394a) && k.a(this.f11395b, fVar.f11395b) && k.a(this.f11396c, fVar.f11396c) && k.a(this.f11397d, fVar.f11397d)) {
            return k.a(this.f11398e, fVar.f11398e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11398e.hashCode() + androidx.activity.b.e(this.f11397d, androidx.activity.b.d(androidx.activity.b.d(this.f11394a.hashCode() * 31, 31, this.f11395b), 31, this.f11396c), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb2.append(this.f11394a);
        sb2.append("',\n            |   onDelete = '");
        sb2.append(this.f11395b);
        sb2.append("',\n            |   onUpdate = '");
        sb2.append(this.f11396c);
        sb2.append("',\n            |   columnNames = {");
        i.M(l.B0(l.H0(this.f11397d), ",", null, null, null, 62));
        i.M("},");
        v vVar = v.f6774a;
        sb2.append(vVar);
        sb2.append("\n            |   referenceColumnNames = {");
        i.M(l.B0(l.H0(this.f11398e), ",", null, null, null, 62));
        i.M(" }");
        sb2.append(vVar);
        sb2.append("\n            |}\n        ");
        return i.M(i.O(sb2.toString()));
    }
}
