package H9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.i0;
import E9.j0;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import ma.AbstractC4927g;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class V extends X implements i0 {

    /* renamed from: l, reason: collision with root package name */
    public static final a f3084l = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public final int f3085f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3086g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3087h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3088i;

    /* renamed from: j, reason: collision with root package name */
    public final ya.S f3089j;

    /* renamed from: k, reason: collision with root package name */
    public final i0 f3090k;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final V a(kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, i0 i0Var, int i10, F9.g annotations, ga.e name, ya.S outType, boolean z10, boolean z11, boolean z12, ya.S s10, E9.W source, InterfaceC5063a<? extends List<? extends j0>> interfaceC5063a) {
            kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.p.i(annotations, "annotations");
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(outType, "outType");
            kotlin.jvm.internal.p.i(source, "source");
            return interfaceC5063a == null ? new V(containingDeclaration, i0Var, i10, annotations, name, outType, z10, z11, z12, s10, source) : new b(containingDeclaration, i0Var, i10, annotations, name, outType, z10, z11, z12, s10, source, interfaceC5063a);
        }

        public a() {
        }
    }

    public static final class b extends V {

        /* renamed from: m, reason: collision with root package name */
        public final Y8.h f3091m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, i0 i0Var, int i10, F9.g annotations, ga.e name, ya.S outType, boolean z10, boolean z11, boolean z12, ya.S s10, E9.W source, InterfaceC5063a<? extends List<? extends j0>> destructuringVariables) {
            super(containingDeclaration, i0Var, i10, annotations, name, outType, z10, z11, z12, s10, source);
            kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.p.i(annotations, "annotations");
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(outType, "outType");
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(destructuringVariables, "destructuringVariables");
            this.f3091m = C4848b.b(destructuringVariables);
        }

        public static final List I0(b bVar) {
            return bVar.J0();
        }

        public final List<j0> J0() {
            return (List) this.f3091m.getValue();
        }

        @Override // H9.V, E9.i0
        public i0 U(kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, ga.e newName, int i10) {
            kotlin.jvm.internal.p.i(newOwner, "newOwner");
            kotlin.jvm.internal.p.i(newName, "newName");
            F9.g annotations = getAnnotations();
            kotlin.jvm.internal.p.h(annotations, "<get-annotations>(...)");
            ya.S type = getType();
            kotlin.jvm.internal.p.h(type, "getType(...)");
            boolean zV0 = v0();
            boolean zL0 = l0();
            boolean zJ0 = j0();
            ya.S sP0 = p0();
            E9.W NO_SOURCE = E9.W.f2444a;
            kotlin.jvm.internal.p.h(NO_SOURCE, "NO_SOURCE");
            return new b(newOwner, null, i10, annotations, newName, type, zV0, zL0, zJ0, sP0, NO_SOURCE, new W(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, i0 i0Var, int i10, F9.g annotations, ga.e name, ya.S outType, boolean z10, boolean z11, boolean z12, ya.S s10, E9.W source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.p.i(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(outType, "outType");
        kotlin.jvm.internal.p.i(source, "source");
        this.f3085f = i10;
        this.f3086g = z10;
        this.f3087h = z11;
        this.f3088i = z12;
        this.f3089j = s10;
        this.f3090k = i0Var == null ? this : i0Var;
    }

    public static final V E0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, i0 i0Var, int i10, F9.g gVar, ga.e eVar, ya.S s10, boolean z10, boolean z11, boolean z12, ya.S s11, E9.W w10, InterfaceC5063a<? extends List<? extends j0>> interfaceC5063a) {
        return f3084l.a(aVar, i0Var, i10, gVar, eVar, s10, z10, z11, z12, s11, w10, interfaceC5063a);
    }

    public Void F0() {
        return null;
    }

    @Override // E9.Y
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public i0 c(TypeSubstitutor substitutor) {
        kotlin.jvm.internal.p.i(substitutor, "substitutor");
        if (substitutor.l()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // E9.j0
    public boolean J() {
        return false;
    }

    @Override // E9.i0
    public i0 U(kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, ga.e newName, int i10) {
        kotlin.jvm.internal.p.i(newOwner, "newOwner");
        kotlin.jvm.internal.p.i(newName, "newName");
        F9.g annotations = getAnnotations();
        kotlin.jvm.internal.p.h(annotations, "<get-annotations>(...)");
        ya.S type = getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        boolean zV0 = v0();
        boolean zL0 = l0();
        boolean zJ0 = j0();
        ya.S sP0 = p0();
        E9.W NO_SOURCE = E9.W.f2444a;
        kotlin.jvm.internal.p.h(NO_SOURCE, "NO_SOURCE");
        return new V(newOwner, null, i10, annotations, newName, type, zV0, zL0, zJ0, sP0, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<i0> d() {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> collectionD = b().d();
        kotlin.jvm.internal.p.h(collectionD, "getOverriddenDescriptors(...)");
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> collection = collectionD;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.a) it.next()).i().get(getIndex()));
        }
        return arrayList;
    }

    @Override // E9.i0
    public int getIndex() {
        return this.f3085f;
    }

    @Override // E9.InterfaceC0807l, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p LOCAL = C0810o.f2474f;
        kotlin.jvm.internal.p.h(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // E9.j0
    public /* bridge */ /* synthetic */ AbstractC4927g i0() {
        return (AbstractC4927g) F0();
    }

    @Override // E9.i0
    public boolean j0() {
        return this.f3088i;
    }

    @Override // E9.i0
    public boolean l0() {
        return this.f3087h;
    }

    @Override // E9.i0
    public ya.S p0() {
        return this.f3089j;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> visitor, D d10) {
        kotlin.jvm.internal.p.i(visitor, "visitor");
        return visitor.l(this, d10);
    }

    @Override // E9.i0
    public boolean v0() {
        if (!this.f3086g) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarB = b();
        kotlin.jvm.internal.p.g(aVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        return ((CallableMemberDescriptor) aVarB).getKind().isReal();
    }

    @Override // H9.AbstractC0835n, E9.InterfaceC0803h
    public kotlin.reflect.jvm.internal.impl.descriptors.a b() {
        InterfaceC0803h interfaceC0803hB = super.b();
        kotlin.jvm.internal.p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) interfaceC0803hB;
    }

    @Override // H9.AbstractC0835n
    public i0 a() {
        i0 i0Var = this.f3090k;
        return i0Var == this ? this : i0Var.a();
    }
}
