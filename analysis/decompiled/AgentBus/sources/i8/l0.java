package i8;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import v9.v0;

/* loaded from: classes.dex */
public class l0 extends u {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(f8.j jVar, l0 l0Var, g8.j jVar2, e9.f fVar, int i2, f8.n0 n0Var) {
        super(i2, fVar, jVar, l0Var, n0Var, jVar2);
        if (jVar == null) {
            R(0);
            throw null;
        }
        if (jVar2 == null) {
            R(1);
            throw null;
        }
        if (fVar == null) {
            R(2);
            throw null;
        }
        if (i2 == 0) {
            R(3);
            throw null;
        }
        if (n0Var != null) {
        } else {
            R(4);
            throw null;
        }
    }

    public static /* synthetic */ void R(int i2) {
        String str = (i2 == 13 || i2 == 18 || i2 == 23 || i2 == 24 || i2 == 29 || i2 == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 13 || i2 == 18 || i2 == 23 || i2 == 24 || i2 == 29 || i2 == 30) ? 2 : 3];
        switch (i2) {
            case 1:
            case 6:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[0] = "visibility";
                break;
            case 13:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i2 == 13 || i2 == 18 || i2 == 23) {
            objArr[1] = "initialize";
        } else if (i2 == 24) {
            objArr[1] = "getOriginal";
        } else if (i2 == 29) {
            objArr[1] = "copy";
        } else if (i2 != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[2] = "initialize";
                break;
            case 13:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 13 && i2 != 18 && i2 != 23 && i2 != 24 && i2 != 29 && i2 != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static l0 R0(b bVar, e9.f fVar, int i2, f8.n0 n0Var) {
        if (bVar == null) {
            R(5);
            throw null;
        }
        if (fVar == null) {
            R(7);
            throw null;
        }
        if (i2 == 0) {
            R(8);
            throw null;
        }
        if (n0Var != null) {
            return new l0(bVar, null, g8.h.f3888a, fVar, i2, n0Var);
        }
        R(9);
        throw null;
    }

    @Override // i8.u
    public u I0(int i2, e9.f fVar, f8.j jVar, f8.t tVar, f8.n0 n0Var, g8.j jVar2) {
        if (jVar == null) {
            R(25);
            throw null;
        }
        if (i2 == 0) {
            R(26);
            throw null;
        }
        if (jVar2 == null) {
            R(27);
            throw null;
        }
        l0 l0Var = (l0) tVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new l0(jVar, l0Var, jVar2, fVar, i2, n0Var);
    }

    @Override // i8.u, i8.n, i8.m, f8.j
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public final l0 a() {
        l0 l0Var = (l0) super.a();
        if (l0Var != null) {
            return l0Var;
        }
        R(24);
        throw null;
    }

    @Override // i8.u
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public final l0 L0(v vVar, v vVar2, List list, List list2, List list3, v9.v vVar3, int i2, f8.n nVar) {
        if (list == null) {
            R(14);
            throw null;
        }
        if (list2 == null) {
            R(15);
            throw null;
        }
        if (list3 == null) {
            R(16);
            throw null;
        }
        if (nVar != null) {
            return U0(vVar, vVar2, list, list2, list3, vVar3, i2, nVar, null);
        }
        R(17);
        throw null;
    }

    public l0 U0(v vVar, v vVar2, List list, List list2, List list3, v9.v vVar3, int i2, f8.n nVar, Map map) {
        if (list == null) {
            R(19);
            throw null;
        }
        if (list2 == null) {
            R(20);
            throw null;
        }
        if (list3 == null) {
            R(21);
            throw null;
        }
        if (nVar == null) {
            R(22);
            throw null;
        }
        super.L0(vVar, vVar2, list, list2, list3, vVar3, i2, nVar);
        if (map != null && !map.isEmpty()) {
            this.H = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // i8.u, f8.t
    public f8.s o0() {
        return M0(v0.f10595b);
    }
}
