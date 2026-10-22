package k8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final b f7355a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7356b;

    /* renamed from: c, reason: collision with root package name */
    public final a f7357c;

    /* renamed from: d, reason: collision with root package name */
    public final b f7358d;

    public w(b bVar, boolean z10, a aVar, b bVar2) {
        bVar.getClass();
        this.f7355a = bVar;
        this.f7356b = z10;
        this.f7357c = aVar;
        this.f7358d = bVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f7355a == wVar.f7355a && this.f7356b == wVar.f7356b && yb.k.a(this.f7357c, wVar.f7357c) && this.f7358d == wVar.f7358d;
    }

    public final int hashCode() {
        int iH = k0.a.h(this.f7355a.hashCode() * 31, 31, this.f7356b);
        a aVar = this.f7357c;
        int iHashCode = (iH + (aVar == null ? 0 : aVar.hashCode())) * 31;
        b bVar = this.f7358d;
        return iHashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public final String toString() {
        return "ActionList(initialTab=" + this.f7355a + ", scrollToPending=" + this.f7356b + ", chartFocus=" + this.f7357c + ", activeTab=" + this.f7358d + ")";
    }
}
