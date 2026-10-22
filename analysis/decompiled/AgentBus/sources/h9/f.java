package h9;

import com.google.protobuf.a1;
import com.google.protobuf.g1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import f8.e0;
import f8.i0;
import f8.o;
import f8.o0;
import f8.z;
import i8.c0;
import i8.k0;
import i8.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import v9.m0;
import v9.v;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4236a = 0;

    static {
        new e9.c("kotlin.jvm.JvmName");
    }

    public static /* synthetic */ void a(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                i10 = 2;
                break;
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 34:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case 57:
            case 58:
            case 59:
            case 61:
            case 64:
            case 82:
            case 95:
            case 97:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 67:
                objArr[0] = "type";
                break;
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                objArr[0] = "other";
                break;
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                objArr[0] = "classKind";
                break;
            case 38:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case 48:
            case 54:
            case 68:
            case 69:
            case 70:
            case 77:
            case 78:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 66:
                objArr[0] = "variable";
                break;
            case 71:
                objArr[0] = "f";
                break;
            case 73:
                objArr[0] = "current";
                break;
            case 74:
                objArr[0] = "result";
                break;
            case 75:
                objArr[0] = "memberDescriptor";
                break;
            case 79:
            case 80:
            case 81:
                objArr[0] = "annotated";
                break;
            case 85:
            case 87:
            case 90:
            case 92:
                objArr[0] = "scope";
                break;
            case 88:
            case 91:
            case 93:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                objArr[1] = "getContainingModule";
                break;
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
            case 63:
                objArr[1] = "unwrapSubstitutionOverride";
                break;
            case 65:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 72:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 76:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 83:
            case 84:
                objArr[1] = "getContainingSourceFile";
                break;
            case 86:
                objArr[1] = "getAllDescriptors";
                break;
            case 89:
                objArr[1] = "getFunctionByName";
                break;
            case 94:
                objArr[1] = "getPropertyByName";
                break;
            case 96:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[2] = "isOverride";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                objArr[2] = "isAnonymousFunction";
                break;
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                objArr[2] = "isEnumEntry";
                break;
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                objArr[2] = "getSuperClassType";
                break;
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 66:
            case 67:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 68:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 69:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 70:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 71:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 73:
            case 74:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 75:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 77:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 78:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 79:
                objArr[2] = "getJvmName";
                break;
            case 80:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 81:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 82:
                objArr[2] = "getContainingSourceFile";
                break;
            case 85:
                objArr[2] = "getAllDescriptors";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByName";
                break;
            case 90:
            case 91:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 92:
            case 93:
                objArr[2] = "getPropertyByName";
                break;
            case 95:
                objArr[2] = "getDirectMember";
                break;
            case 97:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static void b(f8.b bVar, LinkedHashSet linkedHashSet) {
        if (bVar == null) {
            a(73);
            throw null;
        }
        if (linkedHashSet.contains(bVar)) {
            return;
        }
        Iterator it = bVar.a().r().iterator();
        while (it.hasNext()) {
            f8.b bVarA = ((f8.b) it.next()).a();
            b(bVarA, linkedHashSet);
            linkedHashSet.add(bVarA);
        }
    }

    public static f8.e c(v vVar) {
        if (vVar == null) {
            a(45);
            throw null;
        }
        m0 m0VarE0 = vVar.E0();
        if (m0VarE0 == null) {
            a(46);
            throw null;
        }
        f8.e eVar = (f8.e) m0VarE0.c();
        if (eVar != null) {
            return eVar;
        }
        a(47);
        throw null;
    }

    public static z d(f8.j jVar) {
        if (jVar == null) {
            a(21);
            throw null;
        }
        z zVarE = e(jVar);
        if (zVarE != null) {
            return zVarE;
        }
        a(22);
        throw null;
    }

    public static z e(f8.j jVar) {
        if (jVar == null) {
            a(23);
            throw null;
        }
        while (jVar != null) {
            if (jVar instanceof z) {
                return (z) jVar;
            }
            if (jVar instanceof i0) {
                return ((x) ((i0) jVar)).f4896h;
            }
            jVar = jVar.p();
        }
        return null;
    }

    public static o0 f(f8.j jVar) {
        o0 o0Var = o0.f3503g;
        if (jVar == null) {
            a(82);
            throw null;
        }
        if (jVar instanceof k0) {
            jVar = ((k0) jVar).G0();
        }
        if (jVar instanceof f8.k) {
            ((f8.k) jVar).q().getClass();
        }
        return o0Var;
    }

    public static e9.e g(f8.j jVar) {
        if (jVar != null) {
            e9.c cVarH = h(jVar);
            return cVarH != null ? cVarH.i() : g(jVar.p()).b(jVar.getName());
        }
        a(2);
        throw null;
    }

    public static e9.c h(f8.j jVar) {
        if (jVar == null) {
            a(5);
            throw null;
        }
        if ((jVar instanceof z) || x9.i.f(jVar)) {
            return e9.c.f3187c;
        }
        if (jVar instanceof i0) {
            return ((x) ((i0) jVar)).f4897i;
        }
        if (jVar instanceof e0) {
            return ((c0) ((e0) jVar)).f4758j;
        }
        return null;
    }

    public static f8.j i(f8.j jVar, Class cls, boolean z4) {
        if (jVar == null) {
            return null;
        }
        if (z4) {
            jVar = jVar.p();
        }
        while (jVar != null) {
            if (cls.isInstance(jVar)) {
                return jVar;
            }
            jVar = jVar.p();
        }
        return null;
    }

    public static f8.e j(f8.e eVar) {
        if (eVar == null) {
            a(44);
            throw null;
        }
        Iterator it = eVar.h().d().iterator();
        while (it.hasNext()) {
            f8.e eVarC = c((v) it.next());
            if (eVarC.B() != 2) {
                return eVarC;
            }
        }
        return null;
    }

    public static boolean k(f8.j jVar) {
        return n(jVar, 1) && jVar.getName().equals(e9.h.f3200a);
    }

    public static boolean l(f8.j jVar) {
        return n(jVar, 6) && ((f8.e) jVar).C();
    }

    public static boolean m(f8.j jVar) {
        if (jVar != null) {
            return n(jVar, 4);
        }
        a(36);
        throw null;
    }

    public static boolean n(f8.j jVar, int i2) {
        if (i2 != 0) {
            return (jVar instanceof f8.e) && ((f8.e) jVar).B() == i2;
        }
        a(37);
        throw null;
    }

    public static boolean o(f8.j jVar) {
        if (jVar == null) {
            a(1);
            throw null;
        }
        while (jVar != null) {
            if (k(jVar) || ((jVar instanceof f8.m) && ((f8.m) jVar).c() == o.f3493f)) {
                return true;
            }
            jVar = jVar.p();
        }
        return false;
    }

    public static boolean p(v vVar, f8.j jVar) {
        if (vVar == null) {
            a(30);
            throw null;
        }
        if (jVar == null) {
            a(31);
            throw null;
        }
        f8.g gVarC = vVar.E0().c();
        if (gVarC == null) {
            return false;
        }
        f8.j jVarA = gVarC.a();
        return (jVarA instanceof f8.g) && (jVar instanceof f8.g) && ((f8.g) jVar).h().equals(((f8.g) jVarA).h());
    }

    public static boolean q(f8.j jVar) {
        return (n(jVar, 1) || n(jVar, 2)) && ((f8.e) jVar).i() == 2;
    }

    public static boolean r(v vVar, f8.j jVar) {
        if (vVar == null) {
            a(32);
            throw null;
        }
        if (jVar == null) {
            a(33);
            throw null;
        }
        if (p(vVar, jVar)) {
            return true;
        }
        Iterator it = vVar.E0().d().iterator();
        while (it.hasNext()) {
            if (r((v) it.next(), jVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(f8.j jVar) {
        return jVar != null && (jVar.p() instanceof e0);
    }

    public static f8.c t(f8.c cVar) {
        if (cVar == null) {
            a(59);
            throw null;
        }
        while (cVar.getKind() == 2) {
            Collection collectionR = cVar.r();
            if (collectionR.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + cVar);
            }
            cVar = (f8.c) collectionR.iterator().next();
        }
        return cVar;
    }
}
