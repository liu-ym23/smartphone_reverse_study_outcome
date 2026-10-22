package C7;

/* loaded from: classes3.dex */
public final class h implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final byte f307a;

    public /* synthetic */ h(byte b) {
        this.f307a = b;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.k.g(this.f307a & 255, ((h) obj).f307a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f307a == ((h) obj).f307a;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.f307a);
    }

    public final String toString() {
        return String.valueOf(this.f307a & 255);
    }
}
