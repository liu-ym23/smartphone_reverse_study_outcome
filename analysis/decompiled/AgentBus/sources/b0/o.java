package b0;

import com.stepos.agentbus.platform.StartupActivity;
import com.stepos.agentbus.platform.diagnostic.DiagnosticActivity;

/* loaded from: classes.dex */
public final class o implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1250f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1251g;

    public /* synthetic */ o(int i2, Object obj) {
        this.f1250f = i2;
        this.f1251g = obj;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1250f) {
            case 0:
                p pVar = (p) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (pVar.L(iIntValue & 1, (iIntValue & 3) != 2)) {
                    throw null;
                }
                pVar.O();
                return c7.r.f1986a;
            case 1:
                p pVar2 = (p) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && pVar2.z()) {
                    pVar2.O();
                } else {
                    w5.a0.c((StartupActivity) this.f1251g, pVar2, 0);
                }
                return c7.r.f1986a;
            default:
                p pVar3 = (p) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && pVar3.z()) {
                    pVar3.O();
                } else {
                    w5.a0.c((DiagnosticActivity) this.f1251g, pVar3, 0);
                }
                return c7.r.f1986a;
        }
    }
}
