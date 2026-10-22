package L8;

import h8.InterfaceC1524g;
import h8.InterfaceC1540w;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends g {
    public final S7.k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(S7.k kVar, List value) {
        super(value);
        kotlin.jvm.internal.k.f(value, "value");
        this.b = kVar;
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        InterfaceC1524g interfaceC1524gD;
        kotlin.jvm.internal.k.f(module, "module");
        X8.w wVar = (X8.w) this.b.invoke(module);
        if (!e8.i.y(wVar) && (((interfaceC1524gD = wVar.Q().d()) == null || e8.i.r(interfaceC1524gD) == null) && !e8.i.B(wVar, e8.n.f4409W.i()) && !e8.i.B(wVar, e8.n.f4410X.i()) && !e8.i.B(wVar, e8.n.f4411Y.i()))) {
            e8.i.B(wVar, e8.n.f4412Z.i());
        }
        return wVar;
    }
}
