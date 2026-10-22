package r;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final int f8953a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8954b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8955c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8956d;

    public z(int i2, int i10, int i11, int i12) {
        this.f8953a = i2;
        this.f8954b = i10;
        this.f8955c = i11;
        this.f8956d = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f8953a == zVar.f8953a && this.f8954b == zVar.f8954b && this.f8955c == zVar.f8955c && this.f8956d == zVar.f8956d;
    }

    public final int hashCode() {
        return (((((this.f8953a * 31) + this.f8954b) * 31) + this.f8955c) * 31) + this.f8956d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("InsetsValues(left=");
        sb2.append(this.f8953a);
        sb2.append(", top=");
        sb2.append(this.f8954b);
        sb2.append(", right=");
        sb2.append(this.f8955c);
        sb2.append(", bottom=");
        return m.x.m(sb2, this.f8956d, ')');
    }
}
