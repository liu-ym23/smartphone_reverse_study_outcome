package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import i8.InterfaceC1561g;

/* renamed from: k8.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1645n extends AbstractC1644m implements InterfaceC1528k {
    public final InterfaceC1527j c;
    public final InterfaceC1503K d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1645n(InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, G8.f fVar, InterfaceC1503K interfaceC1503K) {
        super(interfaceC1561g, fVar);
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
        this.c = interfaceC1527j;
        this.d = interfaceC1503K;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5 && i != 6) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: Q0 */
    public InterfaceC1528k a() {
        return this;
    }

    public InterfaceC1527j d() {
        InterfaceC1527j interfaceC1527j = this.c;
        if (interfaceC1527j != null) {
            return interfaceC1527j;
        }
        C0(5);
        throw null;
    }

    public InterfaceC1503K getSource() {
        InterfaceC1503K interfaceC1503K = this.d;
        if (interfaceC1503K != null) {
            return interfaceC1503K;
        }
        C0(6);
        throw null;
    }
}
