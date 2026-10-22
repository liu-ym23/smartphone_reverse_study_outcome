package ya;

import E9.InterfaceC0797b;
import E9.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import ka.C4828h;
import xa.InterfaceC5869l;

/* renamed from: ya.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6013t extends AbstractC5985b {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0797b f44126d;

    /* renamed from: e, reason: collision with root package name */
    public final List<E9.b0> f44127e;

    /* renamed from: f, reason: collision with root package name */
    public final Collection<S> f44128f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6013t(InterfaceC0797b interfaceC0797b, List<? extends E9.b0> list, Collection<S> collection, InterfaceC5869l interfaceC5869l) {
        super(interfaceC5869l);
        if (interfaceC0797b == null) {
            I(0);
        }
        if (list == null) {
            I(1);
        }
        if (collection == null) {
            I(2);
        }
        if (interfaceC5869l == null) {
            I(3);
        }
        this.f44126d = interfaceC0797b;
        this.f44127e = Collections.unmodifiableList(new ArrayList(list));
        this.f44128f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void I(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getParameters";
        } else if (i10 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i10 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i10 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ya.AbstractC6014u, ya.v0
    /* renamed from: J */
    public InterfaceC0797b d() {
        InterfaceC0797b interfaceC0797b = this.f44126d;
        if (interfaceC0797b == null) {
            I(5);
        }
        return interfaceC0797b;
    }

    @Override // ya.v0
    public boolean f() {
        return true;
    }

    @Override // ya.v0
    public List<E9.b0> getParameters() {
        List<E9.b0> list = this.f44127e;
        if (list == null) {
            I(4);
        }
        return list;
    }

    @Override // ya.AbstractC6009o
    public Collection<S> s() {
        Collection<S> collection = this.f44128f;
        if (collection == null) {
            I(6);
        }
        return collection;
    }

    public String toString() {
        return C4828h.m(this.f44126d).a();
    }

    @Override // ya.AbstractC6009o
    public E9.Z w() {
        Z.a aVar = Z.a.f2446a;
        if (aVar == null) {
            I(7);
        }
        return aVar;
    }
}
