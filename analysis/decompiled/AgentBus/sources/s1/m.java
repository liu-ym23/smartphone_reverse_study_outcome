package s1;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final a f9283a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9284b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9285c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9286d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9287e;

    /* renamed from: f, reason: collision with root package name */
    public final float f9288f;

    /* renamed from: g, reason: collision with root package name */
    public final float f9289g;

    public m(a aVar, int i2, int i10, int i11, int i12, float f10, float f11) {
        this.f9283a = aVar;
        this.f9284b = i2;
        this.f9285c = i10;
        this.f9286d = i11;
        this.f9287e = i12;
        this.f9288f = f10;
        this.f9289g = f11;
    }

    public final int a(int i2) {
        int i10 = this.f9285c;
        int i11 = this.f9284b;
        return nb.i.k(i2, i11, i10) - i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f9283a.equals(mVar.f9283a) && this.f9284b == mVar.f9284b && this.f9285c == mVar.f9285c && this.f9286d == mVar.f9286d && this.f9287e == mVar.f9287e && Float.compare(this.f9288f, mVar.f9288f) == 0 && Float.compare(this.f9289g, mVar.f9289g) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9289g) + m.x.d(this.f9288f, n.f.b(this.f9287e, n.f.b(this.f9286d, n.f.b(this.f9285c, n.f.b(this.f9284b, this.f9283a.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "ParagraphInfo(paragraph=" + this.f9283a + ", startIndex=" + this.f9284b + ", endIndex=" + this.f9285c + ", startLineIndex=" + this.f9286d + ", endLineIndex=" + this.f9287e + ", top=" + this.f9288f + ", bottom=" + this.f9289g + ')';
    }
}
