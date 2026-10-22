package i5;

import m.x;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f4690a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4691b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4692c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4693d;

    public m(String str, String str2, long j2, long j4) {
        q7.k.e(str, "frameId");
        q7.k.e(str2, "reason");
        this.f4690a = str;
        this.f4691b = str2;
        this.f4692c = j2;
        this.f4693d = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return q7.k.a(this.f4690a, mVar.f4690a) && q7.k.a(this.f4691b, mVar.f4691b) && this.f4692c == mVar.f4692c && this.f4693d == mVar.f4693d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4693d) + x.f(this.f4692c, x.g(this.f4691b, this.f4690a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("OfflineFrameTombstoneEntity(frameId=", this.f4690a, ", reason=", this.f4691b, ", createdAt=");
        sbP.append(this.f4692c);
        sbP.append(", expiresAt=");
        sbP.append(this.f4693d);
        sbP.append(")");
        return sbP.toString();
    }
}
