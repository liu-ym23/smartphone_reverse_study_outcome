package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f16006a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16007b;

    /* renamed from: c, reason: collision with root package name */
    public final long f16008c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f16009d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f16010e;

    /* renamed from: f, reason: collision with root package name */
    public final String f16011f;

    public v(int i, String str, long j10, boolean z10, boolean z11, String str2, int i3) {
        str = (i3 & 2) != 0 ? "" : str;
        j10 = (i3 & 8) != 0 ? 0L : j10;
        z10 = (i3 & 16) != 0 ? true : z10;
        z11 = (i3 & 32) != 0 ? false : z11;
        str2 = (i3 & 64) != 0 ? "" : str2;
        this.f16006a = i;
        this.f16007b = str;
        this.f16008c = j10;
        this.f16009d = z10;
        this.f16010e = z11;
        this.f16011f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f16006a == vVar.f16006a && this.f16007b.equals(vVar.f16007b) && this.f16008c == vVar.f16008c && this.f16009d == vVar.f16009d && this.f16010e == vVar.f16010e && this.f16011f.equals(vVar.f16011f);
    }

    public final int hashCode() {
        return this.f16011f.hashCode() + k0.a.h(k0.a.h(k0.a.i(this.f16008c, s.f.b(1, androidx.activity.b.d(Integer.hashCode(this.f16006a) * 31, 31, this.f16007b), 31), 31), 31, this.f16009d), 31, this.f16010e);
    }

    public final String toString() {
        return "LedgerIpcResult(code=" + this.f16006a + ", message=" + this.f16007b + ", schemaVersion=1, updatedAtMs=" + this.f16008c + ", fromCache=" + this.f16009d + ", stale=" + this.f16010e + ", payloadJson=" + this.f16011f + ")";
    }
}
