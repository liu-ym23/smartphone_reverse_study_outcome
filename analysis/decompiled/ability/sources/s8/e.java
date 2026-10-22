package s8;

import J8.m;
import X8.S;
import X8.w;
import Y8.g;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import e8.i;
import e8.q;
import h8.C1531n;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1527j;
import i8.C1560f;
import i8.C1562h;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import k8.H;
import k8.I;
import k8.J;
import k8.Q;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import q8.u;
import t8.C2026c;
import y8.o;

/* loaded from: classes4.dex */
public class e extends H implements InterfaceC1920a {

    /* renamed from: A, reason: collision with root package name */
    public final boolean f5993A;

    /* renamed from: B, reason: collision with root package name */
    public final Pair f5994B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InterfaceC1527j interfaceC1527j, InterfaceC1561g interfaceC1561g, Modality modality, C1531n c1531n, boolean z10, G8.f fVar, InterfaceC1503K interfaceC1503K, InterfaceC1501I interfaceC1501I, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, boolean z11, Pair pair) {
        super(interfaceC1527j, interfaceC1501I, interfaceC1561g, modality, c1531n, z10, fVar, callableMemberDescriptor$Kind, interfaceC1503K, false, false, false, false, false);
        if (interfaceC1527j == null) {
            C0(0);
            throw null;
        }
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
        if (fVar == null) {
            C0(4);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(5);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(6);
            throw null;
        }
        this.f5993A = z11;
        this.f5994B = pair;
    }

    public static /* synthetic */ void C0(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(str2);
        }
    }

    public static e Z0(InterfaceC1527j interfaceC1527j, C2026c c2026c, C1531n c1531n, boolean z10, G8.f fVar, m8.f fVar2, boolean z11) {
        Modality modality = Modality.b;
        if (interfaceC1527j == null) {
            C0(7);
            throw null;
        }
        if (fVar != null) {
            return new e(interfaceC1527j, c2026c, modality, c1531n, z10, fVar, fVar2, null, CallableMemberDescriptor$Kind.f4950a, z11, null);
        }
        C0(11);
        throw null;
    }

    @Override // k8.H
    public final H T0(InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n, InterfaceC1501I interfaceC1501I, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, G8.f fVar) {
        if (interfaceC1527j == null) {
            C0(13);
            throw null;
        }
        if (modality == null) {
            C0(14);
            throw null;
        }
        if (c1531n == null) {
            C0(15);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(16);
            throw null;
        }
        if (fVar == null) {
            C0(17);
            throw null;
        }
        return new e(interfaceC1527j, getAnnotations(), modality, c1531n, this.f, fVar, InterfaceC1503K.f4577I, interfaceC1501I, callableMemberDescriptor$Kind, this.f5993A, this.f5994B);
    }

    @Override // k8.H
    public final void X0(w wVar) {
    }

    @Override // k8.S, h8.InterfaceC1519b
    public final boolean e0() {
        return false;
    }

    @Override // k8.H, h8.InterfaceC1510S
    public final boolean isConst() {
        w type = getType();
        if (!this.f5993A) {
            return false;
        }
        k.f(type, "type");
        if (((!i.F(type) && !q.a(type)) || S.e(type)) && !i.G(type)) {
            return false;
        }
        C1562h c1562h = o.f6922a;
        G8.c ENHANCED_NULLABILITY_ANNOTATION = u.p;
        k.e(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return !g.u(type, ENHANCED_NULLABILITY_ANNOTATION) || i.G(type);
    }

    @Override // s8.InterfaceC1920a
    public final InterfaceC1920a k0(w wVar, ArrayList arrayList, w wVar2, Pair pair) {
        w wVar3;
        I i;
        J j5;
        InterfaceC1501I interfaceC1501IA = a() == this ? null : a();
        e eVar = new e(d(), getAnnotations(), i(), getVisibility(), this.f, getName(), getSource(), interfaceC1501IA, getKind(), this.f5993A, pair);
        I i6 = this.f4836w;
        if (i6 != null) {
            I i10 = new I(eVar, i6.getAnnotations(), i6.i(), i6.getVisibility(), i6.e, i6.f, i6.i, getKind(), interfaceC1501IA == null ? null : interfaceC1501IA.getGetter(), i6.getSource());
            i10.l = i6.l;
            wVar3 = wVar2;
            i10.m = wVar3;
            i = i10;
        } else {
            wVar3 = wVar2;
            i = null;
        }
        J j6 = this.f4837x;
        if (j6 != null) {
            J j10 = j6;
            j5 = new J(eVar, j6.getAnnotations(), j10.i(), j10.getVisibility(), j10.e, j10.f, j10.i, getKind(), interfaceC1501IA == null ? null : interfaceC1501IA.getSetter(), j6.getSource());
            j5.l = j5.l;
            Q q5 = (Q) j6.x().get(0);
            if (q5 == null) {
                J.C0(6);
                throw null;
            }
            j5.m = q5;
        } else {
            j5 = null;
        }
        eVar.V0(i, j5, this.y, this.f4838z);
        S7.a aVar = this.h;
        if (aVar != null) {
            eVar.W0(this.g, aVar);
        }
        eVar.u0(e());
        eVar.Y0(wVar3, getTypeParameters(), this.f4834t, wVar != null ? m.k(this, wVar, C1560f.f4611a) : null, EmptyList.f4893a);
        return eVar;
    }

    @Override // k8.H, h8.InterfaceC1519b
    public final Object v0(InterfaceC1518a interfaceC1518a) {
        Pair pair = this.f5994B;
        if (pair == null || !((InterfaceC1518a) pair.f4886a).equals(interfaceC1518a)) {
            return null;
        }
        return pair.b;
    }
}
