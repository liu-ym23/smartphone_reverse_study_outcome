package o4;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7405a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7406b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7407c;

    public j0(String str, String str2, String str3) {
        this.f7405a = str;
        this.f7406b = str2;
        this.f7407c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return q7.k.a(this.f7405a, j0Var.f7405a) && q7.k.a(this.f7406b, j0Var.f7406b) && q7.k.a(this.f7407c, j0Var.f7407c);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f7406b, this.f7405a.hashCode() * 31, 31);
        String str = this.f7407c;
        return iG + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return a1.a.m(a1.a.p("ErrorShape(code=", this.f7405a, ", message=", this.f7406b, ", detailsCode="), this.f7407c, ")");
    }
}
