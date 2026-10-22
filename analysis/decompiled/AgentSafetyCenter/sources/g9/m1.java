package g9;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public long f4535a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f4536b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.f4535a == m1Var.f4535a && this.f4536b.equals(m1Var.f4536b);
    }

    public final int hashCode() {
        return this.f4536b.hashCode() + k0.a.i(this.f4535a, Integer.hashCode(1) * 31, 31);
    }

    public final String toString() {
        return "PermissionSnapshot(schemaVersion=1, generatedAtMs=" + this.f4535a + ", items=" + this.f4536b + ")";
    }
}
