package t;

import d2.f;

/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final float f9643a;

    public b(float f10) {
        this.f9643a = f10;
    }

    @Override // t.a
    public final float a(long j2, d2.c cVar) {
        return cVar.o(this.f9643a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && f.a(this.f9643a, ((b) obj).f9643a);
    }

    public final int hashCode() {
        return Float.hashCode(this.f9643a);
    }

    public final String toString() {
        return "CornerSize(size = " + this.f9643a + ".dp)";
    }
}
