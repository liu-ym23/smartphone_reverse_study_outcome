package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: c, reason: collision with root package name */
    public float f9109c;

    /* renamed from: f, reason: collision with root package name */
    public float f9110f;

    @Override // o2.c
    public final float T() {
        return this.f9110f;
    }

    @Override // o2.c
    public final float a() {
        return this.f9109c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Float.compare(this.f9109c, dVar.f9109c) == 0 && Float.compare(this.f9110f, dVar.f9110f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9110f) + (Float.hashCode(this.f9109c) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DensityImpl(density=");
        sb2.append(this.f9109c);
        sb2.append(", fontScale=");
        return k0.a.q(sb2, this.f9110f, ')');
    }
}
