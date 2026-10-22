package o5;

import m.x;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7728a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7729b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7730c;

    public a(boolean z4, boolean z10, boolean z11) {
        this.f7728a = z4;
        this.f7729b = z10;
        this.f7730c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7728a == aVar.f7728a && this.f7729b == aVar.f7729b && this.f7730c == aVar.f7730c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f7730c) + x.e(Boolean.hashCode(this.f7728a) * 31, 31, this.f7729b);
    }

    public final String toString() {
        return "BffLinkProbe(enabled=" + this.f7728a + ", wsConnected=" + this.f7729b + ", authed=" + this.f7730c + ")";
    }
}
