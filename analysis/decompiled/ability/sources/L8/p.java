package L8;

/* loaded from: classes4.dex */
public final class p extends r {

    /* renamed from: a, reason: collision with root package name */
    public final X8.w f942a;

    public p(X8.w wVar) {
        this.f942a = wVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && kotlin.jvm.internal.k.b(this.f942a, ((p) obj).f942a);
    }

    public final int hashCode() {
        return this.f942a.hashCode();
    }

    public final String toString() {
        return "LocalClass(type=" + this.f942a + ')';
    }
}
