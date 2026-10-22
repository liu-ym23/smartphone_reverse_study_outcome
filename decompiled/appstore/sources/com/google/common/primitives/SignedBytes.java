package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<byte[]> {
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
        public /* bridge */ /* synthetic */ int compare(byte[] r10, byte[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(byte[] r10, byte[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = SignedBytes.compare(r10[r13], r11[r13]);
            if (r14 != 0) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            return r10.length - r11.length;
        }
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long r10) {
        byte r11 = (byte) r10;
        if (r11 != r10) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Out of range: %s", r10);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    public static int compare(byte r10, byte r11) {
        return r10 - r11;
    }

    public static String join(String r10, byte... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 5);
        r12.append(r11[0]);
        int r13 = 1;
    L8:
        if (r13 >= r11.length) goto L11;
        r12.append(r10);
        r12.append(r11[r13]);
        r13 = r13 + 1;
        goto L8
    L11:
        return r12.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        byte r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        byte r14 = r10[r11];
        if (r14 <= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L13:
        return r13;
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
        byte r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        byte r14 = r10[r11];
        if (r14 >= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L13:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static byte saturatedCast(long r10) {
        if (r10 <= 127) goto L7;
        return Ascii.DEL;
    L7:
        if (r10 >= (-128)) goto L11;
        return UnsignedBytes.MAX_POWER_OF_TWO;
    L11:
        return (byte) r10;
    }

    public static void sortDescending(byte[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    public static void sortDescending(byte[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        Arrays.sort(r10, r11, r12);
        Bytes.reverse(r10, r11, r12);
    }
}
