package e8;

import X8.A;
import X8.AbstractC0272c;
import X8.F;
import X8.K;
import X8.N;
import X8.S;
import X8.U;
import X8.w;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.material3.MenuKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f8.C1440a;
import f8.C1448i;
import h8.AbstractC1538u;
import h8.InterfaceC1494B;
import h8.InterfaceC1501I;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import h8.InterfaceC1540w;
import i8.C1560f;
import i8.InterfaceC1561g;
import j8.C1602a;
import j8.InterfaceC1603b;
import j8.InterfaceC1605d;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import k8.AbstractC1629B;
import k8.I;
import k8.J;
import k8.z;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import o7.s;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes4.dex */
public abstract class i {
    public static final G8.f e = G8.f.g("<built-ins module>");

    /* renamed from: a, reason: collision with root package name */
    public z f4384a;
    public final W8.h b;
    public final W8.e c;
    public final W8.i d;

    public i(W8.i iVar) {
        this.d = iVar;
        iVar.b(new f(this, 0));
        this.b = new W8.h(iVar, new f(this, 1));
        this.c = iVar.c(new g(this, 0));
    }

    public static boolean A(w wVar, G8.e eVar) {
        if (wVar == null) {
            a(98);
            throw null;
        }
        if (eVar != null) {
            return H(wVar.Q(), eVar);
        }
        a(99);
        throw null;
    }

    public static boolean B(w wVar, G8.e eVar) {
        if (eVar != null) {
            return A(wVar, eVar) && !wVar.W();
        }
        a(136);
        throw null;
    }

    public static boolean C(InterfaceC1536s interfaceC1536s) {
        if (interfaceC1536s.a().getAnnotations().k(n.m)) {
            return true;
        }
        if (!(interfaceC1536s instanceof InterfaceC1501I)) {
            return false;
        }
        InterfaceC1501I interfaceC1501I = (InterfaceC1501I) interfaceC1536s;
        boolean zH = interfaceC1501I.H();
        I getter = interfaceC1501I.getGetter();
        J setter = interfaceC1501I.getSetter();
        if (getter == null || !C(getter)) {
            return false;
        }
        if (zH) {
            return setter != null && C(setter);
        }
        return true;
    }

    public static boolean D(w wVar, G8.e eVar) {
        if (wVar == null) {
            a(106);
            throw null;
        }
        if (eVar != null) {
            return !wVar.W() && A(wVar, eVar);
        }
        a(107);
        throw null;
    }

    public static boolean E(w wVar) {
        if (wVar == null) {
            a(137);
            throw null;
        }
        if (wVar != null) {
            return A(wVar, n.b) && !S.e(wVar);
        }
        a(139);
        throw null;
    }

    public static boolean F(w wVar) {
        if (wVar == null) {
            a(95);
            throw null;
        }
        if (wVar.W()) {
            return false;
        }
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (!(interfaceC1524gD instanceof InterfaceC1522e)) {
            return false;
        }
        InterfaceC1522e interfaceC1522e = (InterfaceC1522e) interfaceC1524gD;
        if (interfaceC1522e != null) {
            return t(interfaceC1522e) != null;
        }
        a(97);
        throw null;
    }

    public static boolean G(w wVar) {
        return D(wVar, n.f);
    }

    public static boolean H(K k, G8.e eVar) {
        if (k == null) {
            a(102);
            throw null;
        }
        if (eVar != null) {
            InterfaceC1524g interfaceC1524gD = k.d();
            return (interfaceC1524gD instanceof InterfaceC1522e) && b((InterfaceC1522e) interfaceC1524gD, eVar);
        }
        a(v7.o.META_DATA_FIELD_NUMBER);
        throw null;
    }

