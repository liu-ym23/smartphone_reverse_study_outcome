package k5;

import m.x;

/* loaded from: classes.dex */
public final class p implements r {

    /* renamed from: a, reason: collision with root package name */
    public final k f5641a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5642b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5643c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5644d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5645e;

    /* renamed from: f, reason: collision with root package name */
    public final String f5646f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5647g;

    public p(k kVar, String str, String str2, int i2, long j2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        q7.k.e(kVar, "direction");
        q7.k.e(str, "sourceConn");
        q7.k.e(str2, "targetConn");
        this.f5641a = kVar;
        this.f5642b = str;
        this.f5643c = str2;
        this.f5644d = i2;
        this.f5645e = j2;
        this.f5646f = str3;
        this.f5647g = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f5641a == pVar.f5641a && q7.k.a(this.f5642b, pVar.f5642b) && q7.k.a(this.f5643c, pVar.f5643c) && this.f5644d == pVar.f5644d && this.f5645e == pVar.f5645e && q7.k.a(this.f5646f, pVar.f5646f) && this.f5647g == pVar.f5647g;
    }

    public final int hashCode() {
        int iF = x.f(this.f5645e, n.f.b(this.f5644d, x.g(this.f5643c, x.g(this.f5642b, this.f5641a.hashCode() * 31, 31), 31), 31), 31);
        String str = this.f5646f;
        return Long.hashCode(this.f5647g) + ((iF + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "FrameRouted(direction=" + this.f5641a + ", sourceConn=" + this.f5642b + ", targetConn=" + this.f5643c + ", frameSize=" + this.f5644d + ", latencyNs=" + this.f5645e + ", method=" + this.f5646f + ", timestamp=" + this.f5647g + ")";
    }
}
