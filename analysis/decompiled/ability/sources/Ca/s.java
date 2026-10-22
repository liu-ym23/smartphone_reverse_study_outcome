package Ca;

/* loaded from: classes4.dex */
public final class s extends G {

    /* renamed from: a, reason: collision with root package name */
    public final za.i f362a;
    public final za.d b;

    public s(za.i iVar, za.d dVar) {
        this.f362a = iVar;
        this.b = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.k.b(this.f362a, sVar.f362a) && kotlin.jvm.internal.k.b(this.b, sVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f362a.hashCode() * 31);
    }

    public final String toString() {
        return "TaskCompleted(info=" + this.f362a + ", result=" + this.b + ")";
    }
}
