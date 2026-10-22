package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    static class LexicographicalComparatorHolder {
        static final Comparator<byte[]> BEST_COMPARATOR = null;

        static final enum PureJavaComparator extends Enum<PureJavaComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ PureJavaComparator[] $VALUES = null;
            public static final PureJavaComparator INSTANCE = null;

            private PureJavaComparator(String r1, int r2) {
                super(r1, r2);
            }

            public static PureJavaComparator valueOf(String r1) {
                return (PureJavaComparator) Enum.valueOf(PureJavaComparator.class, r1);
            }

            public static PureJavaComparator[] values() {
                return (PureJavaComparator[]) $VALUES.clone();
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(byte[] r1, byte[] r2) {
                return compare2(r1, r2);
            }

            static {
                PureJavaComparator r0 = new PureJavaComparator("INSTANCE", 0);
                INSTANCE = r0;
                $VALUES = new PureJavaComparator[]{r0};
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r4, byte[] r5) {
                int r3 = Math.min(r4.length, r5.length);
                int r0 = 0;
            L3:
                if (r0 >= r3) goto L9;
                int r1 = UnsignedBytes.compare(r4[r0], r5[r0]);
                if (r1 != 0) goto L6;
                r0 = r0 + 1;
                goto L3
            L6:
                return r1;
            L9:
                return r4.length - r5.length;
            }
        }

        LexicographicalComparatorHolder() {
        }

        static {
            BEST_COMPARATOR = UnsignedBytes.lexicographicalComparatorJavaImpl();
        }
    }

    public static int toInt(byte r0) {
        return r0 & 255;
    }

    private UnsignedBytes() {
    }

    public static byte checkedCast(long r4) {
        if ((r4 >> 8) != 0) goto L7;
        return (byte) r4;
    L7:
        throw new IllegalArgumentException("Out of range: " + r4);
    }

    public static byte saturatedCast(long r3) {
        if (r3 <= toInt((byte) -1)) goto L6;
        return -1;
    L6:
        if (r3 >= 0) goto L10;
        return 0;
    L10:
        return (byte) r3;
    }

    public static int compare(byte r0, byte r1) {
        return toInt(r0) - toInt(r1);
    }

    public static byte min(byte... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        int r1 = toInt(r3[0]);
    L8:
        if (r2 >= r3.length) goto L14;
        int r4 = toInt(r3[r2]);
        if (r4 >= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return (byte) r1;
    L5:
        r0 = false;
        goto L6
    }

    public static byte max(byte... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        int r1 = toInt(r3[0]);
    L8:
        if (r2 >= r3.length) goto L14;
        int r4 = toInt(r3[r2]);
        if (r4 <= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return (byte) r1;
    L5:
        r0 = false;
        goto L6
    }

    public static String toString(byte r1) {
        return toString(r1, 10);
    }

    public static String toString(byte r4, int r5) {
        if (r5 >= 2) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", new Object[]{Integer.valueOf(r5)});
        return Integer.toString(toInt(r4), r5);
    L5:
        if (r5 > 36) goto L7;
        r0 = true;
        goto L8
    }

    public static byte parseUnsignedByte(String r1) {
        return parseUnsignedByte(r1, 10);
    }

    public static byte parseUnsignedByte(String r2, int r3) {
        int r4 = Integer.parseInt((String) Preconditions.checkNotNull(r2), r3);
        if ((r4 >> 8) != 0) goto L7;
        return (byte) r4;
    L7:
        throw new NumberFormatException("out of range: " + r4);
    }

    public static String join(String r4, byte... r5) {
        Preconditions.checkNotNull(r4);
        if (r5.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r5.length * (r4.length() + 3));
        r0.append(toInt(r5[0]));
        int r1 = 1;
    L8:
        if (r1 >= r5.length) goto L11;
        r0.append(r4).append(toString(r5[r1]));
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }
}
