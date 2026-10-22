package v9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class i extends b {

    /* renamed from: c, reason: collision with root package name */
    public final i8.z f10554c;

    /* renamed from: d, reason: collision with root package name */
    public final List f10555d;

    /* renamed from: e, reason: collision with root package name */
    public final Collection f10556e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(i8.z zVar, List list, Collection collection, u9.n nVar) {
        super(nVar);
        if (list == null) {
            k(1);
            throw null;
        }
        if (collection == null) {
            k(2);
            throw null;
        }
        if (nVar == null) {
            k(3);
            throw null;
        }
        this.f10554c = zVar;
        this.f10555d = Collections.unmodifiableList(new ArrayList(list));
        this.f10556e = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void k(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
        switch (i2) {
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
        if (i2 == 4) {
            objArr[1] = "getParameters";
        } else if (i2 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i2 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i2 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // v9.m0
    public final boolean a() {
        return true;
    }

    @Override // v9.f
    public final Collection e() {
        Collection collection = this.f10556e;
        if (collection != null) {
            return collection;
        }
        k(6);
        throw null;
    }

    @Override // v9.f
    public final f8.o0 g() {
        return f8.o0.f3504h;
    }

    @Override // v9.m0
    public final List getParameters() {
        List list = this.f10555d;
        if (list != null) {
            return list;
        }
        k(4);
        throw null;
    }

    @Override // v9.b
    /* renamed from: l */
    public final f8.e c() {
        i8.z zVar = this.f10554c;
        if (zVar != null) {
            return zVar;
        }
        k(5);
        throw null;
    }

    public final String toString() {
        String str = h9.f.g(this.f10554c).f3193a;
        if (str != null) {
            return str;
        }
        e9.e.a(4);
        throw null;
    }
}
