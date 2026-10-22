package d5;

/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final e f2877a;

    public h(e eVar) {
        q7.k.e(eVar, "connection");
        this.f2877a = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && q7.k.a(this.f2877a, ((h) obj).f2877a);
    }

    public final int hashCode() {
        return this.f2877a.hashCode();
    }

    public final String toString() {
        return "Removed(connection=" + this.f2877a + ")";
    }
}
