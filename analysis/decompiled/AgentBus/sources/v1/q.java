package v1;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final p f10371a;

    /* renamed from: b, reason: collision with root package name */
    public final k f10372b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10373c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10374d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f10375e;

    public q(p pVar, k kVar, int i2, int i10, Object obj) {
        this.f10371a = pVar;
        this.f10372b = kVar;
        this.f10373c = i2;
        this.f10374d = i10;
        this.f10375e = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return q7.k.a(this.f10371a, qVar.f10371a) && q7.k.a(this.f10372b, qVar.f10372b) && this.f10373c == qVar.f10373c && this.f10374d == qVar.f10374d && q7.k.a(this.f10375e, qVar.f10375e);
    }

    public final int hashCode() {
        p pVar = this.f10371a;
        int iB = n.f.b(this.f10374d, n.f.b(this.f10373c, (((pVar == null ? 0 : pVar.hashCode()) * 31) + this.f10372b.f10363f) * 31, 31), 31);
        Object obj = this.f10375e;
        return iB + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TypefaceRequest(fontFamily=");
        sb2.append(this.f10371a);
        sb2.append(", fontWeight=");
        sb2.append(this.f10372b);
        sb2.append(", fontStyle=");
        String str = "Invalid";
        int i2 = this.f10373c;
        sb2.append((Object) (i2 == 0 ? "Normal" : i2 == 1 ? "Italic" : "Invalid"));
        sb2.append(", fontSynthesis=");
        int i10 = this.f10374d;
        if (i10 == 0) {
            str = "None";
        } else if (i10 == 1) {
            str = "Weight";
        } else if (i10 == 2) {
            str = "Style";
        } else if (i10 == 65535) {
            str = "All";
        }
        sb2.append((Object) str);
        sb2.append(", resourceLoaderCacheKey=");
        sb2.append(this.f10375e);
        sb2.append(')');
        return sb2.toString();
    }
}
