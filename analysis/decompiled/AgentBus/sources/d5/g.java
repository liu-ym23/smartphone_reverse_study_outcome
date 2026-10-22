package d5;

/* loaded from: classes.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final e f2876a;

    public g(e eVar) {
        q7.k.e(eVar, "connection");
        this.f2876a = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && q7.k.a(this.f2876a, ((g) obj).f2876a);
    }

    public final int hashCode() {
        return this.f2876a.hashCode();
    }

    public final String toString() {
        return "Added(connection=" + this.f2876a + ")";
    }
}
