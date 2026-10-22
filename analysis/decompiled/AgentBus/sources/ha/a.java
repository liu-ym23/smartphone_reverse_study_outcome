package ha;

import q7.k;

/* loaded from: classes.dex */
public abstract class a implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final long f4247f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f4248g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f4249h = 0;

    static {
        int i2 = b.f4250a;
        f4247f = s7.a.p(4611686018427387903L);
        f4248g = s7.a.p(-4611686018427387903L);
    }

    public static final boolean a(long j2) {
        return j2 == f4247f || j2 == f4248g;
    }

    public static final long b(long j2, c cVar) {
        k.e(cVar, "unit");
        if (j2 == f4247f) {
            return Long.MAX_VALUE;
        }
        if (j2 == f4248g) {
            return Long.MIN_VALUE;
        }
        long j4 = j2 >> 1;
        c cVar2 = (((int) j2) & 1) == 0 ? c.f4251g : c.f4252h;
        k.e(cVar2, "sourceUnit");
        return cVar.f4254f.convert(j4, cVar2.f4254f);
    }
}
