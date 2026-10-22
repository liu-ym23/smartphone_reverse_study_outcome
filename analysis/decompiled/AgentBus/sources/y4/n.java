package y4;

import m.x;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11623a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11624b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11625c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11626d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f11627e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11628f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f11629g;

    public n(boolean z4, String str, String str2, String str3, Long l6, String str4, Long l10) {
        q7.k.e(str, "operatorState");
        q7.k.e(str2, "nodeState");
        this.f11623a = z4;
        this.f11624b = str;
        this.f11625c = str2;
        this.f11626d = str3;
        this.f11627e = l6;
        this.f11628f = str4;
        this.f11629g = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f11623a == nVar.f11623a && q7.k.a(this.f11624b, nVar.f11624b) && q7.k.a(this.f11625c, nVar.f11625c) && q7.k.a(this.f11626d, nVar.f11626d) && q7.k.a(this.f11627e, nVar.f11627e) && q7.k.a(this.f11628f, nVar.f11628f) && q7.k.a(this.f11629g, nVar.f11629g);
    }

    public final int hashCode() {
        int iG = x.g(this.f11625c, x.g(this.f11624b, Boolean.hashCode(this.f11623a) * 31, 31), 31);
        String str = this.f11626d;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        Long l6 = this.f11627e;
        int iHashCode2 = (iHashCode + (l6 == null ? 0 : l6.hashCode())) * 31;
        String str2 = this.f11628f;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.f11629g;
        return iHashCode3 + (l10 != null ? l10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SessionSnapshot(enabled=");
        sb2.append(this.f11623a);
        sb2.append(", operatorState=");
        sb2.append(this.f11624b);
        sb2.append(", nodeState=");
        x.w(sb2, this.f11625c, ", operatorLastFailureReason=", this.f11626d, ", operatorLastFailureAtMs=");
        sb2.append(this.f11627e);
        sb2.append(", nodeLastFailureReason=");
        sb2.append(this.f11628f);
        sb2.append(", nodeLastFailureAtMs=");
        sb2.append(this.f11629g);
        sb2.append(")");
        return sb2.toString();
    }
}
