package com.android.contacts.format;

import android.database.CharArrayBuffer;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class FormatUtils {
    public FormatUtils() {
    }

    public static int overlapPoint(CharArrayBuffer r2, CharArrayBuffer r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return -1;
    L6:
        return overlapPoint(Arrays.copyOfRange(r2.data, 0, r2.sizeCopied), Arrays.copyOfRange(r3.data, 0, r3.sizeCopied));
    L7:
        return -1;
    }

    public static int overlapPoint(String r0, String r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return -1;
    L6:
        return overlapPoint(r0.toCharArray(), r1.toCharArray());
    L7:
        return -1;
    }

    public static int overlapPoint(char[] r8, char[] r9) {
        if (r8 == null) goto L26;
        if (r9 == null) goto L26;
        int r1 = r8.length;
        int r2 = r9.length;
    L7:
        if (r1 <= 0) goto L12;
        if (r2 <= 0) goto L12;
        if (r8[r1 - 1] != r9[r2 - 1]) goto L12;
        r1 = r1 - 1;
        r2 = r2 - 1;
    L12:
        int r4 = 0;
    L13:
        if (r4 >= r1) goto L26;
        if ((r4 + r2) <= r1) goto L17;
        r2 = r1 - r4;
    L17:
        int r5 = 0;
    L18:
        if (r5 >= r2) goto L23;
        if (r8[r4 + r5] != r9[r5]) goto L23;
        r5 = r5 + 1;
    L23:
        if (r5 == r2) goto L24;
        r4 = r4 + 1;
        goto L13
    L24:
        return r4;
    L26:
        return -1;
    }

    public static CharSequence applyStyleToSpan(int r1, CharSequence r2, int r3, int r4, int r5) {
        int r6 = Math.max(0, r3);
        int r7 = Math.min(r2.length(), r4);
        SpannableString r0 = new SpannableString(r2);
        r0.setSpan(new StyleSpan(r1), r6, r7, r5);
        return r0;
    }

    public static void copyToCharArrayBuffer(String r4, CharArrayBuffer r5) {
        if (r4 == null) goto L12;
        char[] r1 = r5.data;
        if (r1 != null) goto L7;
    L10:
        r5.data = r4.toCharArray();
    L11:
        r5.sizeCopied = r4.length();
        return;
    L7:
        if (r1.length < r4.length()) goto L10;
        r4.getChars(0, r4.length(), r1, 0);
        goto L11
    L12:
        r5.sizeCopied = 0;
    }

    public static String charArrayBufferToString(CharArrayBuffer r3) {
        return new String(r3.data, 0, r3.sizeCopied);
    }

    public static int indexOfWordPrefix(CharSequence r8, char[] r9) {
        if (r9 == null) goto L31;
        if (r8 == null) goto L31;
        int r1 = r8.length();
        int r2 = r9.length;
        if (r2 == 0) goto L31;
        if (r1 < r2) goto L31;
        int r4 = 0;
    L11:
        if (r4 >= r1) goto L31;
    L12:
        if (r4 >= r1) goto L17;
        if (Character.isLetterOrDigit(r8.charAt(r4)) == true) goto L17;
        r4 = r4 + 1;
    L17:
        if ((r4 + r2) > r1) goto L18;
        int r5 = 0;
    L20:
        if (r5 >= r2) goto L25;
        if (Character.toUpperCase(r8.charAt(r4 + r5)) != r9[r5]) goto L25;
        r5 = r5 + 1;
    L25:
        if (r5 == r2) goto L26;
    L27:
        if (r4 >= r1) goto L11;
        if (Character.isLetterOrDigit(r8.charAt(r4)) == false) goto L11;
        r4 = r4 + 1;
        goto L27
    L26:
        return r4;
    L18:
        return -1;
    L31:
        return -1;
    }
}
