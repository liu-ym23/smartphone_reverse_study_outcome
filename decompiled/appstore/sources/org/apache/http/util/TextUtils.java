package org.apache.http.util;

/* JADX INFO: loaded from: classes4.dex */
public final class TextUtils {
    public TextUtils() {
    }

    public static boolean containsBlanks(CharSequence r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L13;
        if (Character.isWhitespace(r10.charAt(r11)) == true) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }

    public static boolean isBlank(CharSequence r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L12;
        if (Character.isWhitespace(r10.charAt(r11)) == false) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isEmpty(CharSequence r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        if (r10.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }
}
