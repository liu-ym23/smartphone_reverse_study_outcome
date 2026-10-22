package ya;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import Z8.C1173v;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;
import ya.p0;

/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public static final V f44055a = new V();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5074l<kotlin.reflect.jvm.internal.impl.types.checker.c, AbstractC5990d0> f44056b = a.f44057a;

    public static final class a implements InterfaceC5074l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44057a = new a();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
            kotlin.jvm.internal.p.i(cVar, "<unused var>");
            return null;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC5990d0 f44058a;

        /* renamed from: b, reason: collision with root package name */
        public final v0 f44059b;

        public b(AbstractC5990d0 abstractC5990d0, v0 v0Var) {
            this.f44058a = abstractC5990d0;
            this.f44059b = v0Var;
        }

        public final AbstractC5990d0 a() {
            return this.f44058a;
        }

        public final v0 b() {
            return this.f44059b;
        }
    }

    public static final AbstractC5990d0 c(E9.a0 a0Var, List<? extends B0> arguments) {
        kotlin.jvm.internal.p.i(a0Var, "<this>");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        return new n0(p0.a.f44120a, false).i(o0.f44115e.a(null, a0Var, arguments), s0.f44124b.k());
    }

    public static final K0 e(AbstractC5990d0 lowerBound, AbstractC5990d0 upperBound) {
        kotlin.jvm.internal.p.i(lowerBound, "lowerBound");
        kotlin.jvm.internal.p.i(upperBound, "upperBound");
        return kotlin.jvm.internal.p.d(lowerBound, upperBound) ? lowerBound : new C5975J(lowerBound, upperBound);
    }

    public static final AbstractC5990d0 f(s0 attributes, IntegerLiteralTypeConstructor constructor, boolean z10) {
        kotlin.jvm.internal.p.i(attributes, "attributes");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        return o(attributes, constructor, C1173v.m(), z10, Aa.i.a(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }

    public static final AbstractC5990d0 h(s0 attributes, InterfaceC0797b descriptor, List<? extends B0> arguments) {
        kotlin.jvm.internal.p.i(attributes, "attributes");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        v0 v0VarJ = descriptor.j();
        kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
        return m(attributes, v0VarJ, arguments, false, null, 16, null);
    }

    public static final AbstractC5990d0 i(AbstractC5990d0 baseType, s0 annotations, v0 constructor, List<? extends B0> arguments, boolean z10) {
        kotlin.jvm.internal.p.i(baseType, "baseType");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        return m(annotations, constructor, arguments, z10, null, 16, null);
    }

    public static final AbstractC5990d0 j(s0 attributes, v0 constructor, List<? extends B0> arguments, boolean z10) {
        kotlin.jvm.internal.p.i(attributes, "attributes");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        return m(attributes, constructor, arguments, z10, null, 16, null);
    }

    public static final AbstractC5990d0 k(s0 attributes, v0 constructor, List<? extends B0> arguments, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        kotlin.jvm.internal.p.i(attributes, "attributes");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        if (!attributes.isEmpty() || !arguments.isEmpty() || z10 || constructor.d() == null) {
            return p(attributes, constructor, arguments, z10, f44055a.d(constructor, arguments, cVar), new T(constructor, arguments, attributes, z10));
        }
        InterfaceC0799d interfaceC0799dD = constructor.d();
        kotlin.jvm.internal.p.f(interfaceC0799dD);
        AbstractC5990d0 abstractC5990d0N = interfaceC0799dD.n();
        kotlin.jvm.internal.p.h(abstractC5990d0N, "getDefaultType(...)");
        return abstractC5990d0N;
    }

    public static /* synthetic */ AbstractC5990d0 l(AbstractC5990d0 abstractC5990d0, s0 s0Var, v0 v0Var, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            s0Var = abstractC5990d0.G0();
        }
        if ((i10 & 4) != 0) {
            v0Var = abstractC5990d0.H0();
        }
        if ((i10 & 8) != 0) {
            list = abstractC5990d0.F0();
        }
        if ((i10 & 16) != 0) {
            z10 = abstractC5990d0.I0();
        }
        return i(abstractC5990d0, s0Var, v0Var, list, z10);
    }

    public static /* synthetic */ AbstractC5990d0 m(s0 s0Var, v0 v0Var, List list, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.c cVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            cVar = null;
        }
        return k(s0Var, v0Var, list, z10, cVar);
    }

    public static final AbstractC5990d0 n(v0 v0Var, List list, s0 s0Var, boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.c refiner) {
        kotlin.jvm.internal.p.i(refiner, "refiner");
        b bVarG = f44055a.g(v0Var, refiner, list);
        if (bVarG == null) {
            return null;
        }
        AbstractC5990d0 abstractC5990d0A = bVarG.a();
        if (abstractC5990d0A != null) {
            return abstractC5990d0A;
        }
        v0 v0VarB = bVarG.b();
        kotlin.jvm.internal.p.f(v0VarB);
        return k(s0Var, v0VarB, list, z10, refiner);
    }

    public static final AbstractC5990d0 o(s0 attributes, v0 constructor, List<? extends B0> arguments, boolean z10, InterfaceC5238k memberScope) {
        kotlin.jvm.internal.p.i(attributes, "attributes");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        kotlin.jvm.internal.p.i(memberScope, "memberScope");
        C5992e0 c5992e0 = new C5992e0(constructor, arguments, z10, memberScope, new U(constructor, arguments, attributes, z10, memberScope));
        return attributes.isEmpty() ? c5992e0 : new C5994f0(c5992e0, attributes);
    }

    public static final AbstractC5990d0 p(s0 attributes, v0 constructor, List<? extends B0> arguments, boolean z10, InterfaceC5238k memberScope, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.types.checker.c, ? extends AbstractC5990d0> refinedTypeFactory) {
        kotlin.jvm.internal.p.i(attributes, "attributes");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        kotlin.jvm.internal.p.i(memberScope, "memberScope");
        kotlin.jvm.internal.p.i(refinedTypeFactory, "refinedTypeFactory");
        C5992e0 c5992e0 = new C5992e0(constructor, arguments, z10, memberScope, refinedTypeFactory);
        return attributes.isEmpty() ? c5992e0 : new C5994f0(c5992e0, attributes);
    }

    public static final AbstractC5990d0 q(v0 v0Var, List list, s0 s0Var, boolean z10, InterfaceC5238k interfaceC5238k, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        b bVarG = f44055a.g(v0Var, kotlinTypeRefiner, list);
        if (bVarG == null) {
            return null;
        }
        AbstractC5990d0 abstractC5990d0A = bVarG.a();
        if (abstractC5990d0A != null) {
            return abstractC5990d0A;
        }
        v0 v0VarB = bVarG.b();
        kotlin.jvm.internal.p.f(v0VarB);
        return o(s0Var, v0VarB, list, z10, interfaceC5238k);
    }

    public final InterfaceC5238k d(v0 v0Var, List<? extends B0> list, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        InterfaceC0799d interfaceC0799dD = v0Var.d();
        if (interfaceC0799dD instanceof E9.b0) {
            return ((E9.b0) interfaceC0799dD).n().m();
        }
        if (interfaceC0799dD instanceof InterfaceC0797b) {
            if (cVar == null) {
                cVar = DescriptorUtilsKt.r(DescriptorUtilsKt.s(interfaceC0799dD));
            }
            return list.isEmpty() ? H9.A.b((InterfaceC0797b) interfaceC0799dD, cVar) : H9.A.a((InterfaceC0797b) interfaceC0799dD, w0.f44131c.b(v0Var, list), cVar);
        }
        if (interfaceC0799dD instanceof E9.a0) {
            ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
            String string = ((E9.a0) interfaceC0799dD).getName().toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            return Aa.i.a(errorScopeKind, true, string);
        }
        if (v0Var instanceof C5982Q) {
            return ((C5982Q) v0Var).k();
        }
        throw new IllegalStateException("Unsupported classifier: " + interfaceC0799dD + " for constructor: " + v0Var);
    }

    public final b g(v0 v0Var, kotlin.reflect.jvm.internal.impl.types.checker.c cVar, List<? extends B0> list) {
        InterfaceC0799d interfaceC0799dF;
        InterfaceC0799d interfaceC0799dD = v0Var.d();
        if (interfaceC0799dD == null || (interfaceC0799dF = cVar.f(interfaceC0799dD)) == null) {
            return null;
        }
        if (interfaceC0799dF instanceof E9.a0) {
            return new b(c((E9.a0) interfaceC0799dF, list), null);
        }
        v0 v0VarA = interfaceC0799dF.j().a(cVar);
        kotlin.jvm.internal.p.h(v0VarA, "refine(...)");
        return new b(null, v0VarA);
    }
}
