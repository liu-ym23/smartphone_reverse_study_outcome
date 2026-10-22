package g9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f4548a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4549b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4550c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4551d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4552e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4553f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4554g;

    public o(String str, String str2, String str3, List list, String str4, String str5, boolean z10) {
        str2.getClass();
        str3.getClass();
        list.getClass();
        str4.getClass();
        this.f4548a = str;
        this.f4549b = str2;
        this.f4550c = str3;
        this.f4551d = list;
        this.f4552e = str4;
        this.f4553f = str5;
        this.f4554g = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f4548a.equals(oVar.f4548a) && yb.k.a(this.f4549b, oVar.f4549b) && yb.k.a(this.f4550c, oVar.f4550c) && yb.k.a(this.f4551d, oVar.f4551d) && yb.k.a(this.f4552e, oVar.f4552e) && this.f4553f.equals(oVar.f4553f) && this.f4554g == oVar.f4554g;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f4554g) + androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.e(this.f4551d, androidx.activity.b.d(androidx.activity.b.d(this.f4548a.hashCode() * 31, 31, this.f4549b), 31, this.f4550c), 31), 31, this.f4552e), 31, this.f4553f);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("CloudPermissionGroup(groupId=", this.f4548a, ", name=", this.f4549b, ", description=");
        sbP.append(this.f4550c);
        sbP.append(", availableModes=");
        sbP.append(this.f4551d);
        sbP.append(", currentMode=");
        androidx.activity.b.u(sbP, this.f4552e, ", defaultMode=", this.f4553f, ", isUserConfig=");
        sbP.append(this.f4554g);
        sbP.append(")");
        return sbP.toString();
    }
}
