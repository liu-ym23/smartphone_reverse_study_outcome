package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte CAN = 24;
    private static final char CASE_MASK = ' ';
    public static final byte CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = 127;
    public static final byte DLE = 16;
    public static final byte EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;
    public static final byte FF = 12;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final char MAX = 127;
    public static final char MIN = 0;
    public static final byte NAK = 21;
    public static final byte NL = 10;
    public static final byte NUL = 0;
    public static final byte RS = 30;
    public static final byte SI = 15;
    public static final byte SO = 14;
    public static final byte SOH = 1;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;
    public static final byte US = 31;
    public static final byte VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    private Ascii() {
    }

    public static boolean equalsIgnoreCase(CharSequence r10, CharSequence r11) {
        int r12 = r10.length();
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r12 == r11.length()) goto L8;
        return false;
    L8:
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L19;
        char r14 = r10.charAt(r13);
        char r15 = r11.charAt(r13);
        if (r14 == r15) goto L17;
        int r16 = getAlphaIndex(r14);
        if (r16 >= 26) goto L18;
        if (r16 == getAlphaIndex(r15)) goto L17;
    L18:
        return false;
    L17:
        r13 = r13 + 1;
        goto L9
    L19:
        return true;
    }

    private static int getAlphaIndex(char r10) {
        return (char) ((r10 | ' ') - 97);
    }

    public static boolean isLowerCase(char r10) {
        if (r10 >= 'a') goto L5;
    L7:
        return false;
    L5:
        if (r10 > 'z') goto L7;
        return true;
    }

    public static boolean isUpperCase(char r10) {
        if (r10 >= 'A') goto L5;
    L7:
        return false;
    L5:
        if (r10 > 'Z') goto L7;
        return true;
    }

    public static String toLowerCase(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        if (isUpperCase(r10.charAt(r12)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        char[] r13 = r10.toCharArray();
    L7:
        if (r12 >= r11) goto L13;
        char r14 = r13[r12];
        if (isUpperCase(r14) == false) goto L11;
        r13[r12] = (char) (r14 ^ ' ');
    L11:
        r12 = r12 + 1;
        goto L7
    L13:
        return String.valueOf(r13);
    L15:
        return r10;
    }

    public static String toUpperCase(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        if (isLowerCase(r10.charAt(r12)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        char[] r13 = r10.toCharArray();
    L7:
        if (r12 >= r11) goto L13;
        char r14 = r13[r12];
        if (isLowerCase(r14) == false) goto L11;
        r13[r12] = (char) (r14 ^ ' ');
    L11:
        r12 = r12 + 1;
        goto L7
    L13:
        return String.valueOf(r13);
    L15:
        return r10;
    }

    public static String truncate(CharSequence r10, int r11, String r12) {
        Preconditions.checkNotNull(r10);
        int r13 = r11 - r12.length();
        if (r13 < 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14, "maxLength (%s) must be >= length of the truncation indicator (%s)", r11, r12.length());
        int r15 = r10.length();
        CharSequence r16 = r10;
        if (r15 > r11) goto L11;
        String r17 = r10.toString();
        int r18 = r17.length();
        r16 = r17;
        if (r18 > r11) goto L11;
        return r17;
    L11:
        StringBuilder r19 = new StringBuilder(r11);
        r19.append(r16, 0, r13);
        r19.append(r12);
        return r19.toString();
    L5:
        r14 = false;
        goto L6
    }

    public static String toLowerCase(CharSequence r10) {
        if ((r10 instanceof String) == true) goto L5;
        int r11 = r10.length();
        char[] r12 = new char[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L10;
        r12[r13] = toLowerCase(r10.charAt(r13));
        r13 = r13 + 1;
        goto L7
    L10:
        return String.valueOf(r12);
    L5:
        return toLowerCase((String) r10);
    }

    public static String toUpperCase(CharSequence r10) {
        if ((r10 instanceof String) == true) goto L5;
        int r11 = r10.length();
        char[] r12 = new char[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L10;
        r12[r13] = toUpperCase(r10.charAt(r13));
        r13 = r13 + 1;
        goto L7
    L10:
        return String.valueOf(r12);
    L5:
        return toUpperCase((String) r10);
    }

    public static char toLowerCase(char r10) {
        if (isUpperCase(r10) == true) goto L5;
        return r10;
    L5:
        return (char) (r10 ^ ' ');
    }

    public static char toUpperCase(char r10) {
        if (isLowerCase(r10) == true) goto L5;
        return r10;
    L5:
        return (char) (r10 ^ ' ');
    }
}
