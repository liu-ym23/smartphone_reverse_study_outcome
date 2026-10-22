package L8;

import h8.InterfaceC1540w;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class c extends g {
    public final /* synthetic */ int b = 1;

    public /* synthetic */ c(Object obj) {
        super(obj);
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        switch (this.b) {
            case 0:
                kotlin.jvm.internal.k.f(module, "module");
                e8.i iVarC = module.c();
                iVarC.getClass();
                return iVarC.s(PrimitiveType.f);
            case 1:
                kotlin.jvm.internal.k.f(module, "module");
                e8.i iVarC2 = module.c();
                iVarC2.getClass();
                return iVarC2.s(PrimitiveType.m);
            default:
                kotlin.jvm.internal.k.f(module, "module");
                e8.i iVarC3 = module.c();
                iVarC3.getClass();
                return iVarC3.s(PrimitiveType.k);
        }
    }

    @Override // L8.g
    public String toString() {
        switch (this.b) {
            case 1:
                return ((Number) this.f939a).doubleValue() + ".toDouble()";
            case 2:
                return ((Number) this.f939a).floatValue() + ".toFloat()";
            default:
                return super.toString();
        }
    }

    public c(double d) {
        super(Double.valueOf(d));
    }

    public c(float f) {
        super(Float.valueOf(f));
    }
}
