package s1;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final z1.d f9290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9291b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9292c;

    public n(z1.d dVar, int i2, int i10) {
        this.f9290a = dVar;
        this.f9291b = i2;
        this.f9292c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f9290a.equals(nVar.f9290a) && this.f9291b == nVar.f9291b && this.f9292c == nVar.f9292c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9292c) + n.f.b(this.f9291b, this.f9290a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ParagraphIntrinsicInfo(intrinsics=");
        sb2.append(this.f9290a);
        sb2.append(", startIndex=");
        sb2.append(this.f9291b);
        sb2.append(", endIndex=");
        return m.x.m(sb2, this.f9292c, ')');
    }
}
