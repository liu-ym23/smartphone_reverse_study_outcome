package H9;

import E9.InterfaceC0803h;
import E9.Z;
import E9.b0;
import java.util.ArrayList;
import java.util.List;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import p9.InterfaceC5074l;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public class U extends AbstractC0829h {

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC5074l<ya.S, Void> f3081k;

    /* renamed from: l, reason: collision with root package name */
    public final List<ya.S> f3082l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3083m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(InterfaceC0803h interfaceC0803h, F9.g gVar, boolean z10, Variance variance, ga.e eVar, int i10, E9.W w10, InterfaceC5074l<ya.S, Void> interfaceC5074l, Z z11, InterfaceC5869l interfaceC5869l) {
        super(interfaceC5869l, interfaceC0803h, gVar, eVar, variance, z10, i10, w10, z11);
        if (interfaceC0803h == null) {
            T(19);
        }
        if (gVar == null) {
            T(20);
        }
        if (variance == null) {
            T(21);
        }
        if (eVar == null) {
            T(22);
        }
        if (w10 == null) {
            T(23);
        }
        if (z11 == null) {
            T(24);
        }
        if (interfaceC5869l == null) {
            T(25);
        }
        this.f3082l = new ArrayList(1);
        this.f3083m = false;
        this.f3081k = interfaceC5074l;
    }

    public static U J0(InterfaceC0803h interfaceC0803h, F9.g gVar, boolean z10, Variance variance, ga.e eVar, int i10, E9.W w10, InterfaceC5074l<ya.S, Void> interfaceC5074l, Z z11, InterfaceC5869l interfaceC5869l) {
        if (interfaceC0803h == null) {
            T(12);
        }
        if (gVar == null) {
            T(13);
        }
        if (variance == null) {
            T(14);
        }
        if (eVar == null) {
            T(15);
        }
        if (w10 == null) {
            T(16);
        }
        if (z11 == null) {
            T(17);
        }
        if (interfaceC5869l == null) {
            T(18);
        }
        return new U(interfaceC0803h, gVar, z10, variance, eVar, i10, w10, interfaceC5074l, z11, interfaceC5869l);
    }

    public static U K0(InterfaceC0803h interfaceC0803h, F9.g gVar, boolean z10, Variance variance, ga.e eVar, int i10, E9.W w10, InterfaceC5869l interfaceC5869l) {
        if (interfaceC0803h == null) {
            T(6);
        }
        if (gVar == null) {
            T(7);
        }
        if (variance == null) {
            T(8);
        }
        if (eVar == null) {
            T(9);
        }
        if (w10 == null) {
            T(10);
        }
        if (interfaceC5869l == null) {
            T(11);
        }
        return J0(interfaceC0803h, gVar, z10, variance, eVar, i10, w10, null, Z.a.f2446a, interfaceC5869l);
    }

    public static b0 L0(InterfaceC0803h interfaceC0803h, F9.g gVar, boolean z10, Variance variance, ga.e eVar, int i10, InterfaceC5869l interfaceC5869l) {
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (variance == null) {
            T(2);
        }
        if (eVar == null) {
            T(3);
        }
        if (interfaceC5869l == null) {
            T(4);
        }
        U uK0 = K0(interfaceC0803h, gVar, z10, variance, eVar, i10, E9.W.f2444a, interfaceC5869l);
        uK0.G0(DescriptorUtilsKt.m(interfaceC0803h).z());
        uK0.P0();
        return uK0;
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 5 || i10 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 28) ? 2 : 3];
        switch (i10) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i10 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i10 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i10) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // H9.AbstractC0829h
    public void E0(ya.S s10) {
        if (s10 == null) {
            T(27);
        }
        InterfaceC5074l<ya.S, Void> interfaceC5074l = this.f3081k;
        if (interfaceC5074l == null) {
            return;
        }
        interfaceC5074l.invoke(s10);
    }

    @Override // H9.AbstractC0829h
    public List<ya.S> F0() {
        H0();
        List<ya.S> list = this.f3082l;
        if (list == null) {
            T(28);
        }
        return list;
    }

    public void G0(ya.S s10) {
        if (s10 == null) {
            T(26);
        }
        I0();
        M0(s10);
    }

    public final void H0() {
        if (this.f3083m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + O0());
    }

    public final void I0() {
        if (this.f3083m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + O0());
        }
    }

    public final void M0(ya.S s10) {
        if (ya.W.a(s10)) {
            return;
        }
        this.f3082l.add(s10);
    }

    public boolean N0() {
        return this.f3083m;
    }

    public final String O0() {
        return getName() + " declared in " + C4828h.m(b());
    }

    public void P0() {
        I0();
        this.f3083m = true;
    }
}
