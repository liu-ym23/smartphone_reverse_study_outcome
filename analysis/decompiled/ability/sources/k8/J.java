package k8;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1531n;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public final class J extends F implements InterfaceC1500H {
    public Q m;
    public final J n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g, Modality modality, C1531n c1531n, boolean z10, boolean z11, boolean z12, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, J j5, InterfaceC1503K interfaceC1503K) {
        super(modality, c1531n, interfaceC1501I, interfaceC1561g, G8.f.g("<set-" + interfaceC1501I.getName() + ">"), z10, z11, z12, callableMemberDescriptor$Kind, interfaceC1503K);
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
        this.n = j5 != null ? j5 : this;
    }

    public static /* synthetic */ void C0(int i) {
        String str;
        int i6;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i6 = 2;
                break;
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static Q T0(J j5, X8.w wVar, InterfaceC1561g interfaceC1561g) {
        if (wVar == null) {
            C0(8);
            throw null;
        }
        if (interfaceC1561g != null) {
            return new Q(j5, null, 0, interfaceC1561g, G8.h.g, wVar, false, false, false, null, InterfaceC1503K.f4577I);
        }
        C0(9);
        throw null;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.c(this, obj);
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public final J a() {
        J j5 = this.n;
        if (j5 != null) {
            return j5;
        }
        C0(13);
        throw null;
    }

    @Override // h8.InterfaceC1520c, h8.InterfaceC1519b
    public final Collection e() {
        return S0(false);
    }

    @Override // h8.InterfaceC1519b
    public final X8.w getReturnType() {
        return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(this).w();
    }

    @Override // h8.InterfaceC1519b
    public final List x() {
        Q q5 = this.m;
        if (q5 == null) {
            throw new IllegalStateException();
        }
        List listSingletonList = Collections.singletonList(q5);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        C0(11);
        throw null;
    }
}
