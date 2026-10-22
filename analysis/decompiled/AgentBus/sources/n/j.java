package n;

/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f6639a;

    public j(float f10) {
        this.f6639a = f10;
    }

    @Override // n.n
    public final float a(int i2) {
        if (i2 == 0) {
            return this.f6639a;
        }
        return 0.0f;
    }

    @Override // n.n
    public final int b() {
        return 1;
    }

    @Override // n.n
    public final n c() {
        return new j(0.0f);
    }

    @Override // n.n
    public final void d() {
        this.f6639a = 0.0f;
    }

    @Override // n.n
    public final void e(int i2, float f10) {
        if (i2 == 0) {
            this.f6639a = f10;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j) && ((j) obj).f6639a == this.f6639a;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6639a);
    }

    public final String toString() {
        return "AnimationVector1D: value = " + this.f6639a;
    }
}
