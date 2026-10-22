package b5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final t f914b = new t();

    /* renamed from: a, reason: collision with root package name */
    public final long f915a;

    public /* synthetic */ u(long j4) {
        this.f915a = j4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.p.h(this.f915a ^ Long.MIN_VALUE, ((u) obj).f915a ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            return this.f915a == ((u) obj).f915a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f915a);
    }

    public final String toString() {
        long j4 = this.f915a;
        if (j4 >= 0) {
            x.f.r(10);
            String string = Long.toString(j4, 10);
            kotlin.jvm.internal.p.d(string, "toString(...)");
            return string;
        }
        long j8 = 10;
        long j9 = ((j4 >>> 1) / j8) << 1;
        long j10 = j4 - (j9 * j8);
        if (j10 >= j8) {
            j10 -= j8;
            j9++;
        }
        x.f.r(10);
        String string2 = Long.toString(j9, 10);
        kotlin.jvm.internal.p.d(string2, "toString(...)");
        x.f.r(10);
        String string3 = Long.toString(j10, 10);
        kotlin.jvm.internal.p.d(string3, "toString(...)");
        return string2.concat(string3);
    }
}
