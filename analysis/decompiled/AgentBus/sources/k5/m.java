package k5;

import com.stepos.account.oauth.OAuthConstants;
import d7.a0;
import java.util.Map;
import m.x;

/* loaded from: classes.dex */
public final class m implements r {

    /* renamed from: a, reason: collision with root package name */
    public final String f5633a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5634b;

    /* renamed from: c, reason: collision with root package name */
    public final n f5635c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f5636d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5637e;

    public m(String str, String str2, n nVar, Map map, int i2) {
        map = (i2 & 8) != 0 ? a0.f2944f : map;
        long jCurrentTimeMillis = System.currentTimeMillis();
        q7.k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        q7.k.e(nVar, "severity");
        this.f5633a = str;
        this.f5634b = str2;
        this.f5635c = nVar;
        this.f5636d = map;
        this.f5637e = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return q7.k.a(this.f5633a, mVar.f5633a) && q7.k.a(this.f5634b, mVar.f5634b) && this.f5635c == mVar.f5635c && q7.k.a(this.f5636d, mVar.f5636d) && this.f5637e == mVar.f5637e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5637e) + ((this.f5636d.hashCode() + ((this.f5635c.hashCode() + x.g(this.f5634b, this.f5633a.hashCode() * 31, 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("ErrorReported(errorCode=", this.f5633a, ", message=", this.f5634b, ", severity=");
        sbP.append(this.f5635c);
        sbP.append(", context=");
        sbP.append(this.f5636d);
        sbP.append(", timestamp=");
        sbP.append(this.f5637e);
        sbP.append(")");
        return sbP.toString();
    }
}
