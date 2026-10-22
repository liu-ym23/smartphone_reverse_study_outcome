package k8;

import X8.C0278i;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.AbstractC1508P;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import i8.C1560f;
import i8.InterfaceC1561g;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* renamed from: k8.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1642k extends AbstractC1641j {
    public final Modality g;
    public final ClassKind h;
    public final C0278i i;

    /* renamed from: j, reason: collision with root package name */
    public Q8.o f4848j;
    public Set k;
    public C1640i l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1642k(InterfaceC1527j interfaceC1527j, G8.f fVar, Modality modality, ClassKind classKind, Collection collection, W8.l lVar) {
        super(lVar, interfaceC1527j, fVar, InterfaceC1503K.f4577I);
        if (interfaceC1527j == null) {
            C(0);
            throw null;
        }
        if (fVar == null) {
            C(1);
            throw null;
        }
        if (collection == null) {
            C(4);
            throw null;
        }
        if (lVar == null) {
            C(6);
            throw null;
        }
        this.g = modality;
        this.h = classKind;
        this.i = new C0278i(this, Collections.EMPTY_LIST, collection, lVar);
    }

    public static /* synthetic */ void C(int i) {
        String str;
        int i6;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
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
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        Q8.o oVar = this.f4848j;
        if (oVar != null) {
            return oVar;
        }
        C(13);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return false;
    }

    public final void L(Q8.o oVar, Set set, C1640i c1640i) {
        if (set == null) {
            C(8);
            throw null;
        }
        this.f4848j = oVar;
        this.k = set;
        this.l = c1640i;
    }

    @Override // h8.InterfaceC1522e
    public final AbstractC1508P P() {
        return null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean X() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean c0() {
        return false;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return false;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return C1560f.f4611a;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        ClassKind classKind = this.h;
        if (classKind != null) {
            return classKind;
        }
        C(15);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = AbstractC1532o.e;
        if (c1531n != null) {
            return c1531n;
        }
        C(17);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(18);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o h0() {
        return Q8.n.b;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        Modality modality = this.g;
        if (modality != null) {
            return modality;
        }
        C(16);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final boolean isInline() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean j() {
        return false;
    }

    @Override // h8.InterfaceC1524g
    public final X8.K m() {
        C0278i c0278i = this.i;
        if (c0278i != null) {
            return c0278i;
        }
        C(10);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        Set set = this.k;
        if (set != null) {
            return set;
        }
        C(11);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(19);
        throw null;
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return this.l;
    }
}
