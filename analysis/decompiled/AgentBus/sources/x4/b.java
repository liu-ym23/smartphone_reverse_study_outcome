package x4;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11160a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11161b;

    public b(boolean z4, boolean z10) {
        this.f11160a = z4;
        this.f11161b = z10;
    }

    public static b a(b bVar, boolean z4, int i2) {
        boolean z10 = (i2 & 1) != 0 ? bVar.f11160a : true;
        if ((i2 & 2) != 0) {
            z4 = bVar.f11161b;
        }
        bVar.getClass();
        return new b(z10, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11160a == bVar.f11160a && this.f11161b == bVar.f11161b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11161b) + (Boolean.hashCode(this.f11160a) * 31);
    }

    public final String toString() {
        return "BffLinkState(wsConnected=" + this.f11160a + ", authed=" + this.f11161b + ")";
    }
}
