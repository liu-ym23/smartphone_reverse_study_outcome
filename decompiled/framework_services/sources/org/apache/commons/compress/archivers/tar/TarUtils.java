package org.apache.commons.compress.archivers.tar;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

/* JADX INFO: loaded from: classes3.dex */
public class TarUtils {
    private static final int BYTE_MASK = 255;
    static final ZipEncoding DEFAULT_ENCODING = null;
    static final ZipEncoding FALLBACK_ENCODING = null;

    static {
        DEFAULT_ENCODING = ZipEncodingHelper.getZipEncoding(null);
        FALLBACK_ENCODING = new AnonymousClass1();
    }

    private TarUtils() {
    }

    public static long parseOctal(byte[] buffer, int offset, int length) {
        long result = 0;
        int end = offset + length;
        int start = offset;
        if (length < 2) goto L28;
        if (buffer[start] != 0) goto L9;
        return 0;
    L9:
        if (start >= end) goto L13;
        if (buffer[start] != 32) goto L13;
        start = start + 1;
    L13:
        byte trailer = buffer[end - 1];
    L14:
        if (start >= end) goto L18;
        if (trailer == 0) goto L17;
        if (trailer != 32) goto L18;
    L17:
        end = end - 1;
        trailer = buffer[end - 1];
    L18:
        if (start >= end) goto L26;
        byte currentByte = buffer[start];
        if (currentByte < 48) goto L25;
        if (currentByte > 55) goto L25;
        result = (result << 3) + ((long) (currentByte - 48));
        start = start + 1;
    L25:
        throw new IllegalArgumentException(exceptionMessage(buffer, offset, length, start, currentByte));
    L26:
        return result;
    L28:
        throw new IllegalArgumentException("Length " + length + " must be at least 2");
    }

    public static long parseOctalOrBinary(byte[] buffer, int offset, int length) {
        if ((buffer[offset] & 128) != 0) goto L7;
        return parseOctal(buffer, offset, length);
    L7:
        if (buffer[offset] != (-1)) goto L9;
        boolean negative = true;
    L11:
        if (length >= 9) goto L15;
        return parseBinaryLong(buffer, offset, length, negative);
    L15:
        return parseBinaryBigInteger(buffer, offset, length, negative);
    L9:
        negative = false;
        goto L11
    }

    private static long parseBinaryLong(byte[] buffer, int offset, int length, boolean negative) {
        if (length >= 9) goto L15;
        long val = 0;
        int i = 1;
    L5:
        if (i >= length) goto L8;
        val = (val << 8) + ((long) (buffer[offset + i] & CecDeviceType.INACTIVE));
        i = i + 1;
        goto L5
    L8:
        if (negative == false) goto L10;
        val = (val - 1) ^ (((long) Math.pow(2.0d, ((double) (length - 1)) * 8.0d)) - 1);
    L10:
        if (negative == false) goto L13;
        return -val;
    L13:
        return val;
    L15:
        throw new IllegalArgumentException("At offset " + offset + ", " + length + " byte binary number exceeds maximum signed long value");
    }

    private static long parseBinaryBigInteger(byte[] buffer, int offset, int length, boolean negative) {
        byte[] remainder = new byte[length - 1];
        System.arraycopy(buffer, offset + 1, remainder, 0, length - 1);
        BigInteger val = new BigInteger(remainder);
        if (negative == false) goto L6;
        val = val.add(BigInteger.valueOf(-1)).not();
    L6:
        if (val.bitLength() > 63) goto L12;
        long r2 = val.longValue();
        if (negative == true) goto L10;
        return r2;
    L10:
        return -r2;
    L12:
        throw new IllegalArgumentException("At offset " + offset + ", " + length + " byte binary number exceeds maximum signed long value");
    }

