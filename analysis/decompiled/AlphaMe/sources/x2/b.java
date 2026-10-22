package x2;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f15916a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15917b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15918c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15919d;

    /* renamed from: e, reason: collision with root package name */
    public int f15920e;

    /* renamed from: f, reason: collision with root package name */
    public final String f15921f;

    /* renamed from: g, reason: collision with root package name */
    public final int f15922g;

    /* renamed from: h, reason: collision with root package name */
    public final int f15923h;

    public b(int i4, int i5, String str) {
        int i6 = i4 == 4 ? 5121 : 5126;
        boolean z4 = i4 == 4;
        this.f15916a = i4;
        this.f15917b = i5;
        this.f15919d = i6;
        this.f15918c = z4;
        this.f15921f = str;
        this.f15922g = 0;
        this.f15923h = Integer.numberOfTrailingZeros(i4);
    }

    public final boolean a(b bVar) {
        return bVar != null && this.f15916a == bVar.f15916a && this.f15917b == bVar.f15917b && this.f15919d == bVar.f15919d && this.f15918c == bVar.f15918c && this.f15921f.equals(bVar.f15921f) && this.f15922g == bVar.f15922g;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return a((b) obj);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15921f.hashCode() + (((((this.f15923h << 8) + (this.f15922g & 255)) * 541) + this.f15917b) * 541);
    }
}
