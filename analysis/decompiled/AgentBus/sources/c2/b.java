package c2;

import u0.z;

/* loaded from: classes.dex */
public final class b implements o {

    /* renamed from: a, reason: collision with root package name */
    public final float f1858a;

    public b(u0.k kVar, float f10) {
        this.f1858a = f10;
    }

    @Override // c2.o
    public final long a() {
        int i2 = u0.m.f9917g;
        return u0.m.f9916f;
    }

    @Override // c2.o
    public final z b() {
        return null;
    }

    @Override // c2.o
    public final float c() {
        return this.f1858a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return q7.k.a(null, null) && Float.compare(this.f1858a, ((b) obj).f1858a) == 0;
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "BrushStyle(value=" + ((Object) null) + ", alpha=" + this.f1858a + ')';
    }
}