    public static boolean I(InterfaceC1524g interfaceC1524g) {
        if (interfaceC1524g == null) {
            a(10);
            throw null;
        }
        for (InterfaceC1524g interfaceC1524gD = interfaceC1524g; interfaceC1524gD != null; interfaceC1524gD = interfaceC1524gD.d()) {
            if (interfaceC1524gD instanceof InterfaceC1494B) {
                return ((AbstractC1629B) ((InterfaceC1494B) interfaceC1524gD)).e.h(o.k);
            }
        }
        return false;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i6;
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 69:
            case 70:
            case 71:
            case 75:
            case 82:
            case 85:
            case 87:
            case 88:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 83:
            case 84:
            case 86:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 69:
            case 70:
            case 71:
            case 75:
            case 82:
            case 85:
            case 87:
            case 88:
                i6 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 83:
            case 84:
            case 86:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        switch (i) {
            case 1:
            case 73:
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
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 69:
            case 70:
            case 71:
            case 75:
            case 82:
            case 85:
            case 87:
            case 88:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 77:
            case 78:
            case 90:
            case 97:
            case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
            case 144:
            case 147:
            case 148:
            case 150:
            case 158:
            case 159:
            case 160:
            case 161:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 99:
            case 101:
            case v7.o.META_DATA_FIELD_NUMBER /* 103 */:
            case 105:
            case 107:
            case 136:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 54:
            case 89:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 98:
            case 100:
            case 106:
            case 110:
            case 111:
            case 112:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case MenuKt.InTransitionDuration /* 120 */:
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
            case 135:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 145:
            case 146:
            case 149:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 163:
                objArr[0] = "type";
                break;
            case 47:
                objArr[0] = "classSimpleName";
                break;
            case 68:
                objArr[0] = "arrayType";
                break;
            case 72:
                objArr[0] = "notNullArrayType";
                break;
            case 74:
                objArr[0] = "primitiveType";
                break;
            case 76:
                objArr[0] = "kotlinType";
                break;
            case 79:
            case 83:
                objArr[0] = "projectionType";
                break;
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 84:
            case 86:
                objArr[0] = "argument";
                break;
            case 81:
                objArr[0] = "annotations";
                break;
            case 102:
                objArr[0] = "typeConstructor";
                break;
            case 113:
                objArr[0] = "classDescriptor";
                break;
            case 162:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
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
            case 14:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 83:
            case 84:
            case 86:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKType";
                break;
            case 23:
                objArr[1] = "getKCallable";
                break;
            case 24:
                objArr[1] = "getKProperty";
                break;
            case 25:
                objArr[1] = "getKProperty0";
                break;
            case 26:
                objArr[1] = "getKProperty1";
                break;
            case 27:
                objArr[1] = "getKProperty2";
                break;
            case 28:
                objArr[1] = "getKMutableProperty0";
                break;
            case 29:
                objArr[1] = "getKMutableProperty1";
                break;
            case 30:
                objArr[1] = "getKMutableProperty2";
                break;
            case 31:
                objArr[1] = "getIterator";
                break;
            case 32:
                objArr[1] = "getIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterable";
                break;
            case 34:
                objArr[1] = "getMutableIterator";
                break;
            case 35:
                objArr[1] = "getCollection";
                break;
            case 36:
                objArr[1] = "getMutableCollection";
                break;
            case 37:
                objArr[1] = "getList";
                break;
            case 38:
                objArr[1] = "getMutableList";
                break;
            case 39:
                objArr[1] = "getSet";
                break;
            case 40:
                objArr[1] = "getMutableSet";
                break;
            case 41:
                objArr[1] = "getMap";
                break;
            case 42:
                objArr[1] = "getMutableMap";
                break;
            case 43:
                objArr[1] = "getMapEntry";
                break;
            case 44:
                objArr[1] = "getMutableMapEntry";
                break;
            case 45:
                objArr[1] = "getListIterator";
                break;
            case 46:
                objArr[1] = "getMutableListIterator";
                break;
            case 48:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 49:
                objArr[1] = "getNothingType";
                break;
            case 50:
                objArr[1] = "getNullableNothingType";
                break;
            case 51:
                objArr[1] = "getAnyType";
                break;
            case 52:
                objArr[1] = "getNullableAnyType";
                break;
            case 53:
                objArr[1] = "getDefaultBound";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 56:
                objArr[1] = "getNumberType";
                break;
            case 57:
                objArr[1] = "getByteType";
                break;
            case 58:
                objArr[1] = "getShortType";
                break;
            case 59:
                objArr[1] = "getIntType";
                break;
            case 60:
                objArr[1] = "getLongType";
                break;
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                objArr[1] = "getFloatType";
                break;
            case 62:
                objArr[1] = "getDoubleType";
                break;
            case 63:
                objArr[1] = "getCharType";
                break;
            case 64:
                objArr[1] = "getBooleanType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                objArr[1] = "getUnitType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                objArr[1] = "getStringType";
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                objArr[1] = "getIterableType";
                break;
            case 69:
            case 70:
            case 71:
                objArr[1] = "getArrayElementType";
                break;
            case 75:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 82:
            case 85:
                objArr[1] = "getArrayType";
                break;
            case 87:
                objArr[1] = "getEnumType";
                break;
            case 88:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
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
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 69:
            case 70:
            case 71:
            case 75:
            case 82:
            case 85:
            case 87:
            case 88:
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
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 47:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 54:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 68:
                objArr[2] = "getArrayElementType";
                break;
            case 72:
            case 73:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 77:
            case 94:
                objArr[2] = "getPrimitiveType";
                break;
            case 78:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 83:
            case 84:
                objArr[2] = "getArrayType";
                break;
            case 86:
                objArr[2] = "getEnumType";
                break;
            case 89:
                objArr[2] = "isArray";
                break;
            case 90:
            case 91:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 92:
                objArr[2] = "isPrimitiveArray";
                break;
            case 93:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 95:
                objArr[2] = "isPrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 97:
                objArr[2] = "isPrimitiveClass";
                break;
            case 98:
            case 99:
            case 100:
            case 101:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 102:
            case v7.o.META_DATA_FIELD_NUMBER /* 103 */:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
            case 105:
                objArr[2] = "classFqNameEquals";
                break;
            case 106:
            case 107:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
            case 110:
                objArr[2] = "isAny";
                break;
            case 111:
            case 113:
                objArr[2] = "isBoolean";
                break;
            case 112:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 114:
                objArr[2] = "isNumber";
                break;
            case 115:
                objArr[2] = "isChar";
                break;
            case 116:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 117:
                objArr[2] = "isInt";
                break;
            case 118:
                objArr[2] = "isByte";
                break;
            case 119:
                objArr[2] = "isLong";
                break;
            case MenuKt.InTransitionDuration /* 120 */:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 121:
                objArr[2] = "isShort";
                break;
            case 122:
                objArr[2] = "isFloat";
                break;
            case 123:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 124:
                objArr[2] = "isDouble";
                break;
            case 125:
                objArr[2] = "isUByte";
                break;
            case 126:
                objArr[2] = "isUShort";
                break;
            case 127:
                objArr[2] = "isUInt";
                break;
            case 128:
                objArr[2] = "isULong";
                break;
            case 129:
                objArr[2] = "isUByteArray";
                break;
            case 130:
                objArr[2] = "isUShortArray";
                break;
            case 131:
                objArr[2] = "isUIntArray";
                break;
            case 132:
                objArr[2] = "isULongArray";
                break;
            case 133:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 134:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 135:
            case 136:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 137:
                objArr[2] = "isNothing";
                break;
            case 138:
                objArr[2] = "isNullableNothing";
                break;
            case 139:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 140:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 141:
                objArr[2] = "isNullableAny";
                break;
            case 142:
                objArr[2] = "isDefaultBound";
                break;
            case 143:
                objArr[2] = "isUnit";
                break;
            case 144:
                objArr[2] = "mayReturnNonUnitValue";
                break;
            case 145:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 146:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 147:
                objArr[2] = "isMemberOfAny";
                break;
            case 148:
            case 149:
                objArr[2] = "isEnum";
                break;
            case 150:
            case 151:
                objArr[2] = "isComparable";
                break;
            case 152:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 153:
                objArr[2] = "isListOrNullableList";
                break;
            case 154:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 155:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 156:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 157:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 158:
                objArr[2] = "isThrowable";
                break;
            case 159:
                objArr[2] = "isKClass";
                break;
            case 160:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 161:
                objArr[2] = "isCloneable";
                break;
            case 162:
                objArr[2] = "isDeprecated";
                break;
            case 163:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 69:
            case 70:
            case 71:
            case 75:
            case 82:
            case 85:
            case 87:
            case 88:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 47:
            case 54:
            case 68:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 79:
            case WebSocketImpl.DEFAULT_PORT /* 80 */:
            case 81:
            case 83:
            case 84:
            case 86:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(InterfaceC1522e interfaceC1522e, G8.e eVar) {
        if (interfaceC1522e == null) {
            a(LocationRequestCompat.QUALITY_LOW_POWER);
            throw null;
        }
        if (eVar != null) {
            return interfaceC1522e.getName().equals(eVar.f()) && eVar.equals(J8.e.g(interfaceC1522e));
        }
        a(105);
        throw null;
    }

    public static PrimitiveType r(InterfaceC1524g interfaceC1524g) {
        if (interfaceC1524g == null) {
            a(78);
            throw null;
        }
        if (n.b0.contains(interfaceC1524g.getName())) {
            return (PrimitiveType) n.f4416d0.get(J8.e.g(interfaceC1524g));
        }
        return null;
    }

    public static PrimitiveType t(InterfaceC1522e interfaceC1522e) {
        if (interfaceC1522e == null) {
            a(77);
            throw null;
        }
        if (n.f4414a0.contains(interfaceC1522e.getName())) {
            return (PrimitiveType) n.f4415c0.get(J8.e.g(interfaceC1522e));
        }
        return null;
    }

    public static boolean x(w wVar) {
        if (wVar != null) {
            return A(wVar, n.f4413a);
        }
        a(140);
        throw null;
    }

    public static boolean y(w wVar) {
        if (wVar != null) {
            return A(wVar, n.g);
        }
        a(89);
        throw null;
    }

    public static boolean z(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j != null) {
            return J8.e.i(interfaceC1527j, U8.b.class, false) != null;
        }
        a(9);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [C7.f, java.lang.Object] */
    public final void c(boolean z10) {
        G8.f moduleName = e;
        kotlin.jvm.internal.k.f(moduleName, "moduleName");
        W8.i iVar = this.d;
        z zVar = new z(moduleName, iVar, this, 48);
        this.f4384a = zVar;
        InterfaceC1427c.f4379a.getClass();
        zVar.h = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a) ((InterfaceC1427c) C1426b.b.getF4884a())).a(iVar, this.f4384a, l(), p(), d(), z10);
        z zVar2 = this.f4384a;
        zVar2.getClass();
        List descriptors = D7.q.I0(new z[]{zVar2});
        kotlin.jvm.internal.k.f(descriptors, "descriptors");
        EmptySet friends = EmptySet.f4895a;
        kotlin.jvm.internal.k.f(friends, "friends");
        zVar2.g = new u1.d(descriptors, friends, EmptyList.f4893a, friends);
    }

