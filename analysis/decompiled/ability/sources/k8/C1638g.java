package k8;

import X8.AbstractC0275f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.C1504L;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* renamed from: k8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1638g extends AbstractC0275f {
    public final C1504L c;
    public final /* synthetic */ AbstractC1639h d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1638g(AbstractC1639h abstractC1639h, W8.l lVar, C1504L c1504l) {
        super(lVar);
        if (lVar == null) {
            l(0);
            throw null;
        }
        this.d = abstractC1639h;
        this.c = c1504l;
    }

    public static /* synthetic */ void l(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
        switch (i) {
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
        if (i == 1) {
            objArr[1] = "computeSupertypes";
        } else if (i == 2) {
            objArr[1] = "getParameters";
        } else if (i == 3) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 4) {
            objArr[1] = "getBuiltIns";
        } else if (i == 5) {
            objArr[1] = "getSupertypeLoopChecker";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        } else {
            objArr[1] = "processSupertypesWithoutCycles";
        }
        switch (i) {
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
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // X8.AbstractC0275f
    public final Collection b() {
        List listS0 = this.d.S0();
        if (listS0 != null) {
            return listS0;
        }
        l(1);
        throw null;
    }

    @Override // X8.K
    public final e8.i c() {
        e8.i iVarE = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(this.d);
        if (iVarE != null) {
            return iVarE;
        }
        l(4);
        throw null;
    }

    @Override // X8.K
    public final InterfaceC1524g d() {
        AbstractC1639h abstractC1639h = this.d;
        if (abstractC1639h != null) {
            return abstractC1639h;
        }
        l(3);
        throw null;
    }

    @Override // X8.K
    public final boolean f() {
        return true;
    }

    @Override // X8.AbstractC0275f
    public final X8.w g() {
        return Z8.i.c(ErrorTypeKind.g, new String[0]);
    }

    @Override // X8.K
    public final List getParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        l(2);
        throw null;
    }

    @Override // X8.AbstractC0275f
    public final C1504L h() {
        C1504L c1504l = this.c;
        if (c1504l != null) {
            return c1504l;
        }
        l(5);
        throw null;
    }

    @Override // X8.AbstractC0275f
    public final boolean j(InterfaceC1524g interfaceC1524g) {
        if (!(interfaceC1524g instanceof InterfaceC1507O)) {
            return false;
        }
        return J8.c.f882a.c(this.d, (InterfaceC1507O) interfaceC1524g, true, J8.a.f880a);
    }

    @Override // X8.AbstractC0275f
    public final List k(List list) {
        if (list == null) {
            l(7);
            throw null;
        }
        List listR0 = this.d.R0(list);
        if (listR0 != null) {
            return listR0;
        }
        l(8);
        throw null;
    }

    public final String toString() {
        return this.d.getName().f690a;
    }
}
