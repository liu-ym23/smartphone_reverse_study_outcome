package g9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4581a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4582b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4583c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4584d;

    public p1(String str, String str2, int i, List list) {
        str2.getClass();
        this.f4581a = str;
        this.f4582b = str2;
        this.f4583c = i;
        this.f4584d = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return this.f4581a.equals(p1Var.f4581a) && yb.k.a(this.f4582b, p1Var.f4582b) && this.f4583c == p1Var.f4583c && this.f4584d.equals(p1Var.f4584d);
    }

    public final int hashCode() {
        return this.f4584d.hashCode() + s.f.b(this.f4583c, androidx.activity.b.d(this.f4581a.hashCode() * 31, 31, this.f4582b), 31);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("PermissionUiSection(categoryId=", this.f4581a, ", title=", this.f4582b, ", titleResFallback=");
        sbP.append(this.f4583c);
        sbP.append(", items=");
        sbP.append(this.f4584d);
        sbP.append(")");
        return sbP.toString();
    }
}
