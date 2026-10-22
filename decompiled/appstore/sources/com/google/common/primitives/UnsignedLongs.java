package com.google.common.primitives;

import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        static {
            LexicographicalComparator r10 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new LexicographicalComparator[]{r10};
        }

        private LexicographicalComparator(String r10, int r11) {
            super(r10, r11);
        }

        public static LexicographicalComparator valueOf(String r10) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, r10);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(long[] r10, long[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r10, long[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            long r14 = r10[r13];
            long r15 = r11[r13];
            if (r14 != r15) goto L7;
            r13 = r13 + 1;
            goto L3
        L7:
            return UnsignedLongs.compare(r14, r15);
        L10:
            return r10.length - r11.length;
        }
    }

    public static final class ParseOverflowDetection {
        static final int[] maxSafeDigits = null;
        static final long[] maxValueDivs = null;
        static final int[] maxValueMods = null;

        static {
            maxValueDivs = new long[37];
            maxValueMods = new int[37];
            maxSafeDigits = new int[37];
            BigInteger r10 = new BigInteger("10000000000000000", 16);
            int r11 = 2;
        L4:
            if (r11 > 36) goto L6;
            long r12 = r11;
            maxValueDivs[r11] = UnsignedLongs.divide(-1, r12);
            maxValueMods[r11] = (int) UnsignedLongs.remainder(-1, r12);
            maxSafeDigits[r11] = r10.toString(r11).length() - 1;
            r11 = r11 + 1;
            goto L4
        }

        private ParseOverflowDetection() {
        }

        public static boolean overflowInParse(long r10, int r11, int r12) {
            if (r10 < 0) goto L15;
            long r13 = maxValueDivs[r12];
            if (r10 >= r13) goto L8;
            return false;
        L8:
            if (r10 <= r13) goto L11;
            return true;
        L11:
            if (r11 <= maxValueMods[r12]) goto L14;
            return true;
        L14:
            return false;
        L15:
            return true;
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long r10, long r11) {
        return Longs.compare(flip(r10), flip(r11));
    }

    @CanIgnoreReturnValue
    public static long decode(String r10) {
        ParseRequest r11 = ParseRequest.fromString(r10);
        return parseUnsignedLong(r11.rawValue, r11.radix);
    L5:
        e = move-exception;
        NumberFormatException r12 = new NumberFormatException("Error parsing value: " + r10);
        r12.initCause(e);
        throw r12;
    }

    public static long divide(long r10, long r11) {
        if (r11 >= 0) goto L10;
        if (compare(r10, r11) >= 0) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (r10 >= 0) goto L12;
        int r12 = 1;
        long r13 = ((r10 >>> 1) / r11) << 1;
        if (compare(r10 - (r13 * r11), r11) >= 0) goto L18;
        r12 = 0;
    L18:
        return r13 + ((long) r12);
    L12:
        return r10 / r11;
    }

    private static long flip(long r10) {
        return r10 ^ Long.MIN_VALUE;
    }

    public static String join(String r10, long... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 5);
        r12.append(toString(r11[0]));
        int r13 = 1;
    L8:
        if (r13 >= r11.length) goto L11;
        r12.append(r10);
        r12.append(toString(r11[r13]));
        r13 = r13 + 1;
        goto L8
    L11:
        return r12.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        long r13 = flip(r10[0]);
    L8:
        if (r11 >= r10.length) goto L14;
        long r14 = flip(r10[r11]);
        if (r14 <= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L14:
        return flip(r13);
    L5:
        r12 = false;
        goto L6
    }

    public static long min(long... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        long r13 = flip(r10[0]);
    L8:
        if (r11 >= r10.length) goto L14;
        long r14 = flip(r10[r11]);
        if (r14 >= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L14:
        return flip(r13);
    L5:
        r12 = false;
        goto L6
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String r10) {
        return parseUnsignedLong(r10, 10);
    }

    public static long remainder(long r10, long r11) {
        if (r11 >= 0) goto L10;
        if (compare(r10, r11) >= 0) goto L8;
        return r10;
    L8:
        return r10 - r11;
    L10:
        if (r10 >= 0) goto L12;
        long r12 = r10 - ((((r10 >>> 1) / r11) << 1) * r11);
        if (compare(r12, r11) >= 0) goto L18;
        r11 = 0;
    L18:
        return r12 - r11;
    L12:
        return r10 % r11;
    }

    public static void sort(long[] r10) {
        Preconditions.checkNotNull(r10);
        sort(r10, 0, r10.length);
    }

    public static void sortDescending(long[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    public static String toString(long r10) {
        return toString(r10, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String r10, int r11) {
        Preconditions.checkNotNull(r10);
        if (r10.length() == 0) goto L26;
        if (r11 < 2) goto L24;
        if (r11 > 36) goto L24;
        int r12 = ParseOverflowDetection.maxSafeDigits[r11] - 1;
        long r13 = 0;
        int r14 = 0;
    L10:
        if (r14 >= r10.length()) goto L22;
        int r15 = Character.digit(r10.charAt(r14), r11);
        if (r15 == (-1)) goto L21;
        if (r14 <= r12) goto L19;
        if (ParseOverflowDetection.overflowInParse(r13, r15, r11) == false) goto L19;
        throw new NumberFormatException("Too large for unsigned long: " + r10);
    L19:
        r13 = (r13 * ((long) r11)) + ((long) r15);
        r14 = r14 + 1;
        goto L10
    L21:
        throw new NumberFormatException(r10);
    L22:
        return r13;
    L24:
        throw new NumberFormatException("illegal radix: " + r11);
    L26:
        throw new NumberFormatException("empty string");
    }

    public static String toString(long r10, int r11) {
        if (r11 >= 2) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Preconditions.checkArgument(r12, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", r11);
        if (r10 != 0) goto L12;
        return AdReportParam.ClickPosType.SKIP;
    L12:
        if (r10 > 0) goto L14;
        int r13 = 64;
        char[] r14 = new char[64];
        int r15 = r11 - 1;
        if ((r11 & r15) != 0) goto L22;
        int r16 = Integer.numberOfTrailingZeros(r11);
    L18:
        r13 = r13 - 1;
        r14[r13] = Character.forDigit(((int) r10) & r15, r11);
        r10 = r10 >>> r16;
        if (r10 != 0) goto L18;
    L31:
        return new String(r14, r13, 64 - r13);
    L22:
        if ((r11 & 1) != 0) goto L24;
        long r17 = (r10 >>> 1) / ((long) (r11 >>> 1));
    L25:
        long r18 = r11;
        int r19 = 63;
        r14[63] = Character.forDigit((int) (r10 - (r17 * r18)), r11);
    L27:
        if (r17 <= 0) goto L29;
        r19 = r19 - 1;
        r14[r19] = Character.forDigit((int) (r17 % r18), r11);
        r17 = r17 / r18;
        goto L27
    L29:
        r13 = r19;
        goto L31
    L24:
        r17 = divide(r10, r11);
        goto L25
    L14:
        return Long.toString(r10, r11);
    L5:
        if (r11 > 36) goto L7;
        r12 = true;
        goto L8
    }

    public static void sort(long[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r11;
    L3:
        if (r13 >= r12) goto L5;
        r10[r13] = flip(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        Arrays.sort(r10, r11, r12);
    L6:
        if (r11 >= r12) goto L8;
        r10[r11] = flip(r10[r11]);
        r11 = r11 + 1;
        goto L6
    }

    public static void sortDescending(long[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r11;
    L4:
        if (r13 >= r12) goto L6;
        r10[r13] = Long.MAX_VALUE ^ r10[r13];
        r13 = r13 + 1;
        goto L4
    L6:
        Arrays.sort(r10, r11, r12);
    L7:
        if (r11 >= r12) goto L9;
        r10[r11] = r10[r11] ^ Long.MAX_VALUE;
        r11 = r11 + 1;
        goto L7
    }
}
