package q5;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f8664a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f8665b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f8666c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f8667d;

    /* renamed from: e, reason: collision with root package name */
    public final d5.t f8668e;

    public c0(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, d5.t tVar) {
        this.f8664a = bool;
        this.f8665b = bool2;
        this.f8666c = bool3;
        this.f8667d = bool4;
        this.f8668e = tVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return q7.k.a(this.f8664a, c0Var.f8664a) && q7.k.a(this.f8665b, c0Var.f8665b) && q7.k.a(this.f8666c, c0Var.f8666c) && q7.k.a(this.f8667d, c0Var.f8667d) && this.f8668e == c0Var.f8668e;
    }

    public final int hashCode() {
        Boolean bool = this.f8664a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.f8665b;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.f8666c;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.f8667d;
        int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        d5.t tVar = this.f8668e;
        return iHashCode4 + (tVar != null ? tVar.hashCode() : 0);
    }

    public final String toString() {
        return "SelectionContext(isOnline=" + this.f8664a + ", isMetered=" + this.f8665b + ", isLowBattery=" + this.f8666c + ", privacyModeEnabled=" + this.f8667d + ", preferredDeployment=" + this.f8668e + ")";
    }
}
