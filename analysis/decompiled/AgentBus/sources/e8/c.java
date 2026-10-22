package e8;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final e9.b f3120a;

    /* renamed from: b, reason: collision with root package name */
    public final e9.b f3121b;

    /* renamed from: c, reason: collision with root package name */
    public final e9.b f3122c;

    public c(e9.b bVar, e9.b bVar2, e9.b bVar3) {
        this.f3120a = bVar;
        this.f3121b = bVar2;
        this.f3122c = bVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return q7.k.a(this.f3120a, cVar.f3120a) && q7.k.a(this.f3121b, cVar.f3121b) && q7.k.a(this.f3122c, cVar.f3122c);
    }

    public final int hashCode() {
        return this.f3122c.hashCode() + ((this.f3121b.hashCode() + (this.f3120a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PlatformMutabilityMapping(javaClass=" + this.f3120a + ", kotlinReadOnly=" + this.f3121b + ", kotlinMutable=" + this.f3122c + ')';
    }
}
