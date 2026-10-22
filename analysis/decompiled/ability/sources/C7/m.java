package C7;

import ca.AbstractC0897f;

/* loaded from: classes3.dex */
public final class m implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final long f312a;

    public /* synthetic */ m(long j5) {
        this.f312a = j5;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.k.h(this.f312a ^ Long.MIN_VALUE, ((m) obj).f312a ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f312a == ((m) obj).f312a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f312a);
    }

    public final String toString() {
        long j5 = this.f312a;
        if (j5 >= 0) {
            AbstractC0897f.r(10);
            String string = Long.toString(j5, 10);
            kotlin.jvm.internal.k.e(string, "toString(...)");
            return string;
        }
        long j6 = 10;
        long j10 = ((j5 >>> 1) / j6) << 1;
        long j11 = j5 - (j10 * j6);
        if (j11 >= j6) {
            j11 -= j6;
            j10++;
        }
        AbstractC0897f.r(10);
        String string2 = Long.toString(j10, 10);
        kotlin.jvm.internal.k.e(string2, "toString(...)");
        AbstractC0897f.r(10);
        String string3 = Long.toString(j11, 10);
        kotlin.jvm.internal.k.e(string3, "toString(...)");
        return string2.concat(string3);
    }
}
