package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import C9.i;
import C9.j;
import C9.o;
import Da.d;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.a0;
import E9.b0;
import Ka.t;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import ea.C4018b;
import ea.g;
import ga.b;
import ga.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.a;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import ua.C5602L;
import ua.C5605O;
import ua.C5607Q;
import ua.C5608S;
import ua.C5609T;
import ua.C5610U;
import ua.C5611V;
import ua.C5612W;
import ua.C5613X;
import ua.C5629o;
import wa.C5774P;
import wa.C5777a;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5998h0;
import ya.C6000i0;
import ya.C6004k0;
import ya.C6017x;
import ya.D0;
import ya.S;
import ya.V;
import ya.W;
import ya.r0;
import ya.s0;
import ya.v0;

/* loaded from: classes5.dex */
public final class TypeDeserializer {

    /* renamed from: a, reason: collision with root package name */
    public final C5629o f36006a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeDeserializer f36007b;

    /* renamed from: c, reason: collision with root package name */
    public final String f36008c;

    /* renamed from: d, reason: collision with root package name */
    public final String f36009d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5074l<Integer, InterfaceC0799d> f36010e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5074l<Integer, InterfaceC0799d> f36011f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<Integer, b0> f36012g;

    public TypeDeserializer(C5629o c10, TypeDeserializer typeDeserializer, List<ProtoBuf$TypeParameter> typeParameterProtos, String debugName, String containerPresentableName) {
        Map<Integer, b0> linkedHashMap;
        p.i(c10, "c");
        p.i(typeParameterProtos, "typeParameterProtos");
        p.i(debugName, "debugName");
        p.i(containerPresentableName, "containerPresentableName");
        this.f36006a = c10;
        this.f36007b = typeDeserializer;
        this.f36008c = debugName;
        this.f36009d = containerPresentableName;
        this.f36010e = c10.h().f(new C5608S(this));
        this.f36011f = c10.h().f(new C5609T(this));
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = a.i();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i10 = 0;
            for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(protoBuf$TypeParameter.M()), new C5774P(this.f36006a, protoBuf$TypeParameter, i10));
                i10++;
            }
        }
        this.f36012g = linkedHashMap;
    }

    public static final int A(ProtoBuf$Type it) {
        p.i(it, "it");
        return it.U();
    }

    public static final InterfaceC0799d f(TypeDeserializer typeDeserializer, int i10) {
        return typeDeserializer.g(i10);
    }

    public static final List<ProtoBuf$Type.Argument> p(ProtoBuf$Type protoBuf$Type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf$Type.Argument> listV = protoBuf$Type.V();
        p.h(listV, "getArgumentList(...)");
        List<ProtoBuf$Type.Argument> list = listV;
        ProtoBuf$Type protoBuf$TypeK = g.k(protoBuf$Type, typeDeserializer.f36006a.j());
        List<ProtoBuf$Type.Argument> listP = protoBuf$TypeK != null ? p(protoBuf$TypeK, typeDeserializer) : null;
        if (listP == null) {
            listP = C1173v.m();
        }
        return F.S0(list, listP);
    }

    public static /* synthetic */ AbstractC5990d0 q(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return typeDeserializer.o(protoBuf$Type, z10);
    }

    public static final List r(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type) {
        return typeDeserializer.f36006a.c().d().h(protoBuf$Type, typeDeserializer.f36006a.g());
    }

    public static final InterfaceC0799d v(TypeDeserializer typeDeserializer, int i10) {
        return typeDeserializer.i(i10);
    }

    public static final InterfaceC0797b y(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, int i10) {
        b bVarA = C5602L.a(typeDeserializer.f36006a.g(), i10);
        List<Integer> listE0 = SequencesKt___SequencesKt.e0(SequencesKt___SequencesKt.R(t.q(protoBuf$Type, new C5611V(typeDeserializer)), C5612W.f42583a));
        int iA = SequencesKt___SequencesKt.A(t.q(bVarA, new PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj) {
                return ((b) obj).e();
            }
        }));
        while (listE0.size() < iA) {
            listE0.add(0);
        }
        return typeDeserializer.f36006a.c().r().d(bVarA, listE0);
    }

    public static final ProtoBuf$Type z(TypeDeserializer typeDeserializer, ProtoBuf$Type it) {
        p.i(it, "it");
        return g.k(it, typeDeserializer.f36006a.j());
    }

    public final InterfaceC0799d g(int i10) {
        b bVarA = C5602L.a(this.f36006a.g(), i10);
        return bVarA.i() ? this.f36006a.c().b(bVarA) : FindClassInModuleKt.c(this.f36006a.c().q(), bVarA);
    }

    public final AbstractC5990d0 h(int i10) {
        if (C5602L.a(this.f36006a.g(), i10).i()) {
            return this.f36006a.c().o().a();
        }
        return null;
    }

    public final InterfaceC0799d i(int i10) {
        b bVarA = C5602L.a(this.f36006a.g(), i10);
        if (bVarA.i()) {
            return null;
        }
        return FindClassInModuleKt.f(this.f36006a.c().q(), bVarA);
    }

    public final AbstractC5990d0 j(S s10, S s11) {
        j jVarN = d.n(s10);
        F9.g annotations = s10.getAnnotations();
        S sK = i.k(s10);
        List<S> listE = i.e(s10);
        List listI0 = F.i0(i.m(s10), 1);
        ArrayList arrayList = new ArrayList(C1174w.x(listI0, 10));
        Iterator it = listI0.iterator();
        while (it.hasNext()) {
            arrayList.add(((B0) it.next()).getType());
        }
        return i.b(jVarN, annotations, sK, listE, arrayList, null, s11, true).L0(s10.I0());
    }

    public final AbstractC5990d0 k(s0 s0Var, v0 v0Var, List<? extends B0> list, boolean z10) {
        List<? extends B0> list2;
        AbstractC5990d0 abstractC5990d0L;
        int size;
        int size2 = v0Var.getParameters().size() - list.size();
        if (size2 != 0) {
            abstractC5990d0L = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                v0 v0VarJ = v0Var.g().Y(size).j();
                p.h(v0VarJ, "getTypeConstructor(...)");
                list2 = list;
                abstractC5990d0L = V.m(s0Var, v0VarJ, list2, z10, null, 16, null);
            } else {
                list2 = list;
            }
        } else {
            list2 = list;
            abstractC5990d0L = l(s0Var, v0Var, list2, z10);
        }
        return abstractC5990d0L == null ? Aa.i.f1351a.f(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list2, v0Var, new String[0]) : abstractC5990d0L;
    }

    public final AbstractC5990d0 l(s0 s0Var, v0 v0Var, List<? extends B0> list, boolean z10) {
        AbstractC5990d0 abstractC5990d0M = V.m(s0Var, v0Var, list, z10, null, 16, null);
        if (i.q(abstractC5990d0M)) {
            return t(abstractC5990d0M);
        }
        return null;
    }

    public final List<b0> m() {
        return F.m1(this.f36012g.values());
    }

    public final b0 n(int i10) {
        b0 b0Var = this.f36012g.get(Integer.valueOf(i10));
        if (b0Var != null) {
            return b0Var;
        }
        TypeDeserializer typeDeserializer = this.f36007b;
        if (typeDeserializer != null) {
            return typeDeserializer.n(i10);
        }
        return null;
    }

    public final AbstractC5990d0 o(ProtoBuf$Type proto, boolean z10) {
        AbstractC5990d0 abstractC5990d0C;
        AbstractC5990d0 abstractC5990d0J;
        p.i(proto, "proto");
        AbstractC5990d0 abstractC5990d0H = proto.l0() ? h(proto.W()) : proto.t0() ? h(proto.g0()) : null;
        if (abstractC5990d0H != null) {
            return abstractC5990d0H;
        }
        v0 v0VarX = x(proto);
        if (Aa.i.m(v0VarX.d())) {
            return Aa.i.f1351a.c(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, v0VarX, v0VarX.toString());
        }
        C5777a c5777a = new C5777a(this.f36006a.h(), new C5610U(this, proto));
        s0 s0VarS = s(this.f36006a.c().v(), c5777a, v0VarX, this.f36006a.e());
        List<ProtoBuf$Type.Argument> listP = p(proto, this);
        ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
        int i10 = 0;
        for (Object obj : listP) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            List<b0> parameters = v0VarX.getParameters();
            p.h(parameters, "getParameters(...)");
            arrayList.add(w((b0) F.t0(parameters, i10), (ProtoBuf$Type.Argument) obj));
            i10 = i11;
        }
        List<? extends B0> listM1 = F.m1(arrayList);
        InterfaceC0799d interfaceC0799dD = v0VarX.d();
        if (z10 && (interfaceC0799dD instanceof a0)) {
            AbstractC5990d0 abstractC5990d0C2 = V.c((a0) interfaceC0799dD, listM1);
            abstractC5990d0C = abstractC5990d0C2.L0(W.b(abstractC5990d0C2) || proto.d0()).N0(s(this.f36006a.c().v(), F9.g.f2609m0.a(F.P0(c5777a, abstractC5990d0C2.getAnnotations())), v0VarX, this.f36006a.e()));
        } else if (C4018b.f32374a.d(proto.Z()).booleanValue()) {
            abstractC5990d0C = k(s0VarS, v0VarX, listM1, proto.d0());
        } else {
            AbstractC5990d0 abstractC5990d0M = V.m(s0VarS, v0VarX, listM1, proto.d0(), null, 16, null);
            if (C4018b.f32375b.d(proto.Z()).booleanValue()) {
                abstractC5990d0C = C6017x.a.c(C6017x.f44134d, abstractC5990d0M, true, false, 4, null);
                if (abstractC5990d0C == null) {
                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + abstractC5990d0M + '\'').toString());
                }
            } else {
                abstractC5990d0C = abstractC5990d0M;
            }
        }
        ProtoBuf$Type protoBuf$TypeA = g.a(proto, this.f36006a.j());
        return (protoBuf$TypeA == null || (abstractC5990d0J = C5998h0.j(abstractC5990d0C, o(protoBuf$TypeA, false))) == null) ? abstractC5990d0C : abstractC5990d0J;
    }

    public final s0 s(List<? extends r0> list, F9.g gVar, v0 v0Var, InterfaceC0803h interfaceC0803h) {
        List<? extends r0> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((r0) it.next()).a(gVar, v0Var, interfaceC0803h));
        }
        return s0.f44124b.j(C1174w.z(arrayList));
    }

    public final AbstractC5990d0 t(S s10) {
        S type;
        B0 b02 = (B0) F.E0(i.m(s10));
        if (b02 == null || (type = b02.getType()) == null) {
            return null;
        }
        InterfaceC0799d interfaceC0799dD = type.H0().d();
        c cVarO = interfaceC0799dD != null ? DescriptorUtilsKt.o(interfaceC0799dD) : null;
        if (type.F0().size() != 1 || (!p.d(cVarO, o.f1842w) && !p.d(cVarO, C5613X.f42584a))) {
            return (AbstractC5990d0) s10;
        }
        S type2 = ((B0) F.X0(type.F0())).getType();
        p.h(type2, "getType(...)");
        InterfaceC0803h interfaceC0803hE = this.f36006a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = interfaceC0803hE instanceof kotlin.reflect.jvm.internal.impl.descriptors.a ? (kotlin.reflect.jvm.internal.impl.descriptors.a) interfaceC0803hE : null;
        return p.d(aVar != null ? DescriptorUtilsKt.k(aVar) : null, C5607Q.f42576a) ? j(s10, type2) : j(s10, type2);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f36008c);
        if (this.f36007b == null) {
            str = "";
        } else {
            str = ". Child of " + this.f36007b.f36008c;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final S u(ProtoBuf$Type proto) {
        p.i(proto, "proto");
        if (!proto.n0()) {
            return o(proto, true);
        }
        String string = this.f36006a.g().getString(proto.a0());
        AbstractC5990d0 abstractC5990d0Q = q(this, proto, false, 2, null);
        ProtoBuf$Type protoBuf$TypeF = g.f(proto, this.f36006a.j());
        p.f(protoBuf$TypeF);
        return this.f36006a.c().m().a(proto, string, abstractC5990d0Q, q(this, protoBuf$TypeF, false, 2, null));
    }

    public final B0 w(b0 b0Var, ProtoBuf$Type.Argument argument) {
        if (argument.v() == ProtoBuf$Type.Argument.Projection.STAR) {
            return b0Var == null ? new C6000i0(this.f36006a.c().q().g()) : new C6004k0(b0Var);
        }
        C5605O c5605o = C5605O.f42564a;
        ProtoBuf$Type.Argument.Projection projectionV = argument.v();
        p.h(projectionV, "getProjection(...)");
        Variance varianceC = c5605o.c(projectionV);
        ProtoBuf$Type protoBuf$TypeQ = g.q(argument, this.f36006a.j());
        return protoBuf$TypeQ == null ? new D0(Aa.i.d(ErrorTypeKind.NO_RECORDED_TYPE, argument.toString())) : new D0(varianceC, u(protoBuf$TypeQ));
    }

    public final v0 x(ProtoBuf$Type protoBuf$Type) {
        InterfaceC0799d interfaceC0799dInvoke;
        Object next;
        if (protoBuf$Type.l0()) {
            interfaceC0799dInvoke = this.f36010e.invoke(Integer.valueOf(protoBuf$Type.W()));
            if (interfaceC0799dInvoke == null) {
                interfaceC0799dInvoke = y(this, protoBuf$Type, protoBuf$Type.W());
            }
        } else if (protoBuf$Type.u0()) {
            interfaceC0799dInvoke = n(protoBuf$Type.h0());
            if (interfaceC0799dInvoke == null) {
                return Aa.i.f1351a.e(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, String.valueOf(protoBuf$Type.h0()), this.f36009d);
            }
        } else if (protoBuf$Type.v0()) {
            String string = this.f36006a.g().getString(protoBuf$Type.i0());
            Iterator<T> it = m().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.d(((b0) next).getName().b(), string)) {
                    break;
                }
            }
            interfaceC0799dInvoke = (b0) next;
            if (interfaceC0799dInvoke == null) {
                return Aa.i.f1351a.e(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, string, this.f36006a.e().toString());
            }
        } else {
            if (!protoBuf$Type.t0()) {
                return Aa.i.f1351a.e(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
            }
            interfaceC0799dInvoke = this.f36011f.invoke(Integer.valueOf(protoBuf$Type.g0()));
            if (interfaceC0799dInvoke == null) {
                interfaceC0799dInvoke = y(this, protoBuf$Type, protoBuf$Type.g0());
            }
        }
        v0 v0VarJ = interfaceC0799dInvoke.j();
        p.h(v0VarJ, "getTypeConstructor(...)");
        return v0VarJ;
    }
}
