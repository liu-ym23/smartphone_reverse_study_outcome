package ma;

import E9.InterfaceC0819y;
import ya.AbstractC5990d0;

/* renamed from: ma.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4930j extends AbstractC4927g<Double> {
    public C4930j(double d10) {
        super(Double.valueOf(d10));
    }

    @Override // ma.AbstractC4927g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        AbstractC5990d0 abstractC5990d0A = module.g().A();
        kotlin.jvm.internal.p.h(abstractC5990d0A, "getDoubleType(...)");
        return abstractC5990d0A;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return b().doubleValue() + ".toDouble()";
    }
}
