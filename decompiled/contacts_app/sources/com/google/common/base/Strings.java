package com.google.common.base;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Strings {
    public static String nullToEmpty(@Nullable String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    private Strings() {
    }

    @Nullable
    public static String emptyToNull(@Nullable String r1) {
        if (isNullOrEmpty(r1) == false) goto L6;
        return null;
    L6:
        return r1;
    }

    public static boolean isNullOrEmpty(@Nullable String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static String padStart(String r2, int r3, char r4) {
        Preconditions.checkNotNull(r2);
        if (r2.length() < r3) goto L5;
        return r2;
    L5:
        StringBuilder r0 = new StringBuilder(r3);
        int r1 = r2.length();
    L6:
        if (r1 >= r3) goto L8;
        r0.append(r4);
        r1 = r1 + 1;
        goto L6
    L8:
        r0.append(r2);
        return r0.toString();
    }

    public static String padEnd(String r1, int r2, char r3) {
        Preconditions.checkNotNull(r1);
        if (r1.length() < r2) goto L5;
        return r1;
    L5:
        StringBuilder r0 = new StringBuilder(r2);
        r0.append(r1);
        int r4 = r1.length();
    L6:
        if (r4 >= r2) goto L9;
        r0.append(r3);
        r4 = r4 + 1;
        goto L6
    L9:
        return r0.toString();
    }

    public static String repeat(String r6, int r7) {
        Preconditions.checkNotNull(r6);
        if (r7 > 1) goto L11;
        if (r7 < 0) goto L6;
        boolean r2 = true;
    L7:
        Preconditions.checkArgument(r2, "invalid count: %s", new Object[]{Integer.valueOf(r7)});
        if (r7 != 0) goto L22;
        return "";
    L22:
        return r6;
    L6:
        r2 = false;
        goto L7
    L11:
        int r1 = r6.length();
        long r3 = ((long) r1) * ((long) r7);
        int r8 = (int) r3;
        if (r8 != r3) goto L20;
        char[] r4 = new char[r8];
        r6.getChars(0, r1, r4, 0);
    L14:
        int r9 = r8 - r1;
        if (r1 >= r9) goto L17;
        System.arraycopy(r4, 0, r4, r1, r1);
        r1 = r1 << 1;
        goto L14
    L17:
        System.arraycopy(r4, 0, r4, r1, r9);
        return new String(r4);
    L20:
        throw new ArrayIndexOutOfBoundsException("Required array size too large: " + r3);
    }

    public static String commonPrefix(CharSequence r5, CharSequence r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        int r0 = Math.min(r5.length(), r6.length());
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L7;
        if (r5.charAt(r2) != r6.charAt(r2)) goto L7;
        r2 = r2 + 1;
    L7:
        int r1 = r2 - 1;
        if (validSurrogatePairAt(r5, r1) == false) goto L10;
    L11:
        r2 = r2 - 1;
    L13:
        return r5.subSequence(0, r2).toString();
    L10:
        if (validSurrogatePairAt(r6, r1) == false) goto L13;
        goto L11
    }

    public static String commonSuffix(CharSequence r4, CharSequence r5) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        int r0 = Math.min(r4.length(), r5.length());
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4.charAt((r4.length() - r1) - 1) != r5.charAt((r5.length() - r1) - 1)) goto L8;
        r1 = r1 + 1;
    L8:
        if (validSurrogatePairAt(r4, (r4.length() - r1) - 1) == false) goto L10;
    L11:
        r1 = r1 - 1;
    L13:
        return r4.subSequence(r4.length() - r1, r4.length()).toString();
    L10:
        if (validSurrogatePairAt(r5, (r5.length() - r1) - 1) == false) goto L13;
        goto L11
    }

    static boolean validSurrogatePairAt(CharSequence r1, int r2) {
        if (r2 >= 0) goto L4;
    L10:
        return false;
    L4:
        if (r2 > (r1.length() - 2)) goto L10;
        if (Character.isHighSurrogate(r1.charAt(r2)) == false) goto L10;
        if (Character.isLowSurrogate(r1.charAt(r2 + 1)) == false) goto L10;
        return true;
    }
}
