package v9;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final g8.j f10551a;

    public g(g8.j jVar) {
        q7.k.e(jVar, "annotations");
        this.f10551a = jVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return q7.k.a(((g) obj).f10551a, this.f10551a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10551a.hashCode();
    }
}
