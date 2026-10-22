package d1;

import android.graphics.Shader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends f0 {

    /* renamed from: b, reason: collision with root package name */
    public final long f3013b;

    public l0(long j10) {
        this.f3013b = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            return p.d(this.f3013b, ((l0) obj).f3013b);
        }
        return false;
    }

    @Override // d1.f0
    public final void g(float f5, long j10, f fVar) {
        fVar.c(1.0f);
        long jC = this.f3013b;
        if (f5 != 1.0f) {
            jC = p.c(p.e(jC) * f5, jC);
        }
        fVar.e(jC);
        if (((Shader) fVar.f2969c) != null) {
            fVar.g(null);
        }
    }

    public final int hashCode() {
        int i = p.f3025h;
        return Long.hashCode(this.f3013b);
    }

    public final String toString() {
        return "SolidColor(value=" + ((Object) p.j(this.f3013b)) + ')';
    }
}
