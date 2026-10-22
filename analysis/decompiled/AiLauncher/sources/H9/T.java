package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.a0;
import E9.i0;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ka.C4827g;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import sa.InterfaceC5459f;
import sa.InterfaceC5460g;
import w9.InterfaceC5752k;
import xa.InterfaceC5866i;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.C5977L;
import ya.C5998h0;

/* loaded from: classes5.dex */
public final class T extends AbstractC0839s implements Q {

    /* renamed from: E, reason: collision with root package name */
    public final InterfaceC5869l f3077E;

    /* renamed from: F, reason: collision with root package name */
    public final a0 f3078F;

    /* renamed from: G, reason: collision with root package name */
    public final InterfaceC5866i f3079G;

    /* renamed from: H, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.descriptors.b f3080H;

    /* renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f3076J = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(T.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};

    /* renamed from: I, reason: collision with root package name */
    public static final a f3075I = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Q b(InterfaceC5869l storageManager, a0 typeAliasDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.b constructor) {
            kotlin.reflect.jvm.internal.impl.descriptors.b bVarC;
            List<E9.S> listM;
            kotlin.jvm.internal.p.i(storageManager, "storageManager");
            kotlin.jvm.internal.p.i(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.p.i(constructor, "constructor");
            TypeSubstitutor typeSubstitutorC = c(typeAliasDescriptor);
            if (typeSubstitutorC == null || (bVarC = constructor.c(typeSubstitutorC)) == null) {
                return null;
            }
            F9.g annotations = constructor.getAnnotations();
            CallableMemberDescriptor.Kind kind = constructor.getKind();
            kotlin.jvm.internal.p.h(kind, "getKind(...)");
            E9.W wE = typeAliasDescriptor.e();
            kotlin.jvm.internal.p.h(wE, "getSource(...)");
            T t10 = new T(storageManager, typeAliasDescriptor, bVarC, null, annotations, kind, wE, null);
            List<i0> listI0 = AbstractC0839s.I0(t10, constructor.i(), typeSubstitutorC);
            if (listI0 == null) {
                return null;
            }
            AbstractC5990d0 abstractC5990d0C = C5977L.c(bVarC.getReturnType().K0());
            AbstractC5990d0 abstractC5990d0N = typeAliasDescriptor.n();
            kotlin.jvm.internal.p.h(abstractC5990d0N, "getDefaultType(...)");
            AbstractC5990d0 abstractC5990d0J = C5998h0.j(abstractC5990d0C, abstractC5990d0N);
            E9.S sH = constructor.H();
            E9.S sI = sH != null ? C4827g.i(t10, typeSubstitutorC.o(sH.getType(), Variance.INVARIANT), F9.g.f2609m0.b()) : null;
            InterfaceC0797b interfaceC0797bR = typeAliasDescriptor.r();
            if (interfaceC0797bR != null) {
                List<E9.S> listS0 = constructor.s0();
                kotlin.jvm.internal.p.h(listS0, "getContextReceiverParameters(...)");
                List<E9.S> list = listS0;
                listM = new ArrayList<>(C1174w.x(list, 10));
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        C1173v.w();
                    }
                    E9.S s10 = (E9.S) obj;
                    ya.S sO = typeSubstitutorC.o(s10.getType(), Variance.INVARIANT);
                    InterfaceC5460g value = s10.getValue();
                    kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    listM.add(C4827g.c(interfaceC0797bR, sO, ((InterfaceC5459f) value).a(), F9.g.f2609m0.b(), i10));
                    i10 = i11;
                }
            } else {
                listM = C1173v.m();
            }
            t10.L0(sI, null, listM, typeAliasDescriptor.o(), listI0, abstractC5990d0J, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return t10;
        }

        public final TypeSubstitutor c(a0 a0Var) {
            if (a0Var.r() == null) {
                return null;
            }
            return TypeSubstitutor.g(a0Var.E());
        }

