package ka;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0806k;
import E9.InterfaceC0807l;
import E9.InterfaceC0819y;
import E9.L;
import E9.Q;
import E9.X;
import E9.j0;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.H0;
import ya.S;
import ya.W;
import ya.v0;

/* renamed from: ka.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4828h {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.c f34652a = new ga.c("kotlin.jvm.JvmName");

    public static boolean A(InterfaceC0803h interfaceC0803h) {
        return D(interfaceC0803h, ClassKind.ENUM_CLASS);
    }

    public static boolean B(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(36);
        }
        return D(interfaceC0803h, ClassKind.ENUM_ENTRY);
    }

    public static boolean C(InterfaceC0803h interfaceC0803h) {
        return D(interfaceC0803h, ClassKind.INTERFACE);
    }

    public static boolean D(InterfaceC0803h interfaceC0803h, ClassKind classKind) {
        if (classKind == null) {
            a(37);
        }
        return (interfaceC0803h instanceof InterfaceC0797b) && ((InterfaceC0797b) interfaceC0803h).getKind() == classKind;
    }

    public static boolean E(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(1);
        }
        while (interfaceC0803h != null) {
            if (u(interfaceC0803h) || y(interfaceC0803h)) {
                return true;
            }
            interfaceC0803h = interfaceC0803h.b();
        }
        return false;
    }

    public static boolean F(S s10, InterfaceC0803h interfaceC0803h) {
        if (s10 == null) {
            a(30);
        }
        if (interfaceC0803h == null) {
            a(31);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD == null) {
            return false;
        }
        InterfaceC0803h interfaceC0803hA = interfaceC0799dD.a();
        return (interfaceC0803hA instanceof InterfaceC0799d) && (interfaceC0803h instanceof InterfaceC0799d) && ((InterfaceC0799d) interfaceC0803h).j().equals(((InterfaceC0799d) interfaceC0803hA).j());
    }

    public static boolean G(InterfaceC0803h interfaceC0803h) {
        return (D(interfaceC0803h, ClassKind.CLASS) || D(interfaceC0803h, ClassKind.INTERFACE)) && ((InterfaceC0797b) interfaceC0803h).p() == Modality.SEALED;
    }

    public static boolean H(InterfaceC0797b interfaceC0797b, InterfaceC0797b interfaceC0797b2) {
        if (interfaceC0797b == null) {
            a(28);
        }
        if (interfaceC0797b2 == null) {
            a(29);
        }
        return I(interfaceC0797b.n(), interfaceC0797b2.a());
    }

    public static boolean I(S s10, InterfaceC0803h interfaceC0803h) {
        if (s10 == null) {
            a(32);
        }
        if (interfaceC0803h == null) {
            a(33);
        }
        if (F(s10, interfaceC0803h)) {
            return true;
        }
        Iterator<S> it = s10.H0().e().iterator();
        while (it.hasNext()) {
            if (I(it.next(), interfaceC0803h)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(InterfaceC0803h interfaceC0803h) {
        return interfaceC0803h != null && (interfaceC0803h.b() instanceof E);
    }

    public static boolean K(j0 j0Var, S s10) {
        if (j0Var == null) {
            a(65);
        }
        if (s10 == null) {
            a(66);
        }
        if (j0Var.J() || W.a(s10)) {
            return false;
        }
        if (H0.b(s10)) {
            return true;
        }
        C9.j jVarM = DescriptorUtilsKt.m(j0Var);
        if (!C9.j.t0(s10)) {
            kotlin.reflect.jvm.internal.impl.types.checker.b bVar = kotlin.reflect.jvm.internal.impl.types.checker.b.f36098a;
            if (!bVar.c(jVarM.X(), s10) && !bVar.c(jVarM.L().n(), s10) && !bVar.c(jVarM.i(), s10) && !C9.q.d(s10)) {
                return false;
            }
        }
        return true;
    }

    public static <D extends CallableMemberDescriptor> D L(D d10) {
        if (d10 == null) {
            a(58);
        }
        while (d10.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection<? extends CallableMemberDescriptor> collectionD = d10.d();
            if (collectionD.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d10);
            }
            d10 = (D) collectionD.iterator().next();
        }
        return d10;
    }

    public static <D extends InterfaceC0807l> D M(D d10) {
        if (d10 == null) {
            a(63);
        }
        if (d10 instanceof CallableMemberDescriptor) {
            return L((CallableMemberDescriptor) d10);
        }
        if (d10 == null) {
            a(64);
        }
        return d10;
    }

    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
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
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
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
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
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
            case 60:
            case 63:
            case 81:
            case 94:
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
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = AMapLocationStaticsEntity.FIRST_LOCATE;
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
            case 66:
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
            case 67:
            case 68:
            case 69:
            case 76:
            case 77:
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
            case 65:
                objArr[0] = "variable";
                break;
            case 70:
                objArr[0] = "f";
                break;
            case 72:
                objArr[0] = "current";
                break;
            case 73:
                objArr[0] = "result";
                break;
            case 74:
                objArr[0] = "memberDescriptor";
                break;
            case 78:
            case 79:
            case 80:
                objArr[0] = "annotated";
                break;
            case 84:
            case 86:
            case 89:
            case 91:
                objArr[0] = "scope";
                break;
            case 87:
            case 90:
            case 92:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
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
            case 59:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 61:
            case 62:
                objArr[1] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 75:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 82:
            case 83:
                objArr[1] = "getContainingSourceFile";
                break;
            case 85:
                objArr[1] = "getAllDescriptors";
                break;
            case 88:
                objArr[1] = "getFunctionByName";
                break;
            case 93:
                objArr[1] = "getPropertyByName";
                break;
            case 95:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i10) {
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
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
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
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 63:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 65:
            case 66:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 67:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 68:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 69:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 72:
            case 73:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 74:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 76:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 77:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 78:
                objArr[2] = "getJvmName";
                break;
            case 79:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 80:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 81:
                objArr[2] = "getContainingSourceFile";
                break;
            case 84:
                objArr[2] = "getAllDescriptors";
                break;
            case 86:
            case 87:
                objArr[2] = "getFunctionByName";
                break;
            case 89:
            case 90:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 91:
            case 92:
                objArr[2] = "getPropertyByName";
                break;
            case 94:
                objArr[2] = "getDirectMember";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
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
            case 59:
            case 61:
            case 62:
            case 64:
            case 71:
            case 75:
            case 82:
            case 83:
            case 85:
            case 88:
            case 93:
            case 95:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        if (interfaceC0803h == null) {
            a(16);
        }
        if (interfaceC0803h2 == null) {
            a(17);
        }
        return g(interfaceC0803h).equals(g(interfaceC0803h2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> void c(D d10, Set<D> set) {
        if (d10 == null) {
            a(72);
        }
        if (set == 0) {
            a(73);
        }
        if (set.contains(d10)) {
            return;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> it = d10.a().d().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = it.next().a();
            c(aVarA, set);
            set.add(aVarA);
        }
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> d(D d10) {
        if (d10 == null) {
            a(70);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d10.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static InterfaceC0797b e(S s10) {
        if (s10 == null) {
            a(45);
        }
        return f(s10.H0());
    }

    public static InterfaceC0797b f(v0 v0Var) {
        if (v0Var == null) {
            a(46);
        }
        InterfaceC0797b interfaceC0797b = (InterfaceC0797b) v0Var.d();
        if (interfaceC0797b == null) {
            a(47);
        }
        return interfaceC0797b;
    }

    public static InterfaceC0819y g(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(21);
        }
        InterfaceC0819y interfaceC0819yH = h(interfaceC0803h);
        if (interfaceC0819yH == null) {
            a(22);
        }
        return interfaceC0819yH;
    }

    public static InterfaceC0819y h(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(23);
        }
        while (interfaceC0803h != null) {
            if (interfaceC0803h instanceof InterfaceC0819y) {
                return (InterfaceC0819y) interfaceC0803h;
            }
            if (interfaceC0803h instanceof L) {
                return ((L) interfaceC0803h).getModule();
            }
            interfaceC0803h = interfaceC0803h.b();
        }
        return null;
    }

    public static InterfaceC0819y i(S s10) {
        if (s10 == null) {
            a(20);
        }
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD == null) {
            return null;
        }
        return h(interfaceC0799dD);
    }

    public static X j(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(81);
        }
        if (interfaceC0803h instanceof Q) {
            interfaceC0803h = ((Q) interfaceC0803h).Q();
        }
        if (interfaceC0803h instanceof InterfaceC0806k) {
            X xB = ((InterfaceC0806k) interfaceC0803h).e().b();
            if (xB == null) {
                a(82);
            }
            return xB;
        }
        X x10 = X.f2445a;
        if (x10 == null) {
            a(83);
        }
        return x10;
    }

    public static AbstractC0811p k(InterfaceC0797b interfaceC0797b, boolean z10) {
        if (interfaceC0797b == null) {
            a(48);
        }
        ClassKind kind = interfaceC0797b.getKind();
        if (kind == ClassKind.ENUM_CLASS || kind.isSingleton()) {
            AbstractC0811p abstractC0811p = C0810o.f2469a;
            if (abstractC0811p == null) {
                a(49);
            }
            return abstractC0811p;
        }
        if (G(interfaceC0797b)) {
            if (z10) {
                AbstractC0811p abstractC0811p2 = C0810o.f2471c;
                if (abstractC0811p2 == null) {
                    a(50);
                }
                return abstractC0811p2;
            }
            AbstractC0811p abstractC0811p3 = C0810o.f2469a;
            if (abstractC0811p3 == null) {
                a(51);
            }
            return abstractC0811p3;
        }
        if (u(interfaceC0797b)) {
            AbstractC0811p abstractC0811p4 = C0810o.f2480l;
            if (abstractC0811p4 == null) {
                a(52);
            }
            return abstractC0811p4;
        }
        AbstractC0811p abstractC0811p5 = C0810o.f2473e;
        if (abstractC0811p5 == null) {
            a(53);
        }
        return abstractC0811p5;
    }

    public static E9.S l(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(0);
        }
        if (interfaceC0803h instanceof InterfaceC0797b) {
            return ((InterfaceC0797b) interfaceC0803h).D0();
        }
        return null;
    }

    public static ga.d m(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(2);
        }
        ga.c cVarO = o(interfaceC0803h);
        return cVarO != null ? cVarO.i() : p(interfaceC0803h);
    }

    public static ga.c n(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(3);
        }
        ga.c cVarO = o(interfaceC0803h);
        if (cVarO == null) {
            cVarO = p(interfaceC0803h).m();
        }
        if (cVarO == null) {
            a(4);
        }
        return cVarO;
    }

    public static ga.c o(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(5);
        }
        if ((interfaceC0803h instanceof InterfaceC0819y) || Aa.i.m(interfaceC0803h)) {
            return ga.c.f32726d;
        }
        if (interfaceC0803h instanceof L) {
            return ((L) interfaceC0803h).f();
        }
        if (interfaceC0803h instanceof E) {
            return ((E) interfaceC0803h).f();
        }
        return null;
    }

    public static ga.d p(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(6);
        }
        ga.d dVarB = m(interfaceC0803h.b()).b(interfaceC0803h.getName());
        if (dVarB == null) {
            a(7);
        }
        return dVarB;
    }

    public static <D extends InterfaceC0803h> D q(InterfaceC0803h interfaceC0803h, Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(interfaceC0803h, cls, true);
    }

    public static <D extends InterfaceC0803h> D r(InterfaceC0803h interfaceC0803h, Class<D> cls, boolean z10) {
        if (cls == null) {
            a(19);
        }
        if (interfaceC0803h == null) {
            return null;
        }
        if (z10) {
            interfaceC0803h = (D) interfaceC0803h.b();
        }
        while (interfaceC0803h != null) {
            if (cls.isInstance(interfaceC0803h)) {
                return (D) interfaceC0803h;
            }
            interfaceC0803h = (D) interfaceC0803h.b();
        }
        return null;
    }

    public static InterfaceC0797b s(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(44);
        }
        Iterator<S> it = interfaceC0797b.j().e().iterator();
        while (it.hasNext()) {
            InterfaceC0797b interfaceC0797bE = e(it.next());
            if (interfaceC0797bE.getKind() != ClassKind.INTERFACE) {
                return interfaceC0797bE;
            }
        }
        return null;
    }

    public static boolean t(InterfaceC0803h interfaceC0803h) {
        return D(interfaceC0803h, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean u(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(34);
        }
        return v(interfaceC0803h) && interfaceC0803h.getName().equals(ga.g.f32742b);
    }

    public static boolean v(InterfaceC0803h interfaceC0803h) {
        return D(interfaceC0803h, ClassKind.CLASS);
    }

    public static boolean w(InterfaceC0803h interfaceC0803h) {
        return v(interfaceC0803h) || A(interfaceC0803h);
    }

    public static boolean x(InterfaceC0803h interfaceC0803h) {
        return D(interfaceC0803h, ClassKind.OBJECT) && ((InterfaceC0797b) interfaceC0803h).W();
    }

    public static boolean y(InterfaceC0803h interfaceC0803h) {
        return (interfaceC0803h instanceof InterfaceC0807l) && ((InterfaceC0807l) interfaceC0803h).getVisibility() == C0810o.f2474f;
    }

    public static boolean z(InterfaceC0797b interfaceC0797b, InterfaceC0797b interfaceC0797b2) {
        if (interfaceC0797b == null) {
            a(26);
        }
        if (interfaceC0797b2 == null) {
            a(27);
        }
        Iterator<S> it = interfaceC0797b.j().e().iterator();
        while (it.hasNext()) {
            if (F(it.next(), interfaceC0797b2.a())) {
                return true;
            }
        }
        return false;
    }
}
