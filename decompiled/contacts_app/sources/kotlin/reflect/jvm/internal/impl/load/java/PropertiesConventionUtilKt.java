package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: propertiesConventionUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PropertiesConventionUtilKt {
    public static final Name propertyNameByGetMethodName(Name r7) {
        Intrinsics.checkNotNullParameter(r7, "methodName");
        Name r0 = propertyNameFromAccessorMethodName$default(r7, "get", false, null, 12, null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return propertyNameFromAccessorMethodName$default(r7, "is", false, null, 8, null);
    }

    public static final Name propertyNameBySetMethodName(Name r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "methodName");
        if (r8 == false) goto L5;
        String r9 = "is";
    L7:
        return propertyNameFromAccessorMethodName$default(r7, "set", false, r9, 4, null);
    L5:
        r9 = null;
        goto L7
    }

    public static final List<Name> propertyNamesBySetMethodName(Name r3) {
        Intrinsics.checkNotNullParameter(r3, "methodName");
        return CollectionsKt.listOfNotNull(new Name[]{propertyNameBySetMethodName(r3, false), propertyNameBySetMethodName(r3, true)});
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name r0, String r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = null;
    L9:
        return propertyNameFromAccessorMethodName(r0, r1, r2, r3);
    }

    private static final Name propertyNameFromAccessorMethodName(Name r6, String r7, boolean r8, String r9) {
        if (r6.isSpecial() == false) goto L5;
        return null;
    L5:
        String r0 = r6.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(r0, "methodName.identifier");
        boolean r3 = false;
        if (StringsKt.startsWith$default(r0, r7, false, 2, null) == true) goto L9;
        return null;
    L9:
        if (r0.length() != r7.length()) goto L11;
        return null;
    L11:
        char r2 = r0.charAt(r7.length());
        if ('a' <= r2) goto L14;
    L16:
        if (r3 == false) goto L18;
        return null;
    L18:
        if (r9 != null) goto L20;
        if (r8 == true) goto L23;
        return r6;
    L23:
        String r10 = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(StringsKt.removePrefix(r0, r7), true);
        if (Name.isValidIdentifier(r10) == true) goto L27;
        return null;
    L27:
        return Name.identifier(r10);
    L20:
        return Name.identifier(r9 + StringsKt.removePrefix(r0, r7));
    L14:
        if (r2 >= '{') goto L16;
        r3 = true;
        goto L16
    }

    public static final List<Name> getPropertyNamesCandidatesByAccessorName(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        String r0 = r2.asString();
        Intrinsics.checkNotNullExpressionValue(r0, "name.asString()");
        if (JvmAbi.isGetterName(r0) == false) goto L7;
        return CollectionsKt.listOfNotNull(propertyNameByGetMethodName(r2));
    L7:
        if (JvmAbi.isSetterName(r0) == false) goto L11;
        return propertyNamesBySetMethodName(r2);
    L11:
        return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(r2);
    }
}
