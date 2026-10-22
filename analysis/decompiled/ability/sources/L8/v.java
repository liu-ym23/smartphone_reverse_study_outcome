package L8;

import h8.InterfaceC1540w;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class v extends o {
    public v(short s5) {
        super(Short.valueOf(s5));
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        kotlin.jvm.internal.k.f(module, "module");
        e8.i iVarC = module.c();
        iVarC.getClass();
        return iVarC.s(PrimitiveType.i);
    }

    @Override // L8.g
    public final String toString() {
        return ((Number) this.f939a).intValue() + ".toShort()";
    }
}
