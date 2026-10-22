package ma;

import C9.o;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.AbstractC5990d0;
import ya.S;

/* renamed from: ma.C, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4918C extends AbstractC4920E<Long> {
    public C4918C(long j10) {
        super(Long.valueOf(j10));
    }

    @Override // ma.AbstractC4927g
    public S a(InterfaceC0819y module) {
        AbstractC5990d0 abstractC5990d0N;
        kotlin.jvm.internal.p.i(module, "module");
        InterfaceC0797b interfaceC0797bB = FindClassInModuleKt.b(module, o.a.f1859G0);
        return (interfaceC0797bB == null || (abstractC5990d0N = interfaceC0797bB.n()) == null) ? Aa.i.d(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, "ULong") : abstractC5990d0N;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return b().longValue() + ".toULong()";
    }
}
