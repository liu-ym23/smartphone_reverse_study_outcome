package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1531n;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1528k;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public abstract class F extends AbstractC1645n implements InterfaceC1500H {
    public boolean e;
    public final boolean f;
    public final Modality g;
    public final InterfaceC1501I h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final CallableMemberDescriptor$Kind f4827j;
    public C1531n k;
    public InterfaceC1536s l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(Modality modality, C1531n c1531n, InterfaceC1501I interfaceC1501I, InterfaceC1561g interfaceC1561g, G8.f fVar, boolean z10, boolean z11, boolean z12, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        super(interfaceC1501I.d(), interfaceC1561g, fVar, interfaceC1503K);
        if (modality == null) {
            C0(0);
            throw null;
        }
        if (c1531n == null) {
            C0(1);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(3);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(5);
            throw null;
        }
        this.l = null;
        this.g = modality;
        this.k = c1531n;
        this.h = interfaceC1501I;
        this.e = z10;
        this.f = z11;
        this.i = z12;
        this.f4827j = callableMemberDescriptor$Kind;
    }

    public static /* synthetic */ void C0(int i) {
        String str;
        int i6;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i6 = 2;
                break;
            case 7:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 5:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // h8.InterfaceC1519b
    public final u E() {
        return R0().E();
    }

    @Override // h8.InterfaceC1519b
    public final u I() {
        return R0().I();
    }

    public final InterfaceC1501I R0() {
        InterfaceC1501I interfaceC1501I = this.h;
        if (interfaceC1501I != null) {
            return interfaceC1501I;
        }
        C0(13);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    public final ArrayList S0(boolean z10) {
        ArrayList arrayList = new ArrayList(0);
        for (InterfaceC1501I interfaceC1501I : R0().e()) {
            InterfaceC1536s getter = z10 ? interfaceC1501I.getGetter() : interfaceC1501I.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // h8.InterfaceC1520c
    public final InterfaceC1520c U(InterfaceC1522e interfaceC1522e, Modality modality, C1531n c1531n) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // h8.InterfaceC1536s, h8.InterfaceC1505M
    public final InterfaceC1536s b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar != null) {
            return this;
        }
        C0(7);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public final boolean e0() {
        return false;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return false;
    }

    @Override // h8.InterfaceC1520c
    public final CallableMemberDescriptor$Kind getKind() {
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = this.f4827j;
        if (callableMemberDescriptor$Kind != null) {
            return callableMemberDescriptor$Kind;
        }
        C0(6);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C0(9);
        throw null;
    }

    @Override // h8.InterfaceC1530m, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = this.k;
        if (c1531n != null) {
            return c1531n;
        }
        C0(11);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final Modality i() {
        Modality modality = this.g;
        if (modality != null) {
            return modality;
        }
        C0(10);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean isExternal() {
        return this.f;
    }

    @Override // h8.InterfaceC1536s
    public final boolean isInfix() {
        return false;
    }

    @Override // h8.InterfaceC1536s
    public final boolean isInline() {
        return this.i;
    }

    @Override // h8.InterfaceC1536s
    public final boolean isOperator() {
        return false;
    }

    @Override // h8.InterfaceC1536s
    public final boolean isSuspend() {
        return false;
    }

    @Override // h8.InterfaceC1536s
    public final InterfaceC1536s l0() {
        return this.l;
    }

    @Override // h8.InterfaceC1519b
    public final List p0() {
        List listP0 = R0().p0();
        if (listP0 != null) {
            return listP0;
        }
        C0(14);
        throw null;
    }

    @Override // h8.InterfaceC1536s
    public final boolean t() {
        return false;
    }

    @Override // h8.InterfaceC1536s
    public final boolean t0() {
        return false;
    }

    @Override // h8.InterfaceC1520c
    public final void u0(Collection collection) {
        if (collection != null) {
            return;
        }
        C0(16);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public final Object v0(InterfaceC1518a interfaceC1518a) {
        return null;
    }

    @Override // h8.InterfaceC1536s
    public final boolean w0() {
        return false;
    }

    @Override // h8.InterfaceC1505M
    public final /* bridge */ /* synthetic */ InterfaceC1528k b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        b(aVar);
        return this;
    }
}
