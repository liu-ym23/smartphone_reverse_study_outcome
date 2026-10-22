package r4;

/* renamed from: r4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1023f {

    /* renamed from: a, reason: collision with root package name */
    private final String f20105a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.ranges.h f20106b;

    public C1023f(String str, kotlin.ranges.h hVar) {
        j4.k.g(str, "value");
        j4.k.g(hVar, "range");
        this.f20105a = str;
        this.f20106b = hVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1023f)) {
            return false;
        }
        C1023f c1023f = (C1023f) obj;
        return j4.k.b(this.f20105a, c1023f.f20105a) && j4.k.b(this.f20106b, c1023f.f20106b);
    }

    public int hashCode() {
        return (this.f20105a.hashCode() * 31) + this.f20106b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f20105a + ", range=" + this.f20106b + ')';
    }
}
