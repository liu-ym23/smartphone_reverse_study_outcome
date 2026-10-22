package H9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.InterfaceC0812q;
import E9.b0;
import E9.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ma.AbstractC4927g;
import p9.InterfaceC5063a;
import sa.C5456c;
import sa.C5457d;
import sa.InterfaceC5459f;
import xa.InterfaceC5866i;
import ya.C5967B;
import ya.E0;

/* loaded from: classes5.dex */
public class K extends Y implements E9.O {

    /* renamed from: A, reason: collision with root package name */
    public InterfaceC0812q f3032A;

    /* renamed from: B, reason: collision with root package name */
    public InterfaceC0812q f3033B;

    /* renamed from: i, reason: collision with root package name */
    public final Modality f3034i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC0811p f3035j;

    /* renamed from: k, reason: collision with root package name */
    public Collection<? extends E9.O> f3036k;

    /* renamed from: l, reason: collision with root package name */
    public final E9.O f3037l;

    /* renamed from: m, reason: collision with root package name */
    public final CallableMemberDescriptor.Kind f3038m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3039n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3040o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f3041p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3042q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3043r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f3044s;

    /* renamed from: t, reason: collision with root package name */
    public List<E9.S> f3045t;

    /* renamed from: u, reason: collision with root package name */
    public E9.S f3046u;

    /* renamed from: v, reason: collision with root package name */
    public E9.S f3047v;

    /* renamed from: w, reason: collision with root package name */
    public List<b0> f3048w;

    /* renamed from: x, reason: collision with root package name */
    public L f3049x;

    /* renamed from: y, reason: collision with root package name */
    public E9.Q f3050y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3051z;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC0803h f3052a;

        /* renamed from: b, reason: collision with root package name */
        public Modality f3053b;

        /* renamed from: c, reason: collision with root package name */
        public AbstractC0811p f3054c;

        /* renamed from: f, reason: collision with root package name */
        public CallableMemberDescriptor.Kind f3057f;

        /* renamed from: i, reason: collision with root package name */
        public E9.S f3060i;

        /* renamed from: k, reason: collision with root package name */
        public ga.e f3062k;

        /* renamed from: l, reason: collision with root package name */
        public ya.S f3063l;

        /* renamed from: d, reason: collision with root package name */
        public E9.O f3055d = null;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3056e = false;

        /* renamed from: g, reason: collision with root package name */
        public E0 f3058g = E0.f44017b;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3059h = true;

        /* renamed from: j, reason: collision with root package name */
        public List<b0> f3061j = null;

        public a() {
            this.f3052a = K.this.b();
            this.f3053b = K.this.p();
            this.f3054c = K.this.getVisibility();
            this.f3057f = K.this.getKind();
            this.f3060i = K.this.f3046u;
            this.f3062k = K.this.getName();
            this.f3063l = K.this.getType();
        }

