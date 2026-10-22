package o4;

/* loaded from: classes.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7664a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7665b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7666c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7667d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7668e;

    public v2(String str, boolean z4, String str2, boolean z10, boolean z11) {
        q7.k.e(str2, "stableId");
        this.f7664a = str;
        this.f7665b = z4;
        this.f7666c = str2;
        this.f7667d = z10;
        this.f7668e = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return q7.k.a(this.f7664a, v2Var.f7664a) && this.f7665b == v2Var.f7665b && q7.k.a(this.f7666c, v2Var.f7666c) && this.f7667d == v2Var.f7667d && this.f7668e == v2Var.f7668e;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(true) * 31;
        String str = this.f7664a;
        return Boolean.hashCode(this.f7668e) + m.x.e(m.x.g(this.f7666c, m.x.e((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.f7665b), 31), 31, this.f7667d);
    }

    public final String toString() {
        return "OpenClawTlsParams(required=true, expectedFingerprint=" + this.f7664a + ", allowTOFU=" + this.f7665b + ", stableId=" + this.f7666c + ", useSystemPki=" + this.f7667d + ", requireClientCert=" + this.f7668e + ")";
    }
}
