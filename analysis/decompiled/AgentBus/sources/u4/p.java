package u4;

import m.x;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f10100a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10101b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10102c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10103d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10104e;

    public p(String str, String str2, String str3, String str4, boolean z4, int i2) {
        str = (i2 & 1) != 0 ? null : str;
        str2 = (i2 & 2) != 0 ? null : str2;
        str3 = (i2 & 4) != 0 ? null : str3;
        str4 = (i2 & 8) != 0 ? null : str4;
        z4 = (i2 & 16) != 0 ? false : z4;
        this.f10100a = str;
        this.f10101b = str2;
        this.f10102c = str3;
        this.f10103d = str4;
        this.f10104e = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return q7.k.a(this.f10100a, pVar.f10100a) && q7.k.a(this.f10101b, pVar.f10101b) && q7.k.a(this.f10102c, pVar.f10102c) && q7.k.a(this.f10103d, pVar.f10103d) && this.f10104e == pVar.f10104e;
    }

    public final int hashCode() {
        String str = this.f10100a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f10101b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10102c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f10103d;
        return Boolean.hashCode(this.f10104e) + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("RecordHint(sessionKey=", this.f10100a, ", sessionId=", this.f10101b, ", reqId=");
        x.w(sbP, this.f10102c, ", gatewayConnId=", this.f10103d, ", isChatSend=");
        sbP.append(this.f10104e);
        sbP.append(")");
        return sbP.toString();
    }
}
