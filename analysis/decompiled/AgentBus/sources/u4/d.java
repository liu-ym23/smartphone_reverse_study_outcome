package u4;

/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final b f10058a;

    /* renamed from: b, reason: collision with root package name */
    public final c5.b f10059b;

    /* renamed from: c, reason: collision with root package name */
    public final p f10060c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10061d;

    public d(b bVar, c5.b bVar2, p pVar, long j2) {
        q7.k.e(bVar, "node");
        q7.k.e(bVar2, "frame");
        this.f10058a = bVar;
        this.f10059b = bVar2;
        this.f10060c = pVar;
        this.f10061d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f10058a == dVar.f10058a && q7.k.a(this.f10059b, dVar.f10059b) && q7.k.a(this.f10060c, dVar.f10060c) && this.f10061d == dVar.f10061d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10061d) + ((this.f10060c.hashCode() + ((this.f10059b.hashCode() + (this.f10058a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Data(node=" + this.f10058a + ", frame=" + this.f10059b + ", hint=" + this.f10060c + ", ts=" + this.f10061d + ")";
    }
}
