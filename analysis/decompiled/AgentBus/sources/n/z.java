package n;

/* loaded from: classes.dex */
public final class z implements h {

    /* renamed from: a, reason: collision with root package name */
    public final s f6769a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6770b;

    public z(s sVar, long j2) {
        this.f6769a = sVar;
        this.f6770b = j2;
    }

    @Override // n.h
    public final h1 a(q6.b bVar) {
        return new k1(this.f6769a.a(bVar), this.f6770b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return zVar.f6769a.equals(this.f6769a) && zVar.f6770b == this.f6770b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6770b) + ((f.d(1) + (this.f6769a.hashCode() * 31)) * 31);
    }
}
