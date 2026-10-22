package ma;

import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import ka.C4828h;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.AbstractC5990d0;
import ya.S;

/* loaded from: classes5.dex */
public final class k extends AbstractC4927g<Pair<? extends ga.b, ? extends ga.e>> {

    /* renamed from: b, reason: collision with root package name */
    public final ga.b f37196b;

    /* renamed from: c, reason: collision with root package name */
    public final ga.e f37197c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ga.b enumClassId, ga.e enumEntryName) {
        super(Y8.j.a(enumClassId, enumEntryName));
        kotlin.jvm.internal.p.i(enumClassId, "enumClassId");
        kotlin.jvm.internal.p.i(enumEntryName, "enumEntryName");
        this.f37196b = enumClassId;
        this.f37197c = enumEntryName;
    }

    @Override // ma.AbstractC4927g
    public S a(InterfaceC0819y module) {
        AbstractC5990d0 abstractC5990d0N;
        kotlin.jvm.internal.p.i(module, "module");
        InterfaceC0797b interfaceC0797bB = FindClassInModuleKt.b(module, this.f37196b);
        if (interfaceC0797bB != null) {
            if (!C4828h.A(interfaceC0797bB)) {
                interfaceC0797bB = null;
            }
            if (interfaceC0797bB != null && (abstractC5990d0N = interfaceC0797bB.n()) != null) {
                return abstractC5990d0N;
            }
        }
        ErrorTypeKind errorTypeKind = ErrorTypeKind.ERROR_ENUM_TYPE;
        String string = this.f37196b.toString();
        String string2 = this.f37197c.toString();
        kotlin.jvm.internal.p.h(string2, "toString(...)");
        return Aa.i.d(errorTypeKind, string, string2);
    }

    public final ga.e c() {
        return this.f37197c;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f37196b.h());
        sb2.append('.');
        sb2.append(this.f37197c);
        return sb2.toString();
    }
}
