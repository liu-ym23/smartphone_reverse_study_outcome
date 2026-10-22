package dc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements b<Long>, Iterable<Long>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f8463a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8464b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8465c;

    public g(long j10, long j11) {
        this.f8463a = j10;
        if (j10 < j11) {
            long j12 = j11 % 1;
            long j13 = j10 % 1;
            long j14 = ((j12 < 0 ? j12 + 1 : j12) - (j13 < 0 ? j13 + 1 : j13)) % 1;
            j11 -= j14 < 0 ? j14 + 1 : j14;
        }
        this.f8464b = j11;
        this.f8465c = 1L;
    }

    @Override // dc.b
    public final Comparable b() {
        return Long.valueOf(this.f8463a);
    }

    @Override // dc.b
    public final Comparable c() {
        return Long.valueOf(this.f8464b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        if (isEmpty() && ((g) obj).isEmpty()) {
            return true;
        }
        g gVar = (g) obj;
        return this.f8463a == gVar.f8463a && this.f8464b == gVar.f8464b;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = this.f8463a;
        long j11 = 31 * (j10 ^ (j10 >>> 32));
        long j12 = this.f8464b;
        return (int) (j11 + (j12 ^ (j12 >>> 32)));
    }

    @Override // dc.b
    public final boolean isEmpty() {
        return this.f8463a > this.f8464b;
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return new f(this.f8463a, this.f8464b, this.f8465c);
    }

    public final String toString() {
        return this.f8463a + ".." + this.f8464b;
    }
}
