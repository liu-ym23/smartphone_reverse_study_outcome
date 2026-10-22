package g9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public int f4523a;

    /* renamed from: b, reason: collision with root package name */
    public List f4524b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f4523a == l1Var.f4523a && this.f4524b.equals(l1Var.f4524b);
    }

    public final int hashCode() {
        return this.f4524b.hashCode() + (Integer.hashCode(this.f4523a) * 31);
    }

    public final String toString() {
        return "PermissionSectionSpec(headingRes=" + this.f4523a + ", items=" + this.f4524b + ")";
    }
}
