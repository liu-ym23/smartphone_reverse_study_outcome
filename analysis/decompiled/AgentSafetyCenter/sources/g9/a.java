package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public p f4395a;

    /* renamed from: b, reason: collision with root package name */
    public long f4396b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4397c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return yb.k.a(this.f4395a, aVar.f4395a) && this.f4396b == aVar.f4396b && this.f4397c == aVar.f4397c;
    }

    public final int hashCode() {
        p pVar = this.f4395a;
        return Boolean.hashCode(this.f4397c) + k0.a.i(this.f4396b, (pVar == null ? 0 : pVar.f4572a.hashCode()) * 31, 31);
    }

    public final String toString() {
        return "CacheSnapshot(data=" + this.f4395a + ", updatedAtMs=" + this.f4396b + ", withinTtl=" + this.f4397c + ")";
    }
}
