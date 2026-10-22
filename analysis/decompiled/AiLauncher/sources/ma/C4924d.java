package ma;

import E9.InterfaceC0819y;
import ya.AbstractC5990d0;

/* renamed from: ma.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4924d extends q<Byte> {
    public C4924d(byte b10) {
        super(Byte.valueOf(b10));
    }

    @Override // ma.AbstractC4927g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        AbstractC5990d0 abstractC5990d0U = module.g().u();
        kotlin.jvm.internal.p.h(abstractC5990d0U, "getByteType(...)");
        return abstractC5990d0U;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return b().intValue() + ".toByte()";
    }
}
