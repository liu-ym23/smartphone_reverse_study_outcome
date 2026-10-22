package C7;

/* loaded from: classes3.dex */
public final class k implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f310a;

    public /* synthetic */ k(int i) {
        this.f310a = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.k.g(this.f310a ^ Integer.MIN_VALUE, ((k) obj).f310a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f310a == ((k) obj).f310a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f310a);
    }

    public final String toString() {
        return String.valueOf(this.f310a & 4294967295L);
    }
}
