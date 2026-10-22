package s1;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final String f9277a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f9278b;

    public j(String str, f0 f0Var) {
        this.f9277a = str;
        this.f9278b = f0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q7.k.a(this.f9277a, jVar.f9277a) && q7.k.a(this.f9278b, jVar.f9278b);
    }

    public final int hashCode() {
        int iHashCode = this.f9277a.hashCode() * 31;
        f0 f0Var = this.f9278b;
        return (iHashCode + (f0Var != null ? f0Var.hashCode() : 0)) * 31;
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("LinkAnnotation.Url(url="), this.f9277a, ')');
    }
}
