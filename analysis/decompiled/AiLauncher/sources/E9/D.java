package E9;

import H9.AbstractC0831j;
import H9.C0837p;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ra.InterfaceC5238k;
import v9.C5680i;
import v9.C5685n;
import xa.InterfaceC5863f;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.C6013t;

/* loaded from: classes5.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5869l f2420a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0819y f2421b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5863f<ga.c, E> f2422c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5863f<a, InterfaceC0797b> f2423d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ga.b f2424a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Integer> f2425b;

        public a(ga.b classId, List<Integer> typeParametersCount) {
            kotlin.jvm.internal.p.i(classId, "classId");
            kotlin.jvm.internal.p.i(typeParametersCount, "typeParametersCount");
            this.f2424a = classId;
            this.f2425b = typeParametersCount;
        }

        public final ga.b a() {
            return this.f2424a;
        }

        public final List<Integer> b() {
            return this.f2425b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.p.d(this.f2424a, aVar.f2424a) && kotlin.jvm.internal.p.d(this.f2425b, aVar.f2425b);
        }

        public int hashCode() {
            return (this.f2424a.hashCode() * 31) + this.f2425b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.f2424a + ", typeParametersCount=" + this.f2425b + ')';
        }
    }

    public static final class b extends AbstractC0831j {

        /* renamed from: i, reason: collision with root package name */
        public final boolean f2426i;

        /* renamed from: j, reason: collision with root package name */
        public final List<b0> f2427j;

        /* renamed from: k, reason: collision with root package name */
        public final C6013t f2428k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC5869l storageManager, InterfaceC0803h container, ga.e name, boolean z10, int i10) {
            super(storageManager, container, name, W.f2444a, false);
            kotlin.jvm.internal.p.i(storageManager, "storageManager");
            kotlin.jvm.internal.p.i(container, "container");
            kotlin.jvm.internal.p.i(name, "name");
            this.f2426i = z10;
            C5680i c5680iS = C5685n.s(0, i10);
            ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
            Iterator<Integer> it = c5680iS.iterator();
            while (it.hasNext()) {
                int iNextInt = ((Z8.M) it).nextInt();
                F9.g gVarB = F9.g.f2609m0.b();
                Variance variance = Variance.INVARIANT;
                StringBuilder sb2 = new StringBuilder();
                sb2.append('T');
                sb2.append(iNextInt);
                arrayList.add(H9.U.L0(this, gVarB, false, variance, ga.e.j(sb2.toString()), iNextInt, storageManager));
            }
            this.f2427j = arrayList;
            this.f2428k = new C6013t(this, f0.g(this), Z8.X.d(DescriptorUtilsKt.s(this).g().i()), storageManager);
        }

        @Override // E9.InterfaceC0797b
        public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
            return null;
        }

        @Override // E9.InterfaceC0797b
        public boolean C0() {
            return false;
        }

        @Override // E9.InterfaceC0797b
        /* renamed from: E0, reason: merged with bridge method [inline-methods] */
        public InterfaceC5238k.b g0() {
            return InterfaceC5238k.b.f38898b;
        }

        @Override // E9.InterfaceC0799d
        /* renamed from: F0, reason: merged with bridge method [inline-methods] */
        public C6013t j() {
            return this.f2428k;
        }

        @Override // H9.z
        /* renamed from: G0, reason: merged with bridge method [inline-methods] */
        public InterfaceC5238k.b c0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            return InterfaceC5238k.b.f38898b;
        }

        @Override // E9.InterfaceC0797b
        public g0<AbstractC5990d0> P() {
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

        @Override // E9.InterfaceC0816v
        public boolean e0() {
            return false;
        }

        @Override // F9.a
        public F9.g getAnnotations() {
            return F9.g.f2609m0.b();
        }

        @Override // E9.InterfaceC0797b
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
        public AbstractC0811p getVisibility() {
            AbstractC0811p PUBLIC = C0810o.f2473e;
            kotlin.jvm.internal.p.h(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // E9.InterfaceC0797b
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
            return Z8.Y.e();
        }

        @Override // E9.InterfaceC0797b
        public InterfaceC0797b h0() {
            return null;
        }

        @Override // H9.AbstractC0831j, E9.InterfaceC0816v
        public boolean isExternal() {
            return false;
        }

        @Override // E9.InterfaceC0797b
        public boolean isInline() {
            return false;
        }

        @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
        public List<b0> o() {
            return this.f2427j;
        }

        @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
        public Modality p() {
            return Modality.FINAL;
        }

        @Override // E9.InterfaceC0797b
        public boolean q() {
            return false;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // E9.InterfaceC0800e
        public boolean x() {
            return this.f2426i;
        }
    }

    public D(InterfaceC5869l storageManager, InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(module, "module");
        this.f2420a = storageManager;
        this.f2421b = module;
        this.f2422c = storageManager.c(new B(this));
        this.f2423d = storageManager.c(new C(this));
    }

    public static final InterfaceC0797b c(D d10, a aVar) {
        E eInvoke;
        kotlin.jvm.internal.p.i(aVar, "<destruct>");
        ga.b bVarA = aVar.a();
        List<Integer> listB = aVar.b();
        if (bVarA.i()) {
            throw new UnsupportedOperationException("Unresolved local class: " + bVarA);
        }
        ga.b bVarE = bVarA.e();
        if (bVarE == null || (eInvoke = d10.d(bVarE, Z8.F.h0(listB, 1))) == null) {
            eInvoke = d10.f2422c.invoke(bVarA.f());
        }
        InterfaceC0803h interfaceC0803h = eInvoke;
        boolean zJ = bVarA.j();
        InterfaceC5869l interfaceC5869l = d10.f2420a;
        ga.e eVarH = bVarA.h();
        Integer num = (Integer) Z8.F.s0(listB);
        return new b(interfaceC5869l, interfaceC0803h, eVarH, zJ, num != null ? num.intValue() : 0);
    }

    public static final E e(D d10, ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return new C0837p(d10.f2421b, fqName);
    }

    public final InterfaceC0797b d(ga.b classId, List<Integer> typeParametersCount) {
        kotlin.jvm.internal.p.i(classId, "classId");
        kotlin.jvm.internal.p.i(typeParametersCount, "typeParametersCount");
        return this.f2423d.invoke(new a(classId, typeParametersCount));
    }
}
