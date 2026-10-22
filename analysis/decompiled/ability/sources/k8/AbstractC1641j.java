package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;

/* renamed from: k8.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1641j extends AbstractC1633b {
    public final InterfaceC1527j e;
    public final InterfaceC1503K f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1641j(W8.l lVar, InterfaceC1527j interfaceC1527j, G8.f fVar, InterfaceC1503K interfaceC1503K) {
        super(lVar, fVar);
        if (lVar == null) {
            C(0);
            throw null;
        }
        if (interfaceC1527j == null) {
            C(1);
            throw null;
        }
        if (fVar == null) {
            C(2);
            throw null;
        }
        this.e = interfaceC1527j;
        this.f = interfaceC1503K;
    }

    public static /* synthetic */ void C(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
        } else if (i == 3) {
            objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        InterfaceC1527j interfaceC1527j = this.e;
        if (interfaceC1527j != null) {
            return interfaceC1527j;
        }
        C(4);
        throw null;
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        InterfaceC1503K interfaceC1503K = this.f;
        if (interfaceC1503K != null) {
            return interfaceC1503K;
        }
        C(5);
        throw null;
    }

    public boolean isExternal() {
        return false;
    }
}
