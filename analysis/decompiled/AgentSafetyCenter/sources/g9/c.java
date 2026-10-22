package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: a, reason: collision with root package name */
    public final p f4414a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4415b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4416c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4417d;

    public c(p pVar, long j10, boolean z10, boolean z11) {
        pVar.getClass();
        this.f4414a = pVar;
        this.f4415b = j10;
        this.f4416c = z10;
        this.f4417d = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return yb.k.a(this.f4414a, cVar.f4414a) && this.f4415b == cVar.f4415b && this.f4416c == cVar.f4416c && this.f4417d == cVar.f4417d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f4417d) + k0.a.h(k0.a.i(this.f4415b, this.f4414a.f4572a.hashCode() * 31, 31), 31, this.f4416c);
    }

    public final String toString() {
        return "Ok(data=" + this.f4414a + ", updatedAtMs=" + this.f4415b + ", fromCache=" + this.f4416c + ", stale=" + this.f4417d + ")";
    }
}
