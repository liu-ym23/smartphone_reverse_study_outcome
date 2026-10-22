package o2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final o[] f9127b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f9128c;

    /* renamed from: a, reason: collision with root package name */
    public long f9129a;

    static {
        o oVar = new o();
        oVar.f9130a = 0L;
        VarHandle.storeStoreFence();
        o oVar2 = new o();
        oVar2.f9130a = 4294967296L;
        VarHandle.storeStoreFence();
        o oVar3 = new o();
        oVar3.f9130a = 8589934592L;
        VarHandle.storeStoreFence();
        f9127b = new o[]{oVar, oVar2, oVar3};
        f9128c = com.stepos.statsrpk.h.C(Float.NaN, 0L);
    }

    public static final /* synthetic */ n a(long j10) {
        n nVar = new n();
        nVar.f9129a = j10;
        VarHandle.storeStoreFence();
        return nVar;
    }

    public static final boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static final long c(long j10) {
        return f9127b[(int) ((j10 & 1095216660480L) >>> 32)].f9130a;
    }

    public static final float d(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    public static String e(long j10) {
        long jC = c(j10);
        if (o.a(jC, 0L)) {
            return "Unspecified";
        }
        if (o.a(jC, 4294967296L)) {
            return d(j10) + ".sp";
        }
        if (!o.a(jC, 8589934592L)) {
            return "Invalid";
        }
        return d(j10) + ".em";
    }

    public final boolean equals(Object obj) {
        return (obj instanceof n) && this.f9129a == ((n) obj).f9129a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9129a);
    }

    public final String toString() {
        return e(this.f9129a);
    }
}
