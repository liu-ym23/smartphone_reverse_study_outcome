package m3;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13643a;

    /* renamed from: b, reason: collision with root package name */
    public final l f13644b;

    public o(Object obj, l lVar) {
        this.f13643a = obj;
        this.f13644b = lVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f13643a == oVar.f13643a && this.f13644b.equals(oVar.f13644b);
    }

    public final int hashCode() {
        return this.f13644b.f13634f.hashCode() + this.f13643a.hashCode();
    }
}
