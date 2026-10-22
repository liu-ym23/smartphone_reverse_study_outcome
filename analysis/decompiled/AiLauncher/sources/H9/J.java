package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0803h;
import E9.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes5.dex */
public abstract class J extends AbstractC0835n implements kotlin.reflect.jvm.internal.impl.descriptors.f {

    /* renamed from: e, reason: collision with root package name */
    public boolean f3024e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3025f;

    /* renamed from: g, reason: collision with root package name */
    public final Modality f3026g;

    /* renamed from: h, reason: collision with root package name */
    public final E9.O f3027h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3028i;

    /* renamed from: j, reason: collision with root package name */
    public final CallableMemberDescriptor.Kind f3029j;

    /* renamed from: k, reason: collision with root package name */
    public AbstractC0811p f3030k;

    /* renamed from: l, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.descriptors.e f3031l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(Modality modality, AbstractC0811p abstractC0811p, E9.O o10, F9.g gVar, ga.e eVar, boolean z10, boolean z11, boolean z12, CallableMemberDescriptor.Kind kind, E9.W w10) {
        super(o10.b(), gVar, eVar, w10);
        if (modality == null) {
            T(0);
        }
        if (abstractC0811p == null) {
            T(1);
        }
        if (o10 == null) {
            T(2);
        }
        if (gVar == null) {
            T(3);
        }
        if (eVar == null) {
            T(4);
        }
        if (w10 == null) {
            T(5);
        }
        this.f3031l = null;
        this.f3026g = modality;
        this.f3030k = abstractC0811p;
        this.f3027h = o10;
        this.f3024e = z10;
        this.f3025f = z11;
        this.f3028i = z12;
        this.f3029j = kind;
    }

    private static /* synthetic */ void T(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i11 = 2;
                break;
            case 7:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i10) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.f y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, boolean z10) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    public boolean D() {
        return this.f3024e;
    }

    @Override // H9.AbstractC0835n
    /* renamed from: E0 */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.f a();

    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.f> F0(boolean z10) {
        ArrayList arrayList = new ArrayList(0);
        for (E9.O o10 : Q().d()) {
            F9.a getter = z10 ? o10.getGetter() : o10.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void G0(boolean z10) {
        this.f3024e = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S H() {
        return Q().H();
    }

    public void H0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        this.f3031l = eVar;
    }

    public void I0(AbstractC0811p abstractC0811p) {
        this.f3030k = abstractC0811p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public E9.S K() {
        return Q().K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    public E9.O Q() {
        E9.O o10 = this.f3027h;
        if (o10 == null) {
            T(13);
        }
        return o10;
    }

    @Override // E9.InterfaceC0816v
    public boolean S() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return false;
    }

    @Override // E9.Y
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            T(7);
        }
        return this;
    }

    @Override // E9.InterfaceC0816v
    public boolean e0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.f3029j;
        if (kind == null) {
            T(6);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<b0> getTypeParameters() {
        List<b0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(9);
        }
        return list;
    }

    @Override // E9.InterfaceC0807l, E9.InterfaceC0816v
    public AbstractC0811p getVisibility() {
        AbstractC0811p abstractC0811p = this.f3030k;
        if (abstractC0811p == null) {
            T(11);
        }
        return abstractC0811p;
    }

    @Override // E9.InterfaceC0816v
    public boolean isExternal() {
        return this.f3025f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return this.f3028i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e m0() {
        return this.f3031l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V o0(a.InterfaceC0437a<V> interfaceC0437a) {
        return null;
    }

    @Override // E9.InterfaceC0816v
    public Modality p() {
        Modality modality = this.f3026g;
        if (modality == null) {
            T(10);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<E9.S> s0() {
        List<E9.S> listS0 = Q().s0();
        if (listS0 == null) {
            T(14);
        }
        return listS0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean w0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void x0(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            T(16);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean z0() {
        return false;
    }
}
