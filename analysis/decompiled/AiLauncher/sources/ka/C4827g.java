package ka;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import E9.O;
import E9.S;
import E9.W;
import E9.b0;
import F9.g;
import H9.C0830i;
import H9.K;
import H9.L;
import H9.M;
import H9.N;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import sa.C5455b;
import sa.C5456c;
import sa.C5457d;
import ya.AbstractC5990d0;
import ya.D0;
import ya.V;
import ya.s0;

/* renamed from: ka.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4827g {

    /* renamed from: ka.g$a */
    public static class a extends C0830i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0797b interfaceC0797b, W w10, boolean z10) {
            super(interfaceC0797b, null, F9.g.f2609m0.b(), true, CallableMemberDescriptor.Kind.DECLARATION, w10);
            if (interfaceC0797b == null) {
                T(0);
            }
            if (w10 == null) {
                T(1);
            }
            k1(Collections.EMPTY_LIST, C4828h.k(interfaceC0797b, z10));
        }

        private static /* synthetic */ void T(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 12 || i10 == 23 || i10 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 23 || i10 == 25) ? 2 : 3];
        switch (i10) {
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
                objArr[0] = "source";
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
        if (i10 == 12) {
            objArr[1] = "createSetter";
        } else if (i10 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i10 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i10) {
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
        if (i10 != 12 && i10 != 23 && i10 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static S b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, ya.S s10, ga.e eVar, F9.g gVar, int i10) {
        if (aVar == null) {
            a(32);
        }
        if (gVar == null) {
            a(33);
        }
        if (s10 == null) {
            return null;
        }
        return new N(aVar, new C5456c(aVar, s10, eVar, null), gVar, ga.f.a(i10));
    }

    public static S c(InterfaceC0797b interfaceC0797b, ya.S s10, ga.e eVar, F9.g gVar, int i10) {
        if (interfaceC0797b == null) {
            a(34);
        }
        if (gVar == null) {
            a(35);
        }
        if (s10 == null) {
            return null;
        }
        return new N(interfaceC0797b, new C5455b(interfaceC0797b, s10, eVar, null), gVar, ga.f.a(i10));
    }

    public static L d(O o10, F9.g gVar) {
        if (o10 == null) {
            a(13);
        }
        if (gVar == null) {
            a(14);
        }
        return j(o10, gVar, true, false, false);
    }

    public static M e(O o10, F9.g gVar, F9.g gVar2) {
        if (o10 == null) {
            a(0);
        }
        if (gVar == null) {
            a(1);
        }
        if (gVar2 == null) {
            a(2);
        }
        return n(o10, gVar, gVar2, true, false, false, o10.e());
    }

    public static O f(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(26);
        }
        InterfaceC0819y interfaceC0819yG = C4828h.g(interfaceC0797b);
        InterfaceC0797b interfaceC0797bA = C4840t.a(interfaceC0819yG).a(interfaceC0819yG);
        if (interfaceC0797bA == null) {
            return null;
        }
        g.a aVar = F9.g.f2609m0;
        F9.g gVarB = aVar.b();
        Modality modality = Modality.FINAL;
        AbstractC0811p abstractC0811p = C0810o.f2473e;
        ga.e eVar = C9.o.f1824e;
        CallableMemberDescriptor.Kind kind = CallableMemberDescriptor.Kind.SYNTHESIZED;
        K kI0 = K.I0(interfaceC0797b, gVarB, modality, abstractC0811p, false, eVar, kind, interfaceC0797b.e(), false, false, false, false, false, false);
        L l10 = new L(kI0, aVar.b(), modality, abstractC0811p, false, false, false, kind, null, interfaceC0797b.e());
        kI0.O0(l10, null);
        AbstractC5990d0 abstractC5990d0J = V.j(s0.f44124b.k(), interfaceC0797bA.j(), Collections.singletonList(new D0(interfaceC0797b.n())), false);
        List<? extends b0> list = Collections.EMPTY_LIST;
        kI0.V0(abstractC5990d0J, list, null, null, list);
        l10.K0(kI0.getReturnType());
        return kI0;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.g g(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(24);
        }
        g.a aVar = F9.g.f2609m0;
        H9.O oF1 = H9.O.f1(interfaceC0797b, aVar.b(), C9.o.f1825f, CallableMemberDescriptor.Kind.SYNTHESIZED, interfaceC0797b.e());
        H9.V v10 = new H9.V(oF1, null, 0, aVar.b(), ga.e.j(UxipConstants.f30680s), DescriptorUtilsKt.m(interfaceC0797b).X(), false, false, false, null, interfaceC0797b.e());
        List<S> list = Collections.EMPTY_LIST;
        H9.O oH1 = oF1.L0(null, null, list, list, Collections.singletonList(v10), interfaceC0797b.n(), Modality.FINAL, C0810o.f2473e);
        if (oH1 == null) {
            a(25);
        }
        return oH1;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.g h(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(22);
        }
        H9.O oF1 = H9.O.f1(interfaceC0797b, F9.g.f2609m0.b(), C9.o.f1823d, CallableMemberDescriptor.Kind.SYNTHESIZED, interfaceC0797b.e());
        List<S> list = Collections.EMPTY_LIST;
        H9.O oH1 = oF1.L0(null, null, list, list, list, DescriptorUtilsKt.m(interfaceC0797b).m(Variance.INVARIANT, interfaceC0797b.n()), Modality.FINAL, C0810o.f2473e);
        if (oH1 == null) {
            a(23);
        }
        return oH1;
    }

    public static S i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, ya.S s10, F9.g gVar) {
        if (aVar == null) {
            a(30);
        }
        if (gVar == null) {
            a(31);
        }
        if (s10 == null) {
            return null;
        }
        return new N(aVar, new C5457d(aVar, s10, null), gVar);
    }

    public static L j(O o10, F9.g gVar, boolean z10, boolean z11, boolean z12) {
        if (o10 == null) {
            a(15);
        }
        if (gVar == null) {
            a(16);
        }
        return k(o10, gVar, z10, z11, z12, o10.e());
    }

    public static L k(O o10, F9.g gVar, boolean z10, boolean z11, boolean z12, W w10) {
        if (o10 == null) {
            a(17);
        }
        if (gVar == null) {
            a(18);
        }
        if (w10 == null) {
            a(19);
        }
        return new L(o10, gVar, o10.p(), o10.getVisibility(), z10, z11, z12, CallableMemberDescriptor.Kind.DECLARATION, null, w10);
    }

    public static C0830i l(InterfaceC0797b interfaceC0797b, W w10) {
        if (interfaceC0797b == null) {
            a(20);
        }
        if (w10 == null) {
            a(21);
        }
        return new a(interfaceC0797b, w10, false);
    }

    public static M m(O o10, F9.g gVar, F9.g gVar2, boolean z10, boolean z11, boolean z12, AbstractC0811p abstractC0811p, W w10) {
        if (o10 == null) {
            a(7);
        }
        if (gVar == null) {
            a(8);
        }
        if (gVar2 == null) {
            a(9);
        }
        if (abstractC0811p == null) {
            a(10);
        }
        if (w10 == null) {
            a(11);
        }
        M m10 = new M(o10, gVar, o10.p(), abstractC0811p, z10, z11, z12, CallableMemberDescriptor.Kind.DECLARATION, null, w10);
        m10.L0(M.J0(m10, o10.getType(), gVar2));
        return m10;
    }

    public static M n(O o10, F9.g gVar, F9.g gVar2, boolean z10, boolean z11, boolean z12, W w10) {
        if (o10 == null) {
            a(3);
        }
        if (gVar == null) {
            a(4);
        }
        if (gVar2 == null) {
            a(5);
        }
        if (w10 == null) {
            a(6);
        }
        return m(o10, gVar, gVar2, z10, z11, z12, o10.getVisibility(), w10);
    }

    public static boolean o(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(29);
        }
        return eVar.getKind() == CallableMemberDescriptor.Kind.SYNTHESIZED && C4828h.A(eVar.b());
    }

    public static boolean p(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(28);
        }
        return eVar.getName().equals(C9.o.f1825f) && o(eVar);
    }

    public static boolean q(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(27);
        }
        return eVar.getName().equals(C9.o.f1823d) && o(eVar);
    }
}
