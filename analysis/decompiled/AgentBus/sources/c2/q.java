package c2;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final q f1883c = new q(s7.a.z(0), s7.a.z(0));

    /* renamed from: a, reason: collision with root package name */
    public final long f1884a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1885b;

    public q(long j2, long j4) {
        this.f1884a = j2;
        this.f1885b = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return d2.n.a(this.f1884a, qVar.f1884a) && d2.n.a(this.f1885b, qVar.f1885b);
    }

    public final int hashCode() {
        d2.o[] oVarArr = d2.n.f2797b;
        return Long.hashCode(this.f1885b) + (Long.hashCode(this.f1884a) * 31);
    }

    public final String toString() {
        return "TextIndent(firstLine=" + ((Object) d2.n.d(this.f1884a)) + ", restLine=" + ((Object) d2.n.d(this.f1885b)) + ')';
    }
}
