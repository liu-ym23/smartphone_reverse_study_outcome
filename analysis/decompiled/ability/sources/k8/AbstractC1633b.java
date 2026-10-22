package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import java.util.Collections;
import java.util.List;

/* renamed from: k8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1633b extends y {

    /* renamed from: a, reason: collision with root package name */
    public final G8.f f4844a;
    public final W8.h b;
    public final W8.h c;
    public final W8.h d;

    public AbstractC1633b(W8.l lVar, G8.f fVar) {
        if (lVar == null) {
            C(0);
            throw null;
        }
        if (fVar == null) {
            C(1);
            throw null;
        }
        this.f4844a = fVar;
        W8.i iVar = (W8.i) lVar;
        this.b = new W8.h(iVar, new C1632a(this, 0));
        this.c = new W8.h(iVar, new C1632a(this, 1));
        this.d = new W8.h(iVar, new C1632a(this, 2));
    }

    public static /* synthetic */ void C(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i == 9 || i == 12 || i == 14 || i == 16) {
            objArr[1] = "getMemberScope";
        } else if (i == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 19) {
            objArr[1] = "substitute";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 9 && i != 12 && i != 14 && i != 16 && i != 17 && i != 19 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // h8.InterfaceC1522e
    public final u B0() {
        u uVar = (u) this.d.invoke();
        if (uVar != null) {
            return uVar;
        }
        C(5);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o D(X8.P p) {
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(J8.e.d(this));
        Q8.o oVarK = k(p, Y8.f.f1574a);
        if (oVarK != null) {
            return oVarK;
        }
        C(16);
        throw null;
    }

    @Override // h8.InterfaceC1505M
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public InterfaceC1522e b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar != null) {
            return aVar.f5144a.e() ? this : new x(this, aVar);
        }
        C(18);
        throw null;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.g(this, obj);
    }

    @Override // h8.InterfaceC1522e
    public Q8.o O() {
        Q8.o oVar = (Q8.o) this.c.invoke();
        if (oVar != null) {
            return oVar;
        }
        C(4);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public Q8.o R() {
        kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(J8.e.d(this));
        Q8.o oVarA = A(Y8.f.f1574a);
        if (oVarA != null) {
            return oVarA;
        }
        C(17);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public List T() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(6);
        throw null;
    }

    @Override // k8.y, h8.InterfaceC1522e, h8.InterfaceC1527j
    public final InterfaceC1524g a() {
        return this;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1524g
    public final X8.A g() {
        X8.A a3 = (X8.A) this.b.invoke();
        if (a3 != null) {
            return a3;
        }
        C(20);
        throw null;
    }

    @Override // h8.InterfaceC1527j
    public final G8.f getName() {
        G8.f fVar = this.f4844a;
        if (fVar != null) {
            return fVar;
        }
        C(2);
        throw null;
    }

    @Override // k8.y
    public Q8.o k(X8.P p, Y8.f fVar) {
        if (!p.e()) {
            return new Q8.t(A(fVar), new kotlin.reflect.jvm.internal.impl.types.a(p));
        }
        Q8.o oVarA = A(fVar);
        if (oVarA != null) {
            return oVarA;
        }
        C(12);
        throw null;
    }

    @Override // k8.y, h8.InterfaceC1527j
    public final InterfaceC1527j a() {
        return this;
    }

    @Override // k8.y, h8.InterfaceC1522e, h8.InterfaceC1527j
    public final InterfaceC1522e a() {
        return this;
    }
}
