package kb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f7407a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7408b;

    public v(int i, Object obj) {
        this.f7407a = i;
        this.f7408b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f7407a == vVar.f7407a && yb.k.a(this.f7408b, vVar.f7408b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f7407a) * 31;
        Object obj = this.f7408b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f7407a + ", value=" + this.f7408b + ')';
    }
}
