package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class UnsignedInts {
    static final long INT_MASK = 4294967295L;

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<int[]> {
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
        public /* bridge */ /* synthetic */ int compare(int[] r10, int[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r10, int[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            int r14 = r10[r13];
            int r15 = r11[r13];
            if (r14 != r15) goto L7;
            r13 = r13 + 1;
            goto L3
        L7:
            return UnsignedInts.compare(r14, r15);
        L10:
            return r10.length - r11.length;
        }
    }

    private UnsignedInts() {
    }

    public static int checkedCast(long r10) {
        if ((r10 >> 32) != 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "out of range: %s", r10);
        return (int) r10;
    L5:
        r11 = false;
        goto L6
    }

    public static int compare(int r10, int r11) {
        return Ints.compare(flip(r10), flip(r11));
    }

    @CanIgnoreReturnValue
    public static int decode(String r10) {
        ParseRequest r11 = ParseRequest.fromString(r10);
        return parseUnsignedInt(r11.rawValue, r11.radix);
    L5:
        e = move-exception;
        NumberFormatException r12 = new NumberFormatException("Error parsing value: " + r10);
        r12.initCause(e);
        throw r12;
    }

    public static int divide(int r10, int r11) {
        return (int) (toLong(r10) / toLong(r11));
    }

    public static int flip(int r10) {
        return r10 ^ Integer.MIN_VALUE;
    }

    public static String join(String r10, int... r11) {
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

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = flip(r10[0]);
    L8:
        if (r11 >= r10.length) goto L14;
        int r14 = flip(r10[r11]);
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

    public static int min(int... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = flip(r10[0]);
    L8:
        if (r11 >= r10.length) goto L14;
        int r14 = flip(r10[r11]);
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
    public static int parseUnsignedInt(String r10) {
        return parseUnsignedInt(r10, 10);
    }

    public static int remainder(int r10, int r11) {
        return (int) (toLong(r10) % toLong(r11));
    }

    public static int saturatedCast(long r10) {
        if (r10 > 0) goto L7;
        return 0;
    L7:
        if (r10 < 4294967296L) goto L11;
        return -1;
    L11:
        return (int) r10;
    }

    public static void sort(int[] r10) {
        Preconditions.checkNotNull(r10);
        sort(r10, 0, r10.length);
    }

    public static void sortDescending(int[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    public static long toLong(int r10) {
        return ((long) r10) & INT_MASK;
    }

    public static String toString(int r10) {
        return toString(r10, 10);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String r10, int r11) {
        Preconditions.checkNotNull(r10);
        long r12 = Long.parseLong(r10, r11);
        if ((INT_MASK & r12) != r12) goto L7;
        return (int) r12;
    L7:
        throw new NumberFormatException("Input " + r10 + " in base " + r11 + " is not in the range of an unsigned integer");
    }

    public static String toString(int r10, int r11) {
        return Long.toString(((long) r10) & INT_MASK, r11);
    }

    public static void sort(int[] r10, int r11, int r12) {
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

    public static void sortDescending(int[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r11;
    L4:
        if (r13 >= r12) goto L6;
        r10[r13] = Integer.MAX_VALUE ^ r10[r13];
        r13 = r13 + 1;
        goto L4
    L6:
        Arrays.sort(r10, r11, r12);
    L7:
        if (r11 >= r12) goto L9;
        r10[r11] = r10[r11] ^ Channel.UNLIMITED;
        r11 = r11 + 1;
        goto L7
    }
}
