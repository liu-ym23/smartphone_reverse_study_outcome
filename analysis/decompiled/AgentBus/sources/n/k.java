package n;

/* loaded from: classes.dex */
public final class k extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f6640a;

    /* renamed from: b, reason: collision with root package name */
    public float f6641b;

    public k(float f10, float f11) {
        this.f6640a = f10;
        this.f6641b = f11;
    }

    @Override // n.n
    public final float a(int i2) {
        if (i2 == 0) {
            return this.f6640a;
        }
        if (i2 != 1) {
            return 0.0f;
        }
        return this.f6641b;
    }

    @Override // n.n
    public final int b() {
        return 2;
    }

    @Override // n.n
    public final n c() {
        return new k(0.0f, 0.0f);
    }

    @Override // n.n
    public final void d() {
        this.f6640a = 0.0f;
        this.f6641b = 0.0f;
    }

    @Override // n.n
    public final void e(int i2, float f10) {
        if (i2 == 0) {
            this.f6640a = f10;
        } else {
            if (i2 != 1) {
                return;
            }
            this.f6641b = f10;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.f6640a == this.f6640a && kVar.f6641b == this.f6641b;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6641b) + (Float.hashCode(this.f6640a) * 31);
    }

    public final String toString() {
        return "AnimationVector2D: v1 = " + this.f6640a + ", v2 = " + this.f6641b;
    }
}
