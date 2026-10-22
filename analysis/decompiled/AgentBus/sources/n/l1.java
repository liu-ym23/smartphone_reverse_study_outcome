package n;

/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final n f6653a;

    /* renamed from: b, reason: collision with root package name */
    public final t f6654b;

    public l1(n nVar, t tVar) {
        this.f6653a = nVar;
        this.f6654b = tVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return q7.k.a(this.f6653a, l1Var.f6653a) && q7.k.a(this.f6654b, l1Var.f6654b);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + ((this.f6654b.hashCode() + (this.f6653a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.f6653a + ", easing=" + this.f6654b + ", arcMode=ArcMode(value=0))";
    }
}
