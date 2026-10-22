package wa;

import o4.z2;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final long[] f10960e = new long[0];

    /* renamed from: a, reason: collision with root package name */
    public final ua.d f10961a;

    /* renamed from: b, reason: collision with root package name */
    public final z2 f10962b;

    /* renamed from: c, reason: collision with root package name */
    public long f10963c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f10964d;

    public b(ua.d dVar, z2 z2Var) {
        q7.k.e(dVar, "descriptor");
        this.f10961a = dVar;
        this.f10962b = z2Var;
        int iC = dVar.c();
        if (iC <= 64) {
            this.f10963c = iC != 64 ? (-1) << iC : 0L;
            this.f10964d = f10960e;
            return;
        }
        this.f10963c = 0L;
        int i2 = (iC - 1) >>> 6;
        long[] jArr = new long[i2];
        if ((iC & 63) != 0) {
            jArr[i2 - 1] = (-1) << iC;
        }
        this.f10964d = jArr;
    }
}
