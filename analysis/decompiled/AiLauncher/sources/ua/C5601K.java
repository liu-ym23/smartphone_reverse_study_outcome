package ua;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.a0;
import E9.b0;
import E9.i0;
import F9.g;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import ea.C4018b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ka.C4827g;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import ma.AbstractC4927g;
import ua.AbstractC5604N;
import wa.C5770L;
import wa.C5771M;
import wa.C5772N;
import wa.C5775Q;
import wa.C5777a;
import wa.C5779c;
import xa.InterfaceC5866i;

/* renamed from: ua.K, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5601K {

    /* renamed from: a, reason: collision with root package name */
    public final C5629o f42548a;

    /* renamed from: b, reason: collision with root package name */
    public final C5620f f42549b;

    public C5601K(C5629o c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        this.f42548a = c10;
        this.f42549b = new C5620f(c10.c().q(), c10.c().r());
    }

    public static final AbstractC4927g A(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        AbstractC5604N abstractC5604NJ = c5601k.j(c5601k.f42548a.e());
        kotlin.jvm.internal.p.f(abstractC5604NJ);
        InterfaceC5618d<F9.c, AbstractC4927g<?>> interfaceC5618dD = c5601k.f42548a.c().d();
        ya.S returnType = c5770l.getReturnType();
        kotlin.jvm.internal.p.h(returnType, "getReturnType(...)");
        return interfaceC5618dD.i(abstractC5604NJ, protoBuf$Property, returnType);
    }

    public static final InterfaceC5866i B(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        return c5601k.f42548a.h().h(new C5600J(c5601k, protoBuf$Property, c5770l));
    }

    public static final AbstractC4927g C(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        AbstractC5604N abstractC5604NJ = c5601k.j(c5601k.f42548a.e());
        kotlin.jvm.internal.p.f(abstractC5604NJ);
        InterfaceC5618d<F9.c, AbstractC4927g<?>> interfaceC5618dD = c5601k.f42548a.c().d();
        ya.S returnType = c5770l.getReturnType();
        kotlin.jvm.internal.p.h(returnType, "getReturnType(...)");
        return interfaceC5618dD.g(abstractC5604NJ, protoBuf$Property, returnType);
    }

    public static final List F(C5601K c5601k, AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return Z8.F.m1(c5601k.f42548a.c().d().k(abstractC5604N, hVar, annotatedCallableKind, i10, protoBuf$ValueParameter));
    }

    public static final List l(C5601K c5601k, AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return Z8.F.m1(c5601k.f42548a.c().d().j(abstractC5604N, hVar, annotatedCallableKind, i10, protoBuf$ValueParameter));
    }

    public static final List n(C5601K c5601k, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        AbstractC5604N abstractC5604NJ = c5601k.j(c5601k.f42548a.e());
        List listM1 = abstractC5604NJ != null ? Z8.F.m1(c5601k.f42548a.c().d().m(abstractC5604NJ, hVar, annotatedCallableKind)) : null;
        return listM1 == null ? C1173v.m() : listM1;
    }

    public static final List q(C5601K c5601k, boolean z10, ProtoBuf$Property protoBuf$Property) {
        AbstractC5604N abstractC5604NJ = c5601k.j(c5601k.f42548a.e());
        List listM1 = abstractC5604NJ != null ? z10 ? Z8.F.m1(c5601k.f42548a.c().d().b(abstractC5604NJ, protoBuf$Property)) : Z8.F.m1(c5601k.f42548a.c().d().d(abstractC5604NJ, protoBuf$Property)) : null;
        return listM1 == null ? C1173v.m() : listM1;
    }

    public static final List s(C5601K c5601k, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        AbstractC5604N abstractC5604NJ = c5601k.j(c5601k.f42548a.e());
        List<F9.c> listA = abstractC5604NJ != null ? c5601k.f42548a.c().d().a(abstractC5604NJ, hVar, annotatedCallableKind) : null;
        return listA == null ? C1173v.m() : listA;
    }

    public static /* synthetic */ E9.O y(C5601K c5601k, ProtoBuf$Property protoBuf$Property, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c5601k.x(protoBuf$Property, z10);
    }

    public static final InterfaceC5866i z(C5601K c5601k, ProtoBuf$Property protoBuf$Property, C5770L c5770l) {
        return c5601k.f42548a.h().h(new C5599I(c5601k, protoBuf$Property, c5770l));
    }

    public final a0 D(ProtoBuf$TypeAlias proto) {
        kotlin.jvm.internal.p.i(proto, "proto");
        g.a aVar = F9.g.f2609m0;
        List<ProtoBuf$Annotation> listS = proto.S();
        kotlin.jvm.internal.p.h(listS, "getAnnotationList(...)");
        List<ProtoBuf$Annotation> list = listS;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            C5620f c5620f = this.f42549b;
            kotlin.jvm.internal.p.f(protoBuf$Annotation);
            arrayList.add(c5620f.a(protoBuf$Annotation, this.f42548a.g()));
        }
        C5772N c5772n = new C5772N(this.f42548a.h(), this.f42548a.e(), aVar.a(arrayList), C5602L.b(this.f42548a.g(), proto.a0()), C5606P.a(C5605O.f42564a, C4018b.f32377d.d(proto.Z())), proto, this.f42548a.g(), this.f42548a.j(), this.f42548a.k(), this.f42548a.d());
        C5629o c5629o = this.f42548a;
        List<ProtoBuf$TypeParameter> listD0 = proto.d0();
        kotlin.jvm.internal.p.h(listD0, "getTypeParameterList(...)");
        C5629o c5629oB = C5629o.b(c5629o, c5772n, listD0, null, null, null, null, 60, null);
        c5772n.Q0(c5629oB.i().m(), c5629oB.i().o(ea.g.s(proto, this.f42548a.j()), false), c5629oB.i().o(ea.g.e(proto, this.f42548a.j()), false));
        return c5772n;
    }

    public final List<i0> E(List<ProtoBuf$ValueParameter> list, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        InterfaceC0803h interfaceC0803hE = this.f42548a.e();
        kotlin.jvm.internal.p.g(interfaceC0803hE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) interfaceC0803hE;
        InterfaceC0803h interfaceC0803hB = aVar.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        AbstractC5604N abstractC5604NJ = j(interfaceC0803hB);
        List<ProtoBuf$ValueParameter> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        int i10 = 0;
        for (Object obj : list2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) obj;
            int iR = protoBuf$ValueParameter.Y() ? protoBuf$ValueParameter.R() : 0;
            F9.g gVarB = (abstractC5604NJ == null || !C4018b.f32376c.d(iR).booleanValue()) ? F9.g.f2609m0.b() : new C5775Q(this.f42548a.h(), new C5597G(this, abstractC5604NJ, hVar, annotatedCallableKind, i10, protoBuf$ValueParameter));
            ga.e eVarB = C5602L.b(this.f42548a.g(), protoBuf$ValueParameter.S());
            ya.S sU = this.f42548a.i().u(ea.g.r(protoBuf$ValueParameter, this.f42548a.j()));
            Boolean boolD = C4018b.f32365K.d(iR);
            kotlin.jvm.internal.p.h(boolD, "get(...)");
            boolean zBooleanValue = boolD.booleanValue();
            Boolean boolD2 = C4018b.f32366L.d(iR);
            kotlin.jvm.internal.p.h(boolD2, "get(...)");
            boolean zBooleanValue2 = boolD2.booleanValue();
            Boolean boolD3 = C4018b.f32367M.d(iR);
            kotlin.jvm.internal.p.h(boolD3, "get(...)");
            boolean zBooleanValue3 = boolD3.booleanValue();
            ProtoBuf$Type protoBuf$TypeU = ea.g.u(protoBuf$ValueParameter, this.f42548a.j());
            ya.S sU2 = protoBuf$TypeU != null ? this.f42548a.i().u(protoBuf$TypeU) : null;
            E9.W NO_SOURCE = E9.W.f2444a;
            kotlin.jvm.internal.p.h(NO_SOURCE, "NO_SOURCE");
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = aVar;
            arrayList.add(new H9.V(aVar2, null, i10, gVarB, eVarB, sU, zBooleanValue, zBooleanValue2, zBooleanValue3, sU2, NO_SOURCE));
            aVar = aVar2;
            i10 = i11;
        }
        return Z8.F.m1(arrayList);
    }

    public final AbstractC5604N j(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h instanceof E9.E) {
            return new AbstractC5604N.b(((E9.E) interfaceC0803h).f(), this.f42548a.g(), this.f42548a.j(), this.f42548a.d());
        }
        if (interfaceC0803h instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) interfaceC0803h).c1();
        }
        return null;
    }

    public final List<E9.S> k(List<ProtoBuf$Type> list, List<ProtoBuf$ValueParameter> list2, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        InterfaceC0803h interfaceC0803hE = this.f42548a.e();
        kotlin.jvm.internal.p.g(interfaceC0803hE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) interfaceC0803hE;
        InterfaceC0803h interfaceC0803hB = aVar.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        AbstractC5604N abstractC5604NJ = j(interfaceC0803hB);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) obj;
            ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) Z8.F.t0(list2, i10);
            E9.S sB = C4827g.b(aVar, this.f42548a.i().u(protoBuf$Type), null, (abstractC5604NJ == null || !C4018b.f32376c.d((protoBuf$ValueParameter == null || !protoBuf$ValueParameter.Y()) ? 0 : protoBuf$ValueParameter.R()).booleanValue()) ? F9.g.f2609m0.b() : new C5775Q(this.f42548a.h(), new C5598H(this, abstractC5604NJ, hVar, annotatedCallableKind, i10, protoBuf$ValueParameter)), i10);
            if (sB != null) {
                arrayList.add(sB);
            }
            i10 = i11;
        }
        return arrayList;
    }

    public final F9.g m(kotlin.reflect.jvm.internal.impl.protobuf.h hVar, int i10, AnnotatedCallableKind annotatedCallableKind) {
        return !C4018b.f32376c.d(i10).booleanValue() ? F9.g.f2609m0.b() : new C5775Q(this.f42548a.h(), new C5594D(this, hVar, annotatedCallableKind));
    }

    public final E9.S o() {
        InterfaceC0803h interfaceC0803hE = this.f42548a.e();
        InterfaceC0797b interfaceC0797b = interfaceC0803hE instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hE : null;
        if (interfaceC0797b != null) {
            return interfaceC0797b.D0();
        }
        return null;
    }

    public final F9.g p(ProtoBuf$Property protoBuf$Property, boolean z10) {
        return !C4018b.f32376c.d(protoBuf$Property.H0()).booleanValue() ? F9.g.f2609m0.b() : new C5775Q(this.f42548a.h(), new C5595E(this, z10, protoBuf$Property));
    }

    public final F9.g r(kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        return new C5777a(this.f42548a.h(), new C5596F(this, hVar, annotatedCallableKind));
    }

    public final void t(C5771M c5771m, E9.S s10, E9.S s11, List<? extends E9.S> list, List<? extends b0> list2, List<? extends i0> list3, ya.S s12, Modality modality, AbstractC0811p abstractC0811p, Map<? extends a.InterfaceC0437a<?>, ?> map) {
        c5771m.i1(s10, s11, list, list2, list3, s12, modality, abstractC0811p, map);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.b u(ProtoBuf$Constructor proto, boolean z10) {
        kotlin.jvm.internal.p.i(proto, "proto");
        InterfaceC0803h interfaceC0803hE = this.f42548a.e();
        kotlin.jvm.internal.p.g(interfaceC0803hE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        InterfaceC0797b interfaceC0797b = (InterfaceC0797b) interfaceC0803hE;
        int iS = proto.S();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        C5779c c5779c = new C5779c(interfaceC0797b, null, m(proto, iS, annotatedCallableKind), z10, CallableMemberDescriptor.Kind.DECLARATION, proto, this.f42548a.g(), this.f42548a.j(), this.f42548a.k(), this.f42548a.d(), null, 1024, null);
        C5601K c5601kF = C5629o.b(this.f42548a, c5779c, C1173v.m(), null, null, null, null, 60, null).f();
        List<ProtoBuf$ValueParameter> listV = proto.V();
        kotlin.jvm.internal.p.h(listV, "getValueParameterList(...)");
        c5779c.k1(c5601kF.E(listV, proto, annotatedCallableKind), C5606P.a(C5605O.f42564a, C4018b.f32377d.d(proto.S())));
        c5779c.a1(interfaceC0797b.n());
        c5779c.Q0(interfaceC0797b.e0());
        c5779c.S0(!C4018b.f32388o.d(proto.S()).booleanValue());
        return c5779c;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.g v(ProtoBuf$Function proto) {
        ya.S sU;
        kotlin.jvm.internal.p.i(proto, "proto");
        int iV0 = proto.L0() ? proto.v0() : w(proto.x0());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        F9.g gVarM = m(proto, iV0, annotatedCallableKind);
        F9.g gVarR = ea.g.g(proto) ? r(proto, annotatedCallableKind) : F9.g.f2609m0.b();
        ea.j jVarB = kotlin.jvm.internal.p.d(DescriptorUtilsKt.o(this.f42548a.e()).b(C5602L.b(this.f42548a.g(), proto.w0())), C5607Q.f42576a) ? ea.j.f32424b.b() : this.f42548a.k();
        InterfaceC0803h interfaceC0803hE = this.f42548a.e();
        ga.e eVarB = C5602L.b(this.f42548a.g(), proto.w0());
        C5605O c5605o = C5605O.f42564a;
        F9.g gVar = gVarR;
        C5771M c5771m = new C5771M(interfaceC0803hE, null, gVarM, eVarB, C5606P.b(c5605o, C4018b.f32390q.d(iV0)), proto, this.f42548a.g(), this.f42548a.j(), jVarB, this.f42548a.d(), null, 1024, null);
        C5629o c5629o = this.f42548a;
        List<ProtoBuf$TypeParameter> listE0 = proto.E0();
        kotlin.jvm.internal.p.h(listE0, "getTypeParameterList(...)");
        C5629o c5629oB = C5629o.b(c5629o, c5771m, listE0, null, null, null, null, 60, null);
        ProtoBuf$Type protoBuf$TypeL = ea.g.l(proto, this.f42548a.j());
        E9.S sI = (protoBuf$TypeL == null || (sU = c5629oB.i().u(protoBuf$TypeL)) == null) ? null : C4827g.i(c5771m, sU, gVar);
        E9.S sO = o();
        C5601K c5601kF = c5629oB.f();
        List<ProtoBuf$Type> listC = ea.g.c(proto, this.f42548a.j());
        List<ProtoBuf$ValueParameter> listK0 = proto.k0();
        kotlin.jvm.internal.p.h(listK0, "getContextParameterList(...)");
        List<E9.S> listK = c5601kF.k(listC, listK0, proto, annotatedCallableKind);
        List<b0> listM = c5629oB.i().m();
        C5601K c5601kF2 = c5629oB.f();
        List<ProtoBuf$ValueParameter> listI0 = proto.I0();
        kotlin.jvm.internal.p.h(listI0, "getValueParameterList(...)");
        t(c5771m, sI, sO, listK, listM, c5601kF2.E(listI0, proto, annotatedCallableKind), c5629oB.i().u(ea.g.n(proto, this.f42548a.j())), c5605o.b(C4018b.f32378e.d(iV0)), C5606P.a(c5605o, C4018b.f32377d.d(iV0)), kotlin.collections.a.i());
        Boolean boolD = C4018b.f32391r.d(iV0);
        kotlin.jvm.internal.p.h(boolD, "get(...)");
        c5771m.Z0(boolD.booleanValue());
        Boolean boolD2 = C4018b.f32392s.d(iV0);
        kotlin.jvm.internal.p.h(boolD2, "get(...)");
        c5771m.W0(boolD2.booleanValue());
        Boolean boolD3 = C4018b.f32395v.d(iV0);
        kotlin.jvm.internal.p.h(boolD3, "get(...)");
        c5771m.R0(boolD3.booleanValue());
        Boolean boolD4 = C4018b.f32393t.d(iV0);
        kotlin.jvm.internal.p.h(boolD4, "get(...)");
        c5771m.Y0(boolD4.booleanValue());
        Boolean boolD5 = C4018b.f32394u.d(iV0);
        kotlin.jvm.internal.p.h(boolD5, "get(...)");
        c5771m.c1(boolD5.booleanValue());
        Boolean boolD6 = C4018b.f32396w.d(iV0);
        kotlin.jvm.internal.p.h(boolD6, "get(...)");
        c5771m.b1(boolD6.booleanValue());
        Boolean boolD7 = C4018b.f32397x.d(iV0);
        kotlin.jvm.internal.p.h(boolD7, "get(...)");
        c5771m.Q0(boolD7.booleanValue());
        c5771m.S0(!C4018b.f32398y.d(iV0).booleanValue());
        Pair<a.InterfaceC0437a<?>, Object> pairA = this.f42548a.c().h().a(proto, c5771m, this.f42548a.j(), c5629oB.i());
        if (pairA != null) {
            c5771m.O0(pairA.e(), pairA.f());
        }
        return c5771m;
    }

    public final int w(int i10) {
        return (i10 & 63) + ((i10 >> 8) << 6);
    }

    public final E9.O x(ProtoBuf$Property proto, boolean z10) {
        F9.g gVarM;
        C4018b.d<ProtoBuf$Visibility> dVar;
        C4018b.d<ProtoBuf$Modality> dVar2;
        C5605O c5605o;
        H9.L lD;
        H9.L l10;
        boolean z11;
        H9.M m10;
        ya.S sU;
        kotlin.jvm.internal.p.i(proto, "proto");
        int iH0 = proto.b1() ? proto.H0() : w(proto.N0());
        if (z10) {
            g.a aVar = F9.g.f2609m0;
            List<ProtoBuf$Annotation> listM0 = proto.m0();
            kotlin.jvm.internal.p.h(listM0, "getAnnotationList(...)");
            List<ProtoBuf$Annotation> list = listM0;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (ProtoBuf$Annotation protoBuf$Annotation : list) {
                C5620f c5620f = this.f42549b;
                kotlin.jvm.internal.p.f(protoBuf$Annotation);
                arrayList.add(c5620f.a(protoBuf$Annotation, this.f42548a.g()));
            }
            gVarM = aVar.a(arrayList);
        } else {
            gVarM = null;
        }
        InterfaceC0803h interfaceC0803hE = this.f42548a.e();
        if (gVarM == null) {
            gVarM = m(proto, iH0, AnnotatedCallableKind.PROPERTY);
        }
        C5605O c5605o2 = C5605O.f42564a;
        C4018b.d<ProtoBuf$Modality> dVar3 = C4018b.f32378e;
        Modality modalityB = c5605o2.b(dVar3.d(iH0));
        C4018b.d<ProtoBuf$Visibility> dVar4 = C4018b.f32377d;
        AbstractC0811p abstractC0811pA = C5606P.a(c5605o2, dVar4.d(iH0));
        Boolean boolD = C4018b.f32355A.d(iH0);
        kotlin.jvm.internal.p.h(boolD, "get(...)");
        boolean zBooleanValue = boolD.booleanValue();
        ga.e eVarB = C5602L.b(this.f42548a.g(), proto.M0());
        CallableMemberDescriptor.Kind kindB = C5606P.b(c5605o2, C4018b.f32390q.d(iH0));
        Boolean boolD2 = C4018b.f32359E.d(iH0);
        kotlin.jvm.internal.p.h(boolD2, "get(...)");
        boolean zBooleanValue2 = boolD2.booleanValue();
        F9.g gVar = gVarM;
        Boolean boolD3 = C4018b.f32358D.d(iH0);
        kotlin.jvm.internal.p.h(boolD3, "get(...)");
        boolean zBooleanValue3 = boolD3.booleanValue();
        Boolean boolD4 = C4018b.f32361G.d(iH0);
        kotlin.jvm.internal.p.h(boolD4, "get(...)");
        boolean zBooleanValue4 = boolD4.booleanValue();
        Boolean boolD5 = C4018b.f32362H.d(iH0);
        kotlin.jvm.internal.p.h(boolD5, "get(...)");
        boolean zBooleanValue5 = boolD5.booleanValue();
        Boolean boolD6 = C4018b.f32363I.d(iH0);
        kotlin.jvm.internal.p.h(boolD6, "get(...)");
        int i10 = iH0;
        C5770L c5770l = new C5770L(interfaceC0803hE, null, gVar, modalityB, abstractC0811pA, zBooleanValue, eVarB, kindB, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, boolD6.booleanValue(), proto, this.f42548a.g(), this.f42548a.j(), this.f42548a.k(), this.f42548a.d());
        C5629o c5629o = this.f42548a;
        List<ProtoBuf$TypeParameter> listZ0 = proto.Z0();
        kotlin.jvm.internal.p.h(listZ0, "getTypeParameterList(...)");
        C5629o c5629oB = C5629o.b(c5629o, c5770l, listZ0, null, null, null, null, 60, null);
        Boolean boolD7 = C4018b.f32356B.d(i10);
        kotlin.jvm.internal.p.h(boolD7, "get(...)");
        boolean zBooleanValue6 = boolD7.booleanValue();
        F9.g gVarR = (zBooleanValue6 && ea.g.h(proto)) ? r(proto, AnnotatedCallableKind.PROPERTY_GETTER) : F9.g.f2609m0.b();
        ya.S sU2 = c5629oB.i().u(ea.g.o(proto, this.f42548a.j()));
        List<b0> listM = c5629oB.i().m();
        E9.S sO = o();
        ProtoBuf$Type protoBuf$TypeM = ea.g.m(proto, this.f42548a.j());
        E9.S sI = (protoBuf$TypeM == null || (sU = c5629oB.i().u(protoBuf$TypeM)) == null) ? null : C4827g.i(c5770l, sU, gVarR);
        C5601K c5601kF = c5629oB.f();
        List<ProtoBuf$Type> listD = ea.g.d(proto, this.f42548a.j());
        List<ProtoBuf$ValueParameter> listU0 = proto.u0();
        kotlin.jvm.internal.p.h(listU0, "getContextParameterList(...)");
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_GETTER;
        c5770l.V0(sU2, listM, sO, sI, c5601kF.k(listD, listU0, proto, annotatedCallableKind));
        Boolean boolD8 = C4018b.f32376c.d(i10);
        kotlin.jvm.internal.p.h(boolD8, "get(...)");
        int iB = C4018b.b(boolD8.booleanValue(), dVar4.d(i10), dVar3.d(i10), false, false, false);
        if (zBooleanValue6) {
            int iL0 = proto.c1() ? proto.L0() : iB;
            Boolean boolD9 = C4018b.f32368N.d(iL0);
            kotlin.jvm.internal.p.h(boolD9, "get(...)");
            boolean zBooleanValue7 = boolD9.booleanValue();
            Boolean boolD10 = C4018b.f32369O.d(iL0);
            kotlin.jvm.internal.p.h(boolD10, "get(...)");
            boolean zBooleanValue8 = boolD10.booleanValue();
            Boolean boolD11 = C4018b.f32370P.d(iL0);
            kotlin.jvm.internal.p.h(boolD11, "get(...)");
            boolean zBooleanValue9 = boolD11.booleanValue();
            F9.g gVarM2 = m(proto, iL0, annotatedCallableKind);
            if (zBooleanValue7) {
                c5605o = c5605o2;
                dVar = dVar4;
                dVar2 = dVar3;
                lD = new H9.L(c5770l, gVarM2, c5605o2.b(dVar3.d(iL0)), C5606P.a(c5605o2, dVar4.d(iL0)), !zBooleanValue7, zBooleanValue8, zBooleanValue9, c5770l.getKind(), null, E9.W.f2444a);
            } else {
                dVar = dVar4;
                dVar2 = dVar3;
                c5605o = c5605o2;
                lD = C4827g.d(c5770l, gVarM2);
                kotlin.jvm.internal.p.f(lD);
            }
            lD.K0(c5770l.getReturnType());
        } else {
            dVar = dVar4;
            dVar2 = dVar3;
            c5605o = c5605o2;
            lD = null;
        }
        if (C4018b.f32357C.d(i10).booleanValue()) {
            if (proto.j1()) {
                iB = proto.V0();
            }
            int i11 = iB;
            Boolean boolD12 = C4018b.f32368N.d(i11);
            kotlin.jvm.internal.p.h(boolD12, "get(...)");
            boolean zBooleanValue10 = boolD12.booleanValue();
            Boolean boolD13 = C4018b.f32369O.d(i11);
            kotlin.jvm.internal.p.h(boolD13, "get(...)");
            boolean zBooleanValue11 = boolD13.booleanValue();
            Boolean boolD14 = C4018b.f32370P.d(i11);
            kotlin.jvm.internal.p.h(boolD14, "get(...)");
            boolean zBooleanValue12 = boolD14.booleanValue();
            AnnotatedCallableKind annotatedCallableKind2 = AnnotatedCallableKind.PROPERTY_SETTER;
            F9.g gVarM3 = m(proto, i11, annotatedCallableKind2);
            if (zBooleanValue10) {
                C5605O c5605o3 = c5605o;
                l10 = lD;
                z11 = true;
                H9.M m11 = new H9.M(c5770l, gVarM3, c5605o3.b(dVar2.d(i11)), C5606P.a(c5605o3, dVar.d(i11)), !zBooleanValue10, zBooleanValue11, zBooleanValue12, c5770l.getKind(), null, E9.W.f2444a);
                m10 = m11;
                m10.L0((i0) Z8.F.X0(C5629o.b(c5629oB, m11, C1173v.m(), null, null, null, null, 60, null).f().E(C1172u.e(proto.W0()), proto, annotatedCallableKind2)));
            } else {
                l10 = lD;
                z11 = true;
                H9.M mE = C4827g.e(c5770l, gVarM3, F9.g.f2609m0.b());
                kotlin.jvm.internal.p.f(mE);
                m10 = mE;
            }
        } else {
            l10 = lD;
            z11 = true;
            m10 = null;
        }
        if (C4018b.f32360F.d(i10).booleanValue()) {
            c5770l.F0(new C5592B(this, proto, c5770l));
        }
        InterfaceC0803h interfaceC0803hE2 = this.f42548a.e();
        InterfaceC0797b interfaceC0797b = interfaceC0803hE2 instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hE2 : null;
        if ((interfaceC0797b != null ? interfaceC0797b.getKind() : null) == ClassKind.ANNOTATION_CLASS) {
            c5770l.F0(new C5593C(this, proto, c5770l));
        }
        c5770l.P0(l10, m10, new H9.r(p(proto, false), c5770l), new H9.r(p(proto, z11), c5770l));
        return c5770l;
    }
}
