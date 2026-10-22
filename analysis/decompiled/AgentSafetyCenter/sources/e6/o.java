package e6;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public Long f3588a;

    /* renamed from: b, reason: collision with root package name */
    public String f3589b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f3588a.equals(oVar.f3588a) && yb.k.a(this.f3589b, oVar.f3589b);
    }

    public final int hashCode() {
        int iHashCode = this.f3588a.hashCode() * 31;
        String str = this.f3589b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Entry(value=");
        sb2.append(this.f3588a);
        sb2.append(", memoryCacheKey=");
        return k0.a.s(sb2, this.f3589b, ')');
    }
}
