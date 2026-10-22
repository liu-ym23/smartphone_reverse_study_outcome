package p5;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f8484a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.m f8485b;

    /* renamed from: c, reason: collision with root package name */
    public final i f8486c;

    public s(String str, d5.m mVar, i iVar) {
        this.f8484a = str;
        this.f8485b = mVar;
        this.f8486c = iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return q7.k.a(this.f8484a, sVar.f8484a) && this.f8485b == sVar.f8485b && q7.k.a(this.f8486c, sVar.f8486c);
    }

    public final int hashCode() {
        return this.f8486c.hashCode() + ((this.f8485b.hashCode() + (this.f8484a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RegisteredPeer(clientId=" + this.f8484a + ", role=" + this.f8485b + ", info=" + this.f8486c + ")";
    }
}
