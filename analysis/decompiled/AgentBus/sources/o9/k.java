package o9;

import i8.l0;

/* loaded from: classes.dex */
public final class k extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final k f7927h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f7928i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f7929j;

    /* renamed from: k, reason: collision with root package name */
    public static final k f7930k;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7931g;

    static {
        int i2 = 1;
        f7927h = new k(i2, 0);
        f7928i = new k(i2, 1);
        f7929j = new k(i2, 2);
        f7930k = new k(i2, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i2, int i10) {
        super(i2);
        this.f7931g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f7931g) {
            case 0:
                q7.k.e((e9.f) obj, "it");
                return Boolean.TRUE;
            case 1:
                f8.b bVar = (f8.b) obj;
                q7.k.e(bVar, "$this$selectMostSpecificInEachOverridableGroup");
                return bVar;
            case 2:
                l0 l0Var = (l0) obj;
                q7.k.e(l0Var, "$this$selectMostSpecificInEachOverridableGroup");
                return l0Var;
            default:
                f8.l0 l0Var2 = (f8.l0) obj;
                q7.k.e(l0Var2, "$this$selectMostSpecificInEachOverridableGroup");
                return l0Var2;
        }
    }
}
