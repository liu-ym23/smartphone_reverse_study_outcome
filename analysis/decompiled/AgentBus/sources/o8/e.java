package o8;

import i8.l0;
import i8.r0;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final e f7799h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f7800i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f7801j;

    /* renamed from: k, reason: collision with root package name */
    public static final e f7802k;

    /* renamed from: l, reason: collision with root package name */
    public static final e f7803l;

    /* renamed from: m, reason: collision with root package name */
    public static final e f7804m;

    /* renamed from: n, reason: collision with root package name */
    public static final e f7805n;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7806g;

    static {
        int i2 = 1;
        f7799h = new e(i2, 0);
        f7800i = new e(i2, 1);
        f7801j = new e(i2, 2);
        f7802k = new e(i2, 3);
        f7803l = new e(i2, 4);
        f7804m = new e(i2, 5);
        f7805n = new e(i2, 6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i2, int i10) {
        super(i2);
        this.f7806g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        f8.c cVarB;
        String strN;
        boolean z4 = false;
        switch (this.f7806g) {
            case 0:
                f8.c cVar = (f8.c) obj;
                q7.k.e(cVar, "it");
                int i2 = f.f7813l;
                return Boolean.valueOf(d7.r.I0(f0.f7819f, nb.i.n(cVar)));
            case 1:
                f8.c cVar2 = (f8.c) obj;
                q7.k.e(cVar2, "it");
                if (cVar2 instanceof f8.t) {
                    int i10 = f.f7813l;
                    if (d7.r.I0(f0.f7819f, nb.i.n(cVar2))) {
                        z4 = true;
                    }
                }
                return Boolean.valueOf(z4);
            case 2:
                f8.c cVar3 = (f8.c) obj;
                q7.k.e(cVar3, "it");
                return Boolean.valueOf(n7.a.n(cVar3));
            case 3:
                return ((r0) obj).getType();
            case 4:
                f8.c cVar4 = (f8.c) obj;
                q7.k.e(cVar4, "it");
                return Boolean.valueOf(n7.a.n(l9.d.k(cVar4)));
            case 5:
                f8.c cVar5 = (f8.c) obj;
                q7.k.e(cVar5, "it");
                int i11 = d.f7798l;
                l0 l0Var = (l0) cVar5;
                if (c8.h.z(l0Var) && l9.d.b(l0Var, new c1.w(24, l0Var)) != null) {
                    z4 = true;
                }
                return Boolean.valueOf(z4);
            default:
                f8.c cVar6 = (f8.c) obj;
                q7.k.e(cVar6, "it");
                if (c8.h.z(cVar6)) {
                    int i12 = f.f7813l;
                    if (f0.f7818e.contains(cVar6.getName()) && (cVarB = l9.d.b(cVar6, f7800i)) != null && (strN = nb.i.n(cVarB)) != null) {
                        if (!f0.f7815b.contains(strN)) {
                        }
                        z4 = true;
                    }
                }
                return Boolean.valueOf(z4);
        }
    }
}
