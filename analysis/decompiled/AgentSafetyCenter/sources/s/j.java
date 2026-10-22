package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: a, reason: collision with root package name */
    public float f11034a;

    public j(float f5) {
        this.f11034a = f5;
    }

    @Override // s.n
    public final float a(int i) {
        if (i == 0) {
            return this.f11034a;
        }
        return 0.0f;
    }

    @Override // s.n
    public final int b() {
        return 1;
    }

    @Override // s.n
    public final n c() {
        return new j(0.0f);
    }

    @Override // s.n
    public final void d() {
        this.f11034a = 0.0f;
    }

    @Override // s.n
    public final void e(float f5, int i) {
        if (i == 0) {
            this.f11034a = f5;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j) && ((j) obj).f11034a == this.f11034a;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11034a);
    }

    public final String toString() {
        return "AnimationVector1D: value = " + this.f11034a;
    }
}
