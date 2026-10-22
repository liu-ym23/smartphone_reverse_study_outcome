package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5761c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5762d;

    public u(float f5, float f10) {
        super(3);
        this.f5761c = f5;
        this.f5762d = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Float.compare(this.f5761c, uVar.f5761c) == 0 && Float.compare(this.f5762d, uVar.f5762d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5762d) + (Float.hashCode(this.f5761c) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeLineTo(dx=");
        sb2.append(this.f5761c);
        sb2.append(", dy=");
        return k0.a.q(sb2, this.f5762d, ')');
    }
}
