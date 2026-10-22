package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.C1504L;
import h8.InterfaceC1503K;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: k8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1639h extends AbstractC1645n implements InterfaceC1507O {
    public final Variance e;
    public final boolean f;
    public final int g;
    public final W8.h h;
    public final W8.h i;

    /* renamed from: j, reason: collision with root package name */
    public final W8.i f4846j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1639h(W8.l lVar, InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, G8.f fVar, Variance variance, boolean z10, int i, C1504L c1504l) {
        super(interfaceC1527j, interfaceC1561g, fVar, InterfaceC1503K.f4577I);
        if (lVar == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1527j == null) {
            C0(1);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(2);
            throw null;
        }
        if (fVar == null) {
            C0(3);
            throw null;
        }
        if (variance == null) {
            C0(4);
            throw null;
        }
        if (c1504l == null) {
            C0(6);
            throw null;
        }
        this.e = variance;
        this.f = z10;
        this.g = i;
        V8.n nVar = new V8.n(this, lVar, c1504l);
        W8.i iVar = (W8.i) lVar;
        this.h = new W8.h(iVar, nVar);
        this.i = new W8.h(iVar, new J4.e(13, this, false, fVar));
        this.f4846j = iVar;
    }

    public static /* synthetic */ void C0(int i) {
        String str;
        int i6;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i6 = 2;
                break;
            case 12:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
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
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // h8.InterfaceC1507O
    public final W8.l F() {
        W8.i iVar = this.f4846j;
        if (iVar != null) {
            return iVar;
        }
        C0(14);
        throw null;
    }

    @Override // h8.InterfaceC1507O
    public final boolean K() {
        return false;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.w(this, obj);
    }

    @Override // k8.AbstractC1645n
    /* renamed from: Q0 */
    public final InterfaceC1528k a() {
        return this;
    }

    public List R0(List list) {
        if (list == null) {
            C0(12);
            throw null;
        }
        if (list != null) {
            return list;
        }
        C0(13);
        throw null;
    }

    public abstract List S0();

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1524g a() {
        return this;
    }

    @Override // h8.InterfaceC1524g
    public final X8.A g() {
        X8.A a3 = (X8.A) this.i.invoke();
        if (a3 != null) {
            return a3;
        }
        C0(10);
        throw null;
    }

    @Override // h8.InterfaceC1507O
    public final int getIndex() {
        return this.g;
    }

    @Override // h8.InterfaceC1507O
    public final List getUpperBounds() {
        List listE = ((C1638g) m()).e();
        if (listE != null) {
            return listE;
        }
        C0(8);
        throw null;
    }

    @Override // h8.InterfaceC1524g
    public final X8.K m() {
        X8.K k = (X8.K) this.h.invoke();
        if (k != null) {
            return k;
        }
        C0(9);
        throw null;
    }

    @Override // h8.InterfaceC1507O
    public final boolean o() {
        return this.f;
    }

    @Override // h8.InterfaceC1507O
    public final Variance r() {
        Variance variance = this.e;
        if (variance != null) {
            return variance;
        }
        C0(7);
        throw null;
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1527j a() {
        return this;
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1507O a() {
        return this;
    }
}
