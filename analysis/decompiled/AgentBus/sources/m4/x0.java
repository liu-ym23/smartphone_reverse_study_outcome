package m4;

import java.util.List;

/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f6365a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6366b;

    /* renamed from: c, reason: collision with root package name */
    public final List f6367c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6368d;

    public x0(String str, String str2, List list, String str3) {
        this.f6365a = str;
        this.f6366b = str2;
        this.f6367c = list;
        this.f6368d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return q7.k.a(this.f6365a, x0Var.f6365a) && q7.k.a(this.f6366b, x0Var.f6366b) && q7.k.a(this.f6367c, x0Var.f6367c) && q7.k.a(this.f6368d, x0Var.f6368d);
    }

    public final int hashCode() {
        String str = this.f6365a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f6366b;
        int iH = m.x.h(this.f6367c, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        String str3 = this.f6368d;
        return iH + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("Frontmatter(version=", this.f6365a, ", description=", this.f6366b, ", tags=");
        sbP.append(this.f6367c);
        sbP.append(", name=");
        sbP.append(this.f6368d);
        sbP.append(")");
        return sbP.toString();
    }

    public /* synthetic */ x0() {
        this(null, null, d7.z.f2978f, null);
    }
}
