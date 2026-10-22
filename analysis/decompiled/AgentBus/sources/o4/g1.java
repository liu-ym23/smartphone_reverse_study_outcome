package o4;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7372a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7373b;

    public g1(String str, long j2) {
        q7.k.e(str, "reason");
        this.f7372a = str;
        this.f7373b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return q7.k.a(this.f7372a, g1Var.f7372a) && this.f7373b == g1Var.f7373b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f7373b) + (this.f7372a.hashCode() * 31);
    }

    public final String toString() {
        return "SessionFailure(reason=" + this.f7372a + ", atMs=" + this.f7373b + ")";
    }
}
