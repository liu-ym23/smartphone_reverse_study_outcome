package org.apache.commons.compress.utils;

import android.hardware.audio.common.V2_0.AudioChannelMask;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes3.dex */
public class ArchiveUtils {
    private static final int MAX_SANITIZED_NAME_LENGTH = 255;

    private ArchiveUtils() {
    }

    public static String toString(ArchiveEntry entry) {
        StringBuilder sb = new StringBuilder();
        if (entry.isDirectory() == false) goto L5;
        char r1 = 'd';
    L6:
        sb.append(r1);
        String size = Long.toString(entry.getSize());
        sb.append(' ');
        int i = 7;
    L8:
        if (i <= size.length()) goto L10;
        sb.append(' ');
        i = i - 1;
        goto L8
    L10:
        sb.append(size);
        sb.append(' ');
        sb.append(entry.getName());
        return sb.toString();
    L5:
        r1 = '-';
        goto L6
    }

    public static boolean matchAsciiBuffer(String expected, byte[] buffer, int offset, int length) {
        byte[] buffer1 = expected.getBytes(CharsetNames.US_ASCII);     // Catch: UnsupportedEncodingException -> L5
        return isEqual(buffer1, 0, buffer1.length, buffer, offset, length, false);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean matchAsciiBuffer(String expected, byte[] buffer) {
        return matchAsciiBuffer(expected, buffer, 0, buffer.length);
    }

    public static byte[] toAsciiBytes(String inputString) {
        return inputString.getBytes(CharsetNames.US_ASCII);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String toAsciiString(byte[] inputBytes) {
        return new String(inputBytes, CharsetNames.US_ASCII);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String toAsciiString(byte[] inputBytes, int offset, int length) {
        return new String(inputBytes, offset, length, CharsetNames.US_ASCII);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean isEqual(byte[] buffer1, int offset1, int length1, byte[] buffer2, int offset2, int length2, boolean ignoreTrailingNulls) {
        if (length1 >= length2) goto L4;
        int minLen = length1;
    L5:
        int i = 0;
    L7:
        if (i >= minLen) goto L13;
        if (buffer1[offset1 + i] != buffer2[offset2 + i]) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L13:
        if (length1 != length2) goto L15;
        return true;
    L15:
        if (ignoreTrailingNulls == false) goto L31;
        if (length1 <= length2) goto L24;
        int i2 = length2;
    L18:
        if (i2 >= length1) goto L30;
        if (buffer1[offset1 + i2] != 0) goto L21;
        i2 = i2 + 1;
        goto L18
    L21:
        return false;
    L30:
        return true;
    L24:
        int i3 = length1;
    L25:
        if (i3 >= length2) goto L30;
        if (buffer2[offset2 + i3] != 0) goto L28;
        i3 = i3 + 1;
        goto L25
    L28:
        return false;
    L31:
        return false;
    L4:
        minLen = length2;
        goto L5
    }

    public static boolean isEqual(byte[] buffer1, int offset1, int length1, byte[] buffer2, int offset2, int length2) {
        return isEqual(buffer1, offset1, length1, buffer2, offset2, length2, false);
    }

    public static boolean isEqual(byte[] buffer1, byte[] buffer2) {
        return isEqual(buffer1, 0, buffer1.length, buffer2, 0, buffer2.length, false);
    }

    public static boolean isEqual(byte[] buffer1, byte[] buffer2, boolean ignoreTrailingNulls) {
        return isEqual(buffer1, 0, buffer1.length, buffer2, 0, buffer2.length, ignoreTrailingNulls);
    }

    public static boolean isEqualWithNull(byte[] buffer1, int offset1, int length1, byte[] buffer2, int offset2, int length2) {
        return isEqual(buffer1, offset1, length1, buffer2, offset2, length2, true);
    }

    public static boolean isArrayZero(byte[] a, int size) {
        int i = 0;
    L3:
        if (i >= size) goto L9;
        if (a[i] != 0) goto L6;
        i = i + 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static String sanitize(String s) {
        char[] cs = s.toCharArray();
        if (cs.length > 255) goto L5;
        char[] chars = cs;
    L7:
        if (cs.length <= 255) goto L11;
        int i = AudioChannelMask.IN_6;
    L9:
        if (i >= 255) goto L11;
        chars[i] = '.';
        i = i + 1;
    L11:
        StringBuilder sb = new StringBuilder();
        int r3 = chars.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L23;
        char c = chars[r4];
        if (Character.isISOControl(c) == true) goto L20;
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        if (block == null) goto L20;
        if (block == Character.UnicodeBlock.SPECIALS) goto L20;
        sb.append(c);
    L21:
        r4 = r4 + 1;
    L20:
        sb.append('?');
        goto L21
    L23:
        return sb.toString();
    L5:
        chars = Arrays.copyOf(cs, 255);
        goto L7
    }
}
