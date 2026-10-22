package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f11045a;

    /* renamed from: b, reason: collision with root package name */
    public float f11046b;

    /* renamed from: c, reason: collision with root package name */
    public float f11047c;

    public l(float f5, float f10, float f11) {
        this.f11045a = f5;
        this.f11046b = f10;
        this.f11047c = f11;
    }

    @Override // s.n
    public final float a(int i) {
        if (i == 0) {
            return this.f11045a;
        }
        if (i == 1) {
            return this.f11046b;
        }
        if (i != 2) {
            return 0.0f;
        }
        return this.f11047c;
    }

    @Override // s.n
    public final int b() {
        return 3;
    }

    @Override // s.n
    public final n c() {
        return new l(0.0f, 0.0f, 0.0f);
    }

    @Override // s.n
    public final void d() {
        this.f11045a = 0.0f;
        this.f11046b = 0.0f;
        this.f11047c = 0.0f;
    }

    @Override // s.n
    public final void e(float f5, int i) {
        if (i == 0) {
            this.f11045a = f5;
        } else if (i == 1) {
            this.f11046b = f5;
        } else {
            if (i != 2) {
                return;
            }
            this.f11047c = f5;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f11045a == this.f11045a && lVar.f11046b == this.f11046b && lVar.f11047c == this.f11047c;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11047c) + k0.a.g(Float.hashCode(this.f11045a) * 31, this.f11046b, 31);
    }

    public final String toString() {
        return "AnimationVector3D: v1 = " + this.f11045a + ", v2 = " + this.f11046b + ", v3 = " + this.f11047c;
    }
}
