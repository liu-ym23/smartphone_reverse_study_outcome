package v9;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final f8.q0 f10578a;

    /* renamed from: b, reason: collision with root package name */
    public final t8.a f10579b;

    public o0(f8.q0 q0Var, t8.a aVar) {
        q7.k.e(q0Var, "typeParameter");
        q7.k.e(aVar, "typeAttr");
        this.f10578a = q0Var;
        this.f10579b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return q7.k.a(o0Var.f10578a, this.f10578a) && q7.k.a(o0Var.f10579b, this.f10579b);
    }

    public final int hashCode() {
        int iHashCode = this.f10578a.hashCode();
        return this.f10579b.hashCode() + (iHashCode * 31) + iHashCode;
    }

    public final String toString() {
        return "DataToEraseUpperBound(typeParameter=" + this.f10578a + ", typeAttr=" + this.f10579b + ')';
    }
}
