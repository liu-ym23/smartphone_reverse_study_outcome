package d3;

/* loaded from: classes.dex */
public final class i extends ib.c {

    /* renamed from: a, reason: collision with root package name */
    public final b f2829a;

    public i(b bVar) {
        q7.k.e(bVar, "latestEvent");
        this.f2829a = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && i.class == obj.getClass() && q7.k.a(this.f2829a, ((i) obj).f2829a);
    }

    public final int hashCode() {
        return this.f2829a.hashCode() - 31;
    }

    public final String toString() {
        return "InProgress(latestEvent=" + this.f2829a + ", direction=-1)";
    }
}
