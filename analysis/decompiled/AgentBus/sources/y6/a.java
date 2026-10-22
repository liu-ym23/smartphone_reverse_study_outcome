package y6;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11678a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11679b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11680c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11681d;

    public a(String str, String str2, String str3, boolean z4) {
        k.e(str, "gatewayBaseUrl");
        k.e(str2, "gatewayAppId");
        k.e(str3, "gatewayAppSecret");
        this.f11678a = str;
        this.f11679b = str2;
        this.f11680c = str3;
        this.f11681d = z4;
    }

    public static a copy$default(a aVar, String str, String str2, String str3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.f11678a;
        }
        if ((i2 & 2) != 0) {
            str2 = aVar.f11679b;
        }
        if ((i2 & 4) != 0) {
            str3 = aVar.f11680c;
        }
        if ((i2 & 8) != 0) {
            z4 = aVar.f11681d;
        }
        aVar.getClass();
        k.e(str, "gatewayBaseUrl");
        k.e(str2, "gatewayAppId");
        k.e(str3, "gatewayAppSecret");
        return new a(str, str2, str3, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f11678a, aVar.f11678a) && k.a(this.f11679b, aVar.f11679b) && k.a(this.f11680c, aVar.f11680c) && this.f11681d == aVar.f11681d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11681d) + x.g(this.f11680c, x.g(this.f11679b, this.f11678a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("GatewayConfig(gatewayBaseUrl=", this.f11678a, ", gatewayAppId=", this.f11679b, ", gatewayAppSecret=");
        sbP.append(this.f11680c);
        sbP.append(", useServerTime=");
        sbP.append(this.f11681d);
        sbP.append(")");
        return sbP.toString();
    }

    public /* synthetic */ a(String str, String str2, String str3, boolean z4, int i2, q7.f fVar) {
        this(str, str2, str3, (i2 & 8) != 0 ? true : z4);
    }
}
