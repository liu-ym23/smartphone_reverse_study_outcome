package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public d1.e f13006a = null;

    /* renamed from: b, reason: collision with root package name */
    public d1.a f13007b = null;

    /* renamed from: c, reason: collision with root package name */
    public f1.b f13008c = null;

    /* renamed from: d, reason: collision with root package name */
    public d1.h f13009d = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return yb.k.a(this.f13006a, iVar.f13006a) && yb.k.a(this.f13007b, iVar.f13007b) && yb.k.a(this.f13008c, iVar.f13008c) && yb.k.a(this.f13009d, iVar.f13009d);
    }

    public final int hashCode() {
        d1.e eVar = this.f13006a;
        int iHashCode = (eVar == null ? 0 : eVar.hashCode()) * 31;
        d1.a aVar = this.f13007b;
        int iHashCode2 = (iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        f1.b bVar = this.f13008c;
        int iHashCode3 = (iHashCode2 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        d1.h hVar = this.f13009d;
        return iHashCode3 + (hVar != null ? hVar.hashCode() : 0);
    }

    public final String toString() {
        return "BorderCache(imageBitmap=" + this.f13006a + ", canvas=" + this.f13007b + ", canvasDrawScope=" + this.f13008c + ", borderPath=" + this.f13009d + ')';
    }
}
