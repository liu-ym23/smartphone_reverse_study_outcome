package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.InterfaceC1527j;
import i8.InterfaceC1561g;

/* renamed from: k8.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1644m extends A8.b implements InterfaceC1527j {
    public final G8.f b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1644m(InterfaceC1561g interfaceC1561g, G8.f fVar) {
        super(interfaceC1561g);
        if (interfaceC1561g == null) {
            C0(0);
            throw null;
        }
        if (fVar == null) {
            C0(1);
            throw null;
        }
        this.b = fVar;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = AppAgent.CONSTRUCT;
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static String P0(InterfaceC1527j interfaceC1527j) {
        try {
            String str = I8.g.e.u(interfaceC1527j) + "[" + interfaceC1527j.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(interfaceC1527j)) + "]";
            if (str != null) {
                return str;
            }
            C0(5);
            throw null;
        } catch (Throwable unused) {
            String str2 = interfaceC1527j.getClass().getSimpleName() + " " + interfaceC1527j.getName();
            if (str2 != null) {
                return str2;
            }
            C0(6);
            throw null;
        }
    }

    public InterfaceC1527j a() {
        return this;
    }

    @Override // h8.InterfaceC1527j
    public final G8.f getName() {
        G8.f fVar = this.b;
        if (fVar != null) {
            return fVar;
        }
        C0(2);
        throw null;
    }

    public String toString() {
        return P0(this);
    }
}
