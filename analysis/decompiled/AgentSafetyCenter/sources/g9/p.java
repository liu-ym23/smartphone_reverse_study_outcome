package g9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public List f4572a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && yb.k.a(this.f4572a, ((p) obj).f4572a);
    }

    public final int hashCode() {
        return this.f4572a.hashCode();
    }

    public final String toString() {
        return "CloudPermissionListData(categories=" + this.f4572a + ")";
    }
}
