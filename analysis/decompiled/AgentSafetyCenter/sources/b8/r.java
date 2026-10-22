package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements r0 {

    /* renamed from: c, reason: collision with root package name */
    public long f2014c;

    /* renamed from: f, reason: collision with root package name */
    public Object f2015f;

    public ad.n a() {
        ne.b bVar = new ne.b();
        while (true) {
            String strQ = ((od.k) this.f2015f).q(this.f2014c);
            this.f2014c -= strQ.length();
            if (strQ.length() == 0) {
                return bVar.d();
            }
            int iD0 = hc.h.d0(strQ, ':', 1, 4);
            if (iD0 != -1) {
                bVar.b(strQ.substring(0, iD0), strQ.substring(iD0 + 1));
            } else if (strQ.charAt(0) == ':') {
                bVar.b("", strQ.substring(1));
            } else {
                bVar.b("", strQ);
            }
        }
    }

    @Override // b8.r0
    public String k() {
        return String.valueOf(this.f2014c);
    }

    @Override // b8.r0
    public boolean o(JsonNode jsonNode) {
        String str = (String) this.f2015f;
        if (jsonNode.isBigInteger()) {
            int iCompareTo = jsonNode.bigIntegerValue().compareTo(new BigInteger(str));
            return iCompareTo < 0 || iCompareTo == 0;
        }
        if (jsonNode.isTextual()) {
            int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal(str));
            return iCompareTo2 < 0 || iCompareTo2 == 0;
        }
        long jAsLong = jsonNode.asLong();
        long j10 = this.f2014c;
        return j10 > jAsLong || j10 == jAsLong;
    }
}
