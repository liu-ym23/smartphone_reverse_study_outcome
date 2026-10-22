package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c2 implements e2 {

    /* renamed from: a, reason: collision with root package name */
    public j3 f11502a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11503b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return this.f11502a.equals(c2Var.f11502a) && this.f11503b == c2Var.f11503b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11503b) + (this.f11502a.hashCode() * 31);
    }

    public final String toString() {
        return "Card(group=" + this.f11502a + ", showPendingStyle=" + this.f11503b + ")";
    }
}