    public InterfaceC1603b d() {
        return C1602a.b;
    }

    public final A e() {
        A aG = j("Any").g();
        if (aG != null) {
            return aG;
        }
        a(51);
        throw null;
    }

    public final w f(w wVar) {
        G8.b bVarF;
        G8.b bVar;
        InterfaceC1522e interfaceC1522eA;
        A aG = null;
        if (wVar == null) {
            a(68);
            throw null;
        }
        if (y(wVar)) {
            if (wVar.L().size() != 1) {
                throw new IllegalStateException();
            }
            w wVarB = ((N) wVar.L().get(0)).b();
            if (wVarB != null) {
                return wVarB;
            }
            a(69);
            throw null;
        }
        U uG = S.g(wVar, false);
        w wVar2 = (w) ((h) this.b.invoke()).b.get(uG);
        if (wVar2 != null) {
            return wVar2;
        }
        int i = J8.e.f883a;
        InterfaceC1524g interfaceC1524gD = uG.Q().d();
        InterfaceC1540w interfaceC1540wE = interfaceC1524gD == null ? null : J8.e.e(interfaceC1524gD);
        if (interfaceC1540wE != null) {
            InterfaceC1524g interfaceC1524gD2 = uG.Q().d();
            if (interfaceC1524gD2 != null) {
                Set set = q.f4430a;
                G8.f name = interfaceC1524gD2.getName();
                kotlin.jvm.internal.k.f(name, "name");
                if (q.e.contains(name) && (bVarF = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(interfaceC1524gD2)) != null && (bVar = (G8.b) q.c.get(bVarF)) != null && (interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(interfaceC1540wE, bVar)) != null) {
                    aG = interfaceC1522eA.g();
                }
            }
            if (aG != null) {
                return aG;
            }
        }
        throw new IllegalStateException("not array: " + wVar);
    }

