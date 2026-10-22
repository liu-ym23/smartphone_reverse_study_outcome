package a0;

import o2.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public float f1a;

    @Override // a0.a
    public final float a(long j10, o2.c cVar) {
        return cVar.X(this.f1a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && f.b(this.f1a, ((b) obj).f1a);
    }

    public final int hashCode() {
        return Float.hashCode(this.f1a);
    }

    public final String toString() {
        return "CornerSize(size = " + this.f1a + ".dp)";
    }
}
