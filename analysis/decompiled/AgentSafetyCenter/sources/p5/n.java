package p5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public String f9744a;

    /* renamed from: b, reason: collision with root package name */
    public int f9745b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return yb.k.a(this.f9744a, nVar.f9744a) && this.f9745b == nVar.f9745b;
    }

    public final int hashCode() {
        return s.f.c(this.f9745b) + (this.f9744a.hashCode() * 31);
    }

    public final String toString() {
        return "IdAndState(id=" + this.f9744a + ", state=" + androidx.activity.b.z(this.f9745b) + ')';
    }
}
