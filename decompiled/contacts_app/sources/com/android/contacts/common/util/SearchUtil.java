package com.android.contacts.common.util;

/* JADX INFO: loaded from: classes.dex */
public class SearchUtil {

    public static class MatchedLine {
        public String line;
        public int startIndex;

        public MatchedLine() {
            this.startIndex = -1;
        }

        public String toString() {
            return "MatchedLine{line='" + this.line + "', startIndex=" + this.startIndex + '}';
        }
    }

    public SearchUtil() {
    }

    public static MatchedLine findMatchingLine(String r5, String r6) {
        MatchedLine r0 = new MatchedLine();
        int r7 = contains(r5, r6);
        if (r7 == (-1)) goto L19;
        int r2 = r7 - 1;
    L6:
        if (r2 <= (-1)) goto L11;
        if (r5.charAt(r2) == '\n') goto L11;
        r2 = r2 - 1;
    L11:
        int r1 = r7 + 1;
    L13:
        if (r1 >= r5.length()) goto L18;
        if (r5.charAt(r1) == '\n') goto L18;
        r1 = r1 + 1;
    L18:
        int r3 = r2 + 1;
        r0.line = r5.substring(r3, r1);
        r0.startIndex = r7 - r3;
    L19:
        return r0;
    }

    static int contains(String r8, String r9) {
        if (r8.length() >= r9.length()) goto L5;
        return -1;
    L5:
        int[] r0 = new int[r9.length()];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r9.length()) goto L9;
        int r5 = Character.codePointAt(r9, r3);
        r0[r4] = r5;
        r4 = r4 + 1;
        r3 = r3 + Character.charCount(r5);
        goto L7
    L9:
        int r10 = 0;
    L11:
        if (r10 >= r8.length()) goto L23;
        int r6 = r10;
        int r7 = 0;
    L14:
        if (r6 >= r8.length()) goto L20;
        if (r7 >= r4) goto L20;
        int r11 = Character.toLowerCase(r8.codePointAt(r6));
        if (r11 != r0[r7]) goto L20;
        r6 = r6 + Character.charCount(r11);
        r7 = r7 + 1;
    L20:
        if (r7 == r4) goto L21;
        r10 = findNextTokenStart(r8, r10);
        goto L11
    L21:
        return r10;
    L23:
        return -1;
    }

    static int findNextTokenStart(String r2, int r3) {
    L3:
        if (r3 > r2.length()) goto L12;
        if (r3 == r2.length()) goto L6;
        int r0 = r2.codePointAt(r3);
        if (Character.isLetterOrDigit(r0) == false) goto L12;
        r3 = r3 + Character.charCount(r0);
        goto L3
    L6:
        return r3;
    L12:
        if (r3 > r2.length()) goto L20;
        if (r3 == r2.length()) goto L15;
        int r1 = r2.codePointAt(r3);
        if (Character.isLetterOrDigit(r1) == true) goto L20;
        r3 = r3 + Character.charCount(r1);
        goto L12
    L15:
        return r3;
    L20:
        return r3;
    }

    public static String cleanStartAndEndOfSearchQuery(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length()) goto L10;
        int r1 = r3.codePointAt(r0);
        if (Character.isLetterOrDigit(r1) == true) goto L10;
        r0 = r0 + Character.charCount(r1);
    L10:
        if (r0 != r3.length()) goto L13;
        return "";
    L13:
        int r2 = r3.length();
    L14:
        r2 = r2 - 1;
        if (r2 <= (-1)) goto L24;
        if (Character.isLowSurrogate(r3.charAt(r2)) == false) goto L20;
        r2 = r2 - 1;
    L20:
        if (Character.isLetterOrDigit(r3.codePointAt(r2)) == false) goto L14;
    L24:
        return r3.substring(r0, r2 + 1);
    }
}
