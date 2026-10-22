package k5;

/* loaded from: classes.dex */
public final class i implements r {

    /* renamed from: a, reason: collision with root package name */
    public final String f5629a;

    /* renamed from: b, reason: collision with root package name */
    public final j f5630b;

    /* renamed from: c, reason: collision with root package name */
    public final j f5631c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5632d;

    public i(String str, j jVar, j jVar2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        q7.k.e(str, "connectionId");
        q7.k.e(jVar, "from");
        q7.k.e(jVar2, "to");
        this.f5629a = str;
        this.f5630b = jVar;
        this.f5631c = jVar2;
        this.f5632d = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f5629a, iVar.f5629a) && this.f5630b == iVar.f5630b && this.f5631c == iVar.f5631c && this.f5632d == iVar.f5632d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5632d) + ((this.f5631c.hashCode() + ((this.f5630b.hashCode() + (this.f5629a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ConnectionStateChanged(connectionId=" + this.f5629a + ", from=" + this.f5630b + ", to=" + this.f5631c + ", timestamp=" + this.f5632d + ")";
    }
}
