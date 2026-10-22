package o4;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final z1 f7392a;

    /* renamed from: b, reason: collision with root package name */
    public final v2 f7393b;

    /* renamed from: c, reason: collision with root package name */
    public final y f7394c;

    /* renamed from: d, reason: collision with root package name */
    public final y f7395d;

    public i0(y yVar, y yVar2, z1 z1Var, v2 v2Var) {
        this.f7392a = z1Var;
        this.f7393b = v2Var;
        this.f7394c = yVar;
        this.f7395d = yVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return q7.k.a(this.f7392a, i0Var.f7392a) && q7.k.a(this.f7393b, i0Var.f7393b) && q7.k.a(this.f7394c, i0Var.f7394c) && q7.k.a(this.f7395d, i0Var.f7395d);
    }

    public final int hashCode() {
        int iHashCode = this.f7392a.hashCode() * 31;
        v2 v2Var = this.f7393b;
        int iHashCode2 = (iHashCode + (v2Var == null ? 0 : v2Var.hashCode())) * 31;
        y yVar = this.f7394c;
        int iHashCode3 = (iHashCode2 + (yVar == null ? 0 : yVar.hashCode())) * 31;
        y yVar2 = this.f7395d;
        return iHashCode3 + (yVar2 != null ? yVar2.hashCode() : 0);
    }

    public final String toString() {
        return "DesiredConnection(endpoint=" + this.f7392a + ", tls=" + this.f7393b + ", operatorOptions=" + this.f7394c + ", nodeOptions=" + this.f7395d + ")";
    }
}
