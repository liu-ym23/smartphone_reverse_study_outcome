package w5;

import com.stepos.account.oauth.OAuthConstants;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f10660a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10661b;

    /* renamed from: c, reason: collision with root package name */
    public final b f10662c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10663d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f10664e;

    /* renamed from: f, reason: collision with root package name */
    public final long f10665f;

    public /* synthetic */ a(String str, String str2, b bVar, String str3, long j2, int i2) {
        this(str, str2, bVar, str3, d7.a0.f2944f, (i2 & 32) != 0 ? 0L : j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q7.k.a(this.f10660a, aVar.f10660a) && q7.k.a(this.f10661b, aVar.f10661b) && this.f10662c == aVar.f10662c && q7.k.a(this.f10663d, aVar.f10663d) && q7.k.a(this.f10664e, aVar.f10664e) && this.f10665f == aVar.f10665f;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10665f) + ((this.f10664e.hashCode() + m.x.g(this.f10663d, (this.f10662c.hashCode() + m.x.g(this.f10661b, this.f10660a.hashCode() * 31, 31)) * 31, 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("CheckResult(id=", this.f10660a, ", title=", this.f10661b, ", status=");
        sbP.append(this.f10662c);
        sbP.append(", message=");
        sbP.append(this.f10663d);
        sbP.append(", detail=");
        sbP.append(this.f10664e);
        sbP.append(", durationMs=");
        sbP.append(this.f10665f);
        sbP.append(")");
        return sbP.toString();
    }

    public a(String str, String str2, b bVar, String str3, Map map, long j2) {
        q7.k.e(str, "id");
        q7.k.e(str2, "title");
        q7.k.e(bVar, "status");
        q7.k.e(str3, OAuthConstants.FACTOR_RESULT_MESSAGE);
        this.f10660a = str;
        this.f10661b = str2;
        this.f10662c = bVar;
        this.f10663d = str3;
        this.f10664e = map;
        this.f10665f = j2;
    }
}