    public final A g(U u) {
        Variance variance = Variance.c;
        if (u != null) {
            return h(variance, u, C1560f.f4611a);
        }
        a(84);
        throw null;
    }

    public final A h(Variance variance, w wVar, InterfaceC1561g interfaceC1561g) {
        if (wVar != null) {
            return AbstractC0272c.t(AbstractC0272c.C(interfaceC1561g), j("Array"), Collections.singletonList(new F(wVar, variance)));
        }
        a(80);
        throw null;
    }

    public final InterfaceC1522e i(G8.c cVar) {
        if (cVar == null) {
            a(12);
            throw null;
        }
        z zVarK = k();
        NoLookupLocation noLookupLocation = NoLookupLocation.f4986a;
        InterfaceC1522e interfaceC1522eG = AbstractC1538u.g(zVarK, cVar);
        if (interfaceC1522eG != null) {
            return interfaceC1522eG;
        }
        a(13);
        throw null;
    }

    public final InterfaceC1522e j(String str) {
        if (str != null) {
            return (InterfaceC1522e) this.c.invoke(G8.f.e(str));
        }
        a(14);
        throw null;
    }

    public final z k() {
        this.f4384a.getClass();
        z zVar = this.f4384a;
        if (zVar != null) {
            return zVar;
        }
        a(7);
        throw null;
    }

