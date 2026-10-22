package u5;

import m.x;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f10112a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10113b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10114c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10115d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10116e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10117f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10118g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10119h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10120i;

    public e(String str, String str2, String str3, String str4, boolean z4, int i2) {
        String str5 = (i2 & 512) != 0 ? null : "claw-connection-socket.stepaos.com:443/ws/device";
        this.f10112a = str;
        this.f10113b = "openclaw-android";
        this.f10114c = str2;
        this.f10115d = "agentbus";
        this.f10116e = str3;
        this.f10117f = "safe-key-center-sdk";
        this.f10118g = str4;
        this.f10119h = z4;
        this.f10120i = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f10112a.equals(eVar.f10112a) && this.f10113b.equals(eVar.f10113b) && this.f10114c.equals(eVar.f10114c) && this.f10115d.equals(eVar.f10115d) && this.f10116e.equals(eVar.f10116e) && this.f10117f.equals(eVar.f10117f) && this.f10118g.equals(eVar.f10118g) && this.f10119h == eVar.f10119h && q7.k.a(this.f10120i, eVar.f10120i);
    }

    public final int hashCode() {
        int iE = x.e(x.g(this.f10118g, x.g(this.f10117f, x.g(this.f10116e, x.g(this.f10115d, x.g(this.f10114c, x.g(this.f10113b, this.f10112a.hashCode() * 961, 31), 31), 31), 31), 31), 31), 31, this.f10119h);
        String str = this.f10120i;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("CloudEndpoint(endpoint=", this.f10112a, ", deviceToken=null, clientId=", this.f10113b, ", challengeApiBaseUrl=");
        x.w(sbP, this.f10114c, ", challengeAppId=", this.f10115d, ", challengeAuthToken=");
        x.w(sbP, this.f10116e, ", challengeGatewayAppId=", this.f10117f, ", challengeGatewaySecret=");
        sbP.append(this.f10118g);
        sbP.append(", mtlsRequired=");
        sbP.append(this.f10119h);
        sbP.append(", mtlsFallbackEndpoint=");
        return a1.a.m(sbP, this.f10120i, ")");
    }
}
