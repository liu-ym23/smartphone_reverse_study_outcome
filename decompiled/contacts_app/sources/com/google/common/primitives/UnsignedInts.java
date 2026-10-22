package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedInts {
    static final long INT_MASK = 4294967295L;

    static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<int[]> {
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
        public /* bridge */ /* synthetic */ int compare(int[] r1, int[] r2) {
            return compare2(r1, r2);
        }

        static {
            LexicographicalComparator r0 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new LexicographicalComparator[]{r0};
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r4, int[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L10;
            int r1 = r4[r0];
            int r2 = r5[r0];
            if (r1 != r2) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return UnsignedInts.compare(r1, r2);
        L10:
            return r4.length - r5.length;
        }
    }

    static int flip(int r1) {
        return r1 ^ Integer.MIN_VALUE;
    }

    public static long toLong(int r4) {
        return ((long) r4) & INT_MASK;
    }

    private UnsignedInts() {
    }

    public static int compare(int r0, int r1) {
        return Ints.compare(flip(r0), flip(r1));
    }

    public static int min(int... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        int r1 = flip(r3[0]);
    L8:
        if (r2 >= r3.length) goto L14;
        int r4 = flip(r3[r2]);
        if (r4 >= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return flip(r1);
    L5:
        r0 = false;
        goto L6
    }

    public static int max(int... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        int r1 = flip(r3[0]);
    L8:
        if (r2 >= r3.length) goto L14;
        int r4 = flip(r3[r2]);
        if (r4 <= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return flip(r1);
    L5:
        r0 = false;
        goto L6
    }

    public static String join(String r4, int... r5) {
        Preconditions.checkNotNull(r4);
        if (r5.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r5.length * 5);
        r0.append(toString(r5[0]));
        int r1 = 1;
    L8:
        if (r1 >= r5.length) goto L11;
        r0.append(r4).append(toString(r5[r1]));
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int divide(int r2, int r3) {
        return (int) (toLong(r2) / toLong(r3));
    }

    public static int remainder(int r2, int r3) {
        return (int) (toLong(r2) % toLong(r3));
    }

    public static int decode(String r4) {
        ParseRequest r0 = ParseRequest.fromString(r4);
        return parseUnsignedInt(r0.rawValue, r0.radix);
    L5:
        e = move-exception;
        NumberFormatException r1 = new NumberFormatException("Error parsing value: " + r4);
        r1.initCause(e);
        throw r1;
    }

    public static int parseUnsignedInt(String r1) {
        return parseUnsignedInt(r1, 10);
    }

    public static int parseUnsignedInt(String r4, int r5) {
        Preconditions.checkNotNull(r4);
        long r0 = Long.parseLong(r4, r5);
        if ((INT_MASK & r0) != r0) goto L7;
        return (int) r0;
    L7:
        throw new NumberFormatException("Input " + r4 + " in base " + r5 + " is not in the range of an unsigned integer");
    }

    public static String toString(int r1) {
        return toString(r1, 10);
    }

    public static String toString(int r4, int r5) {
        return Long.toString(((long) r4) & INT_MASK, r5);
    }
}
