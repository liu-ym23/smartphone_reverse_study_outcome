package ma;

import E9.InterfaceC0819y;
import com.fasterxml.jackson.core.JsonFactory;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public final class x extends AbstractC4927g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String value) {
        super(value);
        kotlin.jvm.internal.p.i(value, "value");
    }

    @Override // ma.AbstractC4927g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        AbstractC5990d0 abstractC5990d0X = module.g().X();
        kotlin.jvm.internal.p.h(abstractC5990d0X, "getStringType(...)");
        return abstractC5990d0X;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        return JsonFactory.DEFAULT_QUOTE_CHAR + b() + JsonFactory.DEFAULT_QUOTE_CHAR;
    }
}
