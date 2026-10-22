package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f7079a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7080b;

    public u0(Integer num, Object obj) {
        this.f7079a = num;
        this.f7080b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f7079a.equals(u0Var.f7079a) && yb.k.a(this.f7080b, u0Var.f7080b);
    }

    public final int hashCode() {
        int iHashCode = this.f7079a.hashCode() * 31;
        Object obj = this.f7080b;
        return (obj instanceof Enum ? ((Enum) obj).ordinal() : obj != null ? obj.hashCode() : 0) + iHashCode;
    }

    public final String toString() {
        return "JoinedKey(left=" + this.f7079a + ", right=" + this.f7080b + ')';
    }
}
