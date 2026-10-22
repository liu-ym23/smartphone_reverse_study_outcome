package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0805j;
import E9.i0;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public class M extends J implements E9.Q {

    /* renamed from: m, reason: collision with root package name */
    public i0 f3067m;

    /* renamed from: n, reason: collision with root package name */
    public final E9.Q f3068n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(E9.O o10, F9.g gVar, Modality modality, AbstractC0811p abstractC0811p, boolean z10, boolean z11, boolean z12, CallableMemberDescriptor.Kind kind, E9.Q q10, E9.W w10) {
        super(modality, abstractC0811p, o10, gVar, ga.e.m("<set-" + o10.getName() + ">"), z10, z11, z12, kind, w10);
        if (o10 == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (modality == null) {
            T(2);
        }
        if (abstractC0811p == null) {
            T(3);
        }
        if (kind == null) {
            T(4);
        }
        if (w10 == null) {
            T(5);
        }
        this.f3068n = q10 != null ? q10 : this;
    }

    public static V J0(E9.Q q10, ya.S s10, F9.g gVar) {
        if (q10 == null) {
            T(7);
        }
        if (s10 == null) {
            T(8);
        }
        if (gVar == null) {
            T(9);
        }
        return new V(q10, null, 0, gVar, ga.g.f32756p, s10, false, false, false, null, E9.W.f2444a);
    }

    private static /* synthetic */ void T(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 9:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i10) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i10) {
            case 6:
                objArr[2] = McpSchema.METHOD_INITIALIZE;
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // H9.J, H9.AbstractC0835n
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public E9.Q a() {
        E9.Q q10 = this.f3068n;
        if (q10 == null) {
            T(13);
        }
        return q10;
    }

    public void L0(i0 i0Var) {
        if (i0Var == null) {
            T(6);
        }
        this.f3067m = i0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends E9.Q> d() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.f> collectionF0 = super.F0(false);
        if (collectionF0 == null) {
            T(10);
        }
        return collectionF0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public ya.S getReturnType() {
        AbstractC5990d0 abstractC5990d0A0 = DescriptorUtilsKt.m(this).a0();
        if (abstractC5990d0A0 == null) {
            T(12);
        }
        return abstractC5990d0A0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i0> i() {
        i0 i0Var = this.f3067m;
        if (i0Var == null) {
            throw new IllegalStateException();
        }
        List<i0> listSingletonList = Collections.singletonList(i0Var);
        if (listSingletonList == null) {
            T(11);
        }
        return listSingletonList;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.j(this, d10);
    }
}
