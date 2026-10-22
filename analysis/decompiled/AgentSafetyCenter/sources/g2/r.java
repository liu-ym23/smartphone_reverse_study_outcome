package g2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final q f4261a;

    /* renamed from: b, reason: collision with root package name */
    public final k f4262b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4263c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4264d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4265e;

    public r(q qVar, k kVar, int i, int i3, Object obj) {
        this.f4261a = qVar;
        this.f4262b = kVar;
        this.f4263c = i;
        this.f4264d = i3;
        this.f4265e = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return yb.k.a(this.f4261a, rVar.f4261a) && yb.k.a(this.f4262b, rVar.f4262b) && this.f4263c == rVar.f4263c && this.f4264d == rVar.f4264d && yb.k.a(this.f4265e, rVar.f4265e);
    }

    public final int hashCode() {
        q qVar = this.f4261a;
        int iB = s.f.b(this.f4264d, s.f.b(this.f4263c, (((qVar == null ? 0 : qVar.hashCode()) * 31) + this.f4262b.f4256c) * 31, 31), 31);
        Object obj = this.f4265e;
        return iB + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TypefaceRequest(fontFamily=");
        sb2.append(this.f4261a);
        sb2.append(", fontWeight=");
        sb2.append(this.f4262b);
        sb2.append(", fontStyle=");
        String str = "Invalid";
        int i = this.f4263c;
        sb2.append((Object) (i == 0 ? "Normal" : i == 1 ? "Italic" : "Invalid"));
        sb2.append(", fontSynthesis=");
        int i3 = this.f4264d;
        if (i3 == 0) {
            str = "None";
        } else if (i3 == 1) {
            str = "Weight";
        } else if (i3 == 2) {
            str = "Style";
        } else if (i3 == 65535) {
            str = "All";
        }
        sb2.append((Object) str);
        sb2.append(", resourceLoaderCacheKey=");
        sb2.append(this.f4265e);
        sb2.append(')');
        return sb2.toString();
    }
}
