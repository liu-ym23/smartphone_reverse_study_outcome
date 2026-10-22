package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public k2.d f3166a;

    /* renamed from: b, reason: collision with root package name */
    public int f3167b;

    /* renamed from: c, reason: collision with root package name */
    public int f3168c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f3166a.equals(rVar.f3166a) && this.f3167b == rVar.f3167b && this.f3168c == rVar.f3168c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3168c) + s.f.b(this.f3167b, this.f3166a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ParagraphIntrinsicInfo(intrinsics=");
        sb2.append(this.f3166a);
        sb2.append(", startIndex=");
        sb2.append(this.f3167b);
        sb2.append(", endIndex=");
        return androidx.activity.b.l(sb2, this.f3168c, ')');
    }
}
