package u4;

import m.x;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final long f10093a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10094b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10095c;

    public m(String str, String str2, long j2) {
        this.f10093a = j2;
        this.f10094b = str;
        this.f10095c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f10093a == mVar.f10093a && q7.k.a(this.f10094b, mVar.f10094b) && q7.k.a(this.f10095c, mVar.f10095c);
    }

    public final int hashCode() {
        return this.f10095c.hashCode() + x.g(this.f10094b, Long.hashCode(this.f10093a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Open(startTs=");
        sb2.append(this.f10093a);
        sb2.append(", traceId=");
        sb2.append(this.f10094b);
        return x.n(sb2, ", sid=", this.f10095c, ")");
    }
}
