package k8;

import X8.C0278i;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.AbstractC1508P;
import h8.C1531n;
import h8.InterfaceC1503K;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* renamed from: k8.A, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1628A extends AbstractC1641j {
    public final ClassKind g;
    public Modality h;
    public C1531n i;

    /* renamed from: j, reason: collision with root package name */
    public C0278i f4824j;
    public ArrayList k;
    public final ArrayList l;
    public final W8.l m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1628A(g8.k kVar, G8.f fVar, W8.l lVar) {
        super(lVar, kVar, fVar, InterfaceC1503K.f4577I);
        ClassKind classKind = ClassKind.b;
        if (fVar == null) {
            C(2);
            throw null;
        }
        if (lVar == null) {
            C(4);
            throw null;
        }
        this.l = new ArrayList();
        this.m = lVar;
        this.g = classKind;
    }

    public static /* synthetic */ void C(int i) {
        String str;
        int i6;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i6 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        return Q8.n.b;
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
        return C1560f.f4611a;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        ClassKind classKind = this.g;
        if (classKind != null) {
            return classKind;
        }
        C(8);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = this.i;
        if (c1531n != null) {
            return c1531n;
        }
        C(10);
        throw null;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            return arrayList;
        }
        C(15);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Q8.o h0() {
        return Q8.n.b;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        Modality modality = this.h;
        if (modality != null) {
            return modality;
        }
        C(7);
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
        C0278i c0278i = this.f4824j;
        if (c0278i != null) {
            return c0278i;
        }
        C(11);
        throw null;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        C(13);
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

    public final String toString() {
        return AbstractC1644m.P0(this);
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return null;
    }
}
