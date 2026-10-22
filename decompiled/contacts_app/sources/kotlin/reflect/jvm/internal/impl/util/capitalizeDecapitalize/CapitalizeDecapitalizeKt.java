package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CapitalizeDecapitalizeKt {
    public static final String decapitalizeSmartForCompiler(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        String r0 = r6;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r6;
    L8:
        if (isUpperCaseCharAt(r6, 0, r7) == true) goto L11;
        return r6;
    L11:
        if (r6.length() != 1) goto L13;
    L28:
        if (r7 == false) goto L31;
        return decapitalizeAsciiOnly(r6);
    L31:
        if (r0.length() <= 0) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L42;
        char r9 = Character.toLowerCase(r6.charAt(0));
        String r10 = r6.substring(1);
        Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).substring(startIndex)");
        return r9 + r10;
    L42:
        return r6;
    L33:
        r8 = false;
        goto L34
    L13:
        if (isUpperCaseCharAt(r6, 1, r7) == false) goto L28;
        Iterator<Integer> r2 = StringsKt.getIndices(r0).iterator();
    L17:
        if (r2.hasNext() == false) goto L21;
        Integer r3 = r2.next();
        if ((!isUpperCaseCharAt(r6, r3.intValue(), r7)) == false) goto L17;
    L22:
        Integer r4 = r3;
        if (r4 == null) goto L27;
        int r5 = r4.intValue() - 1;
        StringBuilder r11 = new StringBuilder();
        String r12 = r6.substring(0, r5);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String…ing(startIndex, endIndex)");
        StringBuilder r13 = r11.append(toLowerCase(r12, r7));
        String r14 = r6.substring(r5);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        return r13.append(r14).toString();
    L27:
        return toLowerCase(r6, r7);
    L21:
        r3 = null;
        goto L22
    L5:
        r1 = false;
        goto L6
    }

    private static final boolean isUpperCaseCharAt(String r0, int r1, boolean r2) {
        char r3 = r0.charAt(r1);
        if (r2 == false) goto L10;
        if ('A' <= r3) goto L7;
        return false;
    L7:
        if (r3 >= '[') goto L12;
        return true;
    L12:
        return false;
    L10:
        return Character.isUpperCase(r3);
    }

    private static final String toLowerCase(String r0, boolean r1) {
        if (r1 == true) goto L6;
        String r2 = r0.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r2;
    L6:
        return toLowerCaseAsciiOnly(r0);
    }

    public static final String capitalizeAsciiOnly(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        boolean r2 = false;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        char r1 = r4.charAt(0);
        if ('a' <= r1) goto L11;
    L13:
        if (r2 == false) goto L16;
        char r3 = Character.toUpperCase(r1);
        String r5 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        return r3 + r5;
    L16:
        return r4;
    L11:
        if (r1 >= '{') goto L13;
        r2 = true;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static final String decapitalizeAsciiOnly(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        boolean r2 = false;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        char r1 = r4.charAt(0);
        if ('A' <= r1) goto L11;
    L13:
        if (r2 == false) goto L16;
        char r3 = Character.toLowerCase(r1);
        String r5 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        return r3 + r5;
    L16:
        return r4;
    L11:
        if (r1 >= '[') goto L13;
        r2 = true;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static final String toLowerCaseAsciiOnly(String r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        StringBuilder r0 = new StringBuilder(r6.length());
        int r1 = r6.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        char r4 = r6.charAt(r3);
        if ('A' <= r4) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L12;
        r4 = Character.toLowerCase(r4);
    L12:
        r0.append(r4);
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 >= '[') goto L9;
        r5 = true;
        goto L10
    L13:
        String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "builder.toString()");
        return r7;
    }
}
