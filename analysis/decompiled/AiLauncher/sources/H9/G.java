package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.b0;
import E9.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import ra.InterfaceC5238k;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.C6013t;
import ya.v0;

/* loaded from: classes5.dex */
public class G extends AbstractC0831j {

    /* renamed from: i, reason: collision with root package name */
    public final ClassKind f3010i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3011j;

    /* renamed from: k, reason: collision with root package name */
    public Modality f3012k;

    /* renamed from: l, reason: collision with root package name */
    public AbstractC0811p f3013l;

    /* renamed from: m, reason: collision with root package name */
    public v0 f3014m;

    /* renamed from: n, reason: collision with root package name */
    public List<b0> f3015n;

    /* renamed from: o, reason: collision with root package name */
    public final Collection<ya.S> f3016o;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceC5869l f3017p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(InterfaceC0803h interfaceC0803h, ClassKind classKind, boolean z10, boolean z11, ga.e eVar, E9.W w10, InterfaceC5869l interfaceC5869l) {
        super(interfaceC5869l, interfaceC0803h, eVar, w10, z11);
        if (interfaceC0803h == null) {
            y0(0);
        }
        if (classKind == null) {
            y0(1);
        }
        if (eVar == null) {
            y0(2);
        }
        if (w10 == null) {
            y0(3);
        }
        if (interfaceC5869l == null) {
            y0(4);
        }
        this.f3016o = new ArrayList();
        this.f3017p = interfaceC5869l;
        this.f3010i = classKind;
        this.f3011j = z10;
    }

    private static /* synthetic */ void y0(int i10) {
        String str;
        int i11;
        switch (i10) {
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
        switch (i10) {
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
                i11 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
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
        switch (i10) {
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
        switch (i10) {
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
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
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

    @Override // E9.InterfaceC0797b
    public kotlin.reflect.jvm.internal.impl.descriptors.b B() {
        return null;
    }

    @Override // E9.InterfaceC0797b
    public boolean C0() {
        return false;
    }

    public void E0() {
        this.f3014m = new C6013t(this, this.f3015n, this.f3016o, this.f3017p);
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.b> it = h().iterator();
        while (it.hasNext()) {
            ((C0830i) it.next()).a1(n());
        }
    }

    @Override // E9.InterfaceC0797b
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.jvm.internal.impl.descriptors.b> h() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.b> set = Collections.EMPTY_SET;
        if (set == null) {
            y0(13);
        }
        return set;
    }

    public void G0(Modality modality) {
        if (modality == null) {
            y0(6);
        }
        this.f3012k = modality;
    }

    public void H0(List<b0> list) {
        if (list == null) {
            y0(14);
        }
        if (this.f3015n == null) {
            this.f3015n = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void I0(AbstractC0811p abstractC0811p) {
        if (abstractC0811p == null) {
            y0(9);
        }
        this.f3013l = abstractC0811p;
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
            y0(16);
        }
        InterfaceC5238k.b bVar = InterfaceC5238k.b.f38898b;
        if (bVar == null) {
            y0(17);
        }
        return bVar;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // E9.InterfaceC0797b
    public InterfaceC5238k g0() {
        InterfaceC5238k.b bVar = InterfaceC5238k.b.f38898b;
        if (bVar == null) {
            y0(18);
        }
        return bVar;
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        F9.g gVarB = F9.g.f2609m0.b();
        if (gVarB == null) {
            y0(5);
        }
        return gVarB;
    }

    @Override // E9.InterfaceC0797b
    public ClassKind getKind() {
        ClassKind classKind = this.f3010i;
        if (classKind == null) {
            y0(8);
        }
        return classKind;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = this.f3013l;
        if (abstractC0811p == null) {
            y0(10);
        }
        return abstractC0811p;
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
        v0 v0Var = this.f3014m;
        if (v0Var == null) {
            y0(11);
        }
        return v0Var;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0800e
    public List<b0> o() {
        List<b0> list = this.f3015n;
        if (list == null) {
            y0(15);
        }
        return list;
    }

    @Override // E9.InterfaceC0797b, E9.InterfaceC0816v
    public Modality p() {
        Modality modality = this.f3012k;
        if (modality == null) {
            y0(7);
        }
        return modality;
    }

    @Override // E9.InterfaceC0797b
    public boolean q() {
        return false;
    }

    public String toString() {
        return AbstractC0834m.c0(this);
    }

    @Override // E9.InterfaceC0800e
    public boolean x() {
        return this.f3011j;
    }
}
