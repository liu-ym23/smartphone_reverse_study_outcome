package s8;

import J8.m;
import N9.j;
import X8.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import k8.C1640i;
import k8.t;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;

/* loaded from: classes4.dex */
public final class b extends C1640i implements InterfaceC1920a {
    public Boolean E;

    /* renamed from: F, reason: collision with root package name */
    public Boolean f5992F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC1522e interfaceC1522e, b bVar, InterfaceC1561g interfaceC1561g, boolean z10, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        super(interfaceC1522e, bVar, interfaceC1561g, z10, callableMemberDescriptor$Kind, interfaceC1503K);
        if (interfaceC1522e == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(1);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(2);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(3);
            throw null;
        }
        this.E = null;
        this.f5992F = null;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static b i1(InterfaceC1522e interfaceC1522e, InterfaceC1561g interfaceC1561g, boolean z10, m8.f fVar) {
        if (interfaceC1522e != null) {
            return new b(interfaceC1522e, null, interfaceC1561g, z10, CallableMemberDescriptor$Kind.f4950a, fVar);
        }
        C0(4);
        throw null;
    }

    @Override // k8.C1640i, k8.t
    public final /* bridge */ /* synthetic */ t T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        return j1(interfaceC1527j, interfaceC1536s, callableMemberDescriptor$Kind, interfaceC1561g, interfaceC1503K);
    }

    @Override // k8.t
    public final void Z0(boolean z10) {
        this.E = Boolean.valueOf(z10);
    }

    @Override // k8.t
    public final void a1(boolean z10) {
        this.f5992F = Boolean.valueOf(z10);
    }

    @Override // k8.C1640i
    /* renamed from: c1 */
    public final /* bridge */ /* synthetic */ C1640i T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        return j1(interfaceC1527j, interfaceC1536s, callableMemberDescriptor$Kind, interfaceC1561g, interfaceC1503K);
    }

    @Override // k8.t, h8.InterfaceC1519b
    public final boolean e0() {
        return this.f5992F.booleanValue();
    }

    public final b j1(InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1561g interfaceC1561g, InterfaceC1503K interfaceC1503K) {
        if (interfaceC1527j == null) {
            C0(7);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(8);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(9);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(10);
            throw null;
        }
        if (callableMemberDescriptor$Kind != CallableMemberDescriptor$Kind.f4950a && callableMemberDescriptor$Kind != CallableMemberDescriptor$Kind.d) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + interfaceC1527j + "\nkind: " + callableMemberDescriptor$Kind);
        }
        b bVar = new b((InterfaceC1522e) interfaceC1527j, (b) interfaceC1536s, interfaceC1561g, this.f4847D, callableMemberDescriptor$Kind, interfaceC1503K);
        Boolean bool = this.E;
        bool.getClass();
        bVar.E = bool;
        Boolean bool2 = this.f5992F;
        bool2.getClass();
        bVar.f5992F = bool2;
        return bVar;
    }

    @Override // s8.InterfaceC1920a
    public final InterfaceC1920a k0(w wVar, ArrayList arrayList, w wVar2, Pair pair) {
        b bVarJ1 = j1(d(), null, getKind(), getAnnotations(), getSource());
        bVarJ1.W0(wVar == null ? null : m.k(bVarJ1, wVar, C1560f.f4611a), this.f4864j, EmptyList.f4893a, getTypeParameters(), j.n(arrayList, x(), bVarJ1), wVar2, i(), getVisibility());
        if (pair != null) {
            bVarJ1.Y0((InterfaceC1518a) pair.f4886a, pair.b);
        }
        return bVarJ1;
    }
}
