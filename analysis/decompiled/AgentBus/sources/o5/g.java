package o5;

import n7.o;

/* loaded from: classes.dex */
public final class g extends o {

    /* renamed from: b, reason: collision with root package name */
    public final String f7761b;

    public g(String str) {
        super(2);
        this.f7761b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && q7.k.a(this.f7761b, ((g) obj).f7761b);
    }

    @Override // n7.o
    public final int hashCode() {
        String str = this.f7761b;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // n7.o
    public final String toString() {
        String str = this.f7761b;
        return (str == null || ga.k.t0(str)) ? "Available" : a1.a.j("Available(", str, ")");
    }
}
