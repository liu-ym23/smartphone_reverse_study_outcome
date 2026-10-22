package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.InterfaceC1503K;
import h8.InterfaceC1510S;
import h8.InterfaceC1527j;
import i8.InterfaceC1561g;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class S extends AbstractC1645n implements InterfaceC1510S {
    public X8.w e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, G8.f fVar, X8.w wVar, InterfaceC1503K interfaceC1503K) {
        super(interfaceC1527j, interfaceC1561g, fVar, interfaceC1503K);
        if (interfaceC1527j == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(1);
            throw null;
        }
        if (fVar == null) {
            C0(2);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(3);
            throw null;
        }
        this.e = wVar;
    }

    public static /* synthetic */ void C0(int i) {
        String str;
        int i6;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i6 = 2;
                break;
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public u E() {
        return null;
    }

    public u I() {
        return null;
    }

    @Override // h8.InterfaceC1519b
    public boolean e0() {
        return false;
    }

    public X8.w getReturnType() {
        X8.w type = getType();
        if (type != null) {
            return type;
        }
        C0(10);
        throw null;
    }

    @Override // A8.b, R8.d
    public final X8.w getType() {
        X8.w wVar = this.e;
        if (wVar != null) {
            return wVar;
        }
        C0(4);
        throw null;
    }

    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C0(8);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public final List x() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C0(6);
        throw null;
    }
}
