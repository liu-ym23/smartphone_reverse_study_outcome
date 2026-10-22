package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class p0 extends h {

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f4834p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4835q;

    /* JADX WARN: Illegal instructions before constructor call */
    public p0(f8.j jVar, g8.j jVar2, boolean z4, int i2, e9.f fVar, int i10, u9.n nVar) {
        f8.o0 o0Var = f8.o0.f3504h;
        if (jVar == null) {
            R(19);
            throw null;
        }
        if (jVar2 == null) {
            R(20);
            throw null;
        }
        if (i2 == 0) {
            R(21);
            throw null;
        }
        if (fVar == null) {
            R(22);
            throw null;
        }
        if (nVar == null) {
            R(25);
            throw null;
        }
        super(nVar, jVar, jVar2, fVar, i2, z4, i10, o0Var);
        this.f4834p = new ArrayList(1);
        this.f4835q = false;
    }

    public static p0 I0(f8.j jVar, g8.j jVar2, boolean z4, int i2, e9.f fVar, int i10, u9.n nVar) {
        if (jVar == null) {
            R(6);
            throw null;
        }
        if (jVar2 == null) {
            R(7);
            throw null;
        }
        if (i2 == 0) {
            R(8);
            throw null;
        }
        if (fVar == null) {
            R(9);
            throw null;
        }
        if (nVar == null) {
            R(11);
            throw null;
        }
        if (i2 != 0) {
            return new p0(jVar, jVar2, z4, i2, fVar, i10, nVar);
        }
        R(14);
        throw null;
    }

    public static p0 J0(b bVar, int i2, e9.f fVar, int i10, u9.n nVar) {
        if (i2 == 0) {
            R(2);
            throw null;
        }
        if (nVar == null) {
            R(4);
            throw null;
        }
        p0 p0VarI0 = I0(bVar, g8.h.f3888a, false, i2, fVar, i10, nVar);
        v9.z zVarM = l9.d.e(bVar).m();
        if (p0VarI0.f4835q) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + p0VarI0.K0());
        }
        if (!v9.c.i(zVarM)) {
            p0VarI0.f4834p.add(zVarM);
        }
        if (!p0VarI0.f4835q) {
            p0VarI0.f4835q = true;
            return p0VarI0;
        }
        throw new IllegalStateException("Type parameter descriptor is already initialized: " + p0VarI0.K0());
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 5 || i2 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 28) ? 2 : 3];
        switch (i2) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
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
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[0] = "type";
                break;
        }
        if (i2 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i2 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i2) {
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
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[2] = "createForFurtherModification";
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 5 && i2 != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // i8.h
    public final List H0() {
        if (!this.f4835q) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: " + K0());
        }
        ArrayList arrayList = this.f4834p;
        if (arrayList != null) {
            return arrayList;
        }
        R(28);
        throw null;
    }

    public final String K0() {
        return getName() + " declared in " + h9.f.g(p());
    }
}
