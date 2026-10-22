package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1499G;
import h8.InterfaceC1503K;
import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class u extends AbstractC1644m implements InterfaceC1499G {
    public final /* synthetic */ int c = 0;
    public final InterfaceC1527j d;
    public final R8.d e;

    public u(InterfaceC1522e interfaceC1522e) {
        super(C1560f.f4611a, G8.h.d);
        this.d = interfaceC1522e;
        this.e = new R8.c(interfaceC1522e);
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = AppAgent.CONSTRUCT;
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void D0(int i) {
        String str = (i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i == 7) {
            objArr[1] = "getValue";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void Q0(int i) {
        String str;
        int i6;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                i6 = 2;
                break;
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 2:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // h8.InterfaceC1519b
    public final u E() {
        return null;
    }

    @Override // h8.InterfaceC1519b
    public final u I() {
        return null;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.A(this, obj);
    }

    public final R8.d R0() {
        switch (this.c) {
            case 0:
                R8.c cVar = (R8.c) this.e;
                if (cVar != null) {
                    return cVar;
                }
                C0(1);
                throw null;
            default:
                A8.b bVar = (A8.b) this.e;
                if (bVar != null) {
                    return bVar;
                }
                D0(7);
                throw null;
        }
    }

    @Override // h8.InterfaceC1505M
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public final u b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar == null) {
            Q0(3);
            throw null;
        }
        if (!aVar.f5144a.e()) {
            X8.w wVarI = d() instanceof InterfaceC1522e ? aVar.i(getType(), Variance.e) : aVar.i(getType(), Variance.c);
            if (wVarI == null) {
                return null;
            }
            if (wVarI != getType()) {
                return new u(d(), new R8.e(wVarI), getAnnotations());
            }
        }
        return this;
    }

    @Override // k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1519b a() {
        return this;
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        switch (this.c) {
            case 0:
                InterfaceC1522e interfaceC1522e = (InterfaceC1522e) this.d;
                if (interfaceC1522e != null) {
                    return interfaceC1522e;
                }
                C0(2);
                throw null;
            default:
                InterfaceC1527j interfaceC1527j = this.d;
                if (interfaceC1527j != null) {
                    return interfaceC1527j;
                }
                D0(8);
                throw null;
        }
    }

    @Override // h8.InterfaceC1519b
    public final Collection e() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        Q0(8);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public final boolean e0() {
        return false;
    }

    @Override // h8.InterfaceC1519b
    public final X8.w getReturnType() {
        return getType();
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        return InterfaceC1503K.f4577I;
    }

    @Override // A8.b, R8.d
    public final X8.w getType() {
        X8.w type = R0().getType();
        if (type != null) {
            return type;
        }
        Q0(6);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        Q0(5);
        throw null;
    }

    @Override // h8.InterfaceC1530m, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = AbstractC1532o.f;
        if (c1531n != null) {
            return c1531n;
        }
        Q0(9);
        throw null;
    }

    @Override // k8.AbstractC1644m
    public String toString() {
        switch (this.c) {
            case 0:
                return "class " + ((InterfaceC1522e) this.d).getName() + "::this";
            default:
                return super.toString();
        }
    }

    @Override // h8.InterfaceC1519b
    public final List x() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        Q0(7);
        throw null;
    }

    @Override // k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1527j a() {
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(InterfaceC1527j interfaceC1527j, A8.b bVar, InterfaceC1561g interfaceC1561g) {
        this(interfaceC1527j, bVar, interfaceC1561g, G8.h.d);
        if (interfaceC1527j == null) {
            D0(0);
            throw null;
        }
        if (interfaceC1561g != null) {
        } else {
            D0(2);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(InterfaceC1527j interfaceC1527j, A8.b bVar, InterfaceC1561g interfaceC1561g, G8.f fVar) {
        super(interfaceC1561g, fVar);
        if (interfaceC1527j == null) {
            D0(3);
            throw null;
        }
        if (interfaceC1561g == null) {
            D0(5);
            throw null;
        }
        if (fVar != null) {
            this.d = interfaceC1527j;
            this.e = bVar;
            return;
        }
        D0(6);
        throw null;
    }
}
