package a9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f260a;

    /* renamed from: b, reason: collision with root package name */
    public final String f261b;

    /* renamed from: c, reason: collision with root package name */
    public final String f262c;

    /* renamed from: d, reason: collision with root package name */
    public final String f263d;

    public g(boolean z10, String str, String str2, String str3) {
        this.f260a = z10;
        this.f261b = str;
        this.f262c = str2;
        this.f263d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f260a == gVar.f260a && this.f261b.equals(gVar.f261b) && yb.k.a(this.f262c, gVar.f262c) && yb.k.a(this.f263d, gVar.f263d);
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d(Boolean.hashCode(this.f260a) * 31, 31, this.f261b);
        String str = this.f262c;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f263d;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "Outcome(ok=" + this.f260a + ", rawJson=" + this.f261b + ", code=" + this.f262c + ", message=" + this.f263d + ")";
    }
}