        public static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5 || i10 == 7 || i10 == 9 || i10 == 11 || i10 == 19 || i10 == 13 || i10 == 14 || i10 == 16 || i10 == 17) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "setOwner";
            } else if (i10 == 2) {
                objArr[1] = "setOriginal";
            } else if (i10 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i10 == 5) {
                objArr[1] = "setReturnType";
            } else if (i10 == 7) {
                objArr[1] = "setModality";
            } else if (i10 == 9) {
                objArr[1] = "setVisibility";
            } else if (i10 == 11) {
                objArr[1] = "setKind";
            } else if (i10 == 19) {
                objArr[1] = "setName";
            } else if (i10 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i10 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i10 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i10 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 5 && i10 != 7 && i10 != 9 && i10 != 11 && i10 != 19 && i10 != 13 && i10 != 14 && i10 != 16 && i10 != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public E9.O n() {
            return K.this.K0(this);
        }

        public E9.P o() {
            E9.O o10 = this.f3055d;
            if (o10 == null) {
                return null;
            }
            return o10.getGetter();
        }

        public E9.Q p() {
            E9.O o10 = this.f3055d;
            if (o10 == null) {
                return null;
            }
            return o10.getSetter();
        }

        public a q(boolean z10) {
            this.f3059h = z10;
            return this;
        }

        public a r(CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f3057f = kind;
            return this;
        }

        public a s(Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.f3053b = modality;
            return this;
        }

        public a t(CallableMemberDescriptor callableMemberDescriptor) {
            this.f3055d = (E9.O) callableMemberDescriptor;
            return this;
        }

        public a u(InterfaceC0803h interfaceC0803h) {
            if (interfaceC0803h == null) {
                a(0);
            }
            this.f3052a = interfaceC0803h;
            return this;
        }

        public a v(E0 e02) {
            if (e02 == null) {
                a(15);
            }
            this.f3058g = e02;
            return this;
        }

        public a w(AbstractC0811p abstractC0811p) {
            if (abstractC0811p == null) {
                a(8);
            }
            this.f3054c = abstractC0811p;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(InterfaceC0803h interfaceC0803h, E9.O o10, F9.g gVar, Modality modality, AbstractC0811p abstractC0811p, boolean z10, ga.e eVar, CallableMemberDescriptor.Kind kind, E9.W w10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        super(interfaceC0803h, gVar, eVar, null, z10, w10);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (modality == null) {
            T(2);
        }
        if (abstractC0811p == null) {
            T(3);
        }
        if (eVar == null) {
            T(4);
        }
        if (kind == null) {
            T(5);
        }
        if (w10 == null) {
            T(6);
        }
        this.f3036k = null;
        this.f3045t = Collections.EMPTY_LIST;
        this.f3034i = modality;
        this.f3035j = abstractC0811p;
        this.f3037l = o10 == null ? this : o10;
        this.f3038m = kind;
        this.f3039n = z11;
        this.f3040o = z12;
        this.f3041p = z13;
        this.f3042q = z14;
        this.f3043r = z15;
        this.f3044s = z16;
    }

    public static K I0(InterfaceC0803h interfaceC0803h, F9.g gVar, Modality modality, AbstractC0811p abstractC0811p, boolean z10, ga.e eVar, CallableMemberDescriptor.Kind kind, E9.W w10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        if (interfaceC0803h == null) {
            T(7);
        }
        if (gVar == null) {
            T(8);
        }
        if (modality == null) {
            T(9);
        }
        if (abstractC0811p == null) {
            T(10);
        }
        if (eVar == null) {
            T(11);
        }
        if (kind == null) {
            T(12);
        }
        if (w10 == null) {
            T(13);
        }
        return new K(interfaceC0803h, null, gVar, modality, abstractC0811p, z10, eVar, kind, w10, z11, z12, z13, z14, z15, z16);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.e N0(TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        if (typeSubstitutor == null) {
            T(30);
        }
        if (fVar == null) {
            T(31);
        }
        if (fVar.m0() != null) {
            return fVar.m0().c(typeSubstitutor);
        }
        return null;
    }

    public static AbstractC0811p S0(AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind) {
        return (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && C0810o.g(abstractC0811p.f())) ? C0810o.f2476h : abstractC0811p;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void T(int r11) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H9.K.T(int):void");
    }

    public static E9.S X0(TypeSubstitutor typeSubstitutor, E9.O o10, E9.S s10) {
        ya.S sQ = typeSubstitutor.q(s10.getType(), Variance.IN_VARIANCE);
        if (sQ == null) {
            return null;
        }
        return new N(o10, new C5456c(o10, sQ, ((InterfaceC5459f) s10.getValue()).a(), s10.getValue()), s10.getAnnotations());
    }

    public static E9.S Y0(TypeSubstitutor typeSubstitutor, E9.O o10, E9.S s10) {
        ya.S sQ = typeSubstitutor.q(s10.getType(), Variance.IN_VARIANCE);
        if (sQ == null) {
            return null;
        }
        return new N(o10, new C5457d(o10, sQ, s10.getValue()), s10.getAnnotations());
    }

    @Override // H9.X, kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S H() {
        return this.f3046u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public E9.O y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, boolean z10) {
        E9.O oN = R0().u(interfaceC0803h).t(null).s(modality).w(abstractC0811p).r(kind).q(z10).n();
        if (oN == null) {
            T(42);
        }
        return oN;
    }

    public K J0(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, E9.O o10, CallableMemberDescriptor.Kind kind, ga.e eVar, E9.W w10) {
        if (interfaceC0803h == null) {
            T(32);
        }
        if (modality == null) {
            T(33);
        }
        if (abstractC0811p == null) {
            T(34);
        }
        if (kind == null) {
            T(35);
        }
        if (eVar == null) {
            T(36);
        }
        if (w10 == null) {
            T(37);
        }
        return new K(interfaceC0803h, o10, getAnnotations(), modality, abstractC0811p, J(), eVar, kind, w10, t0(), isConst(), e0(), S(), isExternal(), z());
    }

    @Override // H9.X, kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S K() {
        return this.f3047v;
    }

    public E9.O K0(a aVar) {
        E9.S s10;
        InterfaceC5063a<InterfaceC5866i<AbstractC4927g<?>>> interfaceC5063a;
        if (aVar == null) {
            T(29);
        }
        K kJ0 = J0(aVar.f3052a, aVar.f3053b, aVar.f3054c, aVar.f3055d, aVar.f3057f, aVar.f3062k, M0(aVar.f3056e, aVar.f3055d));
        List<b0> typeParameters = aVar.f3061j == null ? getTypeParameters() : aVar.f3061j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor typeSubstitutorB = C5967B.b(typeParameters, aVar.f3058g, kJ0, arrayList);
        ya.S s11 = aVar.f3063l;
        ya.S sQ = typeSubstitutorB.q(s11, Variance.OUT_VARIANCE);
        if (sQ == null) {
            return null;
        }
        ya.S sQ2 = typeSubstitutorB.q(s11, Variance.IN_VARIANCE);
        if (sQ2 != null) {
            kJ0.T0(sQ2);
        }
        E9.S s12 = aVar.f3060i;
        if (s12 != null) {
            E9.S sC = s12.c(typeSubstitutorB);
            if (sC == null) {
                return null;
            }
            s10 = sC;
        } else {
            s10 = null;
        }
        E9.S s13 = this.f3047v;
        E9.S sY0 = s13 != null ? Y0(typeSubstitutorB, kJ0, s13) : null;
        ArrayList arrayList2 = new ArrayList();
        Iterator<E9.S> it = this.f3045t.iterator();
        while (it.hasNext()) {
            E9.S sX0 = X0(typeSubstitutorB, kJ0, it.next());
            if (sX0 != null) {
                arrayList2.add(sX0);
            }
        }
        kJ0.V0(sQ, arrayList, s10, sY0, arrayList2);
        L l10 = this.f3049x == null ? null : new L(kJ0, this.f3049x.getAnnotations(), aVar.f3053b, S0(this.f3049x.getVisibility(), aVar.f3057f), this.f3049x.D(), this.f3049x.isExternal(), this.f3049x.isInline(), aVar.f3057f, aVar.o(), E9.W.f2444a);
        if (l10 != null) {
            ya.S returnType = this.f3049x.getReturnType();
            l10.H0(N0(typeSubstitutorB, this.f3049x));
            l10.K0(returnType != null ? typeSubstitutorB.q(returnType, Variance.OUT_VARIANCE) : null);
        }
        M m10 = this.f3050y == null ? null : new M(kJ0, this.f3050y.getAnnotations(), aVar.f3053b, S0(this.f3050y.getVisibility(), aVar.f3057f), this.f3050y.D(), this.f3050y.isExternal(), this.f3050y.isInline(), aVar.f3057f, aVar.p(), E9.W.f2444a);
        if (m10 != null) {
            List<i0> listJ0 = AbstractC0839s.J0(m10, this.f3050y.i(), typeSubstitutorB, false, false, null);
            if (listJ0 == null) {
                kJ0.U0(true);
                listJ0 = Collections.singletonList(M.J0(m10, DescriptorUtilsKt.m(aVar.f3052a).I(), this.f3050y.i().get(0).getAnnotations()));
            }
            if (listJ0.size() != 1) {
                throw new IllegalStateException();
            }
            m10.H0(N0(typeSubstitutorB, this.f3050y));
            m10.L0(listJ0.get(0));
        }
        InterfaceC0812q interfaceC0812q = this.f3032A;
        r rVar = interfaceC0812q == null ? null : new r(interfaceC0812q.getAnnotations(), kJ0);
        InterfaceC0812q interfaceC0812q2 = this.f3033B;
        kJ0.P0(l10, m10, rVar, interfaceC0812q2 == null ? null : new r(interfaceC0812q2.getAnnotations(), kJ0));
        if (aVar.f3059h) {
            Ia.k kVarC = Ia.k.c();
            Iterator<? extends E9.O> it2 = d().iterator();
            while (it2.hasNext()) {
                kVarC.add(it2.next().c(typeSubstitutorB));
            }
            kJ0.x0(kVarC);
        }
        if (isConst() && (interfaceC5063a = this.f3096h) != null) {
            kJ0.E0(this.f3095g, interfaceC5063a);
        }
        return kJ0;
    }

    @Override // E9.O
    public InterfaceC0812q L() {
        return this.f3033B;
    }

    @Override // E9.O
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public L getGetter() {
        return this.f3049x;
    }

    public final E9.W M0(boolean z10, E9.O o10) {
        E9.W wE;
        if (z10) {
            if (o10 == null) {
                o10 = a();
            }
            wE = o10.e();
        } else {
            wE = E9.W.f2444a;
        }
        if (wE == null) {
            T(28);
        }
        return wE;
    }

    public void O0(L l10, E9.Q q10) {
        P0(l10, q10, null, null);
    }

    public void P0(L l10, E9.Q q10, InterfaceC0812q interfaceC0812q, InterfaceC0812q interfaceC0812q2) {
        this.f3049x = l10;
        this.f3050y = q10;
        this.f3032A = interfaceC0812q;
        this.f3033B = interfaceC0812q2;
    }

    public boolean Q0() {
        return this.f3051z;
    }

    public a R0() {
        return new a();
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return this.f3042q;
    }

    public void T0(ya.S s10) {
        if (s10 == null) {
            T(14);
        }
    }

    public void U0(boolean z10) {
        this.f3051z = z10;
    }

    public void V0(ya.S s10, List<? extends b0> list, E9.S s11, E9.S s12, List<E9.S> list2) {
        if (s10 == null) {
            T(17);
        }
        if (list == null) {
            T(18);
        }
        if (list2 == null) {
            T(19);
        }
        A0(s10);
        this.f3048w = new ArrayList(list);
        this.f3047v = s12;
        this.f3046u = s11;
        this.f3045t = list2;
    }

    public void W0(AbstractC0811p abstractC0811p) {
        if (abstractC0811p == null) {
            T(20);
        }
        this.f3035j = abstractC0811p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends E9.O> d() {
        Collection<? extends E9.O> collection = this.f3036k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            T(41);
        }
        return collection;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return this.f3041p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.f3038m;
        if (kind == null) {
            T(39);
        }
        return kind;
    }

    @Override // H9.X, kotlin.reflect.jvm.internal.impl.descriptors.a
    public ya.S getReturnType() {
        ya.S type = getType();
        if (type == null) {
            T(23);
        }
        return type;
    }

    @Override // E9.O
    public E9.Q getSetter() {
        return this.f3050y;
    }

    @Override // H9.X, kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<b0> getTypeParameters() {
        List<b0> list = this.f3048w;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // E9.InterfaceC0807l, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = this.f3035j;
        if (abstractC0811p == null) {
            T(25);
        }
        return abstractC0811p;
    }

    @Override // E9.j0
    public boolean isConst() {
        return this.f3040o;
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return this.f3043r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V o0(a.InterfaceC0437a<V> interfaceC0437a) {
        return null;
    }

    @Override // E9.InterfaceC0816v
    public Modality p() {
        Modality modality = this.f3034i;
        if (modality == null) {
            T(24);
        }
        return modality;
    }

    @Override // E9.O
    public InterfaceC0812q r0() {
        return this.f3032A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<E9.S> s0() {
        List<E9.S> list = this.f3045t;
        if (list == null) {
            T(22);
        }
        return list;
    }

    @Override // E9.O
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f> t() {
        ArrayList arrayList = new ArrayList(2);
        L l10 = this.f3049x;
        if (l10 != null) {
            arrayList.add(l10);
        }
        E9.Q q10 = this.f3050y;
        if (q10 != null) {
            arrayList.add(q10);
        }
        return arrayList;
    }

    @Override // E9.j0
    public boolean t0() {
        return this.f3039n;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.h(this, d10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void x0(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            T(40);
        }
        this.f3036k = collection;
    }

    @Override // E9.k0
    public boolean z() {
        return this.f3044s;
    }

    @Override // E9.Y
    public E9.O c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            T(27);
        }
        return typeSubstitutor.l() ? this : R0().v(typeSubstitutor.k()).t(a()).n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [E9.O] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // H9.AbstractC0835n
    public E9.O a() {
        E9.O o10 = this.f3037l;
        ?? A10 = this;
        if (o10 != this) {
            A10 = o10.a();
        }
        if (A10 == 0) {
            T(38);
        }
        return A10;
    }
}
