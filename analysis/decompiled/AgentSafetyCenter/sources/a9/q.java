package a9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public long f299a;

    /* renamed from: b, reason: collision with root package name */
    public String f300b;

    /* renamed from: c, reason: collision with root package name */
    public long f301c;

    /* renamed from: d, reason: collision with root package name */
    public int f302d;

    /* renamed from: e, reason: collision with root package name */
    public long f303e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f299a == qVar.f299a && yb.k.a(this.f300b, qVar.f300b) && this.f301c == qVar.f301c && this.f302d == qVar.f302d && this.f303e == qVar.f303e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f303e) + s.f.b(this.f302d, k0.a.i(this.f301c, androidx.activity.b.d(Long.hashCode(this.f299a) * 31, 31, this.f300b), 31), 31);
    }

    public final String toString() {
        return "MediaRecord(id=" + this.f299a + ", originalPath=" + this.f300b + ", mediaId=" + this.f301c + ", mediaType=" + this.f302d + ", deletedTime=" + this.f303e + ")";
    }
}
