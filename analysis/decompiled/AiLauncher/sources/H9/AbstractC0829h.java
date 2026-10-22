package H9;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.Z;
import E9.b0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import p9.InterfaceC5063a;
import ra.C5236i;
import ra.InterfaceC5238k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.AbstractC6009o;
import ya.s0;
import ya.v0;

/* renamed from: H9.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0829h extends AbstractC0835n implements b0 {

    /* renamed from: e, reason: collision with root package name */
    public final Variance f3115e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3116f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3117g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC5865h<v0> f3118h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC5865h<AbstractC5990d0> f3119i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC5869l f3120j;

    /* renamed from: H9.h$a */
    public class a implements InterfaceC5063a<v0> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5869l f3121a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Z f3122b;

        public a(InterfaceC5869l interfaceC5869l, Z z10) {
            this.f3121a = interfaceC5869l;
            this.f3122b = z10;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v0 invoke() {
            return new c(AbstractC0829h.this, this.f3121a, this.f3122b);
        }
    }

    /* renamed from: H9.h$b */
    public class b implements InterfaceC5063a<AbstractC5990d0> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ga.e f3124a;

        /* renamed from: H9.h$b$a */
        public class a implements InterfaceC5063a<InterfaceC5238k> {
            public a() {
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterfaceC5238k invoke() {
                return ra.x.l("Scope for type parameter " + b.this.f3124a.b(), AbstractC0829h.this.getUpperBounds());
            }
        }

        public b(ga.e eVar) {
            this.f3124a = eVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC5990d0 invoke() {
            return ya.V.o(s0.f44124b.k(), AbstractC0829h.this.j(), Collections.EMPTY_LIST, false, new C5236i(new a()));
        }
    }

    /* renamed from: H9.h$c */
    public class c extends AbstractC6009o {

        /* renamed from: d, reason: collision with root package name */
        public final Z f3127d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractC0829h f3128e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC0829h abstractC0829h, InterfaceC5869l interfaceC5869l, Z z10) {
            super(interfaceC5869l);
            if (interfaceC5869l == null) {
                I(0);
            }
            this.f3128e = abstractC0829h;
            this.f3127d = z10;
        }

        public static /* synthetic */ void I(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i10 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // ya.AbstractC6009o
        public void A(ya.S s10) {
            if (s10 == null) {
                I(6);
            }
            this.f3128e.E0(s10);
        }

        @Override // ya.AbstractC6014u, ya.v0
        public InterfaceC0799d d() {
            AbstractC0829h abstractC0829h = this.f3128e;
            if (abstractC0829h == null) {
                I(3);
            }
            return abstractC0829h;
        }

        @Override // ya.v0
        public boolean f() {
            return true;
        }

        @Override // ya.v0
        public C9.j g() {
            C9.j jVarM = DescriptorUtilsKt.m(this.f3128e);
            if (jVarM == null) {
                I(4);
            }
            return jVarM;
        }

        @Override // ya.v0
        public List<b0> getParameters() {
            List<b0> list = Collections.EMPTY_LIST;
            if (list == null) {
                I(2);
            }
            return list;
        }

        @Override // ya.AbstractC6014u
        public boolean j(InterfaceC0799d interfaceC0799d) {
            if (interfaceC0799d == null) {
                I(9);
            }
            return (interfaceC0799d instanceof b0) && kotlin.reflect.jvm.internal.impl.resolve.a.f35994a.m(this.f3128e, (b0) interfaceC0799d, true);
        }

        @Override // ya.AbstractC6009o
        public Collection<ya.S> s() {
            List<ya.S> listF0 = this.f3128e.F0();
            if (listF0 == null) {
                I(1);
            }
            return listF0;
        }

        @Override // ya.AbstractC6009o
        public ya.S t() {
            return Aa.i.d(ErrorTypeKind.CYCLIC_UPPER_BOUNDS, new String[0]);
        }

        public String toString() {
            return this.f3128e.getName().toString();
        }

        @Override // ya.AbstractC6009o
        public Z w() {
            Z z10 = this.f3127d;
            if (z10 == null) {
                I(5);
            }
            return z10;
        }

        @Override // ya.AbstractC6009o
        public List<ya.S> y(List<ya.S> list) {
            if (list == null) {
                I(7);
            }
            List<ya.S> listA0 = this.f3128e.A0(list);
            if (listA0 == null) {
                I(8);
            }
            return listA0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0829h(InterfaceC5869l interfaceC5869l, InterfaceC0803h interfaceC0803h, F9.g gVar, ga.e eVar, Variance variance, boolean z10, int i10, E9.W w10, Z z11) {
        super(interfaceC0803h, gVar, eVar, w10);
        if (interfaceC5869l == null) {
            T(0);
        }
        if (interfaceC0803h == null) {
            T(1);
        }
        if (gVar == null) {
            T(2);
        }
        if (eVar == null) {
            T(3);
        }
        if (variance == null) {
            T(4);
        }
        if (w10 == null) {
            T(5);
        }
        if (z11 == null) {
            T(6);
        }
        this.f3115e = variance;
        this.f3116f = z10;
        this.f3117g = i10;
        this.f3118h = interfaceC5869l.i(new a(interfaceC5869l, z11));
        this.f3119i = interfaceC5869l.i(new b(eVar));
        this.f3120j = interfaceC5869l;
    }

    private static /* synthetic */ void T(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public List<ya.S> A0(List<ya.S> list) {
        if (list == null) {
            T(12);
        }
        if (list == null) {
            T(13);
        }
        return list;
    }

    public abstract void E0(ya.S s10);

    public abstract List<ya.S> F0();

    @Override // E9.b0
    public InterfaceC5869l I() {
        InterfaceC5869l interfaceC5869l = this.f3120j;
        if (interfaceC5869l == null) {
            T(14);
        }
        return interfaceC5869l;
    }

    @Override // E9.b0
    public boolean M() {
        return false;
    }

    @Override // E9.b0
    public int getIndex() {
        return this.f3117g;
    }

    @Override // E9.b0
    public List<ya.S> getUpperBounds() {
        List<ya.S> listE = ((c) j()).e();
        if (listE == null) {
            T(8);
        }
        return listE;
    }

    @Override // E9.b0, E9.InterfaceC0799d
    public final v0 j() {
        v0 v0VarInvoke = this.f3118h.invoke();
        if (v0VarInvoke == null) {
            T(9);
        }
        return v0VarInvoke;
    }

    @Override // E9.b0
    public Variance l() {
        Variance variance = this.f3115e;
        if (variance == null) {
            T(7);
        }
        return variance;
    }

    @Override // E9.InterfaceC0799d
    public AbstractC5990d0 n() {
        AbstractC5990d0 abstractC5990d0Invoke = this.f3119i.invoke();
        if (abstractC5990d0Invoke == null) {
            T(10);
        }
        return abstractC5990d0Invoke;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.e(this, d10);
    }

    @Override // E9.b0
    public boolean w() {
        return this.f3116f;
    }

    @Override // H9.AbstractC0835n
    public b0 a() {
        b0 b0Var = (b0) super.a();
        if (b0Var == null) {
            T(11);
        }
        return b0Var;
    }
}
