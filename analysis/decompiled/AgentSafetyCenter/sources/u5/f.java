package u5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: a, reason: collision with root package name */
    public h1.b f14056a;

    /* renamed from: b, reason: collision with root package name */
    public e6.q f14057b;

    @Override // u5.g
    public final h1.b a() {
        return this.f14056a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f14056a.equals(fVar.f14056a) && this.f14057b.equals(fVar.f14057b);
    }

    public final int hashCode() {
        return this.f14057b.hashCode() + (this.f14056a.hashCode() * 31);
    }

    public final String toString() {
        return "Success(painter=" + this.f14056a + ", result=" + this.f14057b + ')';
    }
}
