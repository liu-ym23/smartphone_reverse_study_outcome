package z9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import w9.InterfaceC5755n;
import ya.AbstractC5990d0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lw9/n;", "type", Const.INTENT_KEY_APIKEY, "(Lw9/n;)Lw9/n;", "LE9/b;", Const.INTENT_KEY_PKGNAME, "(LE9/b;)LE9/b;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a1 {
    public static final InterfaceC5755n a(InterfaceC5755n type) {
        kotlin.jvm.internal.p.i(type, "type");
        ya.S type2 = ((kotlin.reflect.jvm.internal.s) type).getType();
        if (!(type2 instanceof AbstractC5990d0)) {
            throw new IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + type).toString());
        }
        InterfaceC0799d interfaceC0799dD = type2.H0().d();
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        if (interfaceC0797b != null) {
            AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) type2;
            ya.v0 v0VarJ = b(interfaceC0797b).j();
            kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
            return new kotlin.reflect.jvm.internal.s(ya.V.l(abstractC5990d0, null, v0VarJ, null, false, 26, null), null, 2, null);
        }
        throw new IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
    }

    public static final InterfaceC0797b b(InterfaceC0797b interfaceC0797b) {
        ga.c cVarP = D9.a.f2270a.p(DescriptorUtilsKt.p(interfaceC0797b));
        if (cVarP != null) {
            InterfaceC0797b interfaceC0797bP = DescriptorUtilsKt.m(interfaceC0797b).p(cVarP);
            kotlin.jvm.internal.p.h(interfaceC0797bP, "getBuiltInClassByFqName(...)");
            return interfaceC0797bP;
        }
        throw new IllegalArgumentException("Not a readonly collection: " + interfaceC0797b);
    }
}
