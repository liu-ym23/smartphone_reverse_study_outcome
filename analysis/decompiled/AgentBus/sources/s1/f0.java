package s1;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f9256a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f9257b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f9258c;

    /* renamed from: d, reason: collision with root package name */
    public final a0 f9259d;

    public f0(a0 a0Var, a0 a0Var2, a0 a0Var3, a0 a0Var4) {
        this.f9256a = a0Var;
        this.f9257b = a0Var2;
        this.f9258c = a0Var3;
        this.f9259d = a0Var4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return q7.k.a(this.f9256a, f0Var.f9256a) && q7.k.a(this.f9257b, f0Var.f9257b) && q7.k.a(this.f9258c, f0Var.f9258c) && q7.k.a(this.f9259d, f0Var.f9259d);
    }

    public final int hashCode() {
        a0 a0Var = this.f9256a;
        int iHashCode = (a0Var != null ? a0Var.hashCode() : 0) * 31;
        a0 a0Var2 = this.f9257b;
        int iHashCode2 = (iHashCode + (a0Var2 != null ? a0Var2.hashCode() : 0)) * 31;
        a0 a0Var3 = this.f9258c;
        int iHashCode3 = (iHashCode2 + (a0Var3 != null ? a0Var3.hashCode() : 0)) * 31;
        a0 a0Var4 = this.f9259d;
        return iHashCode3 + (a0Var4 != null ? a0Var4.hashCode() : 0);
    }
}
