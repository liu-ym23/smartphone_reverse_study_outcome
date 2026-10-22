package J8;

import D7.v;
import Q8.o;
import V8.t;
import X8.A;
import X8.AbstractC0272c;
import X8.F;
import X8.K;
import X8.w;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1506N;
import h8.InterfaceC1519b;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import h8.InterfaceC1540w;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import k8.AbstractC1633b;
import k8.H;
import k8.I;
import k8.J;
import k8.Q;
import k8.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.text.Regex;

/* loaded from: classes4.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final A0.b f889a;
    public static final A0.b b;

    static {
        int i = 5;
        f889a = new A0.b("ResolutionAnchorProvider", i);
        b = new A0.b("StdlibClassFinder", i);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 23 || i == 25) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 31:
            case 33:
            case 35:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 22:
            case 24:
            case 26:
                objArr[0] = "enumClass";
                break;
            case 27:
            case 28:
            case 29:
                objArr[0] = "descriptor";
                break;
            case 30:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case 27:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 28:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 29:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 30:
            case 31:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case 35:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 23 && i != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static final void c(InterfaceC1522e interfaceC1522e, LinkedHashSet linkedHashSet, o oVar, boolean z10) {
        for (InterfaceC1527j interfaceC1527j : z2.l.z(oVar, Q8.f.o, 2)) {
            if (interfaceC1527j instanceof InterfaceC1522e) {
                InterfaceC1522e interfaceC1522eR0 = (InterfaceC1522e) interfaceC1527j;
                if (interfaceC1522eR0.g0()) {
                    G8.f name = interfaceC1522eR0.getName();
                    kotlin.jvm.internal.k.e(name, "getName(...)");
                    InterfaceC1524g interfaceC1524gB = oVar.b(name, NoLookupLocation.d);
                    interfaceC1522eR0 = interfaceC1524gB instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gB : interfaceC1524gB instanceof InterfaceC1506N ? ((t) ((InterfaceC1506N) interfaceC1524gB)).R0() : null;
                }
                if (interfaceC1522eR0 != null) {
                    int i = e.f883a;
                    Iterator it = interfaceC1522eR0.m().e().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (e.p((w) it.next(), interfaceC1522e.a())) {
                                linkedHashSet.add(interfaceC1522eR0);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z10) {
                        o oVarO = interfaceC1522eR0.O();
                        kotlin.jvm.internal.k.e(oVarO, "getUnsubstitutedInnerClassesScope(...)");
                        c(interfaceC1522e, linkedHashSet, oVarO, z10);
                    }
                }
            }
        }
    }

    public static u e(InterfaceC1519b interfaceC1519b, w wVar, G8.f fVar, InterfaceC1561g interfaceC1561g, int i) {
        if (interfaceC1561g == null) {
            a(33);
            throw null;
        }
        if (wVar == null) {
            return null;
        }
        R8.a aVar = new R8.a(interfaceC1519b, wVar, fVar);
        Regex regex = G8.g.f691a;
        return new u(interfaceC1519b, aVar, interfaceC1561g, G8.f.e(G8.g.b + '_' + i));
    }

    public static I f(InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g) {
        return l(interfaceC1501I, interfaceC1561g, true, interfaceC1501I.getSource());
    }

    public static J g(InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g) {
        InterfaceC1503K source = interfaceC1501I.getSource();
        if (source != null) {
            return m(interfaceC1501I, interfaceC1561g, C1560f.f4611a, true, interfaceC1501I.getVisibility(), source);
        }
        a(6);
        throw null;
    }

    public static H h(AbstractC1633b abstractC1633b) {
        if (abstractC1633b == null) {
            a(26);
            throw null;
        }
        InterfaceC1540w interfaceC1540wD = e.d(abstractC1633b);
        kotlin.jvm.internal.k.f(interfaceC1540wD, "<this>");
        InterfaceC1522e interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(interfaceC1540wD, G8.i.f702z);
        if (interfaceC1522eA == null) {
            return null;
        }
        Modality modality = Modality.b;
        C1531n c1531n = AbstractC1532o.e;
        G8.f fVar = e8.o.b;
        InterfaceC1503K source = abstractC1633b.getSource();
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = CallableMemberDescriptor$Kind.d;
        H hS0 = H.S0(abstractC1633b, modality, c1531n, false, fVar, callableMemberDescriptor$Kind, source);
        I i = new I(hS0, C1560f.f4611a, modality, c1531n, false, false, false, callableMemberDescriptor$Kind, null, abstractC1633b.getSource());
        hS0.V0(i, null, null, null);
        X8.H.b.getClass();
        X8.H attributes = X8.H.c;
        K constructor = interfaceC1522eA.m();
        List arguments = Collections.singletonList(new F(abstractC1633b.g()));
        kotlin.jvm.internal.k.f(attributes, "attributes");
        kotlin.jvm.internal.k.f(constructor, "constructor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        A aU = AbstractC0272c.u(attributes, constructor, arguments, false);
        List list = Collections.EMPTY_LIST;
        hS0.Y0(aU, list, null, null, list);
        i.U0(hS0.getReturnType());
        return hS0;
    }

    public static k8.K i(AbstractC1633b abstractC1633b) {
        if (abstractC1633b == null) {
            a(24);
            throw null;
        }
        k8.K kC1 = k8.K.c1(abstractC1633b, e8.o.c, CallableMemberDescriptor$Kind.d, abstractC1633b.getSource());
        Q q5 = new Q(kC1, null, 0, C1560f.f4611a, G8.f.e("value"), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(abstractC1633b).u(), false, false, false, null, abstractC1633b.getSource());
        List list = Collections.EMPTY_LIST;
        return kC1.W0(null, null, list, list, Collections.singletonList(q5), abstractC1633b.g(), Modality.b, AbstractC1532o.e);
    }

    public static k8.K j(AbstractC1633b abstractC1633b) {
        if (abstractC1633b == null) {
            a(22);
            throw null;
        }
        k8.K kC1 = k8.K.c1(abstractC1633b, e8.o.f4426a, CallableMemberDescriptor$Kind.d, abstractC1633b.getSource());
        List list = Collections.EMPTY_LIST;
        e8.i iVarE = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(abstractC1633b);
        Variance variance = Variance.c;
        return kC1.W0(null, null, list, list, list, iVarE.g(abstractC1633b.g()), Modality.b, AbstractC1532o.e);
    }

    public static u k(InterfaceC1519b interfaceC1519b, w wVar, InterfaceC1561g interfaceC1561g) {
        if (wVar == null) {
            return null;
        }
        return new u(interfaceC1519b, new R8.b(interfaceC1519b, wVar), interfaceC1561g);
    }

    public static I l(InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g, boolean z10, InterfaceC1503K interfaceC1503K) {
        if (interfaceC1561g == null) {
            a(18);
            throw null;
        }
        if (interfaceC1503K != null) {
            return new I(interfaceC1501I, interfaceC1561g, interfaceC1501I.i(), interfaceC1501I.getVisibility(), z10, false, false, CallableMemberDescriptor$Kind.f4950a, null, interfaceC1503K);
        }
        a(19);
        throw null;
    }

    public static J m(InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g, InterfaceC1561g interfaceC1561g2, boolean z10, C1531n c1531n, InterfaceC1503K interfaceC1503K) {
        if (interfaceC1561g == null) {
            a(8);
            throw null;
        }
        if (interfaceC1561g2 == null) {
            a(9);
            throw null;
        }
        if (c1531n == null) {
            a(10);
            throw null;
        }
        if (interfaceC1503K == null) {
            a(11);
            throw null;
        }
        J j5 = new J(interfaceC1501I, interfaceC1561g, interfaceC1501I.i(), c1531n, z10, false, false, CallableMemberDescriptor$Kind.f4950a, null, interfaceC1503K);
        j5.m = J.T0(j5, interfaceC1501I.getType(), interfaceC1561g2);
        return j5;
    }

    public static boolean n(InterfaceC1536s interfaceC1536s) {
        if (interfaceC1536s.getKind() != CallableMemberDescriptor$Kind.d) {
            return false;
        }
        InterfaceC1527j interfaceC1527jD = interfaceC1536s.d();
        int i = e.f883a;
        return e.n(interfaceC1527jD, ClassKind.c);
    }

    public static final Collection o(Collection collection, S7.k kVar) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        int i = 1;
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        int i6 = g9.i.c;
        g9.i iVarF = g9.l.f();
        while (!linkedList.isEmpty()) {
            Object objA0 = v.A0(linkedList);
            int i10 = g9.i.c;
            g9.i iVarF2 = g9.l.f();
            ArrayList arrayListG = k.g(objA0, linkedList, kVar, new J4.b(iVarF2, i));
            if (arrayListG.size() == 1 && iVarF2.isEmpty()) {
                Object objT0 = v.T0(arrayListG);
                kotlin.jvm.internal.k.e(objT0, "single(...)");
                iVarF.add(objT0);
            } else {
                Object objS = k.s(arrayListG, kVar);
                InterfaceC1519b interfaceC1519b = (InterfaceC1519b) kVar.invoke(objS);
                Iterator it = arrayListG.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    kotlin.jvm.internal.k.c(next);
                    if (!k.k(interfaceC1519b, (InterfaceC1519b) kVar.invoke(next))) {
                        iVarF2.add(next);
                    }
                }
                if (!iVarF2.isEmpty()) {
                    iVarF.addAll(iVarF2);
                }
                iVarF.add(objS);
            }
        }
        return iVarF;
    }

    public abstract void b(InterfaceC1520c interfaceC1520c);

    public abstract void d(InterfaceC1520c interfaceC1520c, InterfaceC1520c interfaceC1520c2);

    public void p(InterfaceC1520c member, Collection collection) {
        kotlin.jvm.internal.k.f(member, "member");
        member.u0(collection);
    }
}
