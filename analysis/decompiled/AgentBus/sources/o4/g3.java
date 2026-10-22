package o4;

/* loaded from: classes.dex */
public final class g3 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7374a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7375b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7376c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7377d;

    public g3(String str, String str2, String str3, boolean z4) {
        this.f7374a = str;
        this.f7375b = str2;
        this.f7376c = str3;
        this.f7377d = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g3)) {
            return false;
        }
        g3 g3Var = (g3) obj;
        return q7.k.a(this.f7374a, g3Var.f7374a) && q7.k.a(this.f7375b, g3Var.f7375b) && q7.k.a(this.f7376c, g3Var.f7376c) && this.f7377d == g3Var.f7377d;
    }

    public final int hashCode() {
        String str = this.f7374a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f7375b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7376c;
        return Boolean.hashCode(this.f7377d) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("WireTraceContext(traceId=", this.f7374a, ", method=", this.f7375b, ", frameId=");
        sbP.append(this.f7376c);
        sbP.append(", reportCloudPipeline=");
        sbP.append(this.f7377d);
        sbP.append(")");
        return sbP.toString();
    }
}
