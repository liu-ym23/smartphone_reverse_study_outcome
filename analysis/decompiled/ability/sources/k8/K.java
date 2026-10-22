package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import h8.InterfaceC1535r;
import h8.InterfaceC1536s;
import i8.C1560f;
import i8.InterfaceC1561g;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public class K extends t {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(InterfaceC1527j interfaceC1527j, K k, InterfaceC1561g interfaceC1561g, G8.f fVar, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        super(fVar, interfaceC1527j, k, interfaceC1503K, interfaceC1561g, callableMemberDescriptor$Kind);
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
        if (callableMemberDescriptor$Kind == null) {
            C0(3);
            throw null;
        }
        if (interfaceC1503K != null) {
        } else {
            C0(4);
            throw null;
        }
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 13 || i == 18 || i == 23 || i == 24 || i == 29 || i == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 18 || i == 23 || i == 24 || i == 29 || i == 30) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 18 || i == 23) {
            objArr[1] = McpSchema.METHOD_INITIALIZE;
        } else if (i == 24) {
            objArr[1] = "getOriginal";
        } else if (i == 29) {
            objArr[1] = "copy";
        } else if (i != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 18 && i != 23 && i != 24 && i != 29 && i != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static K c1(AbstractC1633b abstractC1633b, G8.f fVar, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        if (abstractC1633b == null) {
            C0(5);
            throw null;
        }
        if (fVar == null) {
            C0(7);
            throw null;
        }
        if (interfaceC1503K != null) {
            return new K(abstractC1633b, null, C1560f.f4611a, fVar, callableMemberDescriptor$Kind, interfaceC1503K);
        }
        C0(9);
        throw null;
    }

    @Override // k8.t
    public t T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        if (interfaceC1527j == null) {
            C0(25);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(26);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(27);
            throw null;
        }
        K k = (K) interfaceC1536s;
        if (fVar == null) {
            fVar = getName();
        }
        return new K(interfaceC1527j, k, interfaceC1561g, fVar, callableMemberDescriptor$Kind, interfaceC1503K);
    }

    @Override // k8.t, k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public final K a() {
        K k = (K) super.a();
        if (k != null) {
            return k;
        }
        C0(24);
        throw null;
    }

    @Override // k8.t
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public final K W0(u uVar, u uVar2, List list, List list2, List list3, X8.w wVar, Modality modality, C1531n c1531n) {
        if (list == null) {
            C0(14);
            throw null;
        }
        if (list2 == null) {
            C0(15);
            throw null;
        }
        if (list3 == null) {
            C0(16);
            throw null;
        }
        if (c1531n != null) {
            return f1(uVar, uVar2, list, list2, list3, wVar, modality, c1531n, null);
        }
        C0(17);
        throw null;
    }

    public K f1(u uVar, u uVar2, List list, List list2, List list3, X8.w wVar, Modality modality, C1531n c1531n, Map map) {
        if (list == null) {
            C0(19);
            throw null;
        }
        if (list2 == null) {
            C0(20);
            throw null;
        }
        if (list3 == null) {
            C0(21);
            throw null;
        }
        if (c1531n == null) {
            C0(22);
            throw null;
        }
        super.W0(uVar, uVar2, list, list2, list3, wVar, modality, c1531n);
        if (map != null && !map.isEmpty()) {
            this.f4863C = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public InterfaceC1535r x0() {
        return X0(kotlin.reflect.jvm.internal.impl.types.a.b);
    }
}
