package r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10270c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10271f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f10272g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(n nVar, s1.o0 o0Var, long j10) {
        super(1);
        this.f10270c = 3;
        this.f10271f = o0Var;
        this.f10272g = j10;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r10v15, types: [xb.l, yb.l] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        int iOrdinal;
        int i = this.f10270c;
        long j10 = 0;
        long j11 = this.f10272g;
        Object obj2 = this.f10271f;
        switch (i) {
            case 0:
                g0 g0Var = (g0) obj2;
                int iOrdinal2 = ((w) obj).ordinal();
                if (iOrdinal2 == 0) {
                    q0 q0Var = g0Var.f10287w.f10297a;
                } else if (iOrdinal2 != 1) {
                    if (iOrdinal2 != 2) {
                        g5.f.a();
                        return null;
                    }
                    q0 q0Var2 = g0Var.f10288x.f10306a;
                }
                return o2.k.a(j11);
            case 1:
                w wVar = (w) obj;
                g0 g0Var2 = (g0) obj2;
                if (g0Var2.B != null && g0Var2.B0() != null && !yb.k.a(g0Var2.B, g0Var2.B0()) && (iOrdinal = wVar.ordinal()) != 0 && iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        g5.f.a();
                        return null;
                    }
                    q0 q0Var3 = g0Var2.f10288x.f10306a;
                }
                return o2.i.a(0L);
            case 2:
                w wVar2 = (w) obj;
                g0 g0Var3 = (g0) obj2;
                o0 o0Var = g0Var3.f10287w.f10297a.f10338b;
                long j12 = o0Var != null ? ((o2.i) o0Var.f10325a.invoke(o2.k.a(j11))).f9116a : 0L;
                o0 o0Var2 = g0Var3.f10288x.f10306a.f10338b;
                long j13 = o0Var2 != null ? ((o2.i) o0Var2.f10325a.invoke(o2.k.a(j11))).f9116a : 0L;
                int iOrdinal3 = wVar2.ordinal();
                if (iOrdinal3 == 0) {
                    j10 = j12;
                } else if (iOrdinal3 != 1) {
                    if (iOrdinal3 != 2) {
                        g5.f.a();
                        return null;
                    }
                    j10 = j13;
                }
                return o2.i.a(j10);
            default:
                s1.o0 o0Var3 = (s1.o0) obj2;
                long jB = ac.a.b(o0Var3.f11277c, o0Var3.f11278f);
                o2.l lVar = o2.l.f9123c;
                float f5 = (((int) (j11 >> 32)) - ((int) (jB >> 32))) / 2.0f;
                o2.l lVar2 = o2.l.f9123c;
                float f10 = 1;
                s1.n0.k((s1.n0) obj, o0Var3, (Math.round((f10 - 1.0f) * ((((int) (j11 & 4294967295L)) - ((int) (jB & 4294967295L))) / 2.0f)) & 4294967295L) | (Math.round((f10 - 1.0f) * f5) << 32));
                return jb.v.f6774a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(g0 g0Var, long j10, int i) {
        super(1);
        this.f10270c = i;
        this.f10271f = g0Var;
        this.f10272g = j10;
    }
}
