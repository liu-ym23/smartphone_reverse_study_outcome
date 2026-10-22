package i8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends v9.f {

    /* renamed from: c, reason: collision with root package name */
    public final f8.o0 f4768c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f4769d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, u9.n nVar, f8.o0 o0Var) {
        super(nVar);
        if (nVar == null) {
            k(0);
            throw null;
        }
        this.f4769d = hVar;
        this.f4768c = o0Var;
    }

    public static /* synthetic */ void k(int i2) {
        String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                break;
            case 6:
                objArr[0] = "type";
                break;
            case 7:
                objArr[0] = "supertypes";
                break;
            case 9:
                objArr[0] = "classifier";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i2 == 1) {
            objArr[1] = "computeSupertypes";
        } else if (i2 == 2) {
            objArr[1] = "getParameters";
        } else if (i2 == 3) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i2 == 4) {
            objArr[1] = "getBuiltIns";
        } else if (i2 == 5) {
            objArr[1] = "getSupertypeLoopChecker";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        } else {
            objArr[1] = "processSupertypesWithoutCycles";
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                break;
            case 6:
                objArr[2] = "reportSupertypeLoopError";
                break;
            case 7:
                objArr[2] = "processSupertypesWithoutCycles";
                break;
            case 9:
                objArr[2] = "isSameClassifier";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // v9.m0
    public final boolean a() {
        return true;
    }

    @Override // v9.m0
    public final f8.g c() {
        h hVar = this.f4769d;
        if (hVar != null) {
            return hVar;
        }
        k(3);
        throw null;
    }

    @Override // v9.f
    public final Collection e() {
        List listH0 = this.f4769d.H0();
        if (listH0 != null) {
            return listH0;
        }
        k(1);
        throw null;
    }

    @Override // v9.f
    public final v9.v f() {
        return x9.i.c(x9.h.f11306l, new String[0]);
    }

    @Override // v9.f
    public final f8.o0 g() {
        f8.o0 o0Var = this.f4768c;
        if (o0Var != null) {
            return o0Var;
        }
        k(5);
        throw null;
    }

    @Override // v9.m0
    public final List getParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        k(2);
        throw null;
    }

    @Override // v9.f
    public final boolean i(f8.g gVar) {
        if (!(gVar instanceof f8.q0)) {
            return false;
        }
        return h9.d.f4235a.d(this.f4769d, (f8.q0) gVar, true, h9.c.f4234g);
    }

    @Override // v9.f
    public final List j(List list) {
        List listG0 = this.f4769d.G0(list);
        if (listG0 != null) {
            return listG0;
        }
        k(8);
        throw null;
    }

    @Override // v9.m0
    public final c8.h n() {
        c8.h hVarE = l9.d.e(this.f4769d);
        if (hVarE != null) {
            return hVarE;
        }
        k(4);
        throw null;
    }

    public final String toString() {
        return this.f4769d.getName().f3197f;
    }
}
