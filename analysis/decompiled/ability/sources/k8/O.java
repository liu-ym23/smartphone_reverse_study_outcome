package k8;

import X8.AbstractC0272c;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1504L;
import h8.InterfaceC1527j;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class O extends AbstractC1639h {
    public final ArrayList k;
    public boolean l;

    /* JADX WARN: Illegal instructions before constructor call */
    public O(InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, boolean z10, Variance variance, G8.f fVar, int i, W8.l lVar) {
        C1504L c1504l = C1504L.c;
        if (interfaceC1527j == null) {
            C0(19);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(20);
            throw null;
        }
        if (variance == null) {
            C0(21);
            throw null;
        }
        if (fVar == null) {
            C0(22);
            throw null;
        }
        if (lVar == null) {
            C0(25);
            throw null;
        }
        super(lVar, interfaceC1527j, interfaceC1561g, fVar, variance, z10, i, c1504l);
        this.k = new ArrayList(1);
        this.l = false;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static O T0(InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, boolean z10, Variance variance, G8.f fVar, int i, W8.l lVar) {
        if (interfaceC1527j == null) {
            C0(6);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(7);
            throw null;
        }
        if (variance == null) {
            C0(8);
            throw null;
        }
        if (fVar == null) {
            C0(9);
            throw null;
        }
        if (lVar != null) {
            return new O(interfaceC1527j, interfaceC1561g, z10, variance, fVar, i, lVar);
        }
        C0(11);
        throw null;
    }

    public static O U0(AbstractC1633b abstractC1633b, Variance variance, G8.f fVar, int i, W8.l lVar) {
        if (lVar == null) {
            C0(4);
            throw null;
        }
        O oT0 = T0(abstractC1633b, C1560f.f4611a, false, variance, fVar, i, lVar);
        X8.A aM = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(abstractC1633b).m();
        if (oT0.l) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + oT0.V0());
        }
        if (!AbstractC0272c.k(aM)) {
            oT0.k.add(aM);
        }
        if (!oT0.l) {
            oT0.l = true;
            return oT0;
        }
        throw new IllegalStateException("Type parameter descriptor is already initialized: " + oT0.V0());
    }

    @Override // k8.AbstractC1639h
    public final List S0() {
        if (!this.l) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: " + V0());
        }
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            return arrayList;
        }
        C0(28);
        throw null;
    }

    public final String V0() {
        return getName() + " declared in " + J8.e.g(d());
    }
}
