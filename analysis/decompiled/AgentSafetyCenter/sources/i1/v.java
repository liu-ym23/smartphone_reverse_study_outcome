package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public float f5763c;

    /* renamed from: d, reason: collision with root package name */
    public float f5764d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return Float.compare(this.f5763c, vVar.f5763c) == 0 && Float.compare(this.f5764d, vVar.f5764d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5764d) + (Float.hashCode(this.f5763c) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeMoveTo(dx=");
        sb2.append(this.f5763c);
        sb2.append(", dy=");
        return k0.a.q(sb2, this.f5764d, ')');
    }
}
