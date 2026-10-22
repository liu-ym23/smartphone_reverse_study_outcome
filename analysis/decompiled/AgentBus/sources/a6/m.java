package a6;

import java.util.Map;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f346a;

    /* renamed from: b, reason: collision with root package name */
    public final String f347b;

    /* renamed from: c, reason: collision with root package name */
    public final String f348c;

    /* renamed from: d, reason: collision with root package name */
    public final String f349d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f350e;

    public m(boolean z4, String str, String str2, String str3, Map map, int i2) {
        str = (i2 & 2) != 0 ? null : str;
        str2 = (i2 & 4) != 0 ? null : str2;
        str3 = (i2 & 8) != 0 ? null : str3;
        map = (i2 & 16) != 0 ? d7.a0.f2944f : map;
        q7.k.e(map, "details");
        this.f346a = z4;
        this.f347b = str;
        this.f348c = str2;
        this.f349d = str3;
        this.f350e = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f346a == mVar.f346a && q7.k.a(this.f347b, mVar.f347b) && q7.k.a(this.f348c, mVar.f348c) && q7.k.a(this.f349d, mVar.f349d) && this.f350e.equals(mVar.f350e);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f346a) * 31;
        String str = this.f347b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f348c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f349d;
        return this.f350e.hashCode() + ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("OperationResult(success=");
        sb2.append(this.f346a);
        sb2.append(", id=");
        sb2.append(this.f347b);
        sb2.append(", errorCode=");
        m.x.w(sb2, this.f348c, ", message=", this.f349d, ", details=");
        sb2.append(this.f350e);
        sb2.append(")");
        return sb2.toString();
    }
}
