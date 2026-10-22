package ma;

import E9.InterfaceC0819y;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final class m extends AbstractC4927g<Float> {
    public m(float f10) {
        super(Float.valueOf(f10));
    }

    @Override // ma.AbstractC4927g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        AbstractC5990d0 abstractC5990d0C = module.g().C();
        kotlin.jvm.internal.p.h(abstractC5990d0C, "getFloatType(...)");
        return abstractC5990d0C;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return b().floatValue() + ".toFloat()";
    }
}
