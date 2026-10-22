package q8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d7.z;
import f8.n0;
import f8.t;
import g8.h;
import g8.j;
import h9.m;
import i8.i;
import i8.u;
import java.util.ArrayList;
import v9.v;

/* loaded from: classes.dex */
public final class b extends i implements a {
    public Boolean J;
    public Boolean K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f8.e eVar, b bVar, j jVar, boolean z4, int i2, n0 n0Var) {
        super(eVar, bVar, jVar, z4, i2, n0Var);
        if (eVar == null) {
            R(0);
            throw null;
        }
        if (jVar == null) {
            R(1);
            throw null;
        }
        if (i2 == 0) {
            R(2);
            throw null;
        }
        if (n0Var == null) {
            R(3);
            throw null;
        }
        this.J = null;
        this.K = null;
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 11 || i2 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 11 || i2 == 18) ? 2 : 3];
        switch (i2) {
            case 1:
            case 5:
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i2 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i2 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                break;
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 11 && i2 != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static b X0(f8.e eVar, j jVar, boolean z4, k8.g gVar) {
        if (eVar != null) {
            return new b(eVar, null, jVar, z4, 1, gVar);
        }
        R(4);
        throw null;
    }

    @Override // i8.i, i8.u
    public final /* bridge */ /* synthetic */ u I0(int i2, e9.f fVar, f8.j jVar, t tVar, n0 n0Var, j jVar2) {
        return Y0(jVar, tVar, i2, jVar2, n0Var);
    }

    @Override // i8.u, f8.b
    public final boolean O() {
        return this.K.booleanValue();
    }

    @Override // i8.u
    public final void O0(boolean z4) {
        this.J = Boolean.valueOf(z4);
    }

    @Override // i8.u
    public final void P0(boolean z4) {
        this.K = Boolean.valueOf(z4);
    }

    @Override // i8.i
    /* renamed from: R0 */
    public final /* bridge */ /* synthetic */ i I0(int i2, e9.f fVar, f8.j jVar, t tVar, n0 n0Var, j jVar2) {
        return Y0(jVar, tVar, i2, jVar2, n0Var);
    }

    public final b Y0(f8.j jVar, t tVar, int i2, j jVar2, n0 n0Var) {
        if (jVar == null) {
            R(7);
            throw null;
        }
        if (i2 == 0) {
            R(8);
            throw null;
        }
        if (jVar2 == null) {
            R(9);
            throw null;
        }
        if (n0Var == null) {
            R(10);
            throw null;
        }
        if (i2 != 1 && i2 != 4) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + jVar + "\nkind: " + a1.a.y(i2));
        }
        f8.e eVar = (f8.e) jVar;
        b bVar = (b) tVar;
        if (i2 == 0) {
            R(13);
            throw null;
        }
        b bVar2 = new b(eVar, bVar, jVar2, this.I, i2, n0Var);
        Boolean bool = this.J;
        bool.getClass();
        bVar2.J = bool;
        Boolean bool2 = this.K;
        bool2.getClass();
        bVar2.K = bool2;
        return bVar2;
    }

    @Override // q8.a
    public final a t0(v vVar, ArrayList arrayList, v vVar2, c7.j jVar) {
        b bVarY0 = Y0(p(), null, getKind(), getAnnotations(), q());
        bVarY0.L0(vVar == null ? null : m.k(bVarY0, vVar, h.f3888a), this.f4878o, z.f2978f, getTypeParameters(), n7.a.g(arrayList, x0(), bVarY0), vVar2, i(), c());
        if (jVar != null) {
            bVarY0.N0((f8.a) jVar.f1973f, jVar.f1974g);
        }
        return bVarY0;
    }
}
