package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import G8.f;
import J8.m;
import N9.j;
import X8.w;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import d9.AbstractC1397r;
import d9.C1385f;
import d9.C1388i;
import d9.InterfaceC1384e;
import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.C1560f;
import i8.InterfaceC1561g;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import k8.C1649s;
import k8.K;
import k8.t;
import k8.u;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.text.Regex;
import s8.InterfaceC1920a;
import t8.C2026c;

/* loaded from: classes4.dex */
public final class a extends K implements InterfaceC1920a {

    /* renamed from: F, reason: collision with root package name */
    public static final M8.a f4994F = new M8.a();

    /* renamed from: G, reason: collision with root package name */
    public static final M8.a f4995G = new M8.a();

    /* renamed from: D, reason: collision with root package name */
    public JavaMethodDescriptor$ParameterNamesStatus f4996D;
    public final boolean E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InterfaceC1527j interfaceC1527j, K k, InterfaceC1561g interfaceC1561g, f fVar, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K, boolean z10) {
        super(interfaceC1527j, k, interfaceC1561g, fVar, callableMemberDescriptor$Kind, interfaceC1503K);
        if (interfaceC1527j == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(1);
            throw null;
        }
        if (fVar == null) {
            C0(2);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(3);
            throw null;
        }
        this.f4996D = null;
        this.E = z10;
    }

    public static /* synthetic */ void C0(int i) {
        String str = (i == 13 || i == 18 || i == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 18 || i == 21) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 13) {
            objArr[1] = McpSchema.METHOD_INITIALIZE;
        } else if (i == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 18 && i != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static a g1(InterfaceC1527j interfaceC1527j, C2026c c2026c, f fVar, m8.f fVar2, boolean z10) {
        if (interfaceC1527j == null) {
            C0(5);
            throw null;
        }
        if (fVar != null) {
            return new a(interfaceC1527j, null, c2026c, fVar, CallableMemberDescriptor$Kind.f4950a, fVar2, z10);
        }
        C0(7);
        throw null;
    }

    @Override // k8.K, k8.t
    public final t T0(f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        if (interfaceC1527j == null) {
            C0(14);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(15);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(16);
            throw null;
        }
        K k = (K) interfaceC1536s;
        if (fVar == null) {
            fVar = getName();
        }
        a aVar = new a(interfaceC1527j, k, interfaceC1561g, fVar, callableMemberDescriptor$Kind, interfaceC1503K, this.E);
        JavaMethodDescriptor$ParameterNamesStatus javaMethodDescriptor$ParameterNamesStatus = this.f4996D;
        aVar.h1(javaMethodDescriptor$ParameterNamesStatus.f4993a, javaMethodDescriptor$ParameterNamesStatus.b);
        return aVar;
    }

    @Override // k8.t, h8.InterfaceC1519b
    public final boolean e0() {
        return this.f4996D.b;
    }

    @Override // k8.K
    public final K f1(u uVar, u uVar2, List list, List list2, List list3, w wVar, Modality modality, C1531n c1531n, Map map) {
        C1385f c1385f;
        if (list == null) {
            C0(9);
            throw null;
        }
        if (list2 == null) {
            C0(10);
            throw null;
        }
        if (list3 == null) {
            C0(11);
            throw null;
        }
        if (c1531n == null) {
            C0(12);
            throw null;
        }
        super.f1(uVar, uVar2, list, list2, list3, wVar, modality, c1531n, map);
        for (C1388i c1388i : AbstractC1397r.f4316D) {
            Regex regex = c1388i.b;
            f fVar = c1388i.f4309a;
            if (fVar == null || k.b(getName(), fVar)) {
                if (regex != null) {
                    String strB = getName().b();
                    k.e(strB, "asString(...)");
                    if (!regex.d(strB)) {
                        continue;
                    }
                }
                Collection collection = c1388i.c;
                if (collection == null || collection.contains(getName())) {
                    InterfaceC1384e[] interfaceC1384eArr = c1388i.e;
                    int length = interfaceC1384eArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            c1385f = ((String) c1388i.d.invoke(this)) != null ? new C1385f(false) : C1385f.c;
                        } else {
                            if (interfaceC1384eArr[i].b(this) != null) {
                                c1385f = new C1385f(false);
                                break;
                            }
                            i++;
                        }
                    }
                    this.m = c1385f.f4306a;
                    return this;
                }
            }
        }
        c1385f = C1385f.b;
        this.m = c1385f.f4306a;
        return this;
    }

    public final void h1(boolean z10, boolean z11) {
        this.f4996D = z10 ? z11 ? JavaMethodDescriptor$ParameterNamesStatus.STABLE_SYNTHESIZED : JavaMethodDescriptor$ParameterNamesStatus.STABLE_DECLARED : z11 ? JavaMethodDescriptor$ParameterNamesStatus.NON_STABLE_SYNTHESIZED : JavaMethodDescriptor$ParameterNamesStatus.NON_STABLE_DECLARED;
    }

    @Override // s8.InterfaceC1920a
    public final InterfaceC1920a k0(w wVar, ArrayList arrayList, w wVar2, Pair pair) {
        ArrayList arrayListN = j.n(arrayList, x(), this);
        u uVarK = wVar == null ? null : m.k(this, wVar, C1560f.f4611a);
        C1649s c1649sX0 = X0(kotlin.reflect.jvm.internal.impl.types.a.b);
        c1649sX0.g = arrayListN;
        c1649sX0.k = wVar2;
        c1649sX0.i = uVarK;
        c1649sX0.p = true;
        c1649sX0.o = true;
        a aVar = (a) c1649sX0.f4860x.U0(c1649sX0);
        if (pair != null) {
            aVar.Y0((InterfaceC1518a) pair.f4886a, pair.b);
        }
        if (aVar != null) {
            return aVar;
        }
        C0(21);
        throw null;
    }
}
