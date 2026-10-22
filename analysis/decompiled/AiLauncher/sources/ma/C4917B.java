package ma;

import C9.o;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.AbstractC5990d0;
import ya.S;

/* renamed from: ma.B, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4917B extends AbstractC4920E<Integer> {
    public C4917B(int i10) {
        super(Integer.valueOf(i10));
    }

    @Override // ma.AbstractC4927g
    public S a(InterfaceC0819y module) {
        AbstractC5990d0 abstractC5990d0N;
        kotlin.jvm.internal.p.i(module, "module");
        InterfaceC0797b interfaceC0797bB = FindClassInModuleKt.b(module, o.a.f1857F0);
        return (interfaceC0797bB == null || (abstractC5990d0N = interfaceC0797bB.n()) == null) ? Aa.i.d(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, "UInt") : abstractC5990d0N;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return b().intValue() + ".toUInt()";
    }
}
