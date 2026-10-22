package y4;

import m.x;
import o4.v2;
import o4.z1;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final z1 f11561a;

    /* renamed from: b, reason: collision with root package name */
    public final v2 f11562b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11563c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11564d;

    public f(z1 z1Var, v2 v2Var, boolean z4, boolean z10) {
        this.f11561a = z1Var;
        this.f11562b = v2Var;
        this.f11563c = z4;
        this.f11564d = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11561a.equals(fVar.f11561a) && q7.k.a(this.f11562b, fVar.f11562b) && this.f11563c == fVar.f11563c && this.f11564d == fVar.f11564d;
    }

    public final int hashCode() {
        int iHashCode = this.f11561a.hashCode() * 31;
        v2 v2Var = this.f11562b;
        return Boolean.hashCode(this.f11564d) + x.e((iHashCode + (v2Var == null ? 0 : v2Var.hashCode())) * 31, 31, this.f11563c);
    }

    public final String toString() {
        return "CloudConnectPlan(endpoint=" + this.f11561a + ", tls=" + this.f11562b + ", requireClientCert=" + this.f11563c + ", usingLegacyFallback=" + this.f11564d + ")";
    }
}
