package g9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f4537a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4538b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4539c;

    public n(String str, String str2, List list) {
        str2.getClass();
        list.getClass();
        this.f4537a = str;
        this.f4538b = str2;
        this.f4539c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f4537a.equals(nVar.f4537a) && yb.k.a(this.f4538b, nVar.f4538b) && yb.k.a(this.f4539c, nVar.f4539c);
    }

    public final int hashCode() {
        return this.f4539c.hashCode() + androidx.activity.b.d(this.f4537a.hashCode() * 31, 31, this.f4538b);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("CloudPermissionCategory(categoryId=", this.f4537a, ", categoryName=", this.f4538b, ", groups=");
        sbP.append(this.f4539c);
        sbP.append(")");
        return sbP.toString();
    }
}
