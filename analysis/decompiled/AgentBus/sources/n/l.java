package n;

/* loaded from: classes.dex */
public final class l extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f6648a;

    /* renamed from: b, reason: collision with root package name */
    public float f6649b;

    /* renamed from: c, reason: collision with root package name */
    public float f6650c;

    public l(float f10, float f11, float f12) {
        this.f6648a = f10;
        this.f6649b = f11;
        this.f6650c = f12;
    }

    @Override // n.n
    public final float a(int i2) {
        if (i2 == 0) {
            return this.f6648a;
        }
        if (i2 == 1) {
            return this.f6649b;
        }
        if (i2 != 2) {
            return 0.0f;
        }
        return this.f6650c;
    }

    @Override // n.n
    public final int b() {
        return 3;
    }

    @Override // n.n
    public final n c() {
        return new l(0.0f, 0.0f, 0.0f);
    }

    @Override // n.n
    public final void d() {
        this.f6648a = 0.0f;
        this.f6649b = 0.0f;
        this.f6650c = 0.0f;
    }

    @Override // n.n
    public final void e(int i2, float f10) {
        if (i2 == 0) {
            this.f6648a = f10;
        } else if (i2 == 1) {
            this.f6649b = f10;
        } else {
            if (i2 != 2) {
                return;
            }
            this.f6650c = f10;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f6648a == this.f6648a && lVar.f6649b == this.f6649b && lVar.f6650c == this.f6650c;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6650c) + m.x.d(this.f6649b, Float.hashCode(this.f6648a) * 31, 31);
    }

    public final String toString() {
        return "AnimationVector3D: v1 = " + this.f6648a + ", v2 = " + this.f6649b + ", v3 = " + this.f6650c;
    }
}
