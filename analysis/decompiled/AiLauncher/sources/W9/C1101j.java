package W9;

import E9.InterfaceC0797b;
import E9.i0;
import Z8.C1174w;
import Z9.InterfaceC1178a;
import Z9.InterfaceC1179b;
import Z9.InterfaceC1180c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ma.AbstractC4927g;
import ma.C4921a;
import ma.C4929i;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5866i;
import ya.AbstractC5990d0;

/* renamed from: W9.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1101j implements U9.f {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f6736i = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C1101j.class, "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(C1101j.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(C1101j.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final V9.k f6737a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1178a f6738b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5866i f6739c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h f6740d;

    /* renamed from: e, reason: collision with root package name */
    public final Y9.a f6741e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5865h f6742f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6743g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6744h;

    public C1101j(V9.k c10, InterfaceC1178a javaAnnotation, boolean z10) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(javaAnnotation, "javaAnnotation");
        this.f6737a = c10;
        this.f6738b = javaAnnotation;
        this.f6739c = c10.e().h(new C1098g(this));
        this.f6740d = c10.e().i(new C1099h(this));
        this.f6741e = c10.a().t().a(javaAnnotation);
        this.f6742f = c10.e().i(new C1100i(this));
        this.f6743g = javaAnnotation.k();
        this.f6744h = javaAnnotation.C() || z10;
    }

    public static final Map g(C1101j c1101j) {
        Collection<InterfaceC1179b> collectionG = c1101j.f6738b.g();
        ArrayList arrayList = new ArrayList();
        for (InterfaceC1179b interfaceC1179b : collectionG) {
            ga.e name = interfaceC1179b.getName();
            if (name == null) {
                name = S9.F.f5685c;
            }
            AbstractC4927g<?> abstractC4927gN = c1101j.n(interfaceC1179b);
            Pair pairA = abstractC4927gN != null ? Y8.j.a(name, abstractC4927gN) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return kotlin.collections.a.y(arrayList);
    }

    public static final ga.c i(C1101j c1101j) {
        ga.b bVarJ = c1101j.f6738b.j();
        if (bVarJ != null) {
            return bVarJ.a();
        }
        return null;
    }

    public static final AbstractC5990d0 s(C1101j c1101j) {
        ga.c cVarF = c1101j.f();
        if (cVarF == null) {
            return Aa.i.d(ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, c1101j.f6738b.toString());
        }
        InterfaceC0797b interfaceC0797bF = D9.b.f(D9.b.f2290a, cVarF, c1101j.f6737a.d().g(), null, 4, null);
        if (interfaceC0797bF == null) {
            Z9.g gVarB = c1101j.f6738b.b();
            interfaceC0797bF = gVarB != null ? c1101j.f6737a.a().n().a(gVarB) : null;
            if (interfaceC0797bF == null) {
                interfaceC0797bF = c1101j.h(cVarF);
            }
        }
        return interfaceC0797bF.n();
    }

    @Override // F9.c
    public Map<ga.e, AbstractC4927g<?>> a() {
        return (Map) C5868k.a(this.f6742f, this, f6736i[2]);
    }

    @Override // F9.c
    public ga.c f() {
        return (ga.c) C5868k.b(this.f6739c, this, f6736i[0]);
    }

    public final InterfaceC0797b h(ga.c cVar) {
        return FindClassInModuleKt.d(this.f6737a.d(), ga.b.f32721d.c(cVar), this.f6737a.a().b().f().r());
    }

    @Override // F9.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Y9.a e() {
        return this.f6741e;
    }

    @Override // U9.f
    public boolean k() {
        return this.f6743g;
    }

    @Override // F9.c
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 getType() {
        return (AbstractC5990d0) C5868k.a(this.f6740d, this, f6736i[1]);
    }

    public final boolean m() {
        return this.f6744h;
    }

    public final AbstractC4927g<?> n(InterfaceC1179b interfaceC1179b) {
        if (interfaceC1179b instanceof Z9.o) {
            return C4929i.f(C4929i.f37195a, ((Z9.o) interfaceC1179b).getValue(), null, 2, null);
        }
        if (interfaceC1179b instanceof Z9.m) {
            Z9.m mVar = (Z9.m) interfaceC1179b;
            return q(mVar.d(), mVar.e());
        }
        if (!(interfaceC1179b instanceof Z9.e)) {
            if (interfaceC1179b instanceof InterfaceC1180c) {
                return o(((InterfaceC1180c) interfaceC1179b).a());
            }
            if (interfaceC1179b instanceof Z9.h) {
                return r(((Z9.h) interfaceC1179b).b());
            }
            return null;
        }
        Z9.e eVar = (Z9.e) interfaceC1179b;
        ga.e name = eVar.getName();
        if (name == null) {
            name = S9.F.f5685c;
        }
        kotlin.jvm.internal.p.f(name);
        return p(name, eVar.c());
    }

    public final AbstractC4927g<?> o(InterfaceC1178a interfaceC1178a) {
        return new C4921a(new C1101j(this.f6737a, interfaceC1178a, false, 4, null));
    }

    public final AbstractC4927g<?> p(ga.e eVar, List<? extends InterfaceC1179b> list) {
        ya.S sM;
        if (ya.W.a(getType())) {
            return null;
        }
        InterfaceC0797b interfaceC0797bL = DescriptorUtilsKt.l(this);
        kotlin.jvm.internal.p.f(interfaceC0797bL);
        i0 i0VarB = T9.a.b(eVar, interfaceC0797bL);
        if (i0VarB == null || (sM = i0VarB.getType()) == null) {
            sM = this.f6737a.a().m().g().m(Variance.INVARIANT, Aa.i.d(ErrorTypeKind.UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, new String[0]));
            kotlin.jvm.internal.p.h(sM, "getArrayType(...)");
        }
        List<? extends InterfaceC1179b> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            AbstractC4927g<?> abstractC4927gN = n((InterfaceC1179b) it.next());
            if (abstractC4927gN == null) {
                abstractC4927gN = new ma.u();
            }
            arrayList.add(abstractC4927gN);
        }
        return C4929i.f37195a.c(arrayList, sM);
    }

    public final AbstractC4927g<?> q(ga.b bVar, ga.e eVar) {
        if (bVar == null || eVar == null) {
            return null;
        }
        return new ma.k(bVar, eVar);
    }

    public final AbstractC4927g<?> r(Z9.x xVar) {
        return ma.s.f37205b.a(this.f6737a.g().p(xVar, X9.b.b(TypeUsage.COMMON, false, false, null, 7, null)));
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.O(kotlin.reflect.jvm.internal.impl.renderer.b.f35917h, this, null, 2, null);
    }

    public /* synthetic */ C1101j(V9.k kVar, InterfaceC1178a interfaceC1178a, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(kVar, interfaceC1178a, (i10 & 4) != 0 ? false : z10);
    }
}
