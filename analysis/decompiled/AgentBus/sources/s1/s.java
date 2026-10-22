package s1;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final r f9305a;

    public s(r rVar) {
        this.f9305a = rVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return q7.k.a(this.f9305a, ((s) obj).f9305a);
        }
        return false;
    }

    public final int hashCode() {
        r rVar = this.f9305a;
        if (rVar != null) {
            return rVar.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "PlatformTextStyle(spanStyle=null, paragraphSyle=" + this.f9305a + ')';
    }
}
