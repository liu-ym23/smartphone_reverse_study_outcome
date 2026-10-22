package J8;

import X8.K;
import X8.w;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import h8.AbstractC1532o;
import h8.C1504L;
import h8.InterfaceC1494B;
import h8.InterfaceC1498F;
import h8.InterfaceC1519b;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1530m;
import h8.InterfaceC1540w;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k8.AbstractC1629B;
import k8.J;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import o7.s;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f883a = 0;

    static {
        new G8.c("kotlin.jvm.JvmName");
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i6;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
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
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                i6 = 2;
                break;
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
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
            case 22:
            case 40:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
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
            case 18:
            case 19:
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
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
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
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
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
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
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
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
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
        switch (i) {
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
            case 22:
            case 40:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
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
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
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
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
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
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
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
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
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

    public static void b(InterfaceC1519b interfaceC1519b, LinkedHashSet linkedHashSet) {
        if (interfaceC1519b == null) {
            a(73);
            throw null;
        }
        if (linkedHashSet.contains(interfaceC1519b)) {
            return;
        }
        Iterator it = interfaceC1519b.a().e().iterator();
        while (it.hasNext()) {
            InterfaceC1519b interfaceC1519bA = ((InterfaceC1519b) it.next()).a();
            b(interfaceC1519bA, linkedHashSet);
            linkedHashSet.add(interfaceC1519bA);
        }
    }

    public static InterfaceC1522e c(w wVar) {
        if (wVar == null) {
            a(45);
            throw null;
        }
        K kQ = wVar.Q();
        if (kQ == null) {
            a(46);
            throw null;
        }
        InterfaceC1522e interfaceC1522e = (InterfaceC1522e) kQ.d();
        if (interfaceC1522e != null) {
            return interfaceC1522e;
        }
        a(47);
        throw null;
    }

    public static InterfaceC1540w d(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j == null) {
            a(21);
            throw null;
        }
        InterfaceC1540w interfaceC1540wE = e(interfaceC1527j);
        if (interfaceC1540wE != null) {
            return interfaceC1540wE;
        }
        a(22);
        throw null;
    }

    public static InterfaceC1540w e(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j == null) {
            a(23);
            throw null;
        }
        while (interfaceC1527j != null) {
            if (interfaceC1527j instanceof InterfaceC1540w) {
                return (InterfaceC1540w) interfaceC1527j;
            }
            if (interfaceC1527j instanceof InterfaceC1498F) {
                return ((k8.w) ((InterfaceC1498F) interfaceC1527j)).c;
            }
            interfaceC1527j = interfaceC1527j.d();
        }
        return null;
    }

    public static C1504L f(InterfaceC1527j interfaceC1527j) {
        C1504L c1504l = C1504L.b;
        if (interfaceC1527j == null) {
            a(82);
            throw null;
        }
        if (interfaceC1527j instanceof J) {
            interfaceC1527j = ((J) interfaceC1527j).R0();
        }
        if (interfaceC1527j instanceof InterfaceC1528k) {
            ((InterfaceC1528k) interfaceC1527j).getSource().getClass();
        }
        return c1504l;
    }

    public static G8.e g(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j != null) {
            G8.c cVarH = h(interfaceC1527j);
            return cVarH != null ? cVarH.i() : g(interfaceC1527j.d()).b(interfaceC1527j.getName());
        }
        a(2);
        throw null;
    }

    public static G8.c h(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j == null) {
            a(5);
            throw null;
        }
        if ((interfaceC1527j instanceof InterfaceC1540w) || Z8.i.f(interfaceC1527j)) {
            return G8.c.c;
        }
        if (interfaceC1527j instanceof InterfaceC1498F) {
            return ((k8.w) ((InterfaceC1498F) interfaceC1527j)).d;
        }
        if (interfaceC1527j instanceof InterfaceC1494B) {
            return ((AbstractC1629B) ((InterfaceC1494B) interfaceC1527j)).e;
        }
        return null;
    }

    public static InterfaceC1527j i(InterfaceC1527j interfaceC1527j, Class cls, boolean z10) {
        if (interfaceC1527j == null) {
            return null;
        }
        if (z10) {
            interfaceC1527j = interfaceC1527j.d();
        }
        while (interfaceC1527j != null) {
            if (cls.isInstance(interfaceC1527j)) {
                return interfaceC1527j;
            }
            interfaceC1527j = interfaceC1527j.d();
        }
        return null;
    }

    public static InterfaceC1522e j(InterfaceC1522e interfaceC1522e) {
        if (interfaceC1522e == null) {
            a(44);
            throw null;
        }
        Iterator it = interfaceC1522e.m().e().iterator();
        while (it.hasNext()) {
            InterfaceC1522e interfaceC1522eC = c((w) it.next());
            if (interfaceC1522eC.getKind() != ClassKind.b) {
                return interfaceC1522eC;
            }
        }
        return null;
    }

    public static boolean k(InterfaceC1527j interfaceC1527j) {
        return n(interfaceC1527j, ClassKind.f4951a) && interfaceC1527j.getName().equals(G8.h.f692a);
    }

    public static boolean l(InterfaceC1527j interfaceC1527j) {
        return n(interfaceC1527j, ClassKind.f) && ((InterfaceC1522e) interfaceC1527j).X();
    }

    public static boolean m(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j != null) {
            return n(interfaceC1527j, ClassKind.d);
        }
        a(36);
        throw null;
    }

    public static boolean n(InterfaceC1527j interfaceC1527j, ClassKind classKind) {
        return (interfaceC1527j instanceof InterfaceC1522e) && ((InterfaceC1522e) interfaceC1527j).getKind() == classKind;
    }

    public static boolean o(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j == null) {
            a(1);
            throw null;
        }
        while (interfaceC1527j != null) {
            if (k(interfaceC1527j) || ((interfaceC1527j instanceof InterfaceC1530m) && ((InterfaceC1530m) interfaceC1527j).getVisibility() == AbstractC1532o.f)) {
                return true;
            }
            interfaceC1527j = interfaceC1527j.d();
        }
        return false;
    }

    public static boolean p(w wVar, InterfaceC1527j interfaceC1527j) {
        if (wVar == null) {
            a(30);
            throw null;
        }
        if (interfaceC1527j == null) {
            a(31);
            throw null;
        }
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD == null) {
            return false;
        }
        InterfaceC1527j interfaceC1527jA = interfaceC1524gD.a();
        return (interfaceC1527jA instanceof InterfaceC1524g) && (interfaceC1527j instanceof InterfaceC1524g) && ((InterfaceC1524g) interfaceC1527j).m().equals(((InterfaceC1524g) interfaceC1527jA).m());
    }

    public static boolean q(InterfaceC1527j interfaceC1527j) {
        return (n(interfaceC1527j, ClassKind.f4951a) || n(interfaceC1527j, ClassKind.b)) && ((InterfaceC1522e) interfaceC1527j).i() == Modality.c;
    }

    public static boolean r(w wVar, InterfaceC1527j interfaceC1527j) {
        if (wVar == null) {
            a(32);
            throw null;
        }
        if (interfaceC1527j == null) {
            a(33);
            throw null;
        }
        if (p(wVar, interfaceC1527j)) {
            return true;
        }
        Iterator it = wVar.Q().e().iterator();
        while (it.hasNext()) {
            if (r((w) it.next(), interfaceC1527j)) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(InterfaceC1527j interfaceC1527j) {
        return interfaceC1527j != null && (interfaceC1527j.d() instanceof InterfaceC1494B);
    }

    public static InterfaceC1520c t(InterfaceC1520c interfaceC1520c) {
        if (interfaceC1520c == null) {
            a(59);
            throw null;
        }
        while (interfaceC1520c.getKind() == CallableMemberDescriptor$Kind.b) {
            Collection collectionE = interfaceC1520c.e();
            if (collectionE.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + interfaceC1520c);
            }
            interfaceC1520c = (InterfaceC1520c) collectionE.iterator().next();
        }
        return interfaceC1520c;
    }
}
