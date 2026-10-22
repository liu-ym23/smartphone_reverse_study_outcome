package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpecialNames.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SpecialNames {
    public static final Name ANONYMOUS = null;
    public static final Name ARRAY = null;
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT = null;
    public static final Name DESTRUCT = null;
    public static final Name IMPLICIT_SET_PARAMETER = null;
    public static final Name INIT = null;
    public static final SpecialNames INSTANCE = null;
    public static final Name ITERATOR = null;
    public static final Name LOCAL = null;
    public static final Name NO_NAME_PROVIDED = null;
    public static final Name RECEIVER = null;
    public static final Name ROOT_PACKAGE = null;
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME = null;
    public static final Name THIS = null;
    public static final Name UNARY = null;
    public static final Name UNARY_RESULT = null;
    public static final Name UNDERSCORE_FOR_UNUSED_VAR = null;

    private SpecialNames() {
    }

    static {
        INSTANCE = new SpecialNames();
        Name r0 = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(r0, "special(\"<no name provided>\")");
        NO_NAME_PROVIDED = r0;
        Name r1 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(r1, "special(\"<root package>\")");
        ROOT_PACKAGE = r1;
        Name r2 = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(r2, "identifier(\"Companion\")");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = r2;
        Name r3 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(r3, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        SAFE_IDENTIFIER_FOR_NO_NAME = r3;
        Name r4 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(r4, "special(ANONYMOUS_STRING)");
        ANONYMOUS = r4;
        Name r5 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(r5, "special(\"<unary>\")");
        UNARY = r5;
        Name r6 = Name.special("<unary-result>");
        Intrinsics.checkNotNullExpressionValue(r6, "special(\"<unary-result>\")");
        UNARY_RESULT = r6;
        Name r7 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(r7, "special(\"<this>\")");
        THIS = r7;
        Name r8 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(r8, "special(\"<init>\")");
        INIT = r8;
        Name r9 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(r9, "special(\"<iterator>\")");
        ITERATOR = r9;
        Name r10 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(r10, "special(\"<destruct>\")");
        DESTRUCT = r10;
        Name r11 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(r11, "special(\"<local>\")");
        LOCAL = r11;
        Name r12 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(r12, "special(\"<unused var>\")");
        UNDERSCORE_FOR_UNUSED_VAR = r12;
        Name r13 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(r13, "special(\"<set-?>\")");
        IMPLICIT_SET_PARAMETER = r13;
        Name r14 = Name.special("<array>");
        Intrinsics.checkNotNullExpressionValue(r14, "special(\"<array>\")");
        ARRAY = r14;
        Name r15 = Name.special("<receiver>");
        Intrinsics.checkNotNullExpressionValue(r15, "special(\"<receiver>\")");
        RECEIVER = r15;
    }

    @JvmStatic
    public static final Name safeIdentifier(Name r1) {
        if (r1 == null) goto L7;
        if (r1.isSpecial() == true) goto L7;
        return r1;
    L7:
        return SAFE_IDENTIFIER_FOR_NO_NAME;
    }

    public final boolean isSafeIdentifier(Name r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        String r2 = r3.asString();
        Intrinsics.checkNotNullExpressionValue(r2, "name.asString()");
        if (r2.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L11;
        if (r3.isSpecial() == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r4 = false;
        goto L6
    }
}
