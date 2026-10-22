package m5;

import com.stepos.agentcache.core.ServiceContract;
import java.util.Map;
import m.x;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f6446a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6447b;

    /* renamed from: c, reason: collision with root package name */
    public final r f6448c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6449d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6450e;

    /* renamed from: f, reason: collision with root package name */
    public final long f6451f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6452g;

    public s(String str, String str2, r rVar, String str3, long j2, long j4, Map map) {
        q7.k.e(str, ServiceContract.RequiredKeys.TRACE_ID);
        q7.k.e(str2, "spanId");
        q7.k.e(rVar, "kind");
        this.f6446a = str;
        this.f6447b = str2;
        this.f6448c = rVar;
        this.f6449d = str3;
        this.f6450e = j2;
        this.f6451f = j4;
        this.f6452g = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return q7.k.a(this.f6446a, sVar.f6446a) && q7.k.a(this.f6447b, sVar.f6447b) && this.f6448c == sVar.f6448c && this.f6449d.equals(sVar.f6449d) && this.f6450e == sVar.f6450e && this.f6451f == sVar.f6451f && this.f6452g.equals(sVar.f6452g);
    }

    public final int hashCode() {
        return this.f6452g.hashCode() + x.f(this.f6451f, x.f(this.f6450e, x.g(this.f6449d, (this.f6448c.hashCode() + x.g(this.f6447b, this.f6446a.hashCode() * 31, 961)) * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("SpanRecord(traceId=", this.f6446a, ", spanId=", this.f6447b, ", parentSpanId=null, kind=");
        sbP.append(this.f6448c);
        sbP.append(", name=");
        sbP.append(this.f6449d);
        sbP.append(", startTs=");
        sbP.append(this.f6450e);
        sbP.append(", endTs=");
        sbP.append(this.f6451f);
        sbP.append(", attrs=");
        sbP.append(this.f6452g);
        sbP.append(")");
        return sbP.toString();
    }
}
