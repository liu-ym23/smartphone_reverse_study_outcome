package g9;

import com.stepos.agentsafetycenter.R;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public String f4637a;

    /* renamed from: b, reason: collision with root package name */
    public String f4638b;

    /* renamed from: c, reason: collision with root package name */
    public int f4639c;

    /* renamed from: d, reason: collision with root package name */
    public int f4640d;

    /* renamed from: e, reason: collision with root package name */
    public int f4641e;

    /* renamed from: f, reason: collision with root package name */
    public s0 f4642f;

    /* renamed from: g, reason: collision with root package name */
    public List f4643g;

    /* renamed from: h, reason: collision with root package name */
    public z0 f4644h;
    public boolean i;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f4637a.equals(w0Var.f4637a) && this.f4638b.equals(w0Var.f4638b) && this.f4639c == w0Var.f4639c && this.f4640d == w0Var.f4640d && this.f4641e == w0Var.f4641e && this.f4642f == w0Var.f4642f && this.f4643g.equals(w0Var.f4643g) && this.f4644h == w0Var.f4644h && this.i == w0Var.i;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.i) + ((this.f4644h.hashCode() + androidx.activity.b.e(this.f4643g, (this.f4642f.hashCode() + s.f.b(this.f4641e, s.f.b(this.f4640d, s.f.b(R.string.perm_level_allow, s.f.b(this.f4639c, androidx.activity.b.d(this.f4637a.hashCode() * 31, 31, this.f4638b), 31), 31), 31), 31)) * 31, 31)) * 31);
    }

    public final String toString() {
        String str = this.f4637a;
        String str2 = this.f4638b;
        int i = this.f4639c;
        int i3 = this.f4640d;
        int i10 = this.f4641e;
        s0 s0Var = this.f4642f;
        List list = this.f4643g;
        z0 z0Var = this.f4644h;
        boolean z10 = this.i;
        StringBuilder sbP = androidx.activity.b.p("PermissionItemSpec(key=", str, ", groupId=", str2, ", titleRes=");
        sbP.append(i);
        sbP.append(", subtitleRes=");
        sbP.append(R.string.perm_level_allow);
        sbP.append(", descriptionRes=");
        sbP.append(i3);
        sbP.append(", iconRes=");
        sbP.append(i10);
        sbP.append(", template=");
        sbP.append(s0Var);
        sbP.append(", options=");
        sbP.append(list);
        sbP.append(", defaultOption=");
        sbP.append(z0Var);
        sbP.append(", exposed=");
        sbP.append(z10);
        sbP.append(")");
        return sbP.toString();
    }
}