    public Iterable l() {
        List listSingletonList = Collections.singletonList(new C1440a(this.d, k()));
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(5);
        throw null;
    }

    public final A m() {
        A aO = o();
        if (aO != null) {
            return aO;
        }
        a(53);
        throw null;
    }

    public final A n() {
        A aG = j("Nothing").g();
        if (aG != null) {
            return aG;
        }
        a(49);
        throw null;
    }

    public final A o() {
        A aN0 = e().f0(true);
        if (aN0 != null) {
            return aN0;
        }
        a(52);
        throw null;
    }

    public InterfaceC1605d p() {
        return C1602a.d;
    }

    public final A q(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(74);
            throw null;
        }
        A a3 = (A) ((h) this.b.invoke()).f4383a.get(primitiveType);
        if (a3 != null) {
            return a3;
        }
        a(75);
        throw null;
    }

    public final A s(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(54);
            throw null;
        }
        A aG = j(primitiveType.f4943a.b()).g();
        if (aG != null) {
            return aG;
        }
        a(55);
        throw null;
    }

    public final A u() {
        A aG = j("String").g();
        if (aG != null) {
            return aG;
        }
        a(66);
        throw null;
    }

    public final InterfaceC1522e v(int i) {
        return i(o.f.c(G8.f.e(C1448i.c.b + i)));
    }

    public final A w() {
        A aG = j("Unit").g();
        if (aG != null) {
            return aG;
        }
        a(65);
        throw null;
    }
}
