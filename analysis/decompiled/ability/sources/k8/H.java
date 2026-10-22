package k8;

import h8.C1531n;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1536s;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public class H extends S implements InterfaceC1501I {
    public final boolean f;
    public kotlin.reflect.jvm.internal.impl.storage.a g;
    public S7.a h;
    public final Modality i;

    /* renamed from: j, reason: collision with root package name */
    public C1531n f4830j;
    public Collection k;
    public final InterfaceC1501I l;
    public final CallableMemberDescriptor$Kind m;
    public final boolean n;
    public final boolean o;
    public final boolean p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f4831q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f4832r;

    /* renamed from: s, reason: collision with root package name */
    public List f4833s;

    /* renamed from: t, reason: collision with root package name */
    public u f4834t;
    public u u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f4835v;

    /* renamed from: w, reason: collision with root package name */
    public I f4836w;

    /* renamed from: x, reason: collision with root package name */
    public J f4837x;
    public r y;

    /* renamed from: z, reason: collision with root package name */
    public r f4838z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(InterfaceC1527j interfaceC1527j, InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g, Modality modality, C1531n c1531n, boolean z10, G8.f fVar, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        super(interfaceC1527j, interfaceC1561g, fVar, null, interfaceC1503K);
        if (interfaceC1527j == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(1);
            throw null;
        }
        if (modality == null) {
            C0(2);
            throw null;
        }
        if (c1531n == null) {
            C0(3);
            throw null;
        }
        if (fVar == null) {
            C0(4);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(5);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(6);
            throw null;
        }
        this.f = z10;
        this.k = null;
        this.f4833s = Collections.EMPTY_LIST;
        this.i = modality;
        this.f4830j = c1531n;
        this.l = interfaceC1501I == null ? this : interfaceC1501I;
        this.m = callableMemberDescriptor$Kind;
        this.n = z11;
        this.o = z12;
        this.p = z13;
        this.f4831q = z14;
        this.f4832r = z15;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void C0(int r11) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.H.C0(int):void");
    }

    public static H S0(InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n, boolean z10, G8.f fVar, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        if (interfaceC1527j == null) {
            C0(7);
            throw null;
        }
        if (c1531n == null) {
            C0(10);
            throw null;
        }
        if (fVar == null) {
            C0(11);
            throw null;
        }
        if (interfaceC1503K != null) {
            return new H(interfaceC1527j, null, C1560f.f4611a, modality, c1531n, z10, fVar, callableMemberDescriptor$Kind, interfaceC1503K, false, false, false, false, false);
        }
        C0(13);
        throw null;
    }

    public static InterfaceC1536s U0(kotlin.reflect.jvm.internal.impl.types.a aVar, InterfaceC1500H interfaceC1500H) {
        if (interfaceC1500H == null) {
            C0(31);
            throw null;
        }
        InterfaceC1536s interfaceC1536s = ((F) interfaceC1500H).l;
        if (interfaceC1536s != null) {
            return interfaceC1536s.b(aVar);
        }
        return null;
    }

    @Override // k8.S, h8.InterfaceC1519b
    public final u E() {
        return this.f4834t;
    }

    @Override // h8.InterfaceC1510S
    public final boolean H() {
        return this.f;
    }

    @Override // k8.S, h8.InterfaceC1519b
    public final u I() {
        return this.u;
    }

    @Override // h8.InterfaceC1501I
    public final r J() {
        return this.f4838z;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.p(this, obj);
    }

    @Override // h8.InterfaceC1520c
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public final H U(InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n) {
        G g = new G(this);
        if (interfaceC1527j == null) {
            G.a(0);
            throw null;
        }
        g.f4828a = interfaceC1527j;
        g.d = null;
        g.b = modality;
        if (c1531n == null) {
            G.a(8);
            throw null;
        }
        g.c = c1531n;
        g.e = CallableMemberDescriptor$Kind.b;
        g.g = false;
        H hB = g.b();
        if (hB != null) {
            return hB;
        }
        C0(42);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    public H T0(InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n, InterfaceC1501I interfaceC1501I, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, G8.f fVar) {
        if (interfaceC1527j == null) {
            C0(32);
            throw null;
        }
        if (modality == null) {
            C0(33);
            throw null;
        }
        if (c1531n == null) {
            C0(34);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(35);
            throw null;
        }
        if (fVar == null) {
            C0(36);
            throw null;
        }
        return new H(interfaceC1527j, interfaceC1501I, getAnnotations(), modality, c1531n, this.f, fVar, callableMemberDescriptor$Kind, InterfaceC1503K.f4577I, this.n, isConst(), this.p, isExternal(), this.f4832r);
    }

    public final void V0(I i, J j5, r rVar, r rVar2) {
        this.f4836w = i;
        this.f4837x = j5;
        this.y = rVar;
        this.f4838z = rVar2;
    }

    public final void W0(kotlin.reflect.jvm.internal.impl.storage.a aVar, S7.a aVar2) {
        if (aVar2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compileTimeInitializerFactory", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl", "setCompileTimeInitializer"));
        }
        this.h = aVar2;
        if (aVar == null) {
            aVar = (kotlin.reflect.jvm.internal.impl.storage.a) aVar2.invoke();
        }
        this.g = aVar;
    }

    public void X0(X8.w wVar) {
    }

    public final void Y0(X8.w wVar, List list, u uVar, u uVar2, List list2) {
        if (wVar == null) {
            C0(17);
            throw null;
        }
        if (list == null) {
            C0(18);
            throw null;
        }
        if (list2 == null) {
            C0(19);
            throw null;
        }
        this.e = wVar;
        this.f4835v = new ArrayList(list);
        this.u = uVar2;
        this.f4834t = uVar;
        this.f4833s = list2;
    }

    @Override // h8.InterfaceC1519b
    public final Collection e() {
        Collection collection = this.k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        C0(41);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return this.p;
    }

    @Override // h8.InterfaceC1501I
    public final I getGetter() {
        return this.f4836w;
    }

    @Override // h8.InterfaceC1520c
    public final CallableMemberDescriptor$Kind getKind() {
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = this.m;
        if (callableMemberDescriptor$Kind != null) {
            return callableMemberDescriptor$Kind;
        }
        C0(39);
        throw null;
    }

    @Override // k8.S, h8.InterfaceC1519b
    public final X8.w getReturnType() {
        X8.w type = getType();
        if (type != null) {
            return type;
        }
        C0(23);
        throw null;
    }

    @Override // h8.InterfaceC1501I
    public final J getSetter() {
        return this.f4837x;
    }

    @Override // k8.S, h8.InterfaceC1519b
    public final List getTypeParameters() {
        ArrayList arrayList = this.f4835v;
        if (arrayList != null) {
            return arrayList;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // h8.InterfaceC1530m, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = this.f4830j;
        if (c1531n != null) {
            return c1531n;
        }
        C0(25);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final Modality i() {
        Modality modality = this.i;
        if (modality != null) {
            return modality;
        }
        C0(24);
        throw null;
    }

    @Override // h8.InterfaceC1510S
    public final L8.g i0() {
        kotlin.reflect.jvm.internal.impl.storage.a aVar = this.g;
        if (aVar != null) {
            return (L8.g) aVar.invoke();
        }
        return null;
    }

    @Override // h8.InterfaceC1510S
    public boolean isConst() {
        return this.o;
    }

    public boolean isExternal() {
        return this.f4831q;
    }

    @Override // h8.InterfaceC1501I
    public final ArrayList l() {
        ArrayList arrayList = new ArrayList(2);
        I i = this.f4836w;
        if (i != null) {
            arrayList.add(i);
        }
        J j5 = this.f4837x;
        if (j5 != null) {
            arrayList.add(j5);
        }
        return arrayList;
    }

    @Override // h8.InterfaceC1501I
    public final r o0() {
        return this.y;
    }

    @Override // h8.InterfaceC1519b
    public final List p0() {
        List list = this.f4833s;
        if (list != null) {
            return list;
        }
        C0(22);
        throw null;
    }

    @Override // h8.InterfaceC1510S
    public final boolean q0() {
        return this.n;
    }

    @Override // h8.InterfaceC1501I
    public final boolean s() {
        return this.f4832r;
    }

    @Override // h8.InterfaceC1520c
    public final void u0(Collection collection) {
        if (collection != null) {
            this.k = collection;
        } else {
            C0(40);
            throw null;
        }
    }

    @Override // h8.InterfaceC1519b
    public Object v0(InterfaceC1518a interfaceC1518a) {
        return null;
    }

    @Override // h8.InterfaceC1505M
    public final InterfaceC1501I b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar == null) {
            C0(27);
            throw null;
        }
        if (aVar.f5144a.e()) {
            return this;
        }
        G g = new G(this);
        X8.P pF = aVar.f();
        if (pF == null) {
            G.a(15);
            throw null;
        }
        g.f = pF;
        g.d = a();
        return g.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [h8.I] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1501I a() {
        InterfaceC1501I interfaceC1501I = this.l;
        ?? A10 = this;
        if (interfaceC1501I != this) {
            A10 = interfaceC1501I.a();
        }
        if (A10 != 0) {
            return A10;
        }
        C0(38);
        throw null;
    }
}
