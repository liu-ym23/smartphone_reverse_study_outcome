package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5736c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5737d;

    public n(float f5, float f10) {
        super(3);
        this.f5736c = f5;
        this.f5737d = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Float.compare(this.f5736c, nVar.f5736c) == 0 && Float.compare(this.f5737d, nVar.f5737d) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5737d) + (Float.hashCode(this.f5736c) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MoveTo(x=");
        sb2.append(this.f5736c);
        sb2.append(", y=");
        return k0.a.q(sb2, this.f5737d, ')');
    }
}
