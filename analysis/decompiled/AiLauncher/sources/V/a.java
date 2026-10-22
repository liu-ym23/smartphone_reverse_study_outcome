package V;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final W.e f6419a;

    /* renamed from: b, reason: collision with root package name */
    public final W.e f6420b;

    public a(W.e eVar, W.e eVar2) {
        if (eVar == null) {
            throw new NullPointerException("Null primaryOutConfig");
        }
        this.f6419a = eVar;
        if (eVar2 == null) {
            throw new NullPointerException("Null secondaryOutConfig");
        }
        this.f6420b = eVar2;
    }

    @Override // V.c
    public W.e a() {
        return this.f6419a;
    }

    @Override // V.c
    public W.e b() {
        return this.f6420b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f6419a.equals(cVar.a()) && this.f6420b.equals(cVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f6420b.hashCode() ^ ((this.f6419a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.f6419a + ", secondaryOutConfig=" + this.f6420b + "}";
    }
}
