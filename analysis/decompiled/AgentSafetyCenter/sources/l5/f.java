package l5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7740a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7741b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7742c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7743d;

    public f(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f7740a = z10;
        this.f7741b = z11;
        this.f7742c = z12;
        this.f7743d = z13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f7740a == fVar.f7740a && this.f7741b == fVar.f7741b && this.f7742c == fVar.f7742c && this.f7743d == fVar.f7743d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f7743d) + k0.a.h(k0.a.h(Boolean.hashCode(this.f7740a) * 31, 31, this.f7741b), 31, this.f7742c);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f7740a + ", isValidated=" + this.f7741b + ", isMetered=" + this.f7742c + ", isNotRoaming=" + this.f7743d + ')';
    }
}
