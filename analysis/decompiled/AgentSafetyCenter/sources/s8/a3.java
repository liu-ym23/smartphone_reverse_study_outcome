package s8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a3 {

    /* renamed from: a, reason: collision with root package name */
    public z2 f11451a;

    /* renamed from: b, reason: collision with root package name */
    public List f11452b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a3)) {
            return false;
        }
        a3 a3Var = (a3) obj;
        return this.f11451a == a3Var.f11451a && this.f11452b.equals(a3Var.f11452b);
    }

    public final int hashCode() {
        return this.f11452b.hashCode() + (this.f11451a.hashCode() * 31);
    }

    public final String toString() {
        return "RevokeDialogRequest(mode=" + this.f11451a + ", items=" + this.f11452b + ")";
    }
}
