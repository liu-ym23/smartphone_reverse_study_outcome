package Y8;

import X8.A;
import X8.AbstractC0272c;
import X8.AbstractC0285p;
import X8.C0281l;
import X8.D;
import X8.F;
import X8.J;
import X8.K;
import X8.L;
import X8.N;
import X8.S;
import X8.U;
import X8.v;
import X8.w;
import a9.InterfaceC0309a;
import a9.InterfaceC0310b;
import a9.InterfaceC0311c;
import a9.InterfaceC0312d;
import a9.InterfaceC0313e;
import h8.C1537t;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* loaded from: classes4.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final A0.b f1575a = new A0.b("KotlinTypeRefiner", 5);

    public static boolean A(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return ((K) receiver).f();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean B(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            return AbstractC0272c.k((w) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean C(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            InterfaceC1524g interfaceC1524gD = ((K) receiver).d();
            InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
            return (interfaceC1522e != null ? interfaceC1522e.P() : null) instanceof C1537t;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean D(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return receiver instanceof L8.n;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean E(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return receiver instanceof v;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean F(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            return ((A) receiver).W();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean G(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return e8.i.H((K) receiver, e8.n.b);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean H(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            return S.e((w) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean I(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            return e8.i.F((w) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean J(InterfaceC0309a interfaceC0309a) {
        if (interfaceC0309a instanceof h) {
            return ((h) interfaceC0309a).g;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(interfaceC0309a);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, interfaceC0309a.getClass(), sb).toString());
    }

    public static boolean K(N receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof N) {
            return receiver.c();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void L(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            return;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            return;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static A N(AbstractC0285p abstractC0285p) {
        if (abstractC0285p instanceof AbstractC0285p) {
            return abstractC0285p.b;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(abstractC0285p);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, abstractC0285p.getClass(), sb).toString());
    }

    public static U O(InterfaceC0309a interfaceC0309a) {
        if (interfaceC0309a instanceof h) {
            return ((h) interfaceC0309a).d;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(interfaceC0309a);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, interfaceC0309a.getClass(), sb).toString());
    }

    public static U P(InterfaceC0310b interfaceC0310b) {
        if (interfaceC0310b instanceof U) {
            return AbstractC0272c.n((U) interfaceC0310b, false);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(interfaceC0310b);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, interfaceC0310b.getClass(), sb).toString());
    }

    public static A Q(C0281l c0281l) {
        if (c0281l instanceof C0281l) {
            return c0281l.b;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(c0281l);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, c0281l.getClass(), sb).toString());
    }

    public static int R(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return ((K) receiver).getParameters().size();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static Collection S(b bVar, InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        K kG = bVar.g(receiver);
        if (kG instanceof L8.n) {
            return ((L8.n) kG).f941a;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static N T(K8.b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof i) {
            return ((i) receiver).f1576a;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a U(b bVar, InterfaceC0311c interfaceC0311c) {
        if (interfaceC0311c instanceof A) {
            w wVar = (w) interfaceC0311c;
            return new a(bVar, new kotlin.reflect.jvm.internal.impl.types.a(L.b.f(wVar.Q(), wVar.L())));
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(interfaceC0311c);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, interfaceC0311c.getClass(), sb).toString());
    }

    public static Collection V(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            Collection collectionE = ((K) receiver).e();
            kotlin.jvm.internal.k.e(collectionE, "getSupertypes(...)");
            return collectionE;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static K W(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            return ((A) receiver).Q();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static i X(InterfaceC0309a receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof h) {
            return ((h) receiver).c;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static A Y(AbstractC0285p abstractC0285p) {
        if (abstractC0285p instanceof AbstractC0285p) {
            return abstractC0285p.c;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(abstractC0285p);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, abstractC0285p.getClass(), sb).toString());
    }

    public static A Z(InterfaceC0311c receiver, boolean z10) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            return ((A) receiver).f0(z10);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static InterfaceC0310b a0(b bVar, InterfaceC0310b interfaceC0310b) {
        if (interfaceC0310b instanceof InterfaceC0311c) {
            return bVar.f0((InterfaceC0311c) interfaceC0310b, true);
        }
        if (!(interfaceC0310b instanceof AbstractC0285p)) {
            throw new IllegalStateException("sealed");
        }
        AbstractC0285p abstractC0285p = (AbstractC0285p) interfaceC0310b;
        return bVar.K(bVar.f0(bVar.s(abstractC0285p), true), bVar.f0(bVar.t(abstractC0285p), true));
    }

    public static boolean b(InterfaceC0313e c12, InterfaceC0313e c2) {
        kotlin.jvm.internal.k.f(c12, "c1");
        kotlin.jvm.internal.k.f(c2, "c2");
        if (!(c12 instanceof K)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(c12);
            sb.append(", ");
            throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, c12.getClass(), sb).toString());
        }
        if (c2 instanceof K) {
            return c12.equals(c2);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(c2);
        sb2.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, c2.getClass(), sb2).toString());
    }

    public static int c(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            return ((w) receiver).L().size();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static InterfaceC0312d d(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            return (InterfaceC0312d) receiver;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static InterfaceC0309a e(b bVar, InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            if (receiver instanceof D) {
                return bVar.g0(((D) receiver).b);
            }
            if (receiver instanceof h) {
                return (h) receiver;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static C0281l f(InterfaceC0311c receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof A) {
            if (receiver instanceof C0281l) {
                return (C0281l) receiver;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static AbstractC0285p g(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            U uZ = ((w) receiver).Z();
            if (uZ instanceof AbstractC0285p) {
                return (AbstractC0285p) uZ;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static A h(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            U uZ = ((w) receiver).Z();
            if (uZ instanceof A) {
                return (A) uZ;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static F i(InterfaceC0310b receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            return U7.a.p((w) receiver);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static X8.A j(a9.InterfaceC0311c r13) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y8.g.j(a9.c):X8.A");
    }

    public static CaptureStatus k(InterfaceC0309a receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof h) {
            return ((h) receiver).b;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static J l(boolean z10, kotlin.reflect.jvm.internal.impl.types.checker.a aVar, int i) {
        if ((i & 8) != 0) {
            aVar = e.f1573a;
        }
        return new J(z10, true, m.f1578a, aVar, f.f1574a);
    }

    public static U m(b bVar, InterfaceC0311c lowerBound, InterfaceC0311c upperBound) {
        kotlin.jvm.internal.k.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.k.f(upperBound, "upperBound");
        if (!(lowerBound instanceof A)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(bVar);
            sb.append(", ");
            throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, bVar.getClass(), sb).toString());
        }
        if (upperBound instanceof A) {
            return AbstractC0272c.f((A) lowerBound, (A) upperBound);
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(bVar);
        sb2.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, bVar.getClass(), sb2).toString());
    }

    public static final String n(K k) {
        StringBuilder sb = new StringBuilder();
        o(sb, "type: " + k);
        o(sb, "hashCode: " + k.hashCode());
        o(sb, "javaClass: " + k.getClass().getCanonicalName());
        for (InterfaceC1527j interfaceC1527jD = k.d(); interfaceC1527jD != null; interfaceC1527jD = interfaceC1527jD.d()) {
            o(sb, "fqName: ".concat(I8.g.c.u(interfaceC1527jD)));
            o(sb, "javaClass: " + interfaceC1527jD.getClass().getCanonicalName());
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static final void o(StringBuilder sb, String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        sb.append(str);
        sb.append('\n');
    }

    public static N p(InterfaceC0310b receiver, int i) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof w) {
            return (N) ((w) receiver).L().get(i);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static InterfaceC1507O q(InterfaceC0313e receiver, int i) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            Object obj = ((K) receiver).getParameters().get(i);
            kotlin.jvm.internal.k.e(obj, "get(...)");
            return (InterfaceC1507O) obj;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static U r(N receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof N) {
            return receiver.b().Z();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static InterfaceC1507O s(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            InterfaceC1524g interfaceC1524gD = ((K) receiver).d();
            if (interfaceC1524gD instanceof InterfaceC1507O) {
                return (InterfaceC1507O) interfaceC1524gD;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static TypeVariance t(N receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof N) {
            Variance varianceA = receiver.a();
            kotlin.jvm.internal.k.e(varianceA, "getProjectionKind(...)");
            return z2.l.p(varianceA);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean u(InterfaceC0310b receiver, G8.c fqName) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        if (receiver instanceof w) {
            return ((w) receiver).getAnnotations().k(fqName);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean v(InterfaceC1507O interfaceC1507O, InterfaceC0313e interfaceC0313e) {
        if (interfaceC0313e == null ? true : interfaceC0313e instanceof K) {
            return U7.a.G(interfaceC1507O, (K) interfaceC0313e, 4);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(interfaceC1507O);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, interfaceC1507O.getClass(), sb).toString());
    }

    public static boolean w(InterfaceC0311c a3, InterfaceC0311c b) {
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b, "b");
        if (!(a3 instanceof A)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(a3);
            sb.append(", ");
            throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, a3.getClass(), sb).toString());
        }
        if (b instanceof A) {
            return ((A) a3).L() == ((A) b).L();
        }
        StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb2.append(b);
        sb2.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, b.getClass(), sb2).toString());
    }

    public static boolean x(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return e8.i.H((K) receiver, e8.n.f4413a);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean y(InterfaceC0313e receiver) {
        kotlin.jvm.internal.k.f(receiver, "$receiver");
        if (receiver instanceof K) {
            return ((K) receiver).d() instanceof InterfaceC1522e;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(receiver);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, receiver.getClass(), sb).toString());
    }

    public static boolean z(InterfaceC0313e interfaceC0313e) {
        if (interfaceC0313e instanceof K) {
            InterfaceC1524g interfaceC1524gD = ((K) interfaceC0313e).d();
            InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
            return (interfaceC1522e == null || interfaceC1522e.i() != Modality.b || interfaceC1522e.getKind() == ClassKind.c || interfaceC1522e.getKind() == ClassKind.d || interfaceC1522e.getKind() == ClassKind.e) ? false : true;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(interfaceC0313e);
        sb.append(", ");
        throw new IllegalArgumentException(B7.a.t(kotlin.jvm.internal.m.f4928a, interfaceC0313e.getClass(), sb).toString());
    }
}