        public a() {
        }
    }

    public /* synthetic */ T(InterfaceC5869l interfaceC5869l, a0 a0Var, kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Q q10, F9.g gVar, CallableMemberDescriptor.Kind kind, E9.W w10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5869l, a0Var, bVar, q10, gVar, kind, w10);
    }

    public static final T l1(T t10, kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        InterfaceC5869l interfaceC5869l = t10.f3077E;
        a0 a0VarJ1 = t10.j1();
        F9.g annotations = bVar.getAnnotations();
        CallableMemberDescriptor.Kind kind = bVar.getKind();
        kotlin.jvm.internal.p.h(kind, "getKind(...)");
        E9.W wE = t10.j1().e();
        kotlin.jvm.internal.p.h(wE, "getSource(...)");
        T t11 = new T(interfaceC5869l, a0VarJ1, bVar, t10, annotations, kind, wE);
        TypeSubstitutor typeSubstitutorC = f3075I.c(t10.j1());
        if (typeSubstitutorC == null) {
            return null;
        }
        E9.S sH = bVar.H();
        E9.S sC = sH != null ? sH.c(typeSubstitutorC) : null;
        List<E9.S> listS0 = bVar.s0();
        kotlin.jvm.internal.p.h(listS0, "getContextReceiverParameters(...)");
        List<E9.S> list = listS0;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((E9.S) it.next()).c(typeSubstitutorC));
        }
        t11.L0(null, sC, arrayList, t10.j1().o(), t10.i(), t10.getReturnType(), Modality.FINAL, t10.j1().getVisibility());
        return t11;
    }

    @Override // H9.Q
    public kotlin.reflect.jvm.internal.impl.descriptors.b N() {
        return this.f3080H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c
    public boolean X() {
        return N().X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c
    public InterfaceC0797b Y() {
        InterfaceC0797b interfaceC0797bY = N().Y();
        kotlin.jvm.internal.p.h(interfaceC0797bY, "getConstructedClass(...)");
        return interfaceC0797bY;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: f1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Q y(InterfaceC0803h newOwner, Modality modality, AbstractC0811p visibility, CallableMemberDescriptor.Kind kind, boolean z10) {
        kotlin.jvm.internal.p.i(newOwner, "newOwner");
        kotlin.jvm.internal.p.i(modality, "modality");
        kotlin.jvm.internal.p.i(visibility, "visibility");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarBuild = s().s(newOwner).i(modality).r(visibility).q(kind).m(z10).build();
        kotlin.jvm.internal.p.g(eVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (Q) eVarBuild;
    }

    @Override // H9.AbstractC0839s
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public T F0(InterfaceC0803h newOwner, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g annotations, E9.W source) {
        kotlin.jvm.internal.p.i(newOwner, "newOwner");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(source, "source");
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new T(this.f3077E, j1(), N(), this, annotations, kind2, source);
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.a
    public ya.S getReturnType() {
        ya.S returnType = super.getReturnType();
        kotlin.jvm.internal.p.f(returnType);
        return returnType;
    }

    @Override // H9.AbstractC0835n, E9.InterfaceC0803h
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public a0 b() {
        return j1();
    }

    @Override // H9.AbstractC0839s, H9.AbstractC0835n
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public Q a() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = super.a();
        kotlin.jvm.internal.p.g(eVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (Q) eVarA;
    }

    public a0 j1() {
        return this.f3078F;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e, E9.Y
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public Q c(TypeSubstitutor substitutor) {
        kotlin.jvm.internal.p.i(substitutor, "substitutor");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarC = super.c(substitutor);
        kotlin.jvm.internal.p.g(eVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        T t10 = (T) eVarC;
        TypeSubstitutor typeSubstitutorG = TypeSubstitutor.g(t10.getReturnType());
        kotlin.jvm.internal.p.h(typeSubstitutorG, "create(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.b bVarC = N().a().c(typeSubstitutorG);
        if (bVarC == null) {
            return null;
        }
        t10.f3080H = bVarC;
        return t10;
    }

    public T(InterfaceC5869l interfaceC5869l, a0 a0Var, kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Q q10, F9.g gVar, CallableMemberDescriptor.Kind kind, E9.W w10) {
        super(a0Var, q10, gVar, ga.g.f32750j, kind, w10);
        this.f3077E = interfaceC5869l;
        this.f3078F = a0Var;
        P0(j1().S());
        this.f3079G = interfaceC5869l.h(new S(this, bVar));
        this.f3080H = bVar;
    }
}
