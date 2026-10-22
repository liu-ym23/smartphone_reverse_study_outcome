package n;

/* loaded from: classes.dex */
public final class m extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f6655a;

    /* renamed from: b, reason: collision with root package name */
    public float f6656b;

    /* renamed from: c, reason: collision with root package name */
    public float f6657c;

    /* renamed from: d, reason: collision with root package name */
    public float f6658d;

    public m(float f10, float f11, float f12, float f13) {
        this.f6655a = f10;
        this.f6656b = f11;
        this.f6657c = f12;
        this.f6658d = f13;
    }

    @Override // n.n
    public final float a(int i2) {
        if (i2 == 0) {
            return this.f6655a;
        }
        if (i2 == 1) {
            return this.f6656b;
        }
        if (i2 == 2) {
            return this.f6657c;
        }
        if (i2 != 3) {
            return 0.0f;
        }
        return this.f6658d;
    }

    @Override // n.n
    public final int b() {
        return 4;
    }

    @Override // n.n
    public final n c() {
        return new m(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // n.n
    public final void d() {
        this.f6655a = 0.0f;
        this.f6656b = 0.0f;
        this.f6657c = 0.0f;
        this.f6658d = 0.0f;
    }

    @Override // n.n
    public final void e(int i2, float f10) {
        if (i2 == 0) {
            this.f6655a = f10;
            return;
        }
        if (i2 == 1) {
            this.f6656b = f10;
        } else if (i2 == 2) {
            this.f6657c = f10;
        } else {
            if (i2 != 3) {
                return;
            }
            this.f6658d = f10;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f6655a == this.f6655a && mVar.f6656b == this.f6656b && mVar.f6657c == this.f6657c && mVar.f6658d == this.f6658d;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6658d) + m.x.d(this.f6657c, m.x.d(this.f6656b, Float.hashCode(this.f6655a) * 31, 31), 31);
    }

    public final String toString() {
        return "AnimationVector4D: v1 = " + this.f6655a + ", v2 = " + this.f6656b + ", v3 = " + this.f6657c + ", v4 = " + this.f6658d;
    }
}
