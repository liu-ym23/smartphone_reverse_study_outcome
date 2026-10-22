package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public a f3159a;

    /* renamed from: b, reason: collision with root package name */
    public int f3160b;

    /* renamed from: c, reason: collision with root package name */
    public int f3161c;

    /* renamed from: d, reason: collision with root package name */
    public int f3162d;

    /* renamed from: e, reason: collision with root package name */
    public int f3163e;

    /* renamed from: f, reason: collision with root package name */
    public float f3164f;

    /* renamed from: g, reason: collision with root package name */
    public float f3165g;

    public final int a(int i) {
        int i3 = this.f3160b;
        return p5.f.q(i, i3, this.f3161c) - i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f3159a.equals(qVar.f3159a) && this.f3160b == qVar.f3160b && this.f3161c == qVar.f3161c && this.f3162d == qVar.f3162d && this.f3163e == qVar.f3163e && Float.compare(this.f3164f, qVar.f3164f) == 0 && Float.compare(this.f3165g, qVar.f3165g) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f3165g) + k0.a.g(s.f.b(this.f3163e, s.f.b(this.f3162d, s.f.b(this.f3161c, s.f.b(this.f3160b, this.f3159a.hashCode() * 31, 31), 31), 31), 31), this.f3164f, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ParagraphInfo(paragraph=");
        sb2.append(this.f3159a);
        sb2.append(", startIndex=");
        sb2.append(this.f3160b);
        sb2.append(", endIndex=");
        sb2.append(this.f3161c);
        sb2.append(", startLineIndex=");
        sb2.append(this.f3162d);
        sb2.append(", endLineIndex=");
        sb2.append(this.f3163e);
        sb2.append(", top=");
        sb2.append(this.f3164f);
        sb2.append(", bottom=");
        return k0.a.q(sb2, this.f3165g, ')');
    }
}
