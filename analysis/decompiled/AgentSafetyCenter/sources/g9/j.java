package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f4489a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4490b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4491c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4492d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4493e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4494f;

    public j(int i, String str, long j10, boolean z10, boolean z11, String str2, int i3) {
        j10 = (i3 & 8) != 0 ? 0L : j10;
        z10 = (i3 & 16) != 0 ? true : z10;
        z11 = (i3 & 32) != 0 ? false : z11;
        str2 = (i3 & 64) != 0 ? "" : str2;
        this.f4489a = i;
        this.f4490b = str;
        this.f4491c = j10;
        this.f4492d = z10;
        this.f4493e = z11;
        this.f4494f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f4489a == jVar.f4489a && this.f4490b.equals(jVar.f4490b) && this.f4491c == jVar.f4491c && this.f4492d == jVar.f4492d && this.f4493e == jVar.f4493e && this.f4494f.equals(jVar.f4494f);
    }

    public final int hashCode() {
        return this.f4494f.hashCode() + k0.a.h(k0.a.h(k0.a.i(this.f4491c, s.f.b(1, androidx.activity.b.d(Integer.hashCode(this.f4489a) * 31, 31, this.f4490b), 31), 31), 31, this.f4492d), 31, this.f4493e);
    }

    public final String toString() {
        return "AgentPermissionIpcResult(code=" + this.f4489a + ", message=" + this.f4490b + ", schemaVersion=1, updatedAtMs=" + this.f4491c + ", fromCache=" + this.f4492d + ", stale=" + this.f4493e + ", payloadJson=" + this.f4494f + ")";
    }
}
