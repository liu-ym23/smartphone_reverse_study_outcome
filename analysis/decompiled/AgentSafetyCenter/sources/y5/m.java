package y5;

import v5.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends e {

    /* renamed from: a, reason: collision with root package name */
    public final p f15925a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15926b;

    /* renamed from: c, reason: collision with root package name */
    public final v5.f f15927c;

    public m(p pVar, String str, v5.f fVar) {
        this.f15925a = pVar;
        this.f15926b = str;
        this.f15927c = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f15925a.equals(mVar.f15925a) && yb.k.a(this.f15926b, mVar.f15926b) && this.f15927c == mVar.f15927c;
    }

    public final int hashCode() {
        int iHashCode = this.f15925a.hashCode() * 31;
        String str = this.f15926b;
        return this.f15927c.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }
}
