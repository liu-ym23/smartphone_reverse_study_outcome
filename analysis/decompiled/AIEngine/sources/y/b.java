package y;

import androidx.compose.runtime.snapshots.SnapshotIdSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final SnapshotIdSet f13925a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13926b;

    public b(long j10, SnapshotIdSet snapshotIdSet) {
        int iNumberOfTrailingZeros;
        this.f13925a = snapshotIdSet;
        this.f13926b = j10;
        androidx.preference.c cVar = d.f13932a;
        if (j10 != 0) {
            SnapshotIdSet snapshotIdSetA = a();
            long j11 = snapshotIdSetA.f993c;
            long[] jArr = snapshotIdSetA.f994d;
            if (jArr != null) {
                j10 = jArr[0];
            } else {
                long j12 = snapshotIdSetA.f992b;
                if (j12 != 0) {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j12);
                } else {
                    long j13 = snapshotIdSetA.f991a;
                    if (j13 != 0) {
                        j11 += 64;
                        iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j13);
                    }
                }
                j10 = j11 + iNumberOfTrailingZeros;
            }
            synchronized (d.f13933b) {
                d.f13936e.a(j10);
            }
        }
    }

    public SnapshotIdSet a() {
        return this.f13925a;
    }

    public abstract zb.l<Object, lb.n> b();

    public abstract boolean c();

    public long d() {
        return this.f13926b;
    }

    public int e() {
        return 0;
    }

    public abstract zb.l<Object, lb.n> f();

    public abstract void g(i iVar);

    public void h(int i10) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }
}
