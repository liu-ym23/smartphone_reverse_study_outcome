package kotlin.reflect.jvm.internal.impl.builtins.functions;

import C9.o;
import E9.AbstractC0811p;
import E9.C0810o;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import E9.W;
import E9.Z;
import E9.b0;
import E9.g0;
import F9.g;
import H9.AbstractC0822a;
import H9.U;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.M;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ra.InterfaceC5238k;
import v9.C5680i;
import xa.InterfaceC5869l;
import ya.AbstractC5985b;
import ya.AbstractC5990d0;
import ya.D0;
import ya.S;
import ya.V;
import ya.s0;
import ya.v0;

/* loaded from: classes5.dex */
public final class b extends AbstractC0822a {

    /* renamed from: n, reason: collision with root package name */
    public static final a f34950n = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public static final ga.b f34951o;

    /* renamed from: p, reason: collision with root package name */
    public static final ga.b f34952p;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5869l f34953f;

    /* renamed from: g, reason: collision with root package name */
    public final E f34954g;

    /* renamed from: h, reason: collision with root package name */
    public final e f34955h;

    /* renamed from: i, reason: collision with root package name */
    public final int f34956i;

    /* renamed from: j, reason: collision with root package name */
    public final C0435b f34957j;

    /* renamed from: k, reason: collision with root package name */
    public final c f34958k;

    /* renamed from: l, reason: collision with root package name */
    public final List<b0> f34959l;

    /* renamed from: m, reason: collision with root package name */
    public final FunctionClassKind f34960m;

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.b$b, reason: collision with other inner class name */
    public final class C0435b extends AbstractC5985b {
        public C0435b() {
            super(b.this.f34953f);
        }

        @Override // ya.AbstractC6014u, ya.v0
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public b d() {
            return b.this;
        }

        @Override // ya.v0
        public boolean f() {
            return true;
        }

        @Override // ya.v0
        public List<b0> getParameters() {
            return b.this.f34959l;
        }

        @Override // ya.AbstractC6009o
        public Collection<S> s() {
            List listP;
            e eVarO0 = b.this.O0();
            e.a aVar = e.a.f34968f;
            if (p.d(eVarO0, aVar)) {
                listP = C1172u.e(b.f34951o);
            } else if (p.d(eVarO0, e.b.f34969f)) {
                listP = C1173v.p(b.f34952p, new ga.b(o.f1810B, aVar.c(b.this.K0())));
            } else {
                e.d dVar = e.d.f34971f;
                if (p.d(eVarO0, dVar)) {
                    listP = C1172u.e(b.f34951o);
                } else {
                    if (!p.d(eVarO0, e.c.f34970f)) {
                        Ja.a.b(null, 1, null);
                        throw new KotlinNothingValueException();
                    }
                    listP = C1173v.p(b.f34952p, new ga.b(o.f1838s, dVar.c(b.this.K0())));
                }
            }
            InterfaceC0819y interfaceC0819yB = b.this.f34954g.b();
            List<ga.b> list = listP;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (ga.b bVar : list) {
                InterfaceC0797b interfaceC0797bB = FindClassInModuleKt.b(interfaceC0819yB, bVar);
                if (interfaceC0797bB == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List listG1 = F.g1(getParameters(), interfaceC0797bB.j().getParameters().size());
                ArrayList arrayList2 = new ArrayList(C1174w.x(listG1, 10));
                Iterator it = listG1.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new D0(((b0) it.next()).n()));
                }
                arrayList.add(V.h(s0.f44124b.k(), interfaceC0797bB, arrayList2));
            }
            return F.m1(arrayList);
        }

        public String toString() {
            return d().toString();
        }

        @Override // ya.AbstractC6009o
        public Z w() {
            return Z.a.f2446a;
        }
    }

    static {
        ga.c cVar = o.f1810B;
        ga.e eVarJ = ga.e.j("Function");
        p.h(eVarJ, "identifier(...)");
        f34951o = new ga.b(cVar, eVarJ);
        ga.c cVar2 = o.f1844y;
        ga.e eVarJ2 = ga.e.j("KFunction");
        p.h(eVarJ2, "identifier(...)");
        f34952p = new ga.b(cVar2, eVarJ2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC5869l storageManager, E containingDeclaration, e functionTypeKind, int i10) {
        super(storageManager, functionTypeKind.c(i10));
        p.i(storageManager, "storageManager");
        p.i(containingDeclaration, "containingDeclaration");
        p.i(functionTypeKind, "functionTypeKind");
        this.f34953f = storageManager;
        this.f34954g = containingDeclaration;
        this.f34955h = functionTypeKind;
        this.f34956i = i10;
        this.f34957j = new C0435b();
        this.f34958k = new c(storageManager, this);
        ArrayList arrayList = new ArrayList();
        C5680i c5680i = new C5680i(1, i10);
        ArrayList arrayList2 = new ArrayList(C1174w.x(c5680i, 10));
        Iterator<Integer> it = c5680i.iterator();
        while (it.hasNext()) {
            int iNextInt = ((M) it).nextInt();
            Variance variance = Variance.IN_VARIANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('P');
            sb2.append(iNextInt);
            E0(arrayList, this, variance, sb2.toString());
            arrayList2.add(t.f7040a);
        }
        E0(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.f34959l = F.m1(arrayList);
        this.f34960m = FunctionClassKind.Companion.a(this.f34955h);
    }

    public static final void E0(ArrayList<b0> arrayList, b bVar, Variance variance, String str) {
        arrayList.add(U.L0(bVar, g.f2609m0.b(), false, variance, ga.e.j(str), arrayList.size(), bVar.f34953f));
    }

    @Override // E9.InterfaceC0797b
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.b) R0();
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        return false;
    }

    public final int K0() {
        return this.f34956i;
    }

    public Void L0() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        return C1173v.m();
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0804i, E9.InterfaceC0803h
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public E b() {
        return this.f34954g;
    }

    public final e O0() {
        return this.f34955h;
    }

    @Override // E9.InterfaceC0797b
    public g0<AbstractC5990d0> P() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public InterfaceC5238k.b g0() {
        return InterfaceC5238k.b.f38898b;
    }

    @Override // H9.z
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public c c0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f34958k;
    }

    public Void R0() {
        return null;
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

    @Override // E9.InterfaceC0806k
    public W e() {
        W NO_SOURCE = W.f2444a;
        p.h(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // F9.a
    public g getAnnotations() {
        return g.f2609m0.b();
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p PUBLIC = C0810o.f2473e;
        p.h(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // E9.InterfaceC0797b
    public /* bridge */ /* synthetic */ InterfaceC0797b h0() {
        return (InterfaceC0797b) L0();
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean isInline() {
        return false;
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        return this.f34957j;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        return this.f34959l;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        return Modality.ABSTRACT;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return false;
    }

    public String toString() {
        String strB = getName().b();
        p.h(strB, "asString(...)");
        return strB;
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return false;
    }
}
