package c8;

import com.google.protobuf.a1;
import com.google.protobuf.g1;
import com.google.protobuf.y0;
import f8.e0;
import f8.g0;
import f8.l0;
import f8.t;
import i8.a0;
import i8.c0;
import i8.j0;
import i8.k0;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import o4.d0;
import v9.m0;
import v9.p0;
import v9.q0;
import v9.v;
import v9.x0;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: e, reason: collision with root package name */
    public static final e9.f f1999e = e9.f.g("<built-ins module>");

    /* renamed from: a, reason: collision with root package name */
    public a0 f2000a;

    /* renamed from: b, reason: collision with root package name */
    public final u9.i f2001b;

    /* renamed from: c, reason: collision with root package name */
    public final u9.e f2002c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.k f2003d;

    public h(u9.k kVar) {
        this.f2003d = kVar;
        kVar.a(new f(this, 0));
        this.f2001b = new u9.i(kVar, new f(this, 1));
        this.f2002c = kVar.b(new c6.i(1, this));
    }

    public static boolean A(v vVar, e9.e eVar) {
        if (vVar == null) {
            a(97);
            throw null;
        }
        if (eVar != null) {
            return H(vVar.E0(), eVar);
        }
        a(98);
        throw null;
    }

    public static boolean B(v vVar, e9.e eVar) {
        if (eVar != null) {
            return A(vVar, eVar) && !vVar.F0();
        }
        a(135);
        throw null;
    }

    public static boolean C(t tVar) {
        if (tVar.a().getAnnotations().g(m.f2042m)) {
            return true;
        }
        if (!(tVar instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) tVar;
        boolean zF = l0Var.F();
        j0 j0VarB = l0Var.b();
        k0 k0VarG = l0Var.g();
        if (j0VarB == null || !C(j0VarB)) {
            return false;
        }
        if (zF) {
            return k0VarG != null && C(k0VarG);
        }
        return true;
    }

    public static boolean D(v vVar, e9.e eVar) {
        if (vVar == null) {
            a(105);
            throw null;
        }
        if (eVar != null) {
            return !vVar.F0() && A(vVar, eVar);
        }
        a(106);
        throw null;
    }

    public static boolean E(v vVar) {
        if (vVar == null) {
            a(136);
            throw null;
        }
        if (vVar != null) {
            return A(vVar, m.f2029b) && !x0.e(vVar);
        }
        a(138);
        throw null;
    }

    public static boolean F(v vVar) {
        if (vVar == null) {
            a(94);
            throw null;
        }
        if (vVar.F0()) {
            return false;
        }
        f8.g gVarC = vVar.E0().c();
        return (gVarC instanceof f8.e) && t((f8.e) gVarC) != null;
    }

    public static boolean G(v vVar) {
        return D(vVar, m.f2035f);
    }

    public static boolean H(m0 m0Var, e9.e eVar) {
        if (m0Var == null) {
            a(101);
            throw null;
        }
        if (eVar != null) {
            f8.g gVarC = m0Var.c();
            return (gVarC instanceof f8.e) && b((f8.e) gVarC, eVar);
        }
        a(102);
        throw null;
    }

    public static boolean I(f8.g gVar) {
        if (gVar == null) {
            a(10);
            throw null;
        }
        for (f8.g gVarP = gVar; gVarP != null; gVarP = gVarP.p()) {
            if (gVarP instanceof e0) {
                return ((c0) ((e0) gVarP)).f4758j.h(n.f2065j);
            }
        }
        return false;
    }

    public static /* synthetic */ void a(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i10 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 143:
            case 146:
            case 147:
            case 149:
            case 157:
            case 158:
            case 159:
            case 160:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 144:
            case 145:
            case 148:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 162:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 161:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[1] = "getBuiltInClassByName";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[1] = "getSuspendFunction";
                break;
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[1] = "getKClass";
                break;
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[1] = "getKCallable";
                break;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                objArr[1] = "getMutableCollection";
                break;
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                objArr[1] = "getList";
                break;
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                objArr[1] = "getMutableSet";
                break;
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                objArr[1] = "getMap";
                break;
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                objArr[1] = "getListIterator";
                break;
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "mayReturnNonUnitValue";
                break;
            case 144:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 145:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 146:
                objArr[2] = "isMemberOfAny";
                break;
            case 147:
            case 148:
                objArr[2] = "isEnum";
                break;
            case 149:
            case 150:
                objArr[2] = "isComparable";
                break;
            case 151:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 152:
                objArr[2] = "isListOrNullableList";
                break;
            case 153:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 154:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 155:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 156:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 157:
                objArr[2] = "isThrowable";
                break;
            case 158:
                objArr[2] = "isKClass";
                break;
            case 159:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 160:
                objArr[2] = "isCloneable";
                break;
            case 161:
                objArr[2] = "isDeprecated";
                break;
            case 162:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(f8.e eVar, e9.e eVar2) {
        if (eVar == null) {
            a(103);
            throw null;
        }
        if (eVar2 != null) {
            return eVar.getName().equals(eVar2.f()) && eVar2.equals(h9.f.g(eVar));
        }
        a(104);
        throw null;
    }

    public static j r(f8.g gVar) {
        if (gVar == null) {
            a(77);
            throw null;
        }
        if (m.f2028a0.contains(gVar.getName())) {
            return (j) m.f2032c0.get(h9.f.g(gVar));
        }
        return null;
    }

    public static j t(f8.e eVar) {
        if (m.Z.contains(eVar.getName())) {
            return (j) m.f2030b0.get(h9.f.g(eVar));
        }
        return null;
    }

    public static boolean x(v vVar) {
        if (vVar != null) {
            return A(vVar, m.f2027a);
        }
        a(139);
        throw null;
    }

    public static boolean y(v vVar) {
        if (vVar != null) {
            return A(vVar, m.f2036g);
        }
        a(88);
        throw null;
    }

    public static boolean z(f8.j jVar) {
        if (jVar != null) {
            return h9.f.i(jVar, s9.c.class, false) != null;
        }
        a(9);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [c7.f, java.lang.Object] */
    public final void c() throws IOException {
        e9.f fVar = f1999e;
        q7.k.e(fVar, "moduleName");
        u9.k kVar = this.f2003d;
        a0 a0Var = new a0(fVar, kVar, this, 48);
        this.f2000a = a0Var;
        c.f1992a.getClass();
        c cVar = (c) b.f1991b.getValue();
        a0 a0Var2 = this.f2000a;
        Iterable iterableL = l();
        h8.d dVarP = p();
        h8.b bVarD = d();
        ((s9.b) cVar).getClass();
        q7.k.e(a0Var2, "builtInsModule");
        q7.k.e(iterableL, "classDescriptorFactories");
        q7.k.e(dVarP, "platformDependentDeclarationFilter");
        q7.k.e(bVarD, "additionalClassPartsProvider");
        Set set = n.f2071p;
        q7.k.e(set, "packageFqNames");
        Set<e9.c> set2 = set;
        ArrayList arrayList = new ArrayList(d7.t.A0(set2, 10));
        for (e9.c cVar2 : set2) {
            s9.a.f9622m.getClass();
            String strA = s9.a.a(cVar2);
            q7.k.e(strA, "p0");
            InputStream inputStreamJ = s9.d.j(strA);
            if (inputStreamJ == null) {
                throw new IllegalStateException(a1.a.w("Resource not found in classpath: ", strA));
            }
            arrayList.add(n7.b.f(cVar2, kVar, a0Var2, inputStreamJ));
        }
        g0 g0Var = new g0(arrayList);
        i5.f fVar2 = new i5.f(kVar, a0Var2);
        d0 d0Var = new d0(7, g0Var);
        s9.a aVar = s9.a.f9622m;
        r9.i iVar = new r9.i(kVar, a0Var2, d0Var, new nb.f(a0Var2, fVar2, aVar), g0Var, r9.l.f9079a, r9.j.f9068c, iterableL, fVar2, bVarD, dVarP, aVar.f8822a, null, new h4.n(kVar), null, 851968);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((s9.c) it.next()).H0(iVar);
        }
        a0Var.f4743m = g0Var;
        a0 a0Var3 = this.f2000a;
        a0Var3.getClass();
        a0Var3.f4742l = new b9.g(d7.n.w0(new a0[]{a0Var3}));
    }

    public h8.b d() {
        return h8.a.f4222b;
    }

    public final z e() {
        z zVarK = j("Any").k();
        if (zVarK != null) {
            return zVarK;
        }
        a(50);
        throw null;
    }

    public final v f(v vVar) {
        e9.b bVarF;
        e9.b bVar;
        f8.e eVarD;
        z zVarK = null;
        if (vVar == null) {
            a(67);
            throw null;
        }
        if (y(vVar)) {
            if (vVar.C0().size() != 1) {
                throw new IllegalStateException();
            }
            v vVarB = ((p0) vVar.C0().get(0)).b();
            if (vVarB != null) {
                return vVarB;
            }
            a(68);
            throw null;
        }
        z0 z0VarG = x0.g(vVar, false);
        v vVar2 = (v) ((g) this.f2001b.c()).f1998b.get(z0VarG);
        if (vVar2 != null) {
            return vVar2;
        }
        int i2 = h9.f.f4236a;
        f8.g gVarC = z0VarG.E0().c();
        f8.z zVarE = gVarC == null ? null : h9.f.e(gVarC);
        if (zVarE != null) {
            f8.g gVarC2 = z0VarG.E0().c();
            if (gVarC2 != null) {
                Set set = r.f2083a;
                e9.f name = gVarC2.getName();
                q7.k.e(name, "name");
                if (r.f2086d.contains(name) && (bVarF = l9.d.f(gVarC2)) != null && (bVar = (e9.b) r.f2084b.get(bVarF)) != null && (eVarD = f8.v.d(zVarE, bVar)) != null) {
                    zVarK = eVarD.k();
                }
            }
            if (zVarK != null) {
                return zVarK;
            }
        }
        throw new IllegalStateException("not array: " + vVar);
    }

    public final z g(int i2, v vVar, g8.j jVar) {
        if (i2 == 0) {
            a(78);
            throw null;
        }
        if (vVar != null) {
            return v9.d.q(v9.c.w(jVar), j("Array"), Collections.singletonList(new q0(i2, vVar)));
        }
        a(79);
        throw null;
    }

    public final z h(z0 z0Var) {
        if (z0Var != null) {
            return g(1, z0Var, g8.h.f3888a);
        }
        a(83);
        throw null;
    }

    public final f8.e i(e9.c cVar) {
        if (cVar == null) {
            a(12);
            throw null;
        }
        f8.e eVarJ = f8.v.j(k(), cVar);
        if (eVarJ != null) {
            return eVarJ;
        }
        a(13);
        throw null;
    }

    public final f8.e j(String str) {
        if (str != null) {
            return (f8.e) this.f2002c.invoke(e9.f.e(str));
        }
        a(14);
        throw null;
    }

    public final a0 k() {
        this.f2000a.getClass();
        a0 a0Var = this.f2000a;
        if (a0Var != null) {
            return a0Var;
        }
        a(7);
        throw null;
    }

    public Iterable l() {
        List listSingletonList = Collections.singletonList(new d8.a(this.f2003d, k()));
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(5);
        throw null;
    }

    public final z m() {
        z zVarO = o();
        if (zVarO != null) {
            return zVarO;
        }
        a(52);
        throw null;
    }

    public final z n() {
        z zVarK = j("Nothing").k();
        if (zVarK != null) {
            return zVarK;
        }
        a(48);
        throw null;
    }

    public final z o() {
        z zVarL0 = e().I0(true);
        if (zVarL0 != null) {
            return zVarL0;
        }
        a(51);
        throw null;
    }

    public h8.d p() {
        return h8.a.f4224d;
    }

    public final z q(j jVar) {
        if (jVar == null) {
            a(73);
            throw null;
        }
        z zVar = (z) ((g) this.f2001b.c()).f1997a.get(jVar);
        if (zVar != null) {
            return zVar;
        }
        a(74);
        throw null;
    }

    public final z s(j jVar) {
        if (jVar == null) {
            a(53);
            throw null;
        }
        z zVarK = j(jVar.f2016f.b()).k();
        if (zVarK != null) {
            return zVarK;
        }
        a(54);
        throw null;
    }

    public final z u() {
        z zVarK = j("String").k();
        if (zVarK != null) {
            return zVarK;
        }
        a(65);
        throw null;
    }

    public final f8.e v(int i2) {
        return i(n.f2060e.c(e9.f.e(d8.e.f2995j.f3000g + i2)));
    }

    public final z w() {
        z zVarK = j("Unit").k();
        if (zVarK != null) {
            return zVarK;
        }
        a(64);
        throw null;
    }
}
