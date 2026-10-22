package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f11050a;

    /* renamed from: b, reason: collision with root package name */
    public float f11051b;

    /* renamed from: c, reason: collision with root package name */
    public float f11052c;

    /* renamed from: d, reason: collision with root package name */
    public float f11053d;

    public m(float f5, float f10, float f11, float f12) {
        this.f11050a = f5;
        this.f11051b = f10;
        this.f11052c = f11;
        this.f11053d = f12;
    }

    @Override // s.n
    public final float a(int i) {
        if (i == 0) {
            return this.f11050a;
        }
        if (i == 1) {
            return this.f11051b;
        }
        if (i == 2) {
            return this.f11052c;
        }
        if (i != 3) {
            return 0.0f;
        }
        return this.f11053d;
    }

    @Override // s.n
    public final int b() {
        return 4;
    }

    @Override // s.n
    public final n c() {
        return new m(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // s.n
    public final void d() {
        this.f11050a = 0.0f;
        this.f11051b = 0.0f;
        this.f11052c = 0.0f;
        this.f11053d = 0.0f;
    }

    @Override // s.n
    public final void e(float f5, int i) {
        if (i == 0) {
            this.f11050a = f5;
            return;
        }
        if (i == 1) {
            this.f11051b = f5;
        } else if (i == 2) {
            this.f11052c = f5;
        } else {
            if (i != 3) {
                return;
            }
            this.f11053d = f5;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f11050a == this.f11050a && mVar.f11051b == this.f11051b && mVar.f11052c == this.f11052c && mVar.f11053d == this.f11053d;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11053d) + k0.a.g(k0.a.g(Float.hashCode(this.f11050a) * 31, this.f11051b, 31), this.f11052c, 31);
    }

    public final String toString() {
        return "AnimationVector4D: v1 = " + this.f11050a + ", v2 = " + this.f11051b + ", v3 = " + this.f11052c + ", v4 = " + this.f11053d;
    }
}
