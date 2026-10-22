package kotlin.reflect.jvm.internal.impl.builtins.functions;

import E9.InterfaceC0797b;
import Z8.C1172u;
import Z8.C1173v;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import ra.AbstractC5233f;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class c extends AbstractC5233f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(InterfaceC5869l storageManager, b containingClass) {
        super(storageManager, containingClass);
        p.i(storageManager, "storageManager");
        p.i(containingClass, "containingClass");
    }

    @Override // ra.AbstractC5233f
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e> i() {
        InterfaceC0797b interfaceC0797bL = l();
        p.g(interfaceC0797bL, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        e eVarO0 = ((b) interfaceC0797bL).O0();
        return p.d(eVarO0, e.a.f34968f) ? C1172u.e(d.f34962E.a((b) l(), false)) : p.d(eVarO0, e.d.f34971f) ? C1172u.e(d.f34962E.a((b) l(), true)) : C1173v.m();
    }
}
