package za;

import C9.o;
import E9.C0813s;
import E9.C0817w;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.a0;
import E9.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import ka.C4829i;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import la.C4878a;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5969D;
import ya.C5982Q;
import ya.C5996g0;
import ya.C6017x;
import ya.G0;
import ya.H0;
import ya.InterfaceC5984a0;
import ya.InterfaceC5988c0;
import ya.K0;
import ya.S;
import ya.V;
import ya.W;
import ya.v0;
import ya.w0;

/* renamed from: za.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC6455a extends G0, Ca.t {

    /* renamed from: za.a$a, reason: collision with other inner class name */
    public static final class C0567a {

        /* renamed from: za.a$a$a, reason: collision with other inner class name */
        public static final class C0568a extends TypeCheckerState.b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC6455a f45401a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypeSubstitutor f45402b;

            public C0568a(InterfaceC6455a interfaceC6455a, TypeSubstitutor typeSubstitutor) {
                this.f45401a = interfaceC6455a;
                this.f45402b = typeSubstitutor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Ca.i a(TypeCheckerState state, Ca.g type) {
                kotlin.jvm.internal.p.i(state, "state");
                kotlin.jvm.internal.p.i(type, "type");
                InterfaceC6455a interfaceC6455a = this.f45401a;
                TypeSubstitutor typeSubstitutor = this.f45402b;
                Ca.g gVarZ0 = interfaceC6455a.z0(type);
                kotlin.jvm.internal.p.g(gVarZ0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                S sO = typeSubstitutor.o((S) gVarZ0, Variance.INVARIANT);
                kotlin.jvm.internal.p.h(sO, "safeSubstitute(...)");
                Ca.i iVarF = interfaceC6455a.f((Ca.g) sO);
                kotlin.jvm.internal.p.f(iVarF);
                return iVarF;
            }
        }

        public static Ca.g A(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return C4829i.j((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static List<Ca.g> B(InterfaceC6455a interfaceC6455a, Ca.o receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof b0) {
                List<S> upperBounds = ((b0) receiver).getUpperBounds();
                kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static TypeVariance C(InterfaceC6455a interfaceC6455a, Ca.k receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof B0) {
                Variance varianceC = ((B0) receiver).c();
                kotlin.jvm.internal.p.h(varianceC, "getProjectionKind(...)");
                return Ca.s.a(varianceC);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static TypeVariance D(InterfaceC6455a interfaceC6455a, Ca.o receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof b0) {
                Variance varianceL = ((b0) receiver).l();
                kotlin.jvm.internal.p.h(varianceL, "getVariance(...)");
                return Ca.s.a(varianceL);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean E(InterfaceC6455a interfaceC6455a, Ca.g receiver, ga.c fqName) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            kotlin.jvm.internal.p.i(fqName, "fqName");
            if (receiver instanceof S) {
                return ((S) receiver).getAnnotations().E(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean F(InterfaceC6455a interfaceC6455a, Ca.o receiver, Ca.n nVar) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (!(receiver instanceof b0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
            }
            b0 b0Var = (b0) receiver;
            if (nVar == null ? true : nVar instanceof v0) {
                return Da.d.r(b0Var, (v0) nVar, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b0Var + ", " + kotlin.jvm.internal.t.b(b0Var.getClass())).toString());
        }

        public static boolean G(InterfaceC6455a interfaceC6455a, Ca.h a10, Ca.h b10) {
            kotlin.jvm.internal.p.i(a10, "a");
            kotlin.jvm.internal.p.i(b10, "b");
            if (!(a10 instanceof AbstractC5990d0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a10 + ", " + kotlin.jvm.internal.t.b(a10.getClass())).toString());
            }
            if (b10 instanceof AbstractC5990d0) {
                return ((AbstractC5990d0) a10).F0() == ((AbstractC5990d0) b10).F0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b10 + ", " + kotlin.jvm.internal.t.b(b10.getClass())).toString());
        }

        public static Ca.g H(InterfaceC6455a interfaceC6455a, Collection<? extends Ca.g> types) {
            kotlin.jvm.internal.p.i(types, "types");
            return C6457c.a(types);
        }

        public static boolean I(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return C9.j.x0((v0) receiver, o.a.f1896b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean J(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return C9.j.d0((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean K(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return ((v0) receiver).d() instanceof InterfaceC0797b;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean L(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
                return (interfaceC0797b == null || !C0817w.a(interfaceC0797b) || interfaceC0797b.getKind() == ClassKind.ENUM_ENTRY || interfaceC0797b.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean M(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return ((v0) receiver).f();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean N(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return W.a((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean O(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
                return (interfaceC0797b != null ? interfaceC0797b.P() : null) instanceof C0813s;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean P(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return receiver instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean Q(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return receiver instanceof C5982Q;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean R(InterfaceC6455a interfaceC6455a) {
            return false;
        }

        public static boolean S(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            return (receiver instanceof AbstractC5990d0) && ((AbstractC5990d0) receiver).I0();
        }

        public static boolean T(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            return receiver instanceof InterfaceC5984a0;
        }

        public static boolean U(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return C9.j.x0((v0) receiver, o.a.f1898c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean V(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return H0.l((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean W(InterfaceC6455a interfaceC6455a, Ca.b receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            return receiver instanceof C4878a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean X(InterfaceC6455a interfaceC6455a, Ca.i receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return C9.j.t0((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean Y(InterfaceC6455a interfaceC6455a, Ca.b receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof C6459e) {
                return ((C6459e) receiver).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean Z(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return receiver instanceof InterfaceC5988c0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean a(InterfaceC6455a interfaceC6455a, Ca.n c12, Ca.n c22) {
            kotlin.jvm.internal.p.i(c12, "c1");
            kotlin.jvm.internal.p.i(c22, "c2");
            if (!(c12 instanceof v0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c12 + ", " + kotlin.jvm.internal.t.b(c12.getClass())).toString());
            }
            if (c22 instanceof v0) {
                return kotlin.jvm.internal.p.d(c12, c22);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c22 + ", " + kotlin.jvm.internal.t.b(c22.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean a0(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                if (W.a((S) receiver)) {
                    return false;
                }
                AbstractC5990d0 abstractC5990d0 = (AbstractC5990d0) receiver;
                if (abstractC5990d0.H0().d() instanceof a0) {
                    return false;
                }
                return abstractC5990d0.H0().d() != null || (receiver instanceof C4878a) || (receiver instanceof C6459e) || (receiver instanceof C6017x) || (abstractC5990d0.H0() instanceof IntegerLiteralTypeConstructor) || b0(interfaceC6455a, (Ca.i) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static int b(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return ((S) receiver).F0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean b0(InterfaceC6455a interfaceC6455a, Ca.i iVar) {
            return (iVar instanceof C5996g0) && interfaceC6455a.a(((C5996g0) iVar).A0());
        }

        public static Ca.i c(InterfaceC6455a interfaceC6455a, Ca.g componentType) {
            kotlin.jvm.internal.p.i(componentType, "componentType");
            if (componentType instanceof S) {
                AbstractC5990d0 abstractC5990d0M = interfaceC6455a.g().m(Variance.INVARIANT, (S) componentType);
                kotlin.jvm.internal.p.h(abstractC5990d0M, "getArrayType(...)");
                return abstractC5990d0M;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC6455a + ", " + kotlin.jvm.internal.t.b(interfaceC6455a.getClass())).toString());
        }

        public static boolean c0(InterfaceC6455a interfaceC6455a, Ca.k receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof B0) {
                return ((B0) receiver).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.j d(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                return (Ca.j) receiver;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean d0(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                return Da.d.u((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.b e(InterfaceC6455a interfaceC6455a, Ca.i receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                if (receiver instanceof C5996g0) {
                    return interfaceC6455a.c(((C5996g0) receiver).A0());
                }
                if (receiver instanceof C6459e) {
                    return (C6459e) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean e0(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                return Da.d.v((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.c f(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                if (receiver instanceof C6017x) {
                    return (C6017x) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean f0(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            return (receiver instanceof K0) && (((K0) receiver).H0() instanceof InterfaceC6465k);
        }

        public static Ca.d g(InterfaceC6455a interfaceC6455a, Ca.e receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5974I) {
                if (receiver instanceof C5969D) {
                    return (C5969D) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static boolean g0(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                return interfaceC0799dD != null && C9.j.C0(interfaceC0799dD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.e h(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                K0 K02 = ((S) receiver).K0();
                if (K02 instanceof AbstractC5974I) {
                    return (AbstractC5974I) K02;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.i h0(InterfaceC6455a interfaceC6455a, Ca.e receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5974I) {
                return ((AbstractC5974I) receiver).P0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.i i(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                K0 K02 = ((S) receiver).K0();
                if (K02 instanceof AbstractC5990d0) {
                    return (AbstractC5990d0) K02;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.g i0(InterfaceC6455a interfaceC6455a, Ca.b receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof C6459e) {
                return ((C6459e) receiver).S0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.k j(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return Da.d.d((S) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.g j0(InterfaceC6455a interfaceC6455a, Ca.g receiver, boolean z10) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof K0) {
                return C6456b.b((K0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static AbstractC5990d0 k(InterfaceC6455a interfaceC6455a, Ca.h type, CaptureStatus status) {
            kotlin.jvm.internal.p.i(type, "type");
            kotlin.jvm.internal.p.i(status, "status");
            if (type instanceof AbstractC5990d0) {
                return kotlin.reflect.jvm.internal.impl.types.checker.d.b((AbstractC5990d0) type, status);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + kotlin.jvm.internal.t.b(type.getClass())).toString());
        }

        public static TypeCheckerState k0(InterfaceC6455a interfaceC6455a, boolean z10, boolean z11, boolean z12) {
            return kotlin.reflect.jvm.internal.impl.types.checker.a.b(z10, z11, interfaceC6455a, null, null, 24, null);
        }

        public static CaptureStatus l(InterfaceC6455a interfaceC6455a, Ca.b receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof C6459e) {
                return ((C6459e) receiver).Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.i l0(InterfaceC6455a interfaceC6455a) {
            AbstractC5990d0 abstractC5990d0J = interfaceC6455a.g().J();
            kotlin.jvm.internal.p.h(abstractC5990d0J, "getNullableAnyType(...)");
            return abstractC5990d0J;
        }

        public static Ca.g m(InterfaceC6455a interfaceC6455a, Ca.h lowerBound, Ca.h upperBound) {
            kotlin.jvm.internal.p.i(lowerBound, "lowerBound");
            kotlin.jvm.internal.p.i(upperBound, "upperBound");
            if (!(lowerBound instanceof AbstractC5990d0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC6455a + ", " + kotlin.jvm.internal.t.b(interfaceC6455a.getClass())).toString());
            }
            if (upperBound instanceof AbstractC5990d0) {
                return V.e((AbstractC5990d0) lowerBound, (AbstractC5990d0) upperBound);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC6455a + ", " + kotlin.jvm.internal.t.b(interfaceC6455a.getClass())).toString());
        }

        public static Ca.i m0(InterfaceC6455a interfaceC6455a, Ca.c receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof C6017x) {
                return ((C6017x) receiver).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.k n(InterfaceC6455a interfaceC6455a, Ca.g receiver, int i10) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return ((S) receiver).F0().get(i10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static int n0(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                return ((v0) receiver).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static List<Ca.k> o(InterfaceC6455a interfaceC6455a, Ca.g receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof S) {
                return ((S) receiver).F0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Collection<Ca.g> o0(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            Ca.n nVarE = interfaceC6455a.e(receiver);
            if (nVarE instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) nVarE).l();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static C9.j p(InterfaceC6455a interfaceC6455a) {
            throw new UnsupportedOperationException("Not supported");
        }

        public static Ca.k p0(InterfaceC6455a interfaceC6455a, Ca.a receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof C6464j) {
                return ((C6464j) receiver).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static ga.d q(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                kotlin.jvm.internal.p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtilsKt.p((InterfaceC0797b) interfaceC0799dD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.g q0(InterfaceC6455a interfaceC6455a, Ca.p receiver, Ca.g type) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            kotlin.jvm.internal.p.i(type, "type");
            if (!(type instanceof K0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + kotlin.jvm.internal.t.b(type.getClass())).toString());
            }
            if (receiver instanceof TypeSubstitutor) {
                S sO = ((TypeSubstitutor) receiver).o((S) type, Variance.INVARIANT);
                kotlin.jvm.internal.p.h(sO, "safeSubstitute(...)");
                return sO;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.o r(InterfaceC6455a interfaceC6455a, Ca.n receiver, int i10) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                b0 b0Var = ((v0) receiver).getParameters().get(i10);
                kotlin.jvm.internal.p.h(b0Var, "get(...)");
                return b0Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TypeCheckerState.b r0(InterfaceC6455a interfaceC6455a, Ca.h type) {
            kotlin.jvm.internal.p.i(type, "type");
            if (type instanceof AbstractC5990d0) {
                return new C0568a(interfaceC6455a, w0.f44131c.a((S) type).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + kotlin.jvm.internal.t.b(type.getClass())).toString());
        }

        public static List<Ca.o> s(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                List<b0> parameters = ((v0) receiver).getParameters();
                kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Collection<Ca.g> s0(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                Collection<S> collectionE = ((v0) receiver).e();
                kotlin.jvm.internal.p.h(collectionE, "getSupertypes(...)");
                return collectionE;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static PrimitiveType t(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                kotlin.jvm.internal.p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return C9.j.Q((InterfaceC0797b) interfaceC0799dD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.a t0(InterfaceC6455a interfaceC6455a, Ca.b receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof C6459e) {
                return ((C6459e) receiver).H0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static PrimitiveType u(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                kotlin.jvm.internal.p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return C9.j.T((InterfaceC0797b) interfaceC0799dD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.n u0(InterfaceC6455a interfaceC6455a, Ca.h receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                return ((AbstractC5990d0) receiver).H0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.g v(InterfaceC6455a interfaceC6455a, Ca.o receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof b0) {
                return Da.d.o((b0) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.p v0(InterfaceC6455a interfaceC6455a, Map<Ca.n, ? extends Ca.g> map) {
            kotlin.jvm.internal.p.i(map, "map");
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<Ca.n, ? extends Ca.g> entry : map.entrySet()) {
                Ca.n key = entry.getKey();
                Ca.g value = entry.getValue();
                kotlin.jvm.internal.p.g(key, "null cannot be cast to non-null type org.jetbrains.kotlin.types.TypeConstructor");
                kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                arrayList.add(Y8.j.a((v0) key, Da.d.d((S) value)));
            }
            TypeSubstitutor typeSubstitutorF = TypeSubstitutor.f(kotlin.collections.a.y(arrayList));
            kotlin.jvm.internal.p.h(typeSubstitutorF, "let(...)");
            return typeSubstitutorF;
        }

        public static Ca.g w(InterfaceC6455a interfaceC6455a, Ca.k receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (interfaceC6455a.h(receiver)) {
                return null;
            }
            if (receiver instanceof B0) {
                return ((B0) receiver).getType().K0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.i w0(InterfaceC6455a interfaceC6455a, Ca.e receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5974I) {
                return ((AbstractC5974I) receiver).Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.n x(InterfaceC6455a interfaceC6455a, Ca.o receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof b0) {
                v0 v0VarJ = ((b0) receiver).j();
                kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
                return v0VarJ;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.g x0(InterfaceC6455a interfaceC6455a, Ca.g receiver, boolean z10) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof Ca.h) {
                return interfaceC6455a.b((Ca.h) receiver, z10);
            }
            if (!(receiver instanceof Ca.e)) {
                throw new IllegalStateException("sealed");
            }
            Ca.e eVar = (Ca.e) receiver;
            return interfaceC6455a.w0(interfaceC6455a.b((Ca.h) interfaceC6455a.d(eVar), z10), interfaceC6455a.b((Ca.h) interfaceC6455a.i(eVar), z10));
        }

        public static Ca.o y(InterfaceC6455a interfaceC6455a, Ca.v receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof InterfaceC6465k) {
                return ((InterfaceC6465k) receiver).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.i y0(InterfaceC6455a interfaceC6455a, Ca.h receiver, boolean z10) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof AbstractC5990d0) {
                return ((AbstractC5990d0) receiver).L0(z10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }

        public static Ca.o z(InterfaceC6455a interfaceC6455a, Ca.n receiver) {
            kotlin.jvm.internal.p.i(receiver, "$receiver");
            if (receiver instanceof v0) {
                InterfaceC0799d interfaceC0799dD = ((v0) receiver).d();
                if (interfaceC0799dD instanceof b0) {
                    return (b0) interfaceC0799dD;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + kotlin.jvm.internal.t.b(receiver.getClass())).toString());
        }
    }

    @Override // Ca.q
    boolean a(Ca.h hVar);

    @Override // Ca.q
    Ca.i b(Ca.h hVar, boolean z10);

    @Override // Ca.q
    Ca.b c(Ca.i iVar);

    @Override // Ca.q
    Ca.i d(Ca.e eVar);

    @Override // Ca.q
    Ca.n e(Ca.h hVar);

    @Override // Ca.q
    Ca.i f(Ca.g gVar);

    C9.j g();

    @Override // Ca.q
    boolean h(Ca.k kVar);

    @Override // Ca.q
    Ca.i i(Ca.e eVar);

    Ca.g w0(Ca.h hVar, Ca.h hVar2);
}
