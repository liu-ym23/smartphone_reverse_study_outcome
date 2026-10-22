package o4;

/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: b, reason: collision with root package name */
    public final String f7404b;

    public j(String str) {
        this.f7404b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && q7.k.a(this.f7404b, ((j) obj).f7404b);
    }

    public final int hashCode() {
        return this.f7404b.hashCode();
    }

    public final String toString() {
        return a1.a.j("Completed(text=", this.f7404b, ")");
    }
}
