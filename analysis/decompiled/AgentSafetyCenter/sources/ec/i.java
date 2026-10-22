package ec;

import java.lang.invoke.VarHandle;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements d, Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public long f3766c;

    /* renamed from: f, reason: collision with root package name */
    public long f3767f;

    /* renamed from: g, reason: collision with root package name */
    public long f3768g;

    static {
        new i(1L, 0L);
    }

    public i(long j10, long j11) {
        this.f3766c = j10;
        if (j10 < j11) {
            long j12 = j11 % 1;
            long j13 = j10 % 1;
            long j14 = ((j12 < 0 ? j12 + 1 : j12) - (j13 < 0 ? j13 + 1 : j13)) % 1;
            j11 -= j14 < 0 ? j14 + 1 : j14;
        }
        this.f3767f = j11;
        this.f3768g = 1L;
    }

    @Override // ec.d
    public final Comparable a() {
        return Long.valueOf(this.f3766c);
    }

    @Override // ec.d
    public final Comparable b() {
        return Long.valueOf(this.f3767f);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        long j10 = this.f3766c;
        long j11 = this.f3767f;
        if (j10 > j11) {
            i iVar = (i) obj;
            if (iVar.f3766c > iVar.f3767f) {
                return true;
            }
        }
        i iVar2 = (i) obj;
        return j10 == iVar2.f3766c && j11 == iVar2.f3767f;
    }

    public final int hashCode() {
        long j10 = this.f3766c;
        long j11 = this.f3767f;
        if (j10 > j11) {
            return -1;
        }
        return (int) ((31 * (j10 ^ (j10 >>> 32))) + ((j11 >>> 32) ^ j11));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        long j10 = this.f3766c;
        long j11 = this.f3767f;
        long j12 = this.f3768g;
        h hVar = new h();
        hVar.f3762c = j12;
        hVar.f3763f = j11;
        boolean z10 = false;
        if (j12 <= 0 ? j10 >= j11 : j10 <= j11) {
            z10 = true;
        }
        hVar.f3764g = z10;
        if (!z10) {
            j10 = j11;
        }
        hVar.f3765h = j10;
        VarHandle.storeStoreFence();
        return hVar;
    }

    public final String toString() {
        return this.f3766c + ".." + this.f3767f;
    }
}
