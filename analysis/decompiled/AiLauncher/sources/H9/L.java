package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0805j;
import E9.i0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes5.dex */
public class L extends J implements E9.P {

    /* renamed from: m, reason: collision with root package name */
    public ya.S f3065m;

    /* renamed from: n, reason: collision with root package name */
    public final E9.P f3066n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(E9.O o10, F9.g gVar, Modality modality, AbstractC0811p abstractC0811p, boolean z10, boolean z11, boolean z12, CallableMemberDescriptor.Kind kind, E9.P p10, E9.W w10) {
        super(modality, abstractC0811p, o10, gVar, ga.e.m("<get-" + o10.getName() + ">"), z10, z11, z12, kind, w10);
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
        this.f3066n = p10 != null ? p10 : this;
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 6 || i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 6 || i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
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
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i10 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // H9.J, H9.AbstractC0835n
    /* renamed from: J0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public E9.P a() {
        E9.P p10 = this.f3066n;
        if (p10 == null) {
            T(8);
        }
        return p10;
    }

    public void K0(ya.S s10) {
        if (s10 == null) {
            s10 = Q().getType();
        }
        this.f3065m = s10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends E9.P> d() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.f> collectionF0 = super.F0(true);
        if (collectionF0 == null) {
            T(6);
        }
        return collectionF0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public ya.S getReturnType() {
        return this.f3065m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i0> i() {
        List<i0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(7);
        }
        return list;
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.m(this, d10);
    }
}
