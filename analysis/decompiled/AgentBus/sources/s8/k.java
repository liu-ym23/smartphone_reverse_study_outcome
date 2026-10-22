package s8;

import i8.l0;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final k f9574h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f9575i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f9576j;

    /* renamed from: k, reason: collision with root package name */
    public static final k f9577k;

    /* renamed from: l, reason: collision with root package name */
    public static final k f9578l;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9579g;

    static {
        int i2 = 1;
        f9574h = new k(i2, 0);
        f9575i = new k(i2, 1);
        f9576j = new k(i2, 2);
        f9577k = new k(i2, 3);
        f9578l = new k(i2, 4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i2, int i10) {
        super(i2);
        this.f9579g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f9579g) {
            case 0:
                q7.k.e((l8.w) obj, "it");
                return Boolean.valueOf(!Modifier.isStatic(r1.b().getModifiers()));
            case 1:
                l0 l0Var = (l0) obj;
                q7.k.e(l0Var, "$this$selectMostSpecificInEachOverridableGroup");
                return l0Var;
            case 2:
                l8.w wVar = (l8.w) obj;
                q7.k.e(wVar, "it");
                return Boolean.valueOf(Modifier.isStatic(wVar.b().getModifiers()));
            case 3:
                o9.n nVar = (o9.n) obj;
                q7.k.e(nVar, "it");
                return nVar.d();
            default:
                f8.g gVarC = ((v9.v) obj).E0().c();
                if (gVarC instanceof f8.e) {
                    return (f8.e) gVarC;
                }
                return null;
        }
    }
}
