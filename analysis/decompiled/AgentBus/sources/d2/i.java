package d2;

import m.x;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f2786a;

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public static final long b(long j2, long j4) {
        return ((((int) (j2 >> 32)) - ((int) (j4 >> 32))) << 32) | ((((int) (j2 & 4294967295L)) - ((int) (j4 & 4294967295L))) & 4294967295L);
    }

    public static final long c(long j2, long j4) {
        return ((((int) (j2 >> 32)) + ((int) (j4 >> 32))) << 32) | ((((int) (j2 & 4294967295L)) + ((int) (j4 & 4294967295L))) & 4294967295L);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f2786a == ((i) obj).f2786a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2786a);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("(");
        long j2 = this.f2786a;
        sb2.append((int) (j2 >> 32));
        sb2.append(", ");
        return x.m(sb2, (int) (j2 & 4294967295L), ')');
    }
}
