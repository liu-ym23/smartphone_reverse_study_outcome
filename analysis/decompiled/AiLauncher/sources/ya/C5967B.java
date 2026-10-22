package ya;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.B, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5967B {
    public static /* synthetic */ void a(int i10) {
        String str = i10 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 4 ? 3 : 2];
        switch (i10) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i10 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i10 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i10 == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static TypeSubstitutor b(List<E9.b0> list, E0 e02, InterfaceC0803h interfaceC0803h, List<E9.b0> list2) {
        if (list == null) {
            a(0);
        }
        if (e02 == null) {
            a(1);
        }
        if (interfaceC0803h == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        TypeSubstitutor typeSubstitutorC = c(list, e02, interfaceC0803h, list2, null);
        if (typeSubstitutorC != null) {
            return typeSubstitutorC;
        }
        throw new AssertionError("Substitution failed");
    }

    public static TypeSubstitutor c(List<E9.b0> list, E0 e02, InterfaceC0803h interfaceC0803h, List<E9.b0> list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (e02 == null) {
            a(6);
        }
        if (interfaceC0803h == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i10 = 0;
        for (E9.b0 b0Var : list) {
            H9.U uK0 = H9.U.K0(interfaceC0803h, b0Var.getAnnotations(), b0Var.w(), b0Var.l(), b0Var.getName(), i10, E9.W.f2444a, b0Var.I());
            map.put(b0Var.j(), new D0(uK0.n()));
            map2.put(b0Var, uK0);
            list2.add(uK0);
            i10++;
        }
        w0 w0VarJ = w0.j(map);
        TypeSubstitutor typeSubstitutorI = TypeSubstitutor.i(e02, w0VarJ);
        TypeSubstitutor typeSubstitutorI2 = TypeSubstitutor.i(e02.h(), w0VarJ);
        for (E9.b0 b0Var2 : list) {
            H9.U u10 = (H9.U) map2.get(b0Var2);
            for (S s10 : b0Var2.getUpperBounds()) {
                InterfaceC0799d interfaceC0799dD = s10.H0().d();
                S sQ = (((interfaceC0799dD instanceof E9.b0) && Da.d.p((E9.b0) interfaceC0799dD)) ? typeSubstitutorI : typeSubstitutorI2).q(s10, Variance.OUT_VARIANCE);
                if (sQ == null) {
                    return null;
                }
                if (sQ != s10 && zArr != null) {
                    zArr[0] = true;
                }
                u10.G0(sQ);
            }
            u10.P0();
        }
        return typeSubstitutorI;
    }
}
