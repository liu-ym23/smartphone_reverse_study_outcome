package W9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.b0;
import E9.f0;
import E9.g0;
import E9.m0;
import H9.AbstractC0831j;
import S9.C1016o;
import Z8.C1172u;
import Z8.C1174w;
import Z9.InterfaceC1178a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4848b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ra.C5234g;
import ra.InterfaceC5238k;
import ua.InterfaceC5636v;
import v9.C5680i;
import xa.InterfaceC5865h;
import ya.AbstractC5985b;
import ya.AbstractC5990d0;
import ya.D0;
import ya.s0;
import ya.v0;

/* renamed from: W9.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1105n extends AbstractC0831j implements U9.c {

    /* renamed from: y, reason: collision with root package name */
    public static final a f6748y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    public static final Set<String> f6749z = Z8.Y.j("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");

    /* renamed from: i, reason: collision with root package name */
    public final V9.k f6750i;

    /* renamed from: j, reason: collision with root package name */
    public final Z9.g f6751j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC0797b f6752k;

    /* renamed from: l, reason: collision with root package name */
    public final V9.k f6753l;

    /* renamed from: m, reason: collision with root package name */
    public final Y8.h f6754m;

    /* renamed from: n, reason: collision with root package name */
    public final ClassKind f6755n;

    /* renamed from: o, reason: collision with root package name */
    public final Modality f6756o;

    /* renamed from: p, reason: collision with root package name */
    public final m0 f6757p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f6758q;

    /* renamed from: r, reason: collision with root package name */
    public final b f6759r;

    /* renamed from: s, reason: collision with root package name */
    public final LazyJavaClassMemberScope f6760s;

    /* renamed from: t, reason: collision with root package name */
    public final E9.V<LazyJavaClassMemberScope> f6761t;

    /* renamed from: u, reason: collision with root package name */
    public final C5234g f6762u;

    /* renamed from: v, reason: collision with root package name */
    public final Y f6763v;

    /* renamed from: w, reason: collision with root package name */
    public final F9.g f6764w;

    /* renamed from: x, reason: collision with root package name */
    public final InterfaceC5865h<List<b0>> f6765x;

    /* renamed from: W9.n$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: W9.n$b */
    public final class b extends AbstractC5985b {

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceC5865h<List<b0>> f6766d;

        public b() {
            super(C1105n.this.f6753l.e());
            this.f6766d = C1105n.this.f6753l.e().i(new C1106o(C1105n.this));
        }

        public static final List N(C1105n c1105n) {
            return f0.g(c1105n);
        }

        @Override // ya.AbstractC6014u, ya.v0
        /* renamed from: J */
        public InterfaceC0797b d() {
            return C1105n.this;
        }

        public final ya.S L() {
            ga.c cVarB;
            ArrayList arrayList;
            ga.c cVarM = M();
            if (cVarM == null || cVarM.c() || !cVarM.h(C9.o.f1809A)) {
                cVarM = null;
            }
            if (cVarM == null) {
                cVarB = C1016o.f5760a.b(DescriptorUtilsKt.o(C1105n.this));
                if (cVarB == null) {
                    return null;
                }
            } else {
                cVarB = cVarM;
            }
            InterfaceC0797b interfaceC0797bB = DescriptorUtilsKt.B(C1105n.this.f6753l.d(), cVarB, NoLookupLocation.FROM_JAVA_LOADER);
            if (interfaceC0797bB == null) {
                return null;
            }
            int size = interfaceC0797bB.j().getParameters().size();
            List<b0> parameters = C1105n.this.j().getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            int size2 = parameters.size();
            if (size2 == size) {
                List<b0> list = parameters;
                arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new D0(Variance.INVARIANT, ((b0) it.next()).n()));
                }
            } else {
                if (size2 != 1 || size <= 1 || cVarM != null) {
                    return null;
                }
                D0 d02 = new D0(Variance.INVARIANT, ((b0) Z8.F.X0(parameters)).n());
                C5680i c5680i = new C5680i(1, size);
                ArrayList arrayList2 = new ArrayList(C1174w.x(c5680i, 10));
                Iterator<Integer> it2 = c5680i.iterator();
                while (it2.hasNext()) {
                    ((Z8.M) it2).nextInt();
                    arrayList2.add(d02);
                }
                arrayList = arrayList2;
            }
            return ya.V.h(s0.f44124b.k(), interfaceC0797bB, arrayList);
        }

        public final ga.c M() {
            String strB;
            F9.g annotations = C1105n.this.getAnnotations();
            ga.c PURELY_IMPLEMENTS_ANNOTATION = S9.F.f5700r;
            kotlin.jvm.internal.p.h(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            F9.c cVarD = annotations.d(PURELY_IMPLEMENTS_ANNOTATION);
            if (cVarD == null) {
                return null;
            }
            Object objY0 = Z8.F.Y0(cVarD.a().values());
            ma.x xVar = objY0 instanceof ma.x ? (ma.x) objY0 : null;
            if (xVar == null || (strB = xVar.b()) == null || !kotlin.reflect.jvm.internal.impl.name.a.e(strB)) {
                return null;
            }
            return new ga.c(strB);
        }

        @Override // ya.v0
        public boolean f() {
            return true;
        }

        @Override // ya.v0
        public List<b0> getParameters() {
            return this.f6766d.invoke();
        }

        @Override // ya.AbstractC6009o
        public Collection<ya.S> s() {
            Collection<Z9.j> collectionE = C1105n.this.M0().e();
            ArrayList arrayList = new ArrayList(collectionE.size());
            ArrayList<Z9.x> arrayList2 = new ArrayList(0);
            ya.S sL = L();
            Iterator<Z9.j> it = collectionE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Z9.j next = it.next();
                ya.S sQ = C1105n.this.f6753l.a().r().q(C1105n.this.f6753l.g().p(next, X9.b.b(TypeUsage.SUPERTYPE, false, false, null, 7, null)), C1105n.this.f6753l);
                if (sQ.H0().d() instanceof D.b) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.p.d(sQ.H0(), sL != null ? sL.H0() : null) && !C9.j.c0(sQ)) {
                    arrayList.add(sQ);
                }
            }
            InterfaceC0797b interfaceC0797b = C1105n.this.f6752k;
            Ia.a.a(arrayList, interfaceC0797b != null ? D9.t.a(interfaceC0797b, C1105n.this).c().q(interfaceC0797b.n(), Variance.INVARIANT) : null);
            Ia.a.a(arrayList, sL);
            if (!arrayList2.isEmpty()) {
                InterfaceC5636v interfaceC5636vC = C1105n.this.f6753l.a().c();
                InterfaceC0797b interfaceC0797bD = d();
                ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
                for (Z9.x xVar : arrayList2) {
                    kotlin.jvm.internal.p.g(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((Z9.j) xVar).B());
                }
                interfaceC5636vC.b(interfaceC0797bD, arrayList3);
            }
            return !arrayList.isEmpty() ? Z8.F.m1(arrayList) : C1172u.e(C1105n.this.f6753l.d().g().i());
        }

        public String toString() {
            String strB = C1105n.this.getName().b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            return strB;
        }

        @Override // ya.AbstractC6009o
        public E9.Z w() {
            return C1105n.this.f6753l.a().v();
        }
    }

    public /* synthetic */ C1105n(V9.k kVar, InterfaceC0803h interfaceC0803h, Z9.g gVar, InterfaceC0797b interfaceC0797b, int i10, kotlin.jvm.internal.i iVar) {
        this(kVar, interfaceC0803h, gVar, (i10 & 8) != 0 ? null : interfaceC0797b);
    }

    public static final List K0(C1105n c1105n) {
        List<Z9.y> typeParameters = c1105n.f6751j.getTypeParameters();
        ArrayList arrayList = new ArrayList(C1174w.x(typeParameters, 10));
        for (Z9.y yVar : typeParameters) {
            b0 b0VarA = c1105n.f6753l.f().a(yVar);
            if (b0VarA == null) {
                throw new AssertionError("Parameter " + yVar + " surely belongs to class " + c1105n.f6751j + ", so it must be resolved");
            }
            arrayList.add(b0VarA);
        }
        return arrayList;
    }

    public static final List Q0(C1105n c1105n) {
        ga.b bVarN = DescriptorUtilsKt.n(c1105n);
        if (bVarN != null) {
            return c1105n.f6750i.a().f().a(bVarN);
        }
        return null;
    }

    public static final LazyJavaClassMemberScope R0(C1105n c1105n, kotlin.reflect.jvm.internal.impl.types.checker.c it) {
        kotlin.jvm.internal.p.i(it, "it");
        return new LazyJavaClassMemberScope(c1105n.f6753l, c1105n, c1105n.f6751j, c1105n.f6752k != null, c1105n.f6760s);
    }

    @Override // E9.InterfaceC0797b
    public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        return false;
    }

    public final C1105n J0(T9.j javaResolverCache, InterfaceC0797b interfaceC0797b) {
        kotlin.jvm.internal.p.i(javaResolverCache, "javaResolverCache");
        V9.k kVar = this.f6753l;
        V9.k kVarM = V9.c.m(kVar, kVar.a().x(javaResolverCache));
        InterfaceC0803h interfaceC0803hB = b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        return new C1105n(kVarM, interfaceC0803hB, this.f6751j, interfaceC0797b);
    }

    @Override // E9.InterfaceC0797b
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        return this.f6760s.Z0().invoke();
    }

    public final Z9.g M0() {
        return this.f6751j;
    }

    public final List<InterfaceC1178a> N0() {
        return (List) this.f6754m.getValue();
    }

    @Override // H9.AbstractC0822a, E9.InterfaceC0797b
    public InterfaceC5238k O() {
        return this.f6762u;
    }

    @Override // H9.AbstractC0822a, E9.InterfaceC0797b
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public LazyJavaClassMemberScope R() {
        InterfaceC5238k interfaceC5238kR = super.R();
        kotlin.jvm.internal.p.g(interfaceC5238kR, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope) interfaceC5238kR;
    }

    @Override // E9.InterfaceC0797b
    public g0<AbstractC5990d0> P() {
        return null;
    }

    @Override // H9.z
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public LazyJavaClassMemberScope c0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope) this.f6761t.c(kotlinTypeRefiner);
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean W() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean Z() {
        return false;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k g0() {
        return this.f6763v;
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        return this.f6764w;
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        return this.f6755n;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        if (!kotlin.jvm.internal.p.d(this.f6757p, C0810o.f2469a) || this.f6751j.l() != null) {
            return S9.O.d(this.f6757p);
        }
        AbstractC0811p abstractC0811p = S9.v.f5776a;
        kotlin.jvm.internal.p.f(abstractC0811p);
        return abstractC0811p;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC0797b h0() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    public boolean isInline() {
        return false;
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        return this.f6759r;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        return this.f6765x.invoke();
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        return this.f6756o;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return false;
    }

    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.p(this);
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return this.f6758q;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1105n(V9.k outerContext, InterfaceC0803h containingDeclaration, Z9.g jClass, InterfaceC0797b interfaceC0797b) {
        Modality modalityA;
        super(outerContext.e(), containingDeclaration, jClass.getName(), outerContext.a().t().a(jClass), false);
        kotlin.jvm.internal.p.i(outerContext, "outerContext");
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(jClass, "jClass");
        this.f6750i = outerContext;
        this.f6751j = jClass;
        this.f6752k = interfaceC0797b;
        V9.k kVarF = V9.c.f(outerContext, this, jClass, 0, 4, null);
        this.f6753l = kVarF;
        kVarF.a().h().d(jClass, this);
        jClass.G();
        this.f6754m = C4848b.b(new C1102k(this));
        this.f6755n = jClass.o() ? ClassKind.ANNOTATION_CLASS : jClass.F() ? ClassKind.INTERFACE : jClass.v() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        if (jClass.o() || jClass.v()) {
            modalityA = Modality.FINAL;
        } else {
            modalityA = Modality.Companion.a(jClass.w(), jClass.w() || jClass.isAbstract() || jClass.F(), !jClass.isFinal());
        }
        this.f6756o = modalityA;
        this.f6757p = jClass.getVisibility();
        this.f6758q = (jClass.l() == null || jClass.isStatic()) ? false : true;
        this.f6759r = new b();
        LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(kVarF, this, jClass, interfaceC0797b != null, null, 16, null);
        this.f6760s = lazyJavaClassMemberScope;
        this.f6761t = E9.V.f2438e.a(this, kVarF.e(), kVarF.a().k().d(), new C1103l(this));
        this.f6762u = new C5234g(lazyJavaClassMemberScope);
        this.f6763v = new Y(kVarF, jClass, this);
        this.f6764w = V9.h.a(kVarF, jClass);
        this.f6765x = kVarF.e().i(new C1104m(this));
    }
}
