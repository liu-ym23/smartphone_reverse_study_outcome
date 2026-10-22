package a0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public float f2a;

    @Override // a0.a
    public final float a(long j10, o2.c cVar) {
        return (this.f2a / 100.0f) * c1.e.d(j10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Float.compare(this.f2a, ((c) obj).f2a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2a);
    }

    public final String toString() {
        return "CornerSize(size = " + this.f2a + "%)";
    }
}
