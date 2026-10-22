package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public float f10309a;

    /* renamed from: b, reason: collision with root package name */
    public float f10310b;

    /* renamed from: c, reason: collision with root package name */
    public long f10311c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return Float.compare(this.f10309a, k0Var.f10309a) == 0 && Float.compare(this.f10310b, k0Var.f10310b) == 0 && this.f10311c == k0Var.f10311c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10311c) + k0.a.g(Float.hashCode(this.f10309a) * 31, this.f10310b, 31);
    }

    public final String toString() {
        return "FlingInfo(initialVelocity=" + this.f10309a + ", distance=" + this.f10310b + ", duration=" + this.f10311c + ')';
    }
}
