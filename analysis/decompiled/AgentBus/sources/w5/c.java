package w5;

import r.j0;
import y.k0;

/* loaded from: classes.dex */
public final class c implements p7.o {

    /* renamed from: g, reason: collision with root package name */
    public static final c f10680g = new c(0);

    /* renamed from: h, reason: collision with root package name */
    public static final c f10681h = new c(1);

    /* renamed from: i, reason: collision with root package name */
    public static final c f10682i = new c(2);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10683f;

    public /* synthetic */ c(int i2) {
        this.f10683f = i2;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        switch (this.f10683f) {
            case 0:
                b0.p pVar = (b0.p) obj2;
                int iIntValue = ((Number) obj3).intValue();
                q7.k.e((j0) obj, "$this$Button");
                if ((iIntValue & 17) == 16 && pVar.z()) {
                    pVar.O();
                } else {
                    k0.a("重新诊断", null, 0L, s7.a.z(12), null, null, 0L, 0L, 0, false, 0, 0, null, pVar, 3078, 0, 131062);
                }
                break;
            case 1:
                b0.p pVar2 = (b0.p) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                q7.k.e((j0) obj, "$this$OutlinedButton");
                if ((iIntValue2 & 17) == 16 && pVar2.z()) {
                    pVar2.O();
                } else {
                    k0.a("复制报告", null, 0L, s7.a.z(12), null, null, 0L, 0L, 0, false, 0, 0, null, pVar2, 3078, 0, 131062);
                }
                break;
            default:
                b0.p pVar3 = (b0.p) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                q7.k.e((j0) obj, "$this$OutlinedButton");
                if ((iIntValue3 & 17) == 16 && pVar3.z()) {
                    pVar3.O();
                } else {
                    k0.a("关闭", null, 0L, s7.a.z(12), null, null, 0L, 0L, 0, false, 0, 0, null, pVar3, 3078, 0, 131062);
                }
                break;
        }
        return c7.r.f1986a;
    }
}
