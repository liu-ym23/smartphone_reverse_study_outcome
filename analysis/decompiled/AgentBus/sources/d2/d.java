package d2;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: f, reason: collision with root package name */
    public final float f2779f;

    /* renamed from: g, reason: collision with root package name */
    public final float f2780g;

    public d(float f10, float f11) {
        this.f2779f = f10;
        this.f2780g = f11;
    }

    @Override // d2.c
    public final float c() {
        return this.f2779f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Float.compare(this.f2779f, dVar.f2779f) == 0 && Float.compare(this.f2780g, dVar.f2780g) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2780g) + (Float.hashCode(this.f2779f) * 31);
    }

    @Override // d2.c
    public final float j() {
        return this.f2780g;
    }

    public final String toString() {
        return "DensityImpl(density=" + this.f2779f + ", fontScale=" + this.f2780g + ')';
    }
}
