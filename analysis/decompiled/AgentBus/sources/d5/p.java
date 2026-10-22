package d5;

/* loaded from: classes.dex */
public final class p extends r {

    /* renamed from: a, reason: collision with root package name */
    public final String f2896a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f2897b;

    public p(String str, Throwable th) {
        q7.k.e(str, "reason");
        this.f2896a = str;
        this.f2897b = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return q7.k.a(this.f2896a, pVar.f2896a) && q7.k.a(this.f2897b, pVar.f2897b);
    }

    public final int hashCode() {
        int iHashCode = this.f2896a.hashCode() * 31;
        Throwable th = this.f2897b;
        return iHashCode + (th == null ? 0 : th.hashCode());
    }

    public final String toString() {
        return "Offline(reason=" + this.f2896a + ", cause=" + this.f2897b + ")";
    }
}
