package p;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final long[] f11359a;

    static {
        long[] jArr;
        i iVar = new i();
        iVar.f11374a = m.f11382a;
        iVar.f11375b = f11359a;
        int iD = m.d(0);
        int iMax = iD > 0 ? Math.max(7, m.c(iD)) : 0;
        iVar.f11376c = iMax;
        if (iMax == 0) {
            jArr = m.f11382a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            b1.I(jArr);
        }
        iVar.f11374a = jArr;
        int i10 = iMax >> 3;
        long j10 = 255 << ((iMax & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        m.a(iVar.f11376c);
        iVar.f11375b = new long[iMax];
        f11359a = new long[0];
    }
}
