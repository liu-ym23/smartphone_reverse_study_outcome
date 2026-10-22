package k8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.C1531n;
import h8.InterfaceC1527j;
import h8.InterfaceC1535r;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* renamed from: k8.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1649s implements InterfaceC1535r {

    /* renamed from: a, reason: collision with root package name */
    public X8.P f4852a;
    public InterfaceC1527j b;
    public Modality c;
    public C1531n d;
    public InterfaceC1536s e;
    public CallableMemberDescriptor$Kind f;
    public List g;
    public final List h;
    public u i;

    /* renamed from: j, reason: collision with root package name */
    public u f4853j;
    public X8.w k;
    public G8.f l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4854q;

    /* renamed from: r, reason: collision with root package name */
    public List f4855r;

    /* renamed from: s, reason: collision with root package name */
    public InterfaceC1561g f4856s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4857t;
    public final LinkedHashMap u;

    /* renamed from: v, reason: collision with root package name */
    public Boolean f4858v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4859w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ t f4860x;

    public C1649s(t tVar, X8.P p, InterfaceC1527j interfaceC1527j, Modality modality, C1531n c1531n, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, List list, List list2, u uVar, X8.w wVar) {
        if (p == null) {
            a(0);
            throw null;
        }
        if (interfaceC1527j == null) {
            a(1);
            throw null;
        }
        if (modality == null) {
            a(2);
            throw null;
        }
        if (c1531n == null) {
            a(3);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            a(4);
            throw null;
        }
        if (list == null) {
            a(5);
            throw null;
        }
        if (list2 == null) {
            a(6);
            throw null;
        }
        if (wVar == null) {
            a(7);
            throw null;
        }
        this.f4860x = tVar;
        this.e = null;
        this.f4853j = tVar.f4864j;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.f4854q = tVar.f4867s;
        this.f4855r = null;
        this.f4856s = null;
        this.f4857t = tVar.f4868t;
        this.u = new LinkedHashMap();
        this.f4858v = null;
        this.f4859w = false;
        this.f4852a = p;
        this.b = interfaceC1527j;
        this.c = modality;
        this.d = c1531n;
        this.f = callableMemberDescriptor$Kind;
        this.g = list;
        this.h = list2;
        this.i = uVar;
        this.k = wVar;
        this.l = null;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i6;
        switch (i) {
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                i6 = 2;
                break;
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
                objArr[0] = "newOwner";
                break;
            case 2:
                objArr[0] = "newModality";
                break;
            case 3:
                objArr[0] = "newVisibility";
                break;
            case 4:
            case 14:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "newValueParameterDescriptors";
                break;
            case 6:
                objArr[0] = "newContextReceiverParameters";
                break;
            case 7:
                objArr[0] = "newReturnType";
                break;
            case 8:
                objArr[0] = "owner";
                break;
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 10:
                objArr[0] = "modality";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 17:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 19:
            case 21:
                objArr[0] = "parameters";
                break;
            case 23:
                objArr[0] = "type";
                break;
            case 25:
                objArr[0] = "contextReceiverParameters";
                break;
            case 35:
                objArr[0] = "additionalAnnotations";
                break;
            case 37:
            default:
                objArr[0] = "substitution";
                break;
            case 39:
                objArr[0] = "userDataKey";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "setOwner";
                break;
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 11:
                objArr[1] = "setModality";
                break;
            case 13:
                objArr[1] = "setVisibility";
                break;
            case 15:
                objArr[1] = "setKind";
                break;
            case 16:
                objArr[1] = "setCopyOverrides";
                break;
            case 18:
                objArr[1] = "setName";
                break;
            case 20:
                objArr[1] = "setValueParameters";
                break;
            case 22:
                objArr[1] = "setTypeParameters";
                break;
            case 24:
                objArr[1] = "setReturnType";
                break;
            case 26:
                objArr[1] = "setContextReceiverParameters";
                break;
            case 27:
                objArr[1] = "setExtensionReceiverParameter";
                break;
            case 28:
                objArr[1] = "setDispatchReceiverParameter";
                break;
            case 29:
                objArr[1] = "setOriginal";
                break;
            case 30:
                objArr[1] = "setSignatureChange";
                break;
            case 31:
                objArr[1] = "setPreserveSourceElement";
                break;
            case 32:
                objArr[1] = "setDropOriginalInContainingParts";
                break;
            case 33:
                objArr[1] = "setHiddenToOvercomeSignatureClash";
                break;
            case 34:
                objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                break;
            case 36:
                objArr[1] = "setAdditionalAnnotations";
                break;
            case 38:
                objArr[1] = "setSubstitution";
                break;
            case 40:
                objArr[1] = "putUserData";
                break;
            case 41:
                objArr[1] = "getSubstitution";
                break;
            case 42:
                objArr[1] = "setJustForTypeSubstitution";
                break;
        }
        switch (i) {
            case 8:
                objArr[2] = "setOwner";
                break;
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                break;
            case 10:
                objArr[2] = "setModality";
                break;
            case 12:
                objArr[2] = "setVisibility";
                break;
            case 14:
                objArr[2] = "setKind";
                break;
            case 17:
                objArr[2] = "setName";
                break;
            case 19:
                objArr[2] = "setValueParameters";
                break;
            case 21:
                objArr[2] = "setTypeParameters";
                break;
            case 23:
                objArr[2] = "setReturnType";
                break;
            case 25:
                objArr[2] = "setContextReceiverParameters";
                break;
            case 35:
                objArr[2] = "setAdditionalAnnotations";
                break;
            case 37:
                objArr[2] = "setSubstitution";
                break;
            case 39:
                objArr[2] = "putUserData";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 40:
            case 41:
            case 42:
                throw new IllegalStateException(str2);
            case 10:
            case 12:
            case 14:
            case 17:
            case 19:
            case 21:
            case 23:
            case 25:
            case 35:
            case 37:
            case 39:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r A(X8.w wVar) {
        if (wVar != null) {
            this.k = wVar;
            return this;
        }
        a(23);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r B() {
        this.n = true;
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1536s build() {
        return this.f4860x.U0(this);
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r d(u uVar) {
        this.f4853j = uVar;
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r e(List list) {
        if (list != null) {
            this.g = list;
            return this;
        }
        a(19);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r g(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j != null) {
            this.b = interfaceC1527j;
            return this;
        }
        a(8);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r h(G8.f fVar) {
        if (fVar != null) {
            this.l = fVar;
            return this;
        }
        a(17);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r i() {
        this.f4857t = true;
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r j() {
        this.m = false;
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r p() {
        this.f4854q = true;
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r r(C1531n c1531n) {
        if (c1531n != null) {
            this.d = c1531n;
            return this;
        }
        a(12);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r s(Modality modality) {
        if (modality != null) {
            this.c = modality;
            return this;
        }
        a(10);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r u() {
        this.o = true;
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r v() {
        this.u.put(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a.f4995G, Boolean.TRUE);
        return this;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r w(List list) {
        if (list != null) {
            this.f4855r = list;
            return this;
        }
        a(21);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r x(InterfaceC1561g interfaceC1561g) {
        if (interfaceC1561g != null) {
            this.f4856s = interfaceC1561g;
            return this;
        }
        a(35);
        throw null;
    }

    @Override // h8.InterfaceC1535r
    public final InterfaceC1535r z(CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        if (callableMemberDescriptor$Kind != null) {
            this.f = callableMemberDescriptor$Kind;
            return this;
        }
        a(14);
        throw null;
    }
}
