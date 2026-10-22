package k8;

import X8.C0278i;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.AbstractC1508P;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import i8.InterfaceC1561g;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* renamed from: k8.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1648q extends AbstractC1641j {
    public final C0278i g;
    public final C1647p h;
    public final W8.j i;

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC1561g f4851j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1648q(W8.l lVar, InterfaceC1522e interfaceC1522e, X8.A a3, G8.f fVar, W8.j jVar, InterfaceC1561g interfaceC1561g, InterfaceC1503K interfaceC1503K) {
        super(lVar, interfaceC1522e, fVar, interfaceC1503K);
        if (lVar == null) {
            C(6);
            throw null;
        }
        if (interfaceC1522e == null) {
            C(7);
            throw null;
        }
        if (a3 == null) {
            C(8);
            throw null;
        }
        if (fVar == null) {
            C(9);
            throw null;
        }
        if (jVar == null) {
            C(10);
            throw null;
        }
        this.f4851j = interfaceC1561g;
        this.g = new C0278i(this, Collections.EMPTY_LIST, Collections.singleton(a3), lVar);
        this.h = new C1647p(this, lVar);
        this.i = jVar;
    }

    public static /* synthetic */ void C(int i) {
        String str;
        int i6;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i6 = 2;
                break;
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static C1648q L(W8.l lVar, InterfaceC1522e interfaceC1522e, G8.f fVar, W8.h hVar, InterfaceC1561g interfaceC1561g, InterfaceC1503K interfaceC1503K) {
        if (lVar == null) {
            C(0);
            throw null;
        }
        if (interfaceC1522e == null) {
            C(1);
            throw null;
        }
        if (fVar == null) {
            C(2);
            throw null;
        }
        if (hVar != null) {
            return new C1648q(lVar, interfaceC1522e, interfaceC1522e.g(), fVar, hVar, interfaceC1561g, interfaceC1503K);
        }
        C(3);
        throw null;
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        C1647p c1647p = this.h;
        if (c1647p != null) {
            return c1647p;
        }
        C(14);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return false;
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
        InterfaceC1561g interfaceC1561g = this.f4851j;
        if (interfaceC1561g != null) {
            return interfaceC1561g;
        }
        C(21);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        return ClassKind.d;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = AbstractC1532o.e;
        if (c1531n != null) {
            return c1531n;
        }
        C(20);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(22);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o h0() {
        return Q8.n.b;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        return Modality.b;
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
        C0278i c0278i = this.g;
        if (c0278i != null) {
            return c0278i;
        }
        C(17);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(16);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        C(23);
        throw null;
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return false;
    }

    public final String toString() {
        return "enum entry " + getName();
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return null;
    }
}
