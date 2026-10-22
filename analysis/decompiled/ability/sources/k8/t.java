package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1507O;
import h8.InterfaceC1518a;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1535r;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public abstract class t extends AbstractC1645n implements InterfaceC1536s {

    /* renamed from: A, reason: collision with root package name */
    public final CallableMemberDescriptor$Kind f4861A;

    /* renamed from: B, reason: collision with root package name */
    public InterfaceC1536s f4862B;

    /* renamed from: C, reason: collision with root package name */
    public Map f4863C;
    public List e;
    public List f;
    public X8.w g;
    public List h;
    public u i;

    /* renamed from: j, reason: collision with root package name */
    public u f4864j;
    public Modality k;
    public C1531n l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4865q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4866r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4867s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4868t;
    public boolean u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4869v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4870w;

    /* renamed from: x, reason: collision with root package name */
    public Collection f4871x;
    public volatile J4.e y;

    /* renamed from: z, reason: collision with root package name */
    public final InterfaceC1536s f4872z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        super(interfaceC1527j, interfaceC1561g, fVar, interfaceC1503K);
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
        if (interfaceC1503K == null) {
            C0(4);
            throw null;
        }
        this.l = AbstractC1532o.i;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.f4865q = false;
        this.f4866r = false;
        this.f4867s = false;
        this.f4868t = false;
        this.u = false;
        this.f4869v = true;
        this.f4870w = false;
        this.f4871x = null;
        this.y = null;
        this.f4862B = null;
        this.f4863C = null;
        this.f4872z = interfaceC1536s == null ? this : interfaceC1536s;
        this.f4861A = callableMemberDescriptor$Kind;
    }

    public static /* synthetic */ void C0(int i) {
        String str;
        int i6;
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i6 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = AgentBusWakeContract.EXTRA_SOURCE;
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = McpSchema.METHOD_INITIALIZE;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static ArrayList V0(InterfaceC1536s interfaceC1536s, List list, kotlin.reflect.jvm.internal.impl.types.a aVar, boolean z10, boolean z11, boolean[] zArr) {
        if (list == null) {
            C0(30);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Q q5 = (Q) it.next();
            Q q10 = q5;
            X8.w type = q10.getType();
            Variance variance = Variance.d;
            X8.w wVarI = aVar.i(type, variance);
            X8.w wVar = q5.f4842j;
            X8.w wVarI2 = wVar == null ? null : aVar.i(wVar, variance);
            if (wVarI == null) {
                return null;
            }
            if ((wVarI != q10.getType() || wVar != wVarI2) && zArr != null) {
                zArr[0] = true;
            }
            I8.e eVar = q5 instanceof P ? new I8.e((List) ((P) q5).l.getF4884a(), 25) : null;
            Q q11 = z10 ? null : q5;
            int i = q5.f;
            InterfaceC1561g annotations = q5.getAnnotations();
            G8.f name = q5.getName();
            boolean zS0 = q5.S0();
            boolean z12 = q5.h;
            boolean z13 = q5.i;
            InterfaceC1503K source = z11 ? q5.getSource() : InterfaceC1503K.f4577I;
            kotlin.jvm.internal.k.f(annotations, "annotations");
            kotlin.jvm.internal.k.f(name, "name");
            kotlin.jvm.internal.k.f(source, "source");
            arrayList.add(eVar == null ? new Q(interfaceC1536s, q11, i, annotations, name, wVarI, zS0, z12, z13, wVarI2, source) : new P(interfaceC1536s, q11, i, annotations, name, wVarI, zS0, z12, z13, wVarI2, source, eVar));
        }
        return arrayList;
    }

    @Override // h8.InterfaceC1519b
    public final u E() {
        return this.f4864j;
    }

    @Override // h8.InterfaceC1519b
    public final u I() {
        return this.i;
    }

    public Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.z(this, obj);
    }

    public final InterfaceC1536s R0(InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n) {
        InterfaceC1536s interfaceC1536sBuild = x0().g(interfaceC1527j).s(modality).r(c1531n).z(CallableMemberDescriptor$Kind.b).j().build();
        if (interfaceC1536sBuild != null) {
            return interfaceC1536sBuild;
        }
        C0(26);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // h8.InterfaceC1520c
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public K U(InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n) {
        return (K) R0(interfaceC1527j, modality, c1531n);
    }

    public abstract t T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f9  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k8.t U0(k8.C1649s r21) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.t.U0(k8.s):k8.t");
    }

    public void W0(u uVar, u uVar2, List list, List list2, List list3, X8.w wVar, Modality modality, C1531n c1531n) {
        if (list == null) {
            C0(5);
            throw null;
        }
        if (list2 == null) {
            C0(6);
            throw null;
        }
        if (list3 == null) {
            C0(7);
            throw null;
        }
        if (c1531n == null) {
            C0(8);
            throw null;
        }
        this.e = D7.v.f1(list2);
        this.f = D7.v.f1(list3);
        this.g = wVar;
        this.k = modality;
        this.l = c1531n;
        this.i = uVar;
        this.f4864j = uVar2;
        this.h = list;
        for (int i = 0; i < list2.size(); i++) {
            InterfaceC1507O interfaceC1507O = (InterfaceC1507O) list2.get(i);
            if (interfaceC1507O.getIndex() != i) {
                throw new IllegalStateException(interfaceC1507O + " index is " + interfaceC1507O.getIndex() + " but position is " + i);
            }
        }
        for (int i6 = 0; i6 < list3.size(); i6++) {
            Q q5 = (Q) list3.get(i6);
            if (q5.f != i6) {
                throw new IllegalStateException(q5 + "index is " + q5.f + " but position is " + i6);
            }
        }
    }

    public final C1649s X0(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar != null) {
            return new C1649s(this, aVar.f(), d(), i(), getVisibility(), getKind(), x(), p0(), this.i, getReturnType());
        }
        C0(24);
        throw null;
    }

    public final void Y0(InterfaceC1518a interfaceC1518a, Object obj) {
        if (this.f4863C == null) {
            this.f4863C = new LinkedHashMap();
        }
        this.f4863C.put(interfaceC1518a, obj);
    }

    public void Z0(boolean z10) {
        this.f4869v = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [h8.s] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public InterfaceC1536s a() {
        InterfaceC1536s interfaceC1536s = this.f4872z;
        ?? A10 = this;
        if (interfaceC1536s != this) {
            A10 = interfaceC1536s.a();
        }
        if (A10 != 0) {
            return A10;
        }
        C0(20);
        throw null;
    }

    public void a1(boolean z10) {
        this.f4870w = z10;
    }

    public final void b1(X8.A a3) {
        if (a3 != null) {
            this.g = a3;
        } else {
            C0(11);
            throw null;
        }
    }

    public Collection e() {
        J4.e eVar = this.y;
        if (eVar != null) {
            this.f4871x = (Collection) eVar.invoke();
            this.y = null;
        }
        Collection collection = this.f4871x;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        C0(14);
        throw null;
    }

    @Override // h8.InterfaceC1519b
    public boolean e0() {
        return this.f4870w;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return this.f4866r;
    }

    @Override // h8.InterfaceC1520c
    public final CallableMemberDescriptor$Kind getKind() {
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = this.f4861A;
        if (callableMemberDescriptor$Kind != null) {
            return callableMemberDescriptor$Kind;
        }
        C0(21);
        throw null;
    }

    public X8.w getReturnType() {
        return this.g;
    }

    @Override // h8.InterfaceC1519b
    public final List getTypeParameters() {
        List list = this.e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // h8.InterfaceC1530m, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n c1531n = this.l;
        if (c1531n != null) {
            return c1531n;
        }
        C0(16);
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final Modality i() {
        Modality modality = this.k;
        if (modality != null) {
            return modality;
        }
        C0(15);
        throw null;
    }

    public boolean isExternal() {
        return this.o;
    }

    @Override // h8.InterfaceC1536s
    public final boolean isInfix() {
        if (this.n) {
            return true;
        }
        Iterator it = a().e().iterator();
        while (it.hasNext()) {
            if (((InterfaceC1536s) it.next()).isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.p;
    }

    @Override // h8.InterfaceC1536s
    public final boolean isOperator() {
        if (this.m) {
            return true;
        }
        Iterator it = a().e().iterator();
        while (it.hasNext()) {
            if (((InterfaceC1536s) it.next()).isOperator()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuspend() {
        return this.u;
    }

    @Override // h8.InterfaceC1536s
    public final InterfaceC1536s l0() {
        return this.f4862B;
    }

    @Override // h8.InterfaceC1519b
    public final List p0() {
        List list = this.h;
        if (list != null) {
            return list;
        }
        C0(13);
        throw null;
    }

    public boolean t() {
        return this.f4865q;
    }

    @Override // h8.InterfaceC1536s
    public final boolean t0() {
        return this.f4867s;
    }

    public void u0(Collection collection) {
        if (collection == null) {
            C0(17);
            throw null;
        }
        this.f4871x = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((InterfaceC1536s) it.next()).w0()) {
                this.f4868t = true;
                return;
            }
        }
    }

    public Object v0(InterfaceC1518a interfaceC1518a) {
        Map map = this.f4863C;
        if (map == null) {
            return null;
        }
        return map.get(interfaceC1518a);
    }

    @Override // h8.InterfaceC1536s
    public final boolean w0() {
        return this.f4868t;
    }

    @Override // h8.InterfaceC1519b
    public final List x() {
        List list = this.f;
        if (list != null) {
            return list;
        }
        C0(19);
        throw null;
    }

    public InterfaceC1535r x0() {
        return X0(kotlin.reflect.jvm.internal.impl.types.a.b);
    }

    @Override // h8.InterfaceC1505M
    public InterfaceC1536s b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar == null) {
            C0(22);
            throw null;
        }
        if (aVar.f5144a.e()) {
            return this;
        }
        C1649s c1649sX0 = X0(aVar);
        c1649sX0.e = a();
        c1649sX0.o = true;
        c1649sX0.f4859w = true;
        return c1649sX0.f4860x.U0(c1649sX0);
    }
}
