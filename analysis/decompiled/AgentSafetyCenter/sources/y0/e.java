package y0;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f15868a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15869b;

    /* renamed from: c, reason: collision with root package name */
    public final f f15870c;

    /* renamed from: d, reason: collision with root package name */
    public final stepos.support.v7.app.f f15871d;

    public e(int i, long j10, f fVar, stepos.support.v7.app.f fVar2) {
        this.f15868a = i;
        this.f15869b = j10;
        this.f15870c = fVar;
        this.f15871d = fVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f15868a == eVar.f15868a && this.f15869b == eVar.f15869b && this.f15870c == eVar.f15870c && k.a(this.f15871d, eVar.f15871d);
    }

    public final int hashCode() {
        int iHashCode = (this.f15870c.hashCode() + k0.a.i(this.f15869b, Integer.hashCode(this.f15868a) * 31, 31)) * 31;
        stepos.support.v7.app.f fVar = this.f15871d;
        return iHashCode + (fVar == null ? 0 : fVar.hashCode());
    }

    public final String toString() {
        return "ContentCaptureEvent(id=" + this.f15868a + ", timestamp=" + this.f15869b + ", type=" + this.f15870c + ", structureCompat=" + this.f15871d + ')';
    }
}
