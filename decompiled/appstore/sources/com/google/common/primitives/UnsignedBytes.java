package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Comparator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    @VisibleForTesting
    public static class LexicographicalComparatorHolder {
        static final Comparator<byte[]> BEST_COMPARATOR = null;
        static final String UNSAFE_COMPARATOR_NAME = null;

        public static final enum PureJavaComparator extends Enum<PureJavaComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ PureJavaComparator[] $VALUES = null;
            public static final PureJavaComparator INSTANCE = null;

            static {
                PureJavaComparator r10 = new PureJavaComparator("INSTANCE", 0);
                INSTANCE = r10;
                $VALUES = new PureJavaComparator[]{r10};
            }

            private PureJavaComparator(String r10, int r11) {
                super(r10, r11);
            }

            public static PureJavaComparator valueOf(String r10) {
                return (PureJavaComparator) Enum.valueOf(PureJavaComparator.class, r10);
            }

            public static PureJavaComparator[] values() {
                return (PureJavaComparator[]) $VALUES.clone();
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(byte[] r10, byte[] r11) {
                return compare2(r10, r11);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r10, byte[] r11) {
                int r12 = Math.min(r10.length, r11.length);
                int r13 = 0;
            L3:
                if (r13 >= r12) goto L9;
                int r14 = UnsignedBytes.compare(r10[r13], r11[r13]);
                if (r14 != 0) goto L6;
                r13 = r13 + 1;
                goto L3
            L6:
                return r14;
            L9:
                return r10.length - r11.length;
            }
        }

        @VisibleForTesting
        public static final enum UnsafeComparator extends Enum<UnsafeComparator> implements Comparator<byte[]> {
            private static final /* synthetic */ UnsafeComparator[] $VALUES = null;
            static final boolean BIG_ENDIAN = false;
            static final int BYTE_ARRAY_BASE_OFFSET = 0;
            public static final UnsafeComparator INSTANCE = null;
            static final Unsafe theUnsafe = null;

            static {
                UnsafeComparator r10 = new UnsafeComparator("INSTANCE", 0);
                INSTANCE = r10;
                $VALUES = new UnsafeComparator[]{r10};
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                Unsafe r11 = getUnsafe();
                theUnsafe = r11;
                int r12 = r11.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = r12;
                if ("64".equals(System.getProperty("sun.arch.data.model")) == false) goto L10;
                if ((r12 % 8) != 0) goto L10;
                if (r11.arrayIndexScale(byte[].class) != 1) goto L10;
                return;
            L10:
                throw new Error();
            }

            private UnsafeComparator(String r10, int r11) {
                super(r10, r11);
            }

            private static Unsafe getUnsafe() {
                return Unsafe.getUnsafe();
            L4:
                return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
            L6:
                e = move-exception;
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }

            public static UnsafeComparator valueOf(String r10) {
                return (UnsafeComparator) Enum.valueOf(UnsafeComparator.class, r10);
            }

            public static UnsafeComparator[] values() {
                return (UnsafeComparator[]) $VALUES.clone();
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(byte[] r10, byte[] r11) {
                return compare2(r10, r11);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(byte[] r11, byte[] r12) {
                int r10 = Math.min(r11.length, r12.length);
                int r13 = r10 & (-8);
                int r14 = 0;
            L3:
                if (r14 >= r13) goto L13;
                Unsafe r15 = theUnsafe;
                int r16 = BYTE_ARRAY_BASE_OFFSET;
                long r17 = r14;
                long r18 = r15.getLong(r11, ((long) r16) + r17);
                long r19 = r15.getLong(r12, ((long) r16) + r17);
                if (r18 != r19) goto L7;
                r14 = r14 + 8;
                goto L3
            L7:
                if (BIG_ENDIAN == true) goto L9;
                int r110 = Long.numberOfTrailingZeros(r18 ^ r19) & (-8);
                return ((int) ((r18 >>> r110) & 255)) - ((int) (255 & (r19 >>> r110)));
            L9:
                return UnsignedLongs.compare(r18, r19);
            L13:
                if (r14 >= r10) goto L19;
                int r20 = UnsignedBytes.compare(r11[r14], r12[r14]);
                if (r20 != 0) goto L16;
                r14 = r14 + 1;
                goto L13
            L16:
                return r20;
            L19:
                return r11.length - r12.length;
            }
        }

        static {
            UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
            BEST_COMPARATOR = getBestComparator();
        }

        public LexicographicalComparatorHolder() {
        }

        public static Comparator<byte[]> getBestComparator() {
            return (Comparator) Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
        L5:
            return UnsignedBytes.lexicographicalComparatorJavaImpl();
        }
    }

    private UnsignedBytes() {
    }

    @CanIgnoreReturnValue
    public static byte checkedCast(long r10) {
        if ((r10 >> 8) != 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "out of range: %s", r10);
        return (byte) r10;
    L5:
        r11 = false;
        goto L6
    }

    public static int compare(byte r10, byte r11) {
        return toInt(r10) - toInt(r11);
    }

    private static byte flip(byte r10) {
        return (byte) (r10 ^ MAX_POWER_OF_TWO);
    }

    public static String join(String r10, byte... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * (r10.length() + 3));
        r12.append(toInt(r11[0]));
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

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    public static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte max(byte... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = toInt(r10[0]);
    L8:
        if (r11 >= r10.length) goto L14;
        int r14 = toInt(r10[r11]);
        if (r14 <= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L14:
        return (byte) r13;
    L5:
        r12 = false;
        goto L6
    }

    public static byte min(byte... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = toInt(r10[0]);
    L8:
        if (r11 >= r10.length) goto L14;
        int r14 = toInt(r10[r11]);
        if (r14 >= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L14:
        return (byte) r13;
    L5:
        r12 = false;
        goto L6
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String r10) {
        return parseUnsignedByte(r10, 10);
    }

    public static byte saturatedCast(long r10) {
        if (r10 <= toInt((byte) -1)) goto L6;
        return -1;
    L6:
        if (r10 >= 0) goto L10;
        return 0;
    L10:
        return (byte) r10;
    }

    public static void sort(byte[] r10) {
        Preconditions.checkNotNull(r10);
        sort(r10, 0, r10.length);
    }

    public static void sortDescending(byte[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    public static int toInt(byte r10) {
        return r10 & MAX_VALUE;
    }

    @Beta
    public static String toString(byte r10) {
        return toString(r10, 10);
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String r10, int r11) {
        int r12 = Integer.parseInt((String) Preconditions.checkNotNull(r10), r11);
        if ((r12 >> 8) != 0) goto L7;
        return (byte) r12;
    L7:
        throw new NumberFormatException("out of range: " + r12);
    }

    @Beta
    public static String toString(byte r10, int r11) {
        if (r11 >= 2) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Preconditions.checkArgument(r12, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", r11);
        return Integer.toString(toInt(r10), r11);
    L5:
        if (r11 > 36) goto L7;
        r12 = true;
        goto L8
    }

    public static void sort(byte[] r10, int r11, int r12) {
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

    public static void sortDescending(byte[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r11;
    L3:
        if (r13 >= r12) goto L5;
        r10[r13] = (byte) (r10[r13] ^ Ascii.DEL);
        r13 = r13 + 1;
        goto L3
    L5:
        Arrays.sort(r10, r11, r12);
    L6:
        if (r11 >= r12) goto L8;
        r10[r11] = (byte) (r10[r11] ^ Ascii.DEL);
        r11 = r11 + 1;
        goto L6
    }
}
