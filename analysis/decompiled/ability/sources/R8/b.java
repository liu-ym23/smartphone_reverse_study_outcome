package R8;

import X8.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.InterfaceC1519b;
import k8.AbstractC1645n;

/* loaded from: classes4.dex */
public final class b extends A8.b {
    public final AbstractC1645n b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(InterfaceC1519b interfaceC1519b, w wVar) {
        super(wVar);
        if (wVar == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", AppAgent.CONSTRUCT));
        }
        this.b = (AbstractC1645n) interfaceC1519b;
    }

    public final String toString() {
        return getType() + ": Ext {" + this.b + "}";
    }
}
