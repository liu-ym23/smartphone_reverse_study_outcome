package u0;

import android.graphics.Shader;

/* loaded from: classes.dex */
public final class e0 extends z {

    /* renamed from: b, reason: collision with root package name */
    public final long f9902b;

    public e0(long j2) {
        this.f9902b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            return m.c(this.f9902b, ((e0) obj).f9902b);
        }
        return false;
    }

    @Override // u0.z
    public final void f(float f10, long j2, h4.s sVar) {
        sVar.c(1.0f);
        long jB = this.f9902b;
        if (f10 != 1.0f) {
            jB = m.b(m.d(jB) * f10, jB);
        }
        sVar.e(jB);
        if (((Shader) sVar.f4156h) != null) {
            sVar.g(null);
        }
    }

    public final int hashCode() {
        int i2 = m.f9917g;
        return Long.hashCode(this.f9902b);
    }

    public final String toString() {
        return "SolidColor(value=" + ((Object) m.i(this.f9902b)) + ')';
    }
}
