package o5;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7766a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7767b;

    public /* synthetic */ k() {
        this(false, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f7766a == kVar.f7766a && q7.k.a(this.f7767b, kVar.f7767b);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f7766a) * 31;
        String str = this.f7767b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "UpstreamLinkState(online=" + this.f7766a + ", reason=" + this.f7767b + ")";
    }

    public k(boolean z4, String str) {
        this.f7766a = z4;
        this.f7767b = str;
    }
}
