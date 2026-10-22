package g9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4563a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4564b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4565c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4566d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4567e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4568f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4569g;

    /* renamed from: h, reason: collision with root package name */
    public final List f4570h;
    public final z0 i;

    /* renamed from: j, reason: collision with root package name */
    public final s0 f4571j;

    public o1(String str, String str2, String str3, int i, String str4, int i3, int i10, List list, z0 z0Var, s0 s0Var) {
        z0Var.getClass();
        this.f4563a = str;
        this.f4564b = str2;
        this.f4565c = str3;
        this.f4566d = i;
        this.f4567e = str4;
        this.f4568f = i3;
        this.f4569g = i10;
        this.f4570h = list;
        this.i = z0Var;
        this.f4571j = s0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return this.f4563a.equals(o1Var.f4563a) && this.f4564b.equals(o1Var.f4564b) && this.f4565c.equals(o1Var.f4565c) && this.f4566d == o1Var.f4566d && this.f4567e.equals(o1Var.f4567e) && this.f4568f == o1Var.f4568f && this.f4569g == o1Var.f4569g && this.f4570h.equals(o1Var.f4570h) && this.i == o1Var.i && this.f4571j == o1Var.f4571j;
    }

    public final int hashCode() {
        return this.f4571j.hashCode() + ((this.i.hashCode() + androidx.activity.b.e(this.f4570h, s.f.b(this.f4569g, s.f.b(this.f4568f, androidx.activity.b.d(s.f.b(this.f4566d, androidx.activity.b.d(androidx.activity.b.d(this.f4563a.hashCode() * 31, 31, this.f4564b), 31, this.f4565c), 31), 31, this.f4567e), 31), 31), 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("PermissionUiItem(key=", this.f4563a, ", groupId=", this.f4564b, ", title=");
        sbP.append(this.f4565c);
        sbP.append(", titleResFallback=");
        sbP.append(this.f4566d);
        sbP.append(", description=");
        sbP.append(this.f4567e);
        sbP.append(", descriptionResFallback=");
        sbP.append(this.f4568f);
        sbP.append(", iconRes=");
        sbP.append(this.f4569g);
        sbP.append(", availableOptions=");
        sbP.append(this.f4570h);
        sbP.append(", currentOption=");
        sbP.append(this.i);
        sbP.append(", template=");
        sbP.append(this.f4571j);
        sbP.append(")");
        return sbP.toString();
    }
}
