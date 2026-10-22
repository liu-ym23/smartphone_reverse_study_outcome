package c2;

import u0.z;

/* loaded from: classes.dex */
public final class c implements o {

    /* renamed from: a, reason: collision with root package name */
    public final long f1859a;

    public c(long j2) {
        this.f1859a = j2;
        if (j2 != 16) {
            return;
        }
        x1.a.a("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
    }

    @Override // c2.o
    public final long a() {
        return this.f1859a;
    }

    @Override // c2.o
    public final z b() {
        return null;
    }

    @Override // c2.o
    public final float c() {
        return u0.m.d(this.f1859a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && u0.m.c(this.f1859a, ((c) obj).f1859a);
    }

    public final int hashCode() {
        int i2 = u0.m.f9917g;
        return Long.hashCode(this.f1859a);
    }

    public final String toString() {
        return "ColorStyle(value=" + ((Object) u0.m.i(this.f1859a)) + ')';
    }
}
