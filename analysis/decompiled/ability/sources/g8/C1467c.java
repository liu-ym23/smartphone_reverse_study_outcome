package g8;

/* renamed from: g8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1467c {

    /* renamed from: a, reason: collision with root package name */
    public final G8.b f4489a;
    public final G8.b b;
    public final G8.b c;

    public C1467c(G8.b bVar, G8.b bVar2, G8.b bVar3) {
        this.f4489a = bVar;
        this.b = bVar2;
        this.c = bVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1467c)) {
            return false;
        }
        C1467c c1467c = (C1467c) obj;
        return kotlin.jvm.internal.k.b(this.f4489a, c1467c.f4489a) && kotlin.jvm.internal.k.b(this.b, c1467c.b) && kotlin.jvm.internal.k.b(this.c, c1467c.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f4489a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PlatformMutabilityMapping(javaClass=" + this.f4489a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
    }
}
