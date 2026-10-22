package j9;

/* loaded from: classes.dex */
public final class p extends r {

    /* renamed from: a, reason: collision with root package name */
    public final v9.v f5415a;

    public p(v9.v vVar) {
        this.f5415a = vVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && q7.k.a(this.f5415a, ((p) obj).f5415a);
    }

    public final int hashCode() {
        return this.f5415a.hashCode();
    }

    public final String toString() {
        return "LocalClass(type=" + this.f5415a + ')';
    }
}
