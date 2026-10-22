package H9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.b0;
import E9.g0;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import ra.InterfaceC5238k;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.C6013t;
import ya.v0;

/* renamed from: H9.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0832k extends AbstractC0831j {

    /* renamed from: i, reason: collision with root package name */
    public final Modality f3133i;

    /* renamed from: j, reason: collision with root package name */
    public final ClassKind f3134j;

    /* renamed from: k, reason: collision with root package name */
    public final v0 f3135k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC5238k f3136l;

    /* renamed from: m, reason: collision with root package name */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.b> f3137m;

    /* renamed from: n, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.descriptors.b f3138n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0832k(InterfaceC0803h interfaceC0803h, ga.e eVar, Modality modality, ClassKind classKind, Collection<ya.S> collection, E9.W w10, boolean z10, InterfaceC5869l interfaceC5869l) {
        super(interfaceC5869l, interfaceC0803h, eVar, w10, z10);
        if (interfaceC0803h == null) {
            y0(0);
        }
        if (eVar == null) {
            y0(1);
        }
        if (modality == null) {
            y0(2);
        }
        if (classKind == null) {
            y0(3);
        }
        if (collection == null) {
            y0(4);
        }
        if (w10 == null) {
            y0(5);
        }
        if (interfaceC5869l == null) {
            y0(6);
        }
        this.f3133i = modality;
        this.f3134j = classKind;
        this.f3135k = new C6013t(this, Collections.EMPTY_LIST, collection, interfaceC5869l);
    }

    private static /* synthetic */ void y0(int i10) {
        String str;
        int i11;
        switch (i10) {
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
        switch (i10) {
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
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "name";
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
                objArr[0] = "source";
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
        switch (i10) {
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
        switch (i10) {
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
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
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

    @Override // E9.InterfaceC0797b
    public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return this.f3138n;
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        return false;
    }

    public final void E0(InterfaceC5238k interfaceC5238k, Set<kotlin.reflect.jvm.internal.impl.descriptors.b> set, kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (interfaceC5238k == null) {
            y0(7);
        }
        if (set == null) {
            y0(8);
        }
        this.f3136l = interfaceC5238k;
        this.f3137m = set;
        this.f3138n = bVar;
    }

    @Override // E9.InterfaceC0797b
    public g0<AbstractC5990d0> P() {
        return null;
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean W() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public boolean Z() {
        return false;
    }

    @Override // H9.z
    public InterfaceC5238k c0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (cVar == null) {
            y0(12);
        }
        InterfaceC5238k interfaceC5238k = this.f3136l;
        if (interfaceC5238k == null) {
            y0(13);
        }
        return interfaceC5238k;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k g0() {
        InterfaceC5238k.b bVar = InterfaceC5238k.b.f38898b;
        if (bVar == null) {
            y0(14);
        }
        return bVar;
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        F9.g gVarB = F9.g.f2609m0.b();
        if (gVarB == null) {
            y0(9);
        }
        return gVarB;
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        ClassKind classKind = this.f3134j;
        if (classKind == null) {
            y0(15);
        }
        return classKind;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = C0810o.f2473e;
        if (abstractC0811p == null) {
            y0(17);
        }
        return abstractC0811p;
    }

    @Override // E9.InterfaceC0797b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.b> set = this.f3137m;
        if (set == null) {
            y0(11);
        }
        return set;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC0797b h0() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    public boolean isInline() {
        return false;
    }

    @Override // E9.InterfaceC0799d
    public v0 j() {
        v0 v0Var = this.f3135k;
        if (v0Var == null) {
            y0(10);
        }
        return v0Var;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        List<b0> list = Collections.EMPTY_LIST;
        if (list == null) {
            y0(18);
        }
        return list;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        Modality modality = this.f3133i;
        if (modality == null) {
            y0(16);
        }
        return modality;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return false;
    }
}
