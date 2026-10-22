package o4;

/* loaded from: classes.dex */
public final class a0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final c f7261a;

    public a0(c cVar) {
        this.f7261a = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && q7.k.a(this.f7261a, ((a0) obj).f7261a);
    }

    public final int hashCode() {
        return this.f7261a.f7301a.hashCode();
    }

    public final String toString() {
        return "Ok(identity=" + this.f7261a + ")";
    }
}
