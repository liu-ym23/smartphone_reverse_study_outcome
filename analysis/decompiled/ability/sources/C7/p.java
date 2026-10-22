package C7;

/* loaded from: classes3.dex */
public final class p implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final short f315a;

    public /* synthetic */ p(short s5) {
        this.f315a = s5;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.k.g(this.f315a & 65535, ((p) obj).f315a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f315a == ((p) obj).f315a;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.f315a);
    }

    public final String toString() {
        return String.valueOf(this.f315a & 65535);
    }
}
