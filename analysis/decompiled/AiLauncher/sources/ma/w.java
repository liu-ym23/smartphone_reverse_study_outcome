package ma;

import E9.InterfaceC0819y;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final class w extends q<Short> {
    public w(short s10) {
        super(Short.valueOf(s10));
    }

    @Override // ma.AbstractC4927g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        AbstractC5990d0 abstractC5990d0U = module.g().U();
        kotlin.jvm.internal.p.h(abstractC5990d0U, "getShortType(...)");
        return abstractC5990d0U;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return b().intValue() + ".toShort()";
    }
}
