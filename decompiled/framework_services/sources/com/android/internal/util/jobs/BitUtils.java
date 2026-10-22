package com.android.internal.util.jobs;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public final class BitUtils {
    private BitUtils() {
    }

    public static boolean maskedEquals(long a, long b, long mask) {
        if ((a & mask) != (b & mask)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean maskedEquals(byte a, byte b, byte mask) {
        if ((a & mask) != (b & mask)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean maskedEquals(byte[] a, byte[] b, byte[] mask) {
        if (a == null) goto L27;
        if (b == null) goto L27;
        if (a.length != b.length) goto L9;
        boolean r2 = true;
    L10:
        Preconditions.checkArgument(r2, "Inputs must be of same size");
        if (mask != null) goto L15;
        return Arrays.equals(a, b);
    L15:
        if (a.length != mask.length) goto L17;
        boolean r3 = true;
    L18:
        Preconditions.checkArgument(r3, "Mask must be of same size as inputs");
        int i = 0;
    L20:
        if (i >= mask.length) goto L26;
        if (maskedEquals(a[i], b[i], mask[i]) == false) goto L23;
        i = i + 1;
        goto L20
    L23:
        return false;
    L26:
        return true;
    L17:
        r3 = false;
        goto L18
    L9:
        r2 = false;
    L27:
        if (a == b) goto L29;
        return false;
    L29:
        return true;
    }

    public static boolean maskedEquals(UUID a, UUID b, UUID mask) {
        if (mask != null) goto L6;
        return Objects.equals(a, b);
    L6:
        if (maskedEquals(a.getLeastSignificantBits(), b.getLeastSignificantBits(), mask.getLeastSignificantBits()) == true) goto L8;
    L10:
        return false;
    L8:
        if (maskedEquals(a.getMostSignificantBits(), b.getMostSignificantBits(), mask.getMostSignificantBits()) == false) goto L10;
        return true;
    }

    public static int[] unpackBits(long val) {
        int size = Long.bitCount(val);
        int[] result = new int[size];
        int index = 0;
        int bitPos = 0;
    L4:
        if (val == 0) goto L9;
        if ((val & 1) != 1) goto L8;
        result[index] = bitPos;
        index = index + 1;
    L8:
        val = val >>> 1;
        bitPos = bitPos + 1;
        goto L4
    L9:
        return result;
    }

    public static long packBits(int[] bits) {
        long packed = 0;
        int r2 = bits.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int b = bits[r3];
        packed = packed | (1 << b);
        r3 = r3 + 1;
        goto L3
    L5:
        return packed;
    }

    public static int uint8(byte b) {
        return b & CecDeviceType.INACTIVE;
    }

    public static int uint16(short s) {
        return 65535 & s;
    }

    public static int uint16(byte hi, byte lo) {
        return ((hi & CecDeviceType.INACTIVE) << 8) | (lo & CecDeviceType.INACTIVE);
    }

    public static long uint32(int i) {
        return ((long) i) & 4294967295L;
    }

    public static int bytesToBEInt(byte[] bytes) {
        return (((uint8(bytes[0]) << 24) + (uint8(bytes[1]) << 16)) + (uint8(bytes[2]) << 8)) + uint8(bytes[3]);
    }

    public static int bytesToLEInt(byte[] bytes) {
        return Integer.reverseBytes(bytesToBEInt(bytes));
    }

    public static int getUint8(ByteBuffer buffer, int position) {
        return uint8(buffer.get(position));
    }

    public static int getUint16(ByteBuffer buffer, int position) {
        return uint16(buffer.getShort(position));
    }

    public static long getUint32(ByteBuffer buffer, int position) {
        return uint32(buffer.getInt(position));
    }

    public static void put(ByteBuffer buffer, int position, byte[] bytes) {
        int original = buffer.position();
        buffer.position(position);
        buffer.put(bytes);
        buffer.position(original);
    }

    public static boolean isBitSet(long flags, int bitIndex) {
        if ((bitAt(bitIndex) & flags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static long bitAt(int bitIndex) {
        return 1 << bitIndex;
    }

    public static String flagsToString(int flags, IntFunction<String> getFlagName) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
    L3:
        if (flags == 0) goto L8;
        int flag = 1 << Integer.numberOfTrailingZeros(flags);
        flags = flags & (~flag);
        if (count <= 0) goto L7;
        builder.append(", ");
    L7:
        builder.append(getFlagName.apply(flag));
        count = count + 1;
        goto L3
    L8:
        TextUtils.wrap(builder, "[", "]");
        return builder.toString();
    }

    public static byte[] toBytes(long l) {
        return ByteBuffer.allocate(8).putLong(l).array();
    }

    public static int flagsUpTo(int lastFlag) {
        if (lastFlag > 0) goto L5;
        return 0;
    L5:
        return flagsUpTo(lastFlag >> 1) | lastFlag;
    }

    public static int flagsWithin(int firstFlag, int lastFlag) {
        return (flagsUpTo(lastFlag) & (~flagsUpTo(firstFlag))) | firstFlag;
    }
}
