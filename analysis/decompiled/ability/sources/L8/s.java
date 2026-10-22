package L8;

import X8.A;
import X8.AbstractC0272c;
import X8.F;
import X8.H;
import X8.U;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class s extends g {
    public s(G8.b bVar, int i) {
        super(new q(new f(bVar, i)));
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        X8.w wVarC;
        kotlin.jvm.internal.k.f(module, "module");
        H.b.getClass();
        H h = H.c;
        e8.i iVarC = module.c();
        iVarC.getClass();
        InterfaceC1522e interfaceC1522eI = iVarC.i(e8.n.f4403Q.g());
        Object obj = this.f939a;
        r rVar = (r) obj;
        if (rVar instanceof p) {
            wVarC = ((p) obj).f942a;
        } else {
            if (!(rVar instanceof q)) {
                throw new NoWhenBranchMatchedException();
            }
            f fVar = ((q) obj).f943a;
            G8.b bVar = fVar.f938a;
            int i = fVar.b;
            InterfaceC1522e interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(module, bVar);
            if (interfaceC1522eA == null) {
                wVarC = Z8.i.c(ErrorTypeKind.d, bVar.toString(), String.valueOf(i));
            } else {
                A aG = interfaceC1522eA.g();
                kotlin.jvm.internal.k.e(aG, "getDefaultType(...)");
                U uR = U7.a.R(aG);
                for (int i6 = 0; i6 < i; i6++) {
                    e8.i iVarC2 = module.c();
                    Variance variance = Variance.c;
                    uR = iVarC2.g(uR);
                }
                wVarC = uR;
            }
        }
        return AbstractC0272c.t(h, interfaceC1522eI, H4.o.M(new F(wVarC)));
    }
}
