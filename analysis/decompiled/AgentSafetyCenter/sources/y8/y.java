package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final w f16020a;

    /* renamed from: b, reason: collision with root package name */
    public final long f16021b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16022c;

    public y(w wVar, long j10, String str) {
        this.f16020a = wVar;
        this.f16021b = j10;
        this.f16022c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f16020a == yVar.f16020a && this.f16021b == yVar.f16021b && this.f16022c.equals(yVar.f16022c);
    }

    public final int hashCode() {
        return this.f16022c.hashCode() + k0.a.i(this.f16021b, this.f16020a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "LedgerScopePayload(scope=" + this.f16020a + ", version=" + this.f16021b + ", businessJson=" + this.f16022c + ")";
    }
}
