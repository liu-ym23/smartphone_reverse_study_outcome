package H9;

import E9.InterfaceC0803h;

/* renamed from: H9.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0834m extends F9.b implements InterfaceC0803h {

    /* renamed from: b, reason: collision with root package name */
    public final ga.e f3141b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0834m(F9.g gVar, ga.e eVar) {
        super(gVar);
        if (gVar == null) {
            T(0);
        }
        if (eVar == null) {
            T(1);
        }
        this.f3141b = eVar;
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 5 || i10 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i10 != 2 && i10 != 3) {
            if (i10 == 4) {
                objArr[2] = "toString";
            } else if (i10 != 5 && i10 != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static String c0(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            T(4);
        }
        try {
            String str = kotlin.reflect.jvm.internal.impl.renderer.b.f35920k.M(interfaceC0803h) + "[" + interfaceC0803h.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(interfaceC0803h)) + "]";
            if (str == null) {
                T(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = interfaceC0803h.getClass().getSimpleName() + " " + interfaceC0803h.getName();
            if (str2 == null) {
                T(6);
            }
            return str2;
        }
    }

    public InterfaceC0803h a() {
        return this;
    }

    @Override // E9.A
    public ga.e getName() {
        ga.e eVar = this.f3141b;
        if (eVar == null) {
            T(2);
        }
        return eVar;
    }

    public String toString() {
        return c0(this);
    }
}
