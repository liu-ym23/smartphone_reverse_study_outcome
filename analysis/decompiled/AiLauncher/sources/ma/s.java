package ma;

import C9.o;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0819y;
import E9.b0;
import Z8.C1172u;
import Z8.F;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.AbstractC5990d0;
import ya.B0;
import ya.D0;
import ya.S;
import ya.V;
import ya.W;
import ya.s0;

/* loaded from: classes5.dex */
public final class s extends AbstractC4927g<b> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f37205b = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AbstractC4927g<?> a(S argumentType) {
            kotlin.jvm.internal.p.i(argumentType, "argumentType");
            if (W.a(argumentType)) {
                return null;
            }
            int i10 = 0;
            S type = argumentType;
            while (C9.j.d0(type)) {
                type = ((B0) F.X0(type.F0())).getType();
                kotlin.jvm.internal.p.h(type, "getType(...)");
                i10++;
            }
            InterfaceC0799d interfaceC0799dD = type.H0().d();
            if (interfaceC0799dD instanceof InterfaceC0797b) {
                ga.b bVarN = DescriptorUtilsKt.n(interfaceC0799dD);
                return bVarN == null ? new s(new b.a(argumentType)) : new s(bVarN, i10);
            }
            if (interfaceC0799dD instanceof b0) {
                return new s(ga.b.f32721d.c(o.a.f1896b.m()), 0);
            }
            return null;
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public final S f37206a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(S type) {
                super(null);
                kotlin.jvm.internal.p.i(type, "type");
                this.f37206a = type;
            }

            public final S a() {
                return this.f37206a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.p.d(this.f37206a, ((a) obj).f37206a);
            }

            public int hashCode() {
                return this.f37206a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.f37206a + ')';
            }
        }

        /* renamed from: ma.s$b$b, reason: collision with other inner class name */
        public static final class C0474b extends b {

            /* renamed from: a, reason: collision with root package name */
            public final C4926f f37207a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0474b(C4926f value) {
                super(null);
                kotlin.jvm.internal.p.i(value, "value");
                this.f37207a = value;
            }

            public final int a() {
                return this.f37207a.c();
            }

            public final ga.b b() {
                return this.f37207a.d();
            }

            public final C4926f c() {
                return this.f37207a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0474b) && kotlin.jvm.internal.p.d(this.f37207a, ((C0474b) obj).f37207a);
            }

            public int hashCode() {
                return this.f37207a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.f37207a + ')';
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(b value) {
        super(value);
        kotlin.jvm.internal.p.i(value, "value");
    }

    @Override // ma.AbstractC4927g
    public S a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        s0 s0VarK = s0.f44124b.k();
        InterfaceC0797b interfaceC0797bF = module.g().F();
        kotlin.jvm.internal.p.h(interfaceC0797bF, "getKClass(...)");
        return V.h(s0VarK, interfaceC0797bF, C1172u.e(new D0(c(module))));
    }

    public final S c(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        b bVarB = b();
        if (bVarB instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(bVarB instanceof b.C0474b)) {
            throw new NoWhenBranchMatchedException();
        }
        C4926f c4926fC = ((b.C0474b) b()).c();
        ga.b bVarA = c4926fC.a();
        int iB = c4926fC.b();
        InterfaceC0797b interfaceC0797bB = FindClassInModuleKt.b(module, bVarA);
        if (interfaceC0797bB == null) {
            return Aa.i.d(ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE, bVarA.toString(), String.valueOf(iB));
        }
        AbstractC5990d0 abstractC5990d0N = interfaceC0797bB.n();
        kotlin.jvm.internal.p.h(abstractC5990d0N, "getDefaultType(...)");
        S sD = Da.d.D(abstractC5990d0N);
        for (int i10 = 0; i10 < iB; i10++) {
            sD = module.g().m(Variance.INVARIANT, sD);
            kotlin.jvm.internal.p.h(sD, "getArrayType(...)");
        }
        return sD;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(C4926f value) {
        this(new b.C0474b(value));
        kotlin.jvm.internal.p.i(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(ga.b classId, int i10) {
        this(new C4926f(classId, i10));
        kotlin.jvm.internal.p.i(classId, "classId");
    }
}
