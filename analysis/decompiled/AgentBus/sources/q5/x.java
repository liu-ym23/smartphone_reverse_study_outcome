package q5;

/* loaded from: classes.dex */
public final class x extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final d5.e f8779a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8780b;

    public x(d5.e eVar, String str) {
        q7.k.e(str, "originalUpstreamId");
        this.f8779a = eVar;
        this.f8780b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return q7.k.a(this.f8779a, xVar.f8779a) && q7.k.a(this.f8780b, xVar.f8780b);
    }

    public final int hashCode() {
        return this.f8780b.hashCode() + (this.f8779a.hashCode() * 31);
    }

    public final String toString() {
        return "FollowMapping(target=" + this.f8779a + ", originalUpstreamId=" + this.f8780b + ")";
    }
}
