package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f11036a;

    /* renamed from: b, reason: collision with root package name */
    public float f11037b;

    public k(float f5, float f10) {
        this.f11036a = f5;
        this.f11037b = f10;
    }

    @Override // s.n
    public final float a(int i) {
        if (i == 0) {
            return this.f11036a;
        }
        if (i != 1) {
            return 0.0f;
        }
        return this.f11037b;
    }

    @Override // s.n
    public final int b() {
        return 2;
    }

    @Override // s.n
    public final n c() {
        return new k(0.0f, 0.0f);
    }

    @Override // s.n
    public final void d() {
        this.f11036a = 0.0f;
        this.f11037b = 0.0f;
    }

    @Override // s.n
    public final void e(float f5, int i) {
        if (i == 0) {
            this.f11036a = f5;
        } else {
            if (i != 1) {
                return;
            }
            this.f11037b = f5;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.f11036a == this.f11036a && kVar.f11037b == this.f11037b;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11037b) + (Float.hashCode(this.f11036a) * 31);
    }

    public final String toString() {
        return "AnimationVector2D: v1 = " + this.f11036a + ", v2 = " + this.f11037b;
    }
}
