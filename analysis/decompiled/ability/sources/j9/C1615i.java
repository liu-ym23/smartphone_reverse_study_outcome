package j9;

/* renamed from: j9.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1615i {

    /* renamed from: a, reason: collision with root package name */
    public final String f4786a;
    public final Y7.f b;

    public C1615i(String str, Y7.f fVar) {
        this.f4786a = str;
        this.b = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1615i)) {
            return false;
        }
        C1615i c1615i = (C1615i) obj;
        return kotlin.jvm.internal.k.b(this.f4786a, c1615i.f4786a) && kotlin.jvm.internal.k.b(this.b, c1615i.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4786a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f4786a + ", range=" + this.b + ')';
    }
}
