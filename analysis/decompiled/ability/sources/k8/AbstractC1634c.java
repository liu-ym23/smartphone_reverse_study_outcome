package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1504L;
import h8.InterfaceC1527j;
import i8.InterfaceC1561g;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: k8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1634c extends AbstractC1639h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1634c(W8.l lVar, InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, G8.f fVar, Variance variance, boolean z10, int i, C1504L c1504l) {
        super(lVar, interfaceC1527j, interfaceC1561g, fVar, variance, z10, i, c1504l);
        if (lVar == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1527j == null) {
            C0(1);
            throw null;
        }
        if (c1504l != null) {
        } else {
            C0(6);
            throw null;
        }
    }

    public static /* synthetic */ void C0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = AppAgent.CONSTRUCT;
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // k8.AbstractC1644m
    public final String toString() {
        String str = "";
        String str2 = this.f ? "reified " : "";
        if (r() != Variance.c) {
            str = r() + " ";
        }
        return str2 + str + getName();
    }
}
