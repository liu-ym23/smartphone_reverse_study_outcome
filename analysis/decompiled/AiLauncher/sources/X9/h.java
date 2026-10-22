package X9;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.b0;
import Z8.C1172u;
import Z8.C1174w;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ra.InterfaceC5238k;
import ya.A0;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5971F;
import ya.C5977L;
import ya.D0;
import ya.E0;
import ya.S;
import ya.V;
import ya.W;
import ya.s0;
import ya.v0;

/* loaded from: classes5.dex */
public final class h extends E0 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f6887e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final X9.a f6888f;

    /* renamed from: g, reason: collision with root package name */
    public static final X9.a f6889g;

    /* renamed from: c, reason: collision with root package name */
    public final f f6890c;

    /* renamed from: d, reason: collision with root package name */
    public final A0 f6891d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        f6888f = b.b(typeUsage, false, true, null, 5, null).l(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        f6889g = b.b(typeUsage, false, true, null, 5, null).l(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(A0 a02) {
        f fVar = new f();
        this.f6890c = fVar;
        if (a02 == null) {
            a02 = new A0(fVar, null, 2, 0 == true ? 1 : 0);
        }
        this.f6891d = a02;
    }

    public static final AbstractC5990d0 k(InterfaceC0797b interfaceC0797b, h hVar, AbstractC5990d0 abstractC5990d0, X9.a aVar, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        InterfaceC0797b interfaceC0797bB;
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        ga.b bVarN = DescriptorUtilsKt.n(interfaceC0797b);
        if (bVarN == null || (interfaceC0797bB = kotlinTypeRefiner.b(bVarN)) == null || p.d(interfaceC0797bB, interfaceC0797b)) {
            return null;
        }
        return hVar.j(abstractC5990d0, interfaceC0797bB, aVar).e();
    }

    public static /* synthetic */ S m(h hVar, S s10, X9.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new X9.a(TypeUsage.COMMON, null, false, false, null, null, 62, null);
        }
        return hVar.l(s10, aVar);
    }

    @Override // ya.E0
    public boolean f() {
        return false;
    }

    public final Pair<AbstractC5990d0, Boolean> j(AbstractC5990d0 abstractC5990d0, InterfaceC0797b interfaceC0797b, X9.a aVar) {
        if (abstractC5990d0.H0().getParameters().isEmpty()) {
            return Y8.j.a(abstractC5990d0, Boolean.FALSE);
        }
        if (C9.j.d0(abstractC5990d0)) {
            B0 b02 = abstractC5990d0.F0().get(0);
            Variance varianceC = b02.c();
            S type = b02.getType();
            p.h(type, "getType(...)");
            return Y8.j.a(V.m(abstractC5990d0.G0(), abstractC5990d0.H0(), C1172u.e(new D0(varianceC, l(type, aVar))), abstractC5990d0.I0(), null, 16, null), Boolean.FALSE);
        }
        if (W.a(abstractC5990d0)) {
            return Y8.j.a(Aa.i.d(ErrorTypeKind.ERROR_RAW_TYPE, abstractC5990d0.H0().toString()), Boolean.FALSE);
        }
        InterfaceC5238k interfaceC5238kK0 = interfaceC0797b.k0(this);
        p.h(interfaceC5238kK0, "getMemberScope(...)");
        s0 s0VarG0 = abstractC5990d0.G0();
        v0 v0VarJ = interfaceC0797b.j();
        p.h(v0VarJ, "getTypeConstructor(...)");
        List<b0> parameters = interfaceC0797b.j().getParameters();
        p.h(parameters, "getParameters(...)");
        List<b0> list = parameters;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (b0 b0Var : list) {
            f fVar = this.f6890c;
            p.f(b0Var);
            arrayList.add(C5971F.b(fVar, b0Var, aVar, this.f6891d, null, 8, null));
        }
        return Y8.j.a(V.p(s0VarG0, v0VarJ, arrayList, abstractC5990d0.I0(), interfaceC5238kK0, new g(interfaceC0797b, this, abstractC5990d0, aVar)), Boolean.TRUE);
    }

    public final S l(S s10, X9.a aVar) {
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD instanceof b0) {
            return l(this.f6891d.e((b0) interfaceC0799dD, aVar.j(true)), aVar);
        }
        if (!(interfaceC0799dD instanceof InterfaceC0797b)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + interfaceC0799dD).toString());
        }
        InterfaceC0799d interfaceC0799dD2 = C5977L.d(s10).H0().d();
        if (interfaceC0799dD2 instanceof InterfaceC0797b) {
            Pair<AbstractC5990d0, Boolean> pairJ = j(C5977L.c(s10), (InterfaceC0797b) interfaceC0799dD, f6888f);
            AbstractC5990d0 abstractC5990d0A = pairJ.a();
            boolean zBooleanValue = pairJ.b().booleanValue();
            Pair<AbstractC5990d0, Boolean> pairJ2 = j(C5977L.d(s10), (InterfaceC0797b) interfaceC0799dD2, f6889g);
            AbstractC5990d0 abstractC5990d0A2 = pairJ2.a();
            return (zBooleanValue || pairJ2.b().booleanValue()) ? new j(abstractC5990d0A, abstractC5990d0A2) : V.e(abstractC5990d0A, abstractC5990d0A2);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + interfaceC0799dD2 + "\" while for lower it's \"" + interfaceC0799dD + JsonFactory.DEFAULT_QUOTE_CHAR).toString());
    }

    @Override // ya.E0
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public D0 e(S key) {
        p.i(key, "key");
        return new D0(m(this, key, null, 2, null));
    }

    public /* synthetic */ h(A0 a02, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : a02);
    }
}
