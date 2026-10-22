package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;
    private static final int[] maxSafeDigits = null;
    private static final long[] maxValueDivs = null;
    private static final int[] maxValueMods = null;

    static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        private LexicographicalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static LexicographicalComparator valueOf(String r1) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, r1);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(long[] r1, long[] r2) {
            return compare2(r1, r2);
        }

        static {
            LexicographicalComparator r0 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new LexicographicalComparator[]{r0};
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r7, long[] r8) {
            int r6 = Math.min(r7.length, r8.length);
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L10;
            long r1 = r7[r0];
            long r3 = r8[r0];
            if (r1 != r3) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return UnsignedLongs.compare(r1, r3);
        L10:
            return r7.length - r8.length;
        }
    }

    private static long flip(long r2) {
        return r2 ^ Long.MIN_VALUE;
    }

    private UnsignedLongs() {
    }

    public static int compare(long r0, long r2) {
        return Longs.compare(flip(r0), flip(r2));
    }

    public static long min(long... r6) {
        int r2 = 1;
        if (r6.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        long r1 = flip(r6[0]);
    L8:
        if (r2 >= r6.length) goto L14;
        long r3 = flip(r6[r2]);
        if (r3 >= r1) goto L12;
        r1 = r3;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return flip(r1);
    L5:
        r0 = false;
        goto L6
    }

    public static long max(long... r6) {
        int r2 = 1;
        if (r6.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        long r1 = flip(r6[0]);
    L8:
        if (r2 >= r6.length) goto L14;
        long r3 = flip(r6[r2]);
        if (r3 <= r1) goto L12;
        r1 = r3;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return flip(r1);
    L5:
        r0 = false;
        goto L6
    }

    public static String join(String r5, long... r6) {
        Preconditions.checkNotNull(r5);
        if (r6.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r6.length * 5);
        r0.append(toString(r6[0]));
        int r1 = 1;
    L8:
        if (r1 >= r6.length) goto L11;
        r0.append(r5).append(toString(r6[r1]));
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long divide(long r5, long r7) {
        if (r7 >= 0) goto L10;
        if (compare(r5, r7) >= 0) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (r5 >= 0) goto L12;
        int r0 = 1;
        long r1 = ((r5 >>> 1) / r7) << 1;
        if (compare(r5 - (r1 * r7), r7) >= 0) goto L18;
        r0 = 0;
    L18:
        return r1 + ((long) r0);
    L12:
        return r5 / r7;
    }

    public static long remainder(long r5, long r7) {
        if (r7 >= 0) goto L10;
        if (compare(r5, r7) >= 0) goto L8;
        return r5;
    L8:
        return r5 - r7;
    L10:
        if (r5 >= 0) goto L12;
        long r6 = r5 - ((((r5 >>> 1) / r7) << 1) * r7);
        if (compare(r6, r7) >= 0) goto L18;
        r7 = 0;
    L18:
        return r6 - r7;
    L12:
        return r5 % r7;
    }

    public static long parseUnsignedLong(String r2) {
        return parseUnsignedLong(r2, 10);
    }

    public static long decode(String r4) {
        ParseRequest r0 = ParseRequest.fromString(r4);
        return parseUnsignedLong(r0.rawValue, r0.radix);
    L5:
        e = move-exception;
        NumberFormatException r1 = new NumberFormatException("Error parsing value: " + r4);
        r1.initCause(e);
        throw r1;
    }

    public static long parseUnsignedLong(String r7, int r8) {
        Preconditions.checkNotNull(r7);
        if (r7.length() == 0) goto L26;
        if (r8 < 2) goto L24;
        if (r8 > 36) goto L24;
        int r0 = maxSafeDigits[r8] - 1;
        long r1 = 0;
        int r3 = 0;
    L10:
        if (r3 >= r7.length()) goto L22;
        int r4 = Character.digit(r7.charAt(r3), r8);
        if (r4 == (-1)) goto L21;
        if (r3 <= r0) goto L19;
        if (overflowInParse(r1, r4, r8) == false) goto L19;
        throw new NumberFormatException("Too large for unsigned long: " + r7);
    L19:
        r1 = (r1 * ((long) r8)) + ((long) r4);
        r3 = r3 + 1;
        goto L10
    L21:
        throw new NumberFormatException(r7);
    L22:
        return r1;
    L24:
        throw new NumberFormatException("illegal radix: " + r8);
    L26:
        throw new NumberFormatException("empty string");
    }

    private static boolean overflowInParse(long r5, int r7, int r8) {
        if (r5 < 0) goto L15;
        long r2 = maxValueDivs[r8];
        if (r5 >= r2) goto L8;
        return false;
    L8:
        if (r5 <= r2) goto L11;
        return true;
    L11:
        if (r7 <= maxValueMods[r8]) goto L14;
        return true;
    L14:
        return false;
    L15:
        return true;
    }

    public static String toString(long r1) {
        return toString(r1, 10);
    }

    public static String toString(long r9, int r11) {
        if (r11 >= 2) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", new Object[]{Integer.valueOf(r11)});
        if (r9 != 0) goto L12;
        return "0";
    L12:
        int r3 = 64;
        char[] r4 = new char[64];
        if (r9 >= 0) goto L16;
        long r2 = r11;
        long r5 = divide(r9, r2);
        r3 = 63;
        r4[63] = Character.forDigit((int) (r9 - (r2 * r5)), r11);
        r9 = r5;
    L16:
        if (r9 <= 0) goto L19;
        r3 = r3 - 1;
        long r6 = r11;
        r4[r3] = Character.forDigit((int) (r9 % r6), r11);
        r9 = r9 / r6;
        goto L16
    L19:
        return new String(r4, r3, 64 - r3);
    L5:
        if (r11 > 36) goto L7;
        r0 = true;
        goto L8
    }

    static {
        maxValueDivs = new long[37];
        maxValueMods = new int[37];
        maxSafeDigits = new int[37];
        BigInteger r0 = new BigInteger("10000000000000000", 16);
        int r1 = 2;
    L4:
        if (r1 > 36) goto L6;
        long r3 = r1;
        maxValueDivs[r1] = divide(-1, r3);
        maxValueMods[r1] = (int) remainder(-1, r3);
        maxSafeDigits[r1] = r0.toString(r1).length() - 1;
        r1 = r1 + 1;
        goto L4
    }
}
