package lb;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements Comparable<i> {

    /* renamed from: a, reason: collision with root package name */
    public final long f10404a;

    public /* synthetic */ i(long j10) {
        this.f10404a = j10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(i iVar) {
        return kotlin.jvm.internal.g.h(this.f10404a ^ Long.MIN_VALUE, iVar.f10404a ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f10404a == ((i) obj).f10404a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f10404a);
    }

    public final String toString() {
        long j10 = this.f10404a;
        if (j10 >= 0) {
            b1.l(10);
            String string = Long.toString(j10, 10);
            kotlin.jvm.internal.g.e(string, "toString(...)");
            return string;
        }
        long j11 = 10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        b1.l(10);
        String string2 = Long.toString(j12, 10);
        kotlin.jvm.internal.g.e(string2, "toString(...)");
        b1.l(10);
        String string3 = Long.toString(j13, 10);
        kotlin.jvm.internal.g.e(string3, "toString(...)");
        return string2.concat(string3);
    }
}
