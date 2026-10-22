package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes3.dex */
final class Utils {
    private static final byte[] BYTE_ZEROES = null;
    private static final int[] INT_ZEROES = null;

    Utils() {
    }

    static {
        BYTE_ZEROES = new byte[1024];
        INT_ZEROES = new int[1024];
    }

    static void fillBytesWithZeroes(byte[] dest, int start, int end) {
        int cursor = start;
    L3:
        if (cursor >= end) goto L5;
        int step = Math.min(cursor + 1024, end) - cursor;
        System.arraycopy(BYTE_ZEROES, 0, dest, cursor, step);
        cursor = cursor + step;
        goto L3
    }

    static void fillIntsWithZeroes(int[] dest, int start, int end) {
        int cursor = start;
    L3:
        if (cursor >= end) goto L5;
        int step = Math.min(cursor + 1024, end) - cursor;
        System.arraycopy(INT_ZEROES, 0, dest, cursor, step);
        cursor = cursor + step;
        goto L3
    }

    static void copyBytes(byte[] dst, int target, byte[] src, int start, int end) {
        System.arraycopy(src, start, dst, target, end - start);
    }

    static void copyBytesWithin(byte[] bytes, int target, int start, int end) {
        System.arraycopy(bytes, start, bytes, target, end - start);
    }

    static int readInput(InputStream src, byte[] dst, int offset, int length) {
        return src.read(dst, offset, length);
    L4:
        e = move-exception;
        throw new BrotliRuntimeException("Failed to read input", e);
    }

    static void closeInput(InputStream src) throws IOException {
        src.close();
    }

    static byte[] toUsAsciiBytes(String src) {
        return src.getBytes(CharsetNames.US_ASCII);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static void flipBuffer(Buffer buffer) {
        buffer.flip();
    }

    static int isDebugMode() {
        return Boolean.parseBoolean(System.getProperty("BROTLI_ENABLE_ASSERTS")) ? 1 : 0;
    }

    static int getLogBintness() {
        boolean isLongExpensive = Boolean.parseBoolean(System.getProperty("BROTLI_32_BIT_CPU"));
        if (isLongExpensive == false) goto L5;
        return 5;
    L5:
        return 6;
    }
}
