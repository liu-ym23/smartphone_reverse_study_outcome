package H9;

import E9.InterfaceC0803h;
import E9.b0;
import E9.i0;
import E9.j0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class X extends AbstractC0835n implements j0 {

    /* renamed from: e, reason: collision with root package name */
    public ya.S f3093e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(InterfaceC0803h interfaceC0803h, F9.g gVar, ga.e eVar, ya.S s10, E9.W w10) {
        super(interfaceC0803h, gVar, eVar, w10);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (eVar == null) {
            T(2);
        }
        if (w10 == null) {
            T(3);
        }
        this.f3093e = s10;
    }

    private static /* synthetic */ void T(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public void A0(ya.S s10) {
        this.f3093e = s10;
    }

    public E9.S H() {
        return null;
    }

    public E9.S K() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean b0() {
        return false;
    }

    public ya.S getReturnType() {
        ya.S type = getType();
        if (type == null) {
            T(10);
        }
        return type;
    }

    @Override // E9.h0
    public ya.S getType() {
        ya.S s10 = this.f3093e;
        if (s10 == null) {
            T(4);
        }
        return s10;
    }

    public List<b0> getTypeParameters() {
        List<b0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(8);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i0> i() {
        List<i0> list = Collections.EMPTY_LIST;
        if (list == null) {
            T(6);
        }
        return list;
    }
}
