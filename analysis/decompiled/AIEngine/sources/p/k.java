package p;

import androidx.collection.ScatterSet;
import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k<E> extends ScatterSet<E> {

    /* renamed from: e, reason: collision with root package name */
    public int f11377e;

    public k(int i10) {
        this.f972a = m.f11382a;
        this.f973b = q.a.f11484c;
        if (i10 >= 0) {
            b(m.d(i10));
        } else {
            q.a.c("Capacity must be a positive value.");
            throw null;
        }
    }

    public final int a(int i10) {
        int i11 = this.f974c;
        int i12 = i10 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.f972a;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j10 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j11 = j10 & ((~j10) << 7) & (-9187201950435737472L);
            if (j11 != 0) {
                return (i12 + (Long.numberOfTrailingZeros(j11) >> 3)) & i11;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
        }
    }

    public final void b(int i10) {
        long[] jArr;
        int iMax = i10 > 0 ? Math.max(7, m.c(i10)) : 0;
        this.f974c = iMax;
        if (iMax == 0) {
            jArr = m.f11382a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            b1.I(jArr);
        }
        this.f972a = jArr;
        int i11 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i11] = (jArr[i11] & (~j10)) | j10;
        this.f11377e = m.a(this.f974c) - this.f975d;
        this.f973b = iMax == 0 ? q.a.f11484c : new Object[iMax];
    }
}
