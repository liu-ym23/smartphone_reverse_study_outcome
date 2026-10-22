package H9;

import E9.InterfaceC0803h;
import E9.InterfaceC0804i;
import E9.InterfaceC0806k;

/* renamed from: H9.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0835n extends AbstractC0834m implements InterfaceC0804i {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0803h f3142c;

    /* renamed from: d, reason: collision with root package name */
    public final E9.W f3143d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0835n(InterfaceC0803h interfaceC0803h, F9.g gVar, ga.e eVar, E9.W w10) {
        super(gVar, eVar);
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
        this.f3142c = interfaceC0803h;
        this.f3143d = w10;
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getOriginal";
        } else if (i10 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public InterfaceC0803h b() {
        InterfaceC0803h interfaceC0803h = this.f3142c;
        if (interfaceC0803h == null) {
            T(5);
        }
        return interfaceC0803h;
    }

    public E9.W e() {
        E9.W w10 = this.f3143d;
        if (w10 == null) {
            T(6);
        }
        return w10;
    }

    @Override // H9.AbstractC0834m, E9.InterfaceC0803h
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0806k a() {
        InterfaceC0806k interfaceC0806k = (InterfaceC0806k) super.a();
        if (interfaceC0806k == null) {
            T(4);
        }
        return interfaceC0806k;
    }
}
