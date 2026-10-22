package w8;

import i8.v;
import v9.z0;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final m f10913h;

    /* renamed from: i, reason: collision with root package name */
    public static final m f10914i;

    /* renamed from: j, reason: collision with root package name */
    public static final m f10915j;

    /* renamed from: k, reason: collision with root package name */
    public static final m f10916k;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10917g;

    static {
        int i2 = 1;
        f10913h = new m(i2, 0);
        f10914i = new m(i2, 1);
        f10915j = new m(i2, 2);
        f10916k = new m(i2, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i2, int i10) {
        super(i2);
        this.f10917g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f10917g) {
            case 0:
                f8.g gVarC = ((z0) obj).E0().c();
                if (gVarC == null) {
                    return Boolean.FALSE;
                }
                e9.f name = gVarC.getName();
                e9.c cVar = e8.d.f3128f;
                return Boolean.valueOf(q7.k.a(name, cVar.f()) && q7.k.a(l9.d.c(gVarC), cVar));
            case 1:
                f8.c cVar2 = (f8.c) obj;
                q7.k.e(cVar2, "it");
                v vVarI = cVar2.I();
                q7.k.b(vVarI);
                return vVarI.getType();
            case 2:
                f8.c cVar3 = (f8.c) obj;
                q7.k.e(cVar3, "it");
                v9.v vVarF = cVar3.f();
                q7.k.b(vVarF);
                return vVarF;
            case 3:
                z0 z0Var = (z0) obj;
                q7.k.e(z0Var, "it");
                return Boolean.valueOf(z0Var instanceof t8.f);
            default:
                n nVar = (n) obj;
                q7.k.e(nVar, "$this$function");
                String strConcat = "java/util/".concat("Spliterator");
                e eVar = k.f10908b;
                nVar.b(strConcat, eVar, eVar);
                return c7.r.f1986a;
        }
    }
}
