package k4;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final c f4807a;
    public final int b;

    public m(c cVar, int i) {
        this.f4807a = cVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kotlin.jvm.internal.k.b(this.f4807a, mVar.f4807a) && this.b == mVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f4807a.hashCode() * 31);
    }

    public final String toString() {
        return "Binding(identity=" + this.f4807a + ", uid=" + this.b + ")";
    }
}
