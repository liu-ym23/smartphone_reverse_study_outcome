package k8;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1531n;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public final class I extends F implements InterfaceC1500H {
    public X8.w m;
    public final I n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g, Modality modality, C1531n c1531n, boolean z10, boolean z11, boolean z12, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, I i, InterfaceC1503K interfaceC1503K) {
        super(modality, c1531n, interfaceC1501I, interfaceC1561g, G8.f.g("<get-" + interfaceC1501I.getName() + ">"), z10, z11, z12, callableMemberDescriptor$Kind, interfaceC1503K);
        if (interfaceC1561g == null) {
            C0(1);
            throw null;
        }
        if (modality == null) {
            C0(2);
            throw null;
        }
        if (c1531n == null) {
            C0(3);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(4);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(5);
            throw null;
        }
        this.n = i != null ? i : this;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.r(this, obj);
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public final I a() {
        I i = this.n;
        if (i != null) {
            return i;
        }
        C0(8);
        throw null;
    }

    public final void U0(X8.w wVar) {
        if (wVar == null) {
            wVar = R0().getType();
        }
        this.m = wVar;
    }

    @Override // h8.InterfaceC1520c, h8.InterfaceC1519b
    public final Collection e() {
        return S0(true);
    }

    @Override // h8.InterfaceC1519b
    public final X8.w getReturnType() {
        return this.m;
    }

    @Override // h8.InterfaceC1519b
    public final List x() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C0(7);
        throw null;
    }
}
