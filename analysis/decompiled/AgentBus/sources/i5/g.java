package i5;

import m.x;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final long f4657a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4658b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4659c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4660d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4661e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4662f;

    public g(long j2, String str, int i2, long j4, long j10, String str2) {
        q7.k.e(str, "frameJson");
        q7.k.e(str2, "targetKind");
        this.f4657a = j2;
        this.f4658b = str;
        this.f4659c = i2;
        this.f4660d = j4;
        this.f4661e = j10;
        this.f4662f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f4657a == gVar.f4657a && q7.k.a(this.f4658b, gVar.f4658b) && this.f4659c == gVar.f4659c && this.f4660d == gVar.f4660d && this.f4661e == gVar.f4661e && q7.k.a(this.f4662f, gVar.f4662f);
    }

    public final int hashCode() {
        return this.f4662f.hashCode() + x.f(this.f4661e, x.f(this.f4660d, n.f.b(this.f4659c, x.g(this.f4658b, Long.hashCode(this.f4657a) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("OfflineFrameEntity(id=");
        sb2.append(this.f4657a);
        sb2.append(", frameJson=");
        sb2.append(this.f4658b);
        sb2.append(", sizeBytes=");
        sb2.append(this.f4659c);
        sb2.append(", createdAt=");
        sb2.append(this.f4660d);
        sb2.append(", ttlExpiresAt=");
        sb2.append(this.f4661e);
        sb2.append(", targetKind=");
        return a1.a.m(sb2, this.f4662f, ")");
    }
}
