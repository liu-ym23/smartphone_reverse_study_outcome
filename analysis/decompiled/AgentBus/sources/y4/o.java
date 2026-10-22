package y4;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final n f11630a;

    /* renamed from: b, reason: collision with root package name */
    public final n f11631b;

    public o(n nVar, n nVar2) {
        this.f11630a = nVar;
        this.f11631b = nVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return q7.k.a(this.f11630a, oVar.f11630a) && q7.k.a(this.f11631b, oVar.f11631b);
    }

    public final int hashCode() {
        return this.f11631b.hashCode() + (this.f11630a.hashCode() * 31);
    }

    public final String toString() {
        return "Snapshot(cloud=" + this.f11630a + ", edge=" + this.f11631b + ")";
    }
}
