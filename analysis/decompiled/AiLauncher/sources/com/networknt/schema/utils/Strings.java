package com.networknt.schema.utils;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class Strings {
    private static final char CHAR_0 = '0';
    private static final char CHAR_1 = '1';
    private static final char CHAR_9 = '9';
    private static final char CHAR_E = 'E';
    private static final char CHAR_e = 'e';
    private static final char DOT = '.';
    private static final char MINUS = '-';
    private static final char PLUS = '+';

    private Strings() {
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isBoolean(String str) {
        return "true".equals(str) || "false".equals(str);
    }

    public static boolean isInteger(String str) {
        int i10;
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.charAt(0) != '-' && str.charAt(0) != '+') {
            i10 = 0;
        } else {
            if (str.length() == 1) {
                return false;
            }
            i10 = 1;
        }
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
            i10++;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x009c A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00a0 -> B:50:0x008e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isNumeric(java.lang.String r13) {
        /*
            r0 = 0
            if (r13 == 0) goto Lae
            boolean r1 = r13.isEmpty()
            if (r1 == 0) goto Lb
            goto Lae
        Lb:
            int r1 = r13.length()
            char r2 = r13.charAt(r0)
            r3 = 43
            r4 = 45
            r5 = 1
            if (r2 == r4) goto L23
            char r2 = r13.charAt(r0)
            if (r2 != r3) goto L21
            goto L23
        L21:
            r2 = r0
            goto L2b
        L23:
            int r2 = r13.length()
            if (r2 != r5) goto L2a
            return r0
        L2a:
            r2 = r5
        L2b:
            int r6 = r2 + 1
            char r7 = r13.charAt(r2)
            r8 = 101(0x65, float:1.42E-43)
            r9 = 69
            r10 = 46
            r11 = 57
            r12 = 48
            if (r7 != r12) goto L4e
            if (r6 >= r1) goto L62
            int r2 = r2 + 2
            char r7 = r13.charAt(r6)
            if (r7 == r10) goto L4c
            if (r7 == r9) goto L4c
            if (r7 == r8) goto L4c
            return r0
        L4c:
            r6 = r2
            goto L62
        L4e:
            r2 = 49
            if (r2 > r7) goto Lae
            if (r7 > r11) goto Lae
        L54:
            if (r6 >= r1) goto L62
            if (r12 > r7) goto L62
            if (r7 > r11) goto L62
            int r2 = r6 + 1
            char r7 = r13.charAt(r6)
            r6 = r2
            goto L54
        L62:
            if (r7 != r10) goto L7c
            if (r6 < r1) goto L67
            return r0
        L67:
            int r2 = r6 + 1
            char r6 = r13.charAt(r6)
            r7 = r6
        L6e:
            r6 = r2
            if (r6 >= r1) goto L7c
            if (r12 > r7) goto L7c
            if (r7 > r11) goto L7c
            int r2 = r6 + 1
            char r7 = r13.charAt(r6)
            goto L6e
        L7c:
            if (r7 == r9) goto L80
            if (r7 != r8) goto La7
        L80:
            if (r6 < r1) goto L83
            return r0
        L83:
            int r2 = r6 + 1
            char r7 = r13.charAt(r6)
            if (r7 == r3) goto L90
            if (r7 != r4) goto L8e
            goto L90
        L8e:
            r6 = r2
            goto L9a
        L90:
            if (r2 < r1) goto L93
            return r0
        L93:
            int r6 = r6 + 2
            char r2 = r13.charAt(r2)
            r7 = r2
        L9a:
            if (r6 >= r1) goto La7
            if (r12 > r7) goto La7
            if (r7 > r11) goto La7
            int r2 = r6 + 1
            char r7 = r13.charAt(r6)
            goto L8e
        La7:
            if (r6 < r1) goto Lae
            if (r12 > r7) goto Lae
            if (r7 > r11) goto Lae
            return r5
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.networknt.schema.utils.Strings.isNumeric(java.lang.String):boolean");
    }

    public static String[] split(String str, char c10) {
        int i10 = 0;
        if (str == null) {
            return new String[0];
        }
        if (str.isEmpty()) {
            return new String[]{""};
        }
        ArrayList arrayList = new ArrayList();
        while (i10 <= str.length()) {
            int iIndexOf = str.indexOf(c10, i10);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            arrayList.add(str.substring(i10, iIndexOf));
            if (iIndexOf == str.length()) {
                break;
            }
            i10 = iIndexOf + 1;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