    public static boolean parseBoolean(byte[] buffer, int offset) {
        if (buffer[offset] == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static String exceptionMessage(byte[] buffer, int offset, int length, int current, byte currentByte) {
        String string = new String(buffer, offset, length);
        return "Invalid byte " + currentByte + " at offset " + (current - offset) + " in '" + string.replaceAll("\u0000", "{NUL}") + "' len=" + length;
    }

    public static String parseName(byte[] buffer, int offset, int length) {
        return parseName(buffer, offset, length, DEFAULT_ENCODING);
    L12:
        return parseName(buffer, offset, length, FALLBACK_ENCODING);
    L7:
        ex2 = move-exception;
        throw new RuntimeException(ex2);
    }

    public static String parseName(byte[] buffer, int offset, int length, ZipEncoding encoding) throws IOException {
        int len = 0;
        int i = offset;
    L3:
        if (len >= length) goto L7;
        if (buffer[i] == 0) goto L7;
        len = len + 1;
        i = i + 1;
    L7:
        if (len <= 0) goto L10;
        byte[] b = new byte[len];
        System.arraycopy(buffer, offset, b, 0, len);
        return encoding.decode(b);
    L10:
        return "";
    }

    public static int formatNameBytes(String name, byte[] buf, int offset, int length) {
        return formatNameBytes(name, buf, offset, length, DEFAULT_ENCODING);
    L12:
        return formatNameBytes(name, buf, offset, length, FALLBACK_ENCODING);
    L7:
        ex2 = move-exception;
        throw new RuntimeException(ex2);
    }

    public static int formatNameBytes(String name, byte[] buf, int offset, int length, ZipEncoding encoding) throws IOException {
        int len = name.length();
        ByteBuffer b = encoding.encode(name);
    L4:
        if (b.limit() <= length) goto L7;
        if (len <= 0) goto L7;
        len = len - 1;
        b = encoding.encode(name.substring(0, len));
    L7:
        int limit = b.limit() - b.position();
        System.arraycopy(b.array(), b.arrayOffset(), buf, offset, limit);
        int i = limit;
    L8:
        if (i >= length) goto L11;
        buf[offset + i] = 0;
        i = i + 1;
        goto L8
    L11:
        return offset + length;
    }

    public static void formatUnsignedOctalString(long value, byte[] buffer, int offset, int length) {
        int remaining = length - 1;
        if (value != 0) goto L5;
        int remaining2 = remaining - 1;
        buffer[remaining + offset] = 48;
    L13:
        if (remaining2 < 0) goto L15;
        buffer[offset + remaining2] = 48;
        remaining2 = remaining2 - 1;
        goto L13
    L15:
        return;
    L5:
        long val = value;
    L6:
        if (remaining < 0) goto L11;
        if (val == 0) goto L11;
        buffer[offset + remaining] = (byte) (((byte) (7 & val)) + 48);
        val = val >>> 3;
        remaining = remaining - 1;
    L11:
        if (val != 0) goto L17;
        remaining2 = remaining;
        goto L13
    L17:
        throw new IllegalArgumentException(value + "=" + Long.toOctalString(value) + " will not fit in octal number buffer of length " + length);
    }

    public static int formatOctalBytes(long value, byte[] buf, int offset, int length) {
        int idx = length - 2;
        formatUnsignedOctalString(value, buf, offset, idx);
        buf[idx + offset] = ParameterName.CVRR;
        buf[offset + (idx + 1)] = 0;
        return offset + length;
    }

    public static int formatLongOctalBytes(long value, byte[] buf, int offset, int length) {
        int idx = length - 1;
        formatUnsignedOctalString(value, buf, offset, idx);
        buf[offset + idx] = ParameterName.CVRR;
        return offset + length;
    }

    public static int formatLongOctalOrBinaryBytes(long value, byte[] buf, int offset, int length) {
        if (length != 8) goto L5;
        long maxAsOctalChar = TarConstants.MAXID;
    L7:
        if (value >= 0) goto L9;
        boolean r2 = true;
    L10:
        boolean negative = r2;
        if (negative == true) goto L17;
        if (value > maxAsOctalChar) goto L17;
        return formatLongOctalBytes(value, buf, offset, length);
    L17:
        if (length >= 9) goto L19;
        byte[] buf2 = buf;
        int offset2 = offset;
        int length2 = length;
        formatLongBinary(value, buf2, offset2, length2, negative);
    L20:
        if (negative == false) goto L22;
        int r9 = 255;
    L23:
        buf2[offset2] = (byte) r9;
        return offset2 + length2;
    L22:
        r9 = 128;
        goto L23
    L19:
        buf2 = buf;
        offset2 = offset;
        length2 = length;
        formatBigIntegerBinary(value, buf2, offset2, length2, negative);
        goto L20
    L9:
        r2 = false;
        goto L10
    L5:
        maxAsOctalChar = TarConstants.MAXSIZE;
        goto L7
    }

    private static void formatLongBinary(long value, byte[] buf, int offset, int length, boolean negative) {
        int bits = (length - 1) * 8;
        long max = 1 << bits;
        long val = Math.abs(value);
        if (val < 0) goto L14;
        if (val >= max) goto L14;
        if (negative == false) goto L8;
        val = ((val ^ (max - 1)) + 1) | (255 << bits);
    L8:
        int i = (offset + length) - 1;
    L9:
        if (i < offset) goto L12;
        buf[i] = (byte) val;
        val = val >> 8;
        i = i - 1;
        goto L9
    L12:
        return;
    L14:
        throw new IllegalArgumentException("Value " + value + " is too large for " + length + " byte field.");
    }

    private static void formatBigIntegerBinary(long value, byte[] buf, int offset, int length, boolean negative) {
        BigInteger val = BigInteger.valueOf(value);
        byte[] b = val.toByteArray();
        int len = b.length;
        if (len > (length - 1)) goto L13;
        int off = (offset + length) - len;
        int r4 = 0;
        System.arraycopy(b, 0, buf, off, len);
        if (negative == false) goto L7;
        r4 = 255;
    L7:
        byte fill = (byte) r4;
        int i = offset + 1;
    L8:
        if (i >= off) goto L11;
        buf[i] = fill;
        i = i + 1;
        goto L8
    L11:
        return;
    L13:
        throw new IllegalArgumentException("Value " + value + " is too large for " + length + " byte field.");
    }

    public static int formatCheckSumOctalBytes(long value, byte[] buf, int offset, int length) {
        int idx = length - 2;
        formatUnsignedOctalString(value, buf, offset, idx);
        buf[idx + offset] = 0;
        buf[offset + (idx + 1)] = ParameterName.CVRR;
        return offset + length;
    }

    public static long computeCheckSum(byte[] buf) {
        long sum = 0;
        int r2 = buf.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        byte element = buf[r3];
        sum = sum + ((long) (element & CecDeviceType.INACTIVE));
        r3 = r3 + 1;
        goto L3
    L5:
        return sum;
    }

    public static boolean verifyCheckSum(byte[] header) {
        long storedSum = parseOctal(header, 148, 8);
        long unsignedSum = 0;
        long signedSum = 0;
        int i = 0;
    L4:
        if (i >= header.length) goto L12;
        byte b = header[i];
        if (148 > i) goto L10;
        if (i >= 156) goto L10;
        b = ParameterName.CVRR;
    L10:
        unsignedSum = unsignedSum + ((long) (b & CecDeviceType.INACTIVE));
        signedSum = signedSum + ((long) b);
        i = i + 1;
        goto L4
    L12:
        if (storedSum != unsignedSum) goto L14;
    L17:
        return true;
    L14:
        if (storedSum == signedSum) goto L17;
        return false;
    }
}
