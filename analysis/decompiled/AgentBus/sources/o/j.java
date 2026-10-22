package o;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public u0.d f7066a = null;

    /* renamed from: b, reason: collision with root package name */
    public u0.a f7067b = null;

    /* renamed from: c, reason: collision with root package name */
    public w0.b f7068c = null;

    /* renamed from: d, reason: collision with root package name */
    public u0.f f7069d = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q7.k.a(this.f7066a, jVar.f7066a) && q7.k.a(this.f7067b, jVar.f7067b) && q7.k.a(this.f7068c, jVar.f7068c) && q7.k.a(this.f7069d, jVar.f7069d);
    }

    public final int hashCode() {
        u0.d dVar = this.f7066a;
        int iHashCode = (dVar == null ? 0 : dVar.hashCode()) * 31;
        u0.a aVar = this.f7067b;
        int iHashCode2 = (iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        w0.b bVar = this.f7068c;
        int iHashCode3 = (iHashCode2 + (bVar == null ? 0 : bVar.hashCode())) * 31;
        u0.f fVar = this.f7069d;
        return iHashCode3 + (fVar != null ? fVar.hashCode() : 0);
    }

    public final String toString() {
        return "BorderCache(imageBitmap=" + this.f7066a + ", canvas=" + this.f7067b + ", canvasDrawScope=" + this.f7068c + ", borderPath=" + this.f7069d + ')';
    }
}
