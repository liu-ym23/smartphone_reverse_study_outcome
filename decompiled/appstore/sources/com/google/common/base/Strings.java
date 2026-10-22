package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Strings {
    private Strings() {
    }

    public static String commonPrefix(CharSequence r10, CharSequence r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = Math.min(r10.length(), r11.length());
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L7;
        if (r10.charAt(r13) != r11.charAt(r13)) goto L7;
        r13 = r13 + 1;
    L7:
        int r14 = r13 - 1;
        if (validSurrogatePairAt(r10, r14) == false) goto L10;
    L11:
        r13 = r13 - 1;
    L13:
        return r10.subSequence(0, r13).toString();
    L10:
        if (validSurrogatePairAt(r11, r14) == false) goto L13;
        goto L11
    }

    public static String commonSuffix(CharSequence r10, CharSequence r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        int r12 = Math.min(r10.length(), r11.length());
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r10.charAt((r10.length() - r13) - 1) != r11.charAt((r11.length() - r13) - 1)) goto L8;
        r13 = r13 + 1;
    L8:
        if (validSurrogatePairAt(r10, (r10.length() - r13) - 1) == false) goto L10;
    L11:
        r13 = r13 - 1;
    L13:
        return r10.subSequence(r10.length() - r13, r10.length()).toString();
    L10:
        if (validSurrogatePairAt(r11, (r11.length() - r13) - 1) == false) goto L13;
        goto L11
    }

    @NullableDecl
    public static String emptyToNull(@NullableDecl String r10) {
        return Platform.emptyToNull(r10);
    }

    public static boolean isNullOrEmpty(@NullableDecl String r10) {
        return Platform.stringIsNullOrEmpty(r10);
    }

    public static String lenientFormat(@NullableDecl String r10, @NullableDecl Object... r11) {
        String r12 = String.valueOf(r10);
        int r13 = 0;
        if (r11 != null) goto L5;
        r11 = new Object[]{"(Object[])null"};
    L9:
        StringBuilder r14 = new StringBuilder(r12.length() + (r11.length * 16));
        int r15 = 0;
    L11:
        if (r13 >= r11.length) goto L16;
        int r16 = r12.indexOf("%s", r15);
        if (r16 == (-1)) goto L16;
        r14.append(r12, r15, r16);
        r14.append(r11[r13]);
        r15 = r16 + 2;
        r13 = r13 + 1;
    L16:
        r14.append(r12, r15, r12.length());
        if (r13 >= r11.length) goto L24;
        r14.append(" [");
        int r17 = r13 + 1;
        r14.append(r11[r13]);
    L20:
        if (r17 >= r11.length) goto L22;
        r14.append(", ");
        r14.append(r11[r17]);
        r17 = r17 + 1;
        goto L20
    L22:
        r14.append(']');
    L24:
        return r14.toString();
    L5:
        int r18 = 0;
    L7:
        if (r18 >= r11.length) goto L9;
        r11[r18] = lenientToString(r11[r18]);
        r18 = r18 + 1;
        goto L7
    }

    private static String lenientToString(@NullableDecl Object r10) {
        return String.valueOf(r10);
    L4:
        e = move-exception;
        String r11 = r10.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(r10));
        Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + r11, e);
        return "<" + r11 + " threw " + e.getClass().getName() + ">";
    }

    public static String nullToEmpty(@NullableDecl String r10) {
        return Platform.nullToEmpty(r10);
    }

    public static String padEnd(String r10, int r11, char r12) {
        Preconditions.checkNotNull(r10);
        if (r10.length() < r11) goto L5;
        return r10;
    L5:
        StringBuilder r13 = new StringBuilder(r11);
        r13.append(r10);
        int r14 = r10.length();
    L6:
        if (r14 >= r11) goto L9;
        r13.append(r12);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13.toString();
    }

    public static String padStart(String r10, int r11, char r12) {
        Preconditions.checkNotNull(r10);
        if (r10.length() < r11) goto L5;
        return r10;
    L5:
        StringBuilder r13 = new StringBuilder(r11);
        int r14 = r10.length();
    L6:
        if (r14 >= r11) goto L8;
        r13.append(r12);
        r14 = r14 + 1;
        goto L6
    L8:
        r13.append(r10);
        return r13.toString();
    }

    public static String repeat(String r10, int r11) {
        Preconditions.checkNotNull(r10);
        boolean r12 = false;
        if (r11 > 1) goto L10;
        if (r11 < 0) goto L6;
        r12 = true;
    L6:
        Preconditions.checkArgument(r12, "invalid count: %s", r11);
        if (r11 != 0) goto L21;
        return "";
    L21:
        return r10;
    L10:
        int r13 = r10.length();
        long r14 = ((long) r13) * ((long) r11);
        int r15 = (int) r14;
        if (r15 != r14) goto L19;
        char[] r16 = new char[r15];
        r10.getChars(0, r13, r16, 0);
    L13:
        int r17 = r15 - r13;
        if (r13 >= r17) goto L16;
        System.arraycopy(r16, 0, r16, r13, r13);
        r13 = r13 << 1;
        goto L13
    L16:
        System.arraycopy(r16, 0, r16, r13, r17);
        return new String(r16);
    L19:
        throw new ArrayIndexOutOfBoundsException("Required array size too large: " + r14);
    }

    @VisibleForTesting
    public static boolean validSurrogatePairAt(CharSequence r10, int r11) {
        if (r11 >= 0) goto L4;
    L10:
        return false;
    L4:
        if (r11 > (r10.length() - 2)) goto L10;
        if (Character.isHighSurrogate(r10.charAt(r11)) == false) goto L10;
        if (Character.isLowSurrogate(r10.charAt(r11 + 1)) == false) goto L10;
        return true;
    }
}
