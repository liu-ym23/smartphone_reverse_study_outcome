package c7;

/* loaded from: classes.dex */
public final class e implements Comparable {

    /* renamed from: j, reason: collision with root package name */
    public static final e f1965j = new e(2, 1, 20);

    /* renamed from: f, reason: collision with root package name */
    public final int f1966f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1967g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1968h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1969i;

    public e(int i2, int i10, int i11) {
        this.f1966f = i2;
        this.f1967g = i10;
        this.f1968h = i11;
        if (i2 >= 0 && i2 < 256 && i10 >= 0 && i10 < 256 && i11 >= 0 && i11 < 256) {
            this.f1969i = (i2 << 16) + (i10 << 8) + i11;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i10 + '.' + i11).toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        q7.k.e(eVar, "other");
        return this.f1969i - eVar.f1969i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.f1969i == eVar.f1969i;
    }

    public final int hashCode() {
        return this.f1969i;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1966f);
        sb2.append('.');
        sb2.append(this.f1967g);
        sb2.append('.');
        sb2.append(this.f1968h);
        return sb2.toString();
    }
}
