package p;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final long[] f11382a = {-9187201950435737345L, -1};

    static {
        int iD = d(0);
        int iMax = iD > 0 ? Math.max(7, c(iD)) : 0;
        if (iMax != 0) {
            long[] jArr = new long[((iMax + 15) & (-8)) >> 3];
            b1.I(jArr);
            int i10 = iMax >> 3;
            long j10 = 255 << ((iMax & 7) << 3);
            jArr[i10] = (jArr[i10] & (~j10)) | j10;
        }
        if (iMax != 0) {
            Object[] objArr = new Object[iMax];
        }
        if (iMax == 0) {
            return;
        }
        Object[] objArr2 = new Object[iMax];
    }

    public static final int a(int i10) {
        if (i10 == 7) {
            return 6;
        }
        return i10 - (i10 / 8);
    }

    public static final int b(int i10) {
        if (i10 == 0) {
            return 6;
        }
        return (i10 * 2) + 1;
    }

    public static final int c(int i10) {
        if (i10 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i10);
        }
        return 0;
    }

    public static final int d(int i10) {
        if (i10 == 7) {
            return 8;
        }
        return ((i10 - 1) / 7) + i10;
    }
}
