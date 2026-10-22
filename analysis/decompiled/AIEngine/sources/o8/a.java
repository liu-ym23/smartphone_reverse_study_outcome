package o8;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f10778a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10779b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10780c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10781d;

    public a(String str, String str2, String str3, String str4) {
        this.f10778a = str;
        this.f10779b = str2;
        this.f10780c = str3;
        this.f10781d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.g.b(this.f10778a, aVar.f10778a) && kotlin.jvm.internal.g.b(this.f10779b, aVar.f10779b) && kotlin.jvm.internal.g.b(this.f10780c, aVar.f10780c) && kotlin.jvm.internal.g.b(this.f10781d, aVar.f10781d);
    }

    public final int hashCode() {
        String str = this.f10778a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f10779b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10780c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f10781d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        return com.stepos.core.ota.d.j(ai.onnxruntime.a.s("AuditResult(status=", this.f10778a, ", decision=", this.f10779b, ", riskLevel="), this.f10780c, ", suggestText=", this.f10781d, ")");
    }
}
